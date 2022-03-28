import java.util.List;

public class Main {
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(7);

        node5.setRightChild(node6);
        node3.setRightChild(node5);
        node1.setLeftChild(node3);
        node2.setRightChild(node4);

        root.setLeftChild(node1);
        root.setRightChild(node2);

        BinaryTreePrint print = new BinaryTreePrint();
        print.printTree(root);
        BinaryTree<Integer> tree = new BinaryTree<>(root);

        List<Integer> inOrderElements = tree.inOrder();
        System.out.println(inOrderElements);

        int height = tree.height();
        System.out.println(height);
    }
}
