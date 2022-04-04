public class BinarySearchTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> {
    private BinarySearchTreeNode<T> leftChild;
    private BinarySearchTreeNode<T> rightChild;
    private T element;

    public BinarySearchTreeNode(T element) {
        this.element = element;
    }

    @Override
    public T getElement() {
        return element;
    }




    @Override
    public void setElement(T element) {
        this.element = element;
    }

    public void addLeftChild(BinarySearchTreeNode<T> newLeftChild) {
        if (newLeftChild == null) {
            return;
        }

        BinarySearchTreeNode<T> node = this;
        // Check if element is less than left child
        if (newLeftChild.getElement().compareTo(getElement()) < 0) {
            if (leftChild == null) {
                leftChild = newLeftChild;
                return;
            }
            leftChild.addLeftChild(newLeftChild);
        }
    }

    public void addRightChild(BinarySearchTreeNode<T> newRightChild) {
        if (newRightChild == null) {
            return;
        }

        if (newRightChild.getElement().compareTo(getElement()) >= 0) {
            if (rightChild == null) {
                rightChild = newRightChild;
                return;
            }
            rightChild.addRightChild(newRightChild);
        }
    }


    public BinarySearchTreeNode<T> leftChild() {
        return leftChild;
    }

    public BinarySearchTreeNode<T> rightChild() {
        return rightChild;
    }
}
