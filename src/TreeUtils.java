public class TreeUtils<T extends Comparable<T>> {





    public int getBinarySearchTreeHeight(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return -1;
        }

        return binarySearchTreeHeightHelper(node, -1) + 1;
    }

    public int getHeight(BinaryTreeNode<T> root) {
        if (root == null) {
            return -1;
        }

        return heightHelper(root, -1) + 1;
    }

    private int heightHelper(BinaryTreeNode<T> node, int currentHeight) {
        int leftChildHeight = currentHeight;
        int rightChildHeight = currentHeight;

        if (node.getLeftChild() != null) {
            leftChildHeight = heightHelper(node.getLeftChild(), currentHeight + 1);
        }

        if (node.getRightChild() != null) {
            rightChildHeight = heightHelper(node.getRightChild(), currentHeight + 1);
        }
        return Math.max(leftChildHeight, rightChildHeight);
    }


    private int binarySearchTreeHeightHelper(BinarySearchTreeNode<T> node, int currentHeight) {
        int leftChildHeight = currentHeight;
        int rightChildHeight = currentHeight;

        if (node.leftChild() != null) {
            leftChildHeight = binarySearchTreeHeightHelper(node.leftChild(), currentHeight + 1);
        }

        if (node.rightChild() != null) {
            rightChildHeight = binarySearchTreeHeightHelper(node.rightChild(), currentHeight + 1);
        }
        return Math.max(leftChildHeight, rightChildHeight);
    }
}
