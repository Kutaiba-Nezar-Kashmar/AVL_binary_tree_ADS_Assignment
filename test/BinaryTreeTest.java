import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {


    @Test
    void constructor_ExpectedValue_1_doesNotThrow() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(1);

        assertDoesNotThrow(() -> new BinaryTree(node));
    }

    @Test
    void constructor_ExpectedValue_minus1_doesNotThrow() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(-1);

        assertDoesNotThrow(() -> new BinaryTree(node));
    }

    @Test
    void constructor_ExpectedValue_500_doesNotThrow() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(500);

        assertDoesNotThrow(() -> new BinaryTree(node));
    }

    @Test
    void constructor_ExpectedValue_minus500_doesNotThrow() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(-500);

        assertDoesNotThrow(() -> new BinaryTree(node));
    }

    @Test
    void constructor_ExpectedValue_0_doesNotThrow() {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(0);

        assertDoesNotThrow(() -> new BinaryTree(node));
    }

    @Test
    void constructor_null_throws() {

        assertThrows(IllegalArgumentException.class, () -> new BinaryTree(null));
    }


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

    @Test
    void getRoot_ExpectedElement_Equals() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(8);

        root.addRightChild(node1);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
        assertEquals(binaryTree.getRoot(),root);
    }

    @Test
    void getRoot_UnexpectedElement_doesNotEquals() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(8);

        root.addRightChild(node1);
        BinaryTree<Integer> binaryTree = new BinaryTree<>(root);
        assertNotEquals(binaryTree.getRoot(),node1);
    }

    @Test
    void setRoot_ExpectedElement_Equals() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(8);

        root.addRightChild(node1);
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(root);
        assertEquals(binaryTree.getRoot(),root);
    }

    @Test
    void setRoot_UnexpectedElement_DoesNotEquals() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(8);

        root.addRightChild(node1);
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(root);
        assertNotEquals(binaryTree.getRoot(),node1);
    }

    @Test
    void isEmpty_NotEmptyTree_True() {

        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        assertTrue(binaryTree.isEmpty());
    }

    @Test
    void isEmpty_EmptyTree_False() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(8);

        root.addRightChild(node1);
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(root);
        assertFalse(binaryTree.isEmpty());
    }

    @Test
    void size_sizeOfThree_EqualsThree() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(8);

        root.addRightChild(node1);
        root.addLeftChild(node2);
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(root);
        assertEquals(3,binaryTree.size());
    }

    @Test
    void size_sizeOfThree_DoesNotEqualsTwo() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(8);
        BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(8);

        root.addRightChild(node1);
        root.addLeftChild(node2);
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.setRoot(root);
        assertNotEquals(2,binaryTree.size());
    }






}