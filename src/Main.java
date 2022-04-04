import java.util.List;

public class Main {
    public static void main(String[] args) {

        BinarySearchTreeNode<Integer> searchRoot = new BinarySearchTreeNode<>(10);
        BinarySearchTreeNode<Integer> bstnode1 = new BinarySearchTreeNode<>(3);
        BinarySearchTreeNode<Integer> bstnode3 = new BinarySearchTreeNode<>(1);
        BinarySearchTreeNode<Integer> bstnode2 = new BinarySearchTreeNode<>(-1);
//        BinarySearchTreeNode<Integer> bstnode4 = new BinarySearchTreeNode<>(4);

        bstnode1.addLeftChild(bstnode3);
//        bstnode2.addRightChild(bstnode4);
        searchRoot.addLeftChild(bstnode1);
        searchRoot.addLeftChild(bstnode2);
//        searchRoot.addRightChild(bstnode2);
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(searchRoot);
        BinarySearchTreePrint print = new BinarySearchTreePrint();

//        System.out.println(binarySearchTree.findMin());
//        System.out.println(binarySearchTree.containsElement(11));
//        System.out.println(binarySearchTree.containsElement(0));
        print.printTree(binarySearchTree.root());
        binarySearchTree.reBalance();
        print.printTree(binarySearchTree.root());
    }
}
