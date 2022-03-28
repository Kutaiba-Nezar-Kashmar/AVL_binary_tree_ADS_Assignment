public class BinarySearchTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T> {
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;

    public BinarySearchTreeNode(T element) {
        super(element);
    }

    @Override
    public T getElement() {
        return super.getElement();
    }

    @Override
    public void setElement(T element) {
        super.setElement(element);
    }

    @Override
    public void addLeftChild(BinaryTreeNode<T> newLeftChild) {
        // Check if element is less than left child
        BinarySearchTreeNode<T> node = this;

        if (leftChild == null) {
            leftChild = newLeftChild;
            return;
        }

        if (newLeftChild.getElement().compareTo(super.getElement()) < 0) {
            leftChild.addLeftChild(newLeftChild);
        }
    }

    @Override
    public void addRightChild(BinaryTreeNode<T> newRightChild) {
        if (rightChild == null) {
            rightChild = newRightChild;
            return;
        }

        if (newRightChild.getElement().compareTo(super.getElement()) < 0) {
            rightChild.addRightChild(newRightChild);
        }
    }


    @Override
    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    @Override
    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }
}
