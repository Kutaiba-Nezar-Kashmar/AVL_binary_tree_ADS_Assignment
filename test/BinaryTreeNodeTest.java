import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    BinaryTreeNode<Integer> node;


    @Test
    void constructor_ExpectedValue_1_doesNotThrow() {

        assertDoesNotThrow(() -> new BinaryTreeNode<>(1));
    }

    @Test
    void constructor_ExpectedValue_minus1_doesNotThrow() {

        assertDoesNotThrow(() -> new BinaryTreeNode<>(-1));
    }

    @Test
    void constructor_ExpectedValue_500_doesNotThrow() {

        assertDoesNotThrow(() -> new BinaryTreeNode<>(500));
    }

    @Test
    void constructor_ExpectedValue_minus500_doesNotThrow() {

        assertDoesNotThrow(() -> new BinaryTreeNode<>(-500));
    }

    @Test
    void constructor_ExpectedValue_0_doesNotThrow() {

        assertDoesNotThrow(() -> new BinaryTreeNode<>(0));
    }

    @Test
    void constructor_null_throws() {

        assertThrows(IllegalArgumentException.class, () -> new BinaryTreeNode<>(null));
    }

    @Test
    void getElement_5_returns5() {

        node = new BinaryTreeNode<>(5);

        assertEquals(5, node.getElement());

    }

    @Test
    void getElement_5_returns4_notEquals() {

        node = new BinaryTreeNode<>(5);

        assertNotEquals(4, node.getElement());

    }

    @Test
    void getLeftChild_returns_correctLeftChild() {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8);

        root.addLeftChild(node1);


        assertEquals(node1, root.getLeftChild());
    }

    @Test
    void getRightChild_returns_correctRightChild() {
        BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(8);

        root.addRightChild(node1);


        assertEquals(node1, root.getRightChild());
    }


}