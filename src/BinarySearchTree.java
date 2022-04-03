import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    private BinarySearchTreeNode<T> root;


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
        //TODO: implement
        return false;
    }

    public T findMin() {
        BinarySearchTreeNode<T> node;
        node = root;

        while (node.getLeftChild() != null) {
            node = (BinarySearchTreeNode<T>) node.getLeftChild();
        }

        return node.getElement();
    }

    public T findMax() {
        BinarySearchTreeNode<T> node;
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
