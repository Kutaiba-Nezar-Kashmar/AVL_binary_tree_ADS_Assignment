import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    private BinaryTreeNode<T> root;


    public BinarySearchTree(BinarySearchTreeNode<T> root) {
        this.root = root;
    }

    public BinarySearchTree() {

    }

    public boolean insert(T element) {
        if (this.containsElement(element)) {return false;}
        BinarySearchTreeNode<T> z = new BinarySearchTreeNode<>(element);
        BinaryTreeNode<T> y = null;
        BinaryTreeNode<T> x = root;
        while (x != null){
            y = x;
            x = z.getElement().compareTo(x.getElement()) < 0 ? x.getLeftChild() : x.getRightChild();
        }
        if (y == null){
            root = z;
            return true;
        }
        else if (z.getElement().compareTo(y.getElement()) < 0){
            y.addLeftChild(z);
            return true;
        }
        else {
            y.addRightChild(z);
            return true;
        }
    }



    public boolean removeElement(T element) {
        BinaryTreeNode<T> focusNode = root;
        BinaryTreeNode<T> parent = root;

        boolean isItALEftChild = true;

        while (!focusNode.getElement().equals(element)){
            parent = focusNode;

            if (element.compareTo(focusNode.getElement()) < 0 ) {
                isItALEftChild = true;

                focusNode = focusNode.getLeftChild();
            }else {
                isItALEftChild = false;
                focusNode = focusNode.getRightChild();
            }

            if(focusNode == null){
                return false;
            }

            if(focusNode.getLeftChild() == null && focusNode.getRightChild() == null){
                if (focusNode == root){
                    root = null;
                } else if (isItALEftChild){
                    parent.addLeftChild(null);
                } else {
                    parent.addRightChild(null);
                }
            }

            else if (focusNode.getRightChild() == null){
                if (focusNode == root)
                    root =focusNode.getLeftChild();

                else if (isItALEftChild)
                    parent.addLeftChild(focusNode.getLeftChild());
                else parent.addRightChild(focusNode.getLeftChild());
            }
            else if (focusNode.getLeftChild() == null){
                if(focusNode == root)
                    root = focusNode.getRightChild();
                else if(isItALEftChild)
                    parent.addLeftChild(focusNode.getRightChild());
                else
                    parent.addRightChild(focusNode.getLeftChild());
            }
            else {
                BinaryTreeNode replacement = getReplacementNode(focusNode);

                if(focusNode == root)
                    root = replacement;
                else if (isItALEftChild)
                    parent.addLeftChild(replacement);
                else
                    parent.addRightChild(replacement);
                replacement.addLeftChild(focusNode.getLeftChild());
            }
        }

        return true;
    }

    public BinaryTreeNode<T> getReplacementNode(BinaryTreeNode<T> replaced){
        BinaryTreeNode<T> replacementParent = replaced;
        BinaryTreeNode<T> replacement = replaced;

        BinaryTreeNode<T> focusNode = replaced.getRightChild();
        while (focusNode != null){

            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.getLeftChild();
        }
        if (replacement != replaced.getRightChild()){
            replacementParent.addLeftChild(replacement.getRightChild());
            replacement.addRightChild(replaced.getRightChild());
        }
        return replacement;
    }

    public T findMin() {
        BinaryTreeNode<T> node;
        node = root;

        while (node.getLeftChild() != null) {
            node = (BinarySearchTreeNode<T>) node.getLeftChild();
        }

        return node.getElement();
    }

    public T findMax() {
        BinaryTreeNode<T> node;
        node = root;

        while (node.getRightChild() != null) {
            node = (BinarySearchTreeNode<T>) node.getRightChild();
        }

        return node.getElement();
    }

    public boolean containsElement(T element) {
        List<T> elements = inOrder();
        return elements.contains(element);
    }


    @Override
    public List<T> inOrder() {

        List<T> elements = new ArrayList<>();
        inOrderHelper(elements, this.root);
        return elements;
    }

    private void inOrderHelper(List<T> elements, BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }

        inOrderHelper(elements, node.getLeftChild());
        visitNode(elements, node);
        inOrderHelper(elements, node.getRightChild());
    }

    private void visitNode(List<T> elements, BinaryTreeNode<T> node) {
        elements.add(node.getElement());
    }

    public void rebalance() {
        //TODO: implement

    }


}
