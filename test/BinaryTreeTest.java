import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    @Test
    public void height_TreeRootIsNull_ReturnsMinusOne() {
        // Arrange
        BinaryTree<Integer> tree = new BinaryTree<>();

        // Act
        tree.setRoot(null);

        //Assert
        assertEquals(-1, tree.height());
    }

    @Test
    public void height_TreeHasHeightOfFour_ReturnsFour() {
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
    public void height_RootIsLeaf_ReturnsZero() {
        // Arrange
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(2);

        //Act
        BinaryTree<Integer> tree = new BinaryTree<>(root);

        // Assert
        assertEquals(0, tree.height());
    }

    // TODO: Move this to BinarySearchTree test
    @Test
    public void inOrder_InOrderTraversal_ReturnsElementsInAscendingOrder() {
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
        BinaryTree<Integer> tree = new BinaryTree<>(root);

        // Act
        List<Integer> inOrderElements = tree.inOrder();
        List<Integer> expected = Arrays.asList(1, 3, 4, 5, 6, 6, 7);

        // Assert
        for (int i = 0; i < inOrderElements.size(); i++) {
            if (!inOrderElements.get(i).equals(expected.get(i))) {
                fail("List is: " + inOrderElements.toString() + " expected is: " + expected.toString());
            }
        }

    }


}