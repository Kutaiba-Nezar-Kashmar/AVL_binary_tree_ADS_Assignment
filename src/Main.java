import java.util.List;

public class Main {
    public static void main(String[] args) {
//        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
//        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(3);
//        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(1);
//        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(5);
//        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(6);
//        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(6);
//        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(7);
//
//        node5.addRightChild(node6);
//        node3.addRightChild(node5);
//        node1.addLeftChild(node3);
//        node2.addRightChild(node4);
//
//        root.addLeftChild(node1);
//        root.addRightChild(node2);
//
//        BinaryTreePrint print = new BinaryTreePrint();
//        print.printTree(root);
//        BinaryTree<Integer> tree = new BinaryTree<>(root);
//
//        List<Integer> inOrderElements = tree.inOrder();
//        System.out.println(inOrderElements);


        BinarySearchTreeNode<Integer> searchRoot = new BinarySearchTreeNode<>(10);
        BinarySearchTreeNode<Integer> bstnode1 = new BinarySearchTreeNode<>(3);
        BinarySearchTreeNode<Integer> bstnode3 = new BinarySearchTreeNode<>(1);
        BinarySearchTreeNode<Integer> bstnode2 = new BinarySearchTreeNode<>(11);
        BinarySearchTreeNode<Integer> bstnode4 = new BinarySearchTreeNode<>(4);

        bstnode1.addLeftChild(bstnode3);
        bstnode2.addRightChild(bstnode4);

        searchRoot.addLeftChild(bstnode1);
        searchRoot.addRightChild(bstnode2);
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(searchRoot);
        BinaryTreePrint print = new BinaryTreePrint();

        System.out.println(binarySearchTree.findMin());
        System.out.println(binarySearchTree.containsElement(11));
        System.out.println(binarySearchTree.containsElement(0));
    }
}
