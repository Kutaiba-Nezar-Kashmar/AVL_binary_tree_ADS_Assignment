public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {


    private BinarySearchTreeNode<T> root;


    public BinarySearchTree(BinarySearchTreeNode<T> root) {
        this.root = root;
    }

    public BinarySearchTree() {

    }

    public boolean insert(T element) {
        //TODO: implement
        return false;
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
        //TODO: implement
        return false;
    }

    public void rebalance() {
        //TODO: implement

    }


}
