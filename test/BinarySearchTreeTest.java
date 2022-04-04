import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {


    @Test
    public void inOrder_InOrderTraversal_ReturnsElementsInAscendingOrder() {
        // Arrange
        BinarySearchTreeNode<Integer> root = new BinarySearchTreeNode<>(4);
        BinarySearchTreeNode<Integer> node1 = new BinarySearchTreeNode<>(3);
        BinarySearchTreeNode<Integer> node3 = new BinarySearchTreeNode<>(1);
        BinarySearchTreeNode<Integer> node2 = new BinarySearchTreeNode<>(5);
        BinarySearchTreeNode<Integer> node4 = new BinarySearchTreeNode<>(6);
        BinarySearchTreeNode<Integer> node5 = new BinarySearchTreeNode<>(6);
        BinarySearchTreeNode<Integer> node6 = new BinarySearchTreeNode<>(7);
        node5.addRightChild(node6);
        node3.addRightChild(node5);
        node1.addLeftChild(node3);
        node2.addRightChild(node4);
        root.addLeftChild(node1);
        root.addRightChild(node2);
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(root);

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