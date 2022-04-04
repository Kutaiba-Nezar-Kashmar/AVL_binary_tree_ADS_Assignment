import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeNodeTest {

    BinarySearchTreeNode<Integer> node;


    @Test
    void constructor_ExpectedValue_1_doesNotThrow() {

        assertDoesNotThrow(() -> new BinarySearchTreeNode<>(1));
    }

    @Test
    void constructor_ExpectedValue_minus1_doesNotThrow() {

        assertDoesNotThrow(() -> new BinarySearchTreeNode<>(-1));
    }

    @Test
    void constructor_ExpectedValue_500_doesNotThrow() {

        assertDoesNotThrow(() -> new BinarySearchTreeNode<>(500));
    }

    @Test
    void constructor_ExpectedValue_minus500_doesNotThrow() {

        assertDoesNotThrow(() -> new BinarySearchTreeNode<>(-500));
    }

    @Test
    void constructor_ExpectedValue_0_doesNotThrow() {

        assertDoesNotThrow(() -> new BinarySearchTreeNode<>(0));
    }

    @Test
    void constructor_null_throws() {

        assertThrows(IllegalArgumentException.class, () -> new BinarySearchTreeNode<>(null));
    }

    @Test
    void getElement_5_returns5() {

        node = new BinarySearchTreeNode<>(5);

        assertEquals(5, node.getElement());

    }

    @Test
    void getElement_5_returns4_notEquals() {

        node = new BinarySearchTreeNode<>(5);

        assertNotEquals(4, node.getElement());

    }

    @Test
    void getLeftChild_returns_correctLeftChild() {
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node2 = new BinarySearchTreeNode<>(6);
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(8);

        root.addLeftChild(node1);
        root.addLeftChild(node2);


        assertEquals(node2, node1.getLeftChild());
    }

    @Test
    void getRightChild_returns_correctRightChild() {
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node2 = new BinarySearchTreeNode<>(6);
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(3);

        root.addRightChild(node1);
        root.addRightChild(node2);


        assertEquals(node2, node1.getRightChild());
    }

}