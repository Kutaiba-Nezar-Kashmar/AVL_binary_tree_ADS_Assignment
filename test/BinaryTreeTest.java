import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    @Test
    public void height_TreeRootIsNull_ReturnsMinusOne(){
        // Arrange
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Act
        tree.setRoot(null);

        //Assert
        assertEquals(-1, tree.height());
    }

    @Test
    public void height_TreeHasHeightOfFour_ReturnsFour(){
        // Arrange
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(7);
        node5.addRightChild(node6);
        node3.addRightChild(node5);
        node1.addLeftChild(node3);
        node2.addRightChild(node4);
        root.addLeftChild(node1);
        root.addRightChild(node2);

        // Act
        BinaryTree<Integer> tree = new BinaryTree<>(root);

        // Assert
        assertEquals(4, tree.height());
    }

    @Test
    public void height_RootIsLeaf_ReturnsZero(){
        // Arrange
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);

        //Act
        BinaryTree<Integer> tree = new BinaryTree<>(root);

        // Assert
        assertEquals(0, tree.height());
    }

    public void inOrder_InOrderTraversal_ReturnsElementsInAscendingOrder(){
        // Arrange
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(3);
        BinaryTreeNode<Integer> node3 = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> node5 = new BinaryTreeNode<>(6);
        BinaryTreeNode<Integer> node6 = new BinaryTreeNode<>(7);
        node5.addRightChild(node6);
        node3.addRightChild(node5);
        node1.addLeftChild(node3);
        node2.addRightChild(node4);
        root.addLeftChild(node1);
        root.addRightChild(node2);
    }


}