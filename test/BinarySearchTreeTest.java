import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {


    @Test
    void constructor_ExpectedValue_1_doesNotThrow() {
        BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(1);

        assertDoesNotThrow(() -> new BinarySearchTree(node));
    }

    @Test
    void constructor_ExpectedValue_minus1_doesNotThrow() {
        BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(-1);

        assertDoesNotThrow(() -> new BinarySearchTree(node));
    }

    @Test
    void constructor_ExpectedValue_500_doesNotThrow() {
        BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(500);

        assertDoesNotThrow(() -> new BinarySearchTree(node));
    }

    @Test
    void constructor_ExpectedValue_minus500_doesNotThrow() {
        BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(-500);

        assertDoesNotThrow(() -> new BinarySearchTree(node));
    }

    @Test
    void constructor_ExpectedValue_0_doesNotThrow() {
        BinarySearchTreeNode<Integer> node = new BinarySearchTreeNode<>(0);

        assertDoesNotThrow(() -> new BinarySearchTree(node));
    }

    @Test
    void constructor_null_throws() {

        assertThrows(IllegalArgumentException.class, () -> new BinarySearchTree(null));
    }


    @Test
    public void height_TreeRootIsNull_ReturnsMinusOne() {
        // Arrange
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // Act
        tree.setRoot(null);

        //Assert
        assertEquals(-1, tree.height());
    }

    @Test
    public void height_TreeHasHeightOfFour_ReturnsFour() {
        // Arrange
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(4);


        // Act
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);

        // Assert
        assertEquals(5, tree.height());
    }

    @Test
    public void height_RootIsLeaf_ReturnsZero() {
        // Arrange
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(2);

        //Act
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

        // Assert
        assertEquals(0, tree.height());
    }

    @Test
    void getRoot_ExpectedElement_Equals() {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(8);

        root.addRightChild(node1);
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(root);
        assertEquals(root, binarySearchTree.root());
    }

    @Test
    void getRoot_UnexpectedElement_doesNotEquals() {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(8);

        root.addRightChild(node1);
        BinarySearchTree<Integer> BinarySearchTree = new BinarySearchTree<>(root);
        assertNotEquals(BinarySearchTree.getRoot(), node1);
    }

    @Test
    void setRoot_ExpectedElement_Equals() {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(8);

        root.addRightChild(node1);
        BinarySearchTree<Integer> BinarySearchTree = new BinarySearchTree<>();
        BinarySearchTree.setRoot(root);
        assertEquals(BinarySearchTree.getRoot(), root);
    }

    @Test
    void setRoot_UnexpectedElement_DoesNotEquals() {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(8);

        root.addRightChild(node1);
        BinarySearchTree<Integer> BinarySearchTree = new BinarySearchTree<>();
        BinarySearchTree.setRoot(root);
        assertNotEquals(BinarySearchTree.getRoot(), node1);
    }

    @Test
    void isEmpty_NotEmptyTree_True() {

        BinarySearchTree<Integer> BinarySearchTree = new BinarySearchTree<>();
        assertTrue(BinarySearchTree.isEmpty());
    }

    @Test
    void isEmpty_EmptyTree_False() {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(8);

        root.addRightChild(node1);
        BinarySearchTree<Integer> BinarySearchTree = new BinarySearchTree<>();
        BinarySearchTree.setRoot(root);
        assertFalse(BinarySearchTree.isEmpty());
    }

    @Test
    void size_sizeOfThree_EqualsThree() {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(8);
        BinarySearchTreeNode<Integer> node2 = new BinarySearchTreeNode<>(8);

        root.addRightChild(node1);
        root.addLeftChild(node2);
        BinarySearchTree<Integer> BinarySearchTree = new BinarySearchTree<>();
        BinarySearchTree.setRoot(root);
        assertEquals(3, BinarySearchTree.size());
    }

    @Test
    void size_sizeOfThree_DoesNotEqualsTwo() {
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(8);
        BinarySearchTreeNode<Integer> node2 = new BinarySearchTreeNode<>(8);

        root.addRightChild(node1);
        root.addLeftChild(node2);
        BinarySearchTree<Integer> BinarySearchTree = new BinarySearchTree<>();
        BinarySearchTree.setRoot(root);
        assertNotEquals(2, BinarySearchTree.size());
    }


    @Test
    public void inOrder_InOrderTraversal_ReturnsElementsInAscendingOrder() {
        // Arrange

        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new BinarySearchTreeNode<>(6));

        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(11);
        tree.insert(14);

        // Act
        List<Integer> inOrderElements = tree.inOrder();
        List<Integer> expected = Arrays.asList(5, 6, 7, 8, 9, 11, 14);

        // Assert
        for (int i = 0; i < inOrderElements.size(); i++) {
            if (!inOrderElements.get(i).equals(expected.get(i))) {
                fail("List is: " + inOrderElements.toString() + " expected is: " + expected.toString());
            }
        }
    }
}