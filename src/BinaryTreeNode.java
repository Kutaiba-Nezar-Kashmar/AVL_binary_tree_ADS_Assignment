public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(T element) {

        if (element == null)
        {
            throw new IllegalArgumentException("Element can't be null");
        }
        this.element = element;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public void addLeftChild(BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public void addRightChild(BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }
}
