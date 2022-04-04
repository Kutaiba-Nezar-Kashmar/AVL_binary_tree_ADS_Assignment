import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> root;
    private int size;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public List<T> inOrder() {
        List<T> elements = new ArrayList<>();
        inOrderHelper(elements, this.root);
        return elements;
    }

    public int size() {
        List<T> elements = inOrder();
        return elements.size();
    }

    public List<T> preOrder() {
        List<T> elements = new ArrayList<>();
        preOrderHelper(elements, this.root);
        return elements;
    }

    public List<T> postOrder() {
        List<T> elements = new ArrayList<>();
        postOrderHelper(elements, this.root);
        return elements;
    }

    public int height() {
        TreeUtils<T> util = new TreeUtils<>();
        return util.getHeight(this.root);
    }


    private void inOrderHelper(List<T> elements, BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }

        inOrderHelper(elements, node.getLeftChild());
        visitNode(elements, node);
        inOrderHelper(elements, node.getRightChild());
    }

    private void preOrderHelper(List<T> elements, BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }

        visitNode(elements, node);
        preOrderHelper(elements, node.getLeftChild());
        preOrderHelper(elements, node.getRightChild());
    }

    private void postOrderHelper(List<T> elements, BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }

        postOrderHelper(elements, node.getLeftChild());
        postOrderHelper(elements, node.getRightChild());
        visitNode(elements, node);
    }


    private void visitNode(List<T> elements, BinaryTreeNode<T> node) {
        elements.add(node.getElement());
    }

}
