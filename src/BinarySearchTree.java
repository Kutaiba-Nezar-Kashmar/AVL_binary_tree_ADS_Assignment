import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
    private BinarySearchTreeNode<T> root;
    private TreeUtils<T> util = new TreeUtils<>();
    private int size = 0;

    public BinarySearchTree(BinarySearchTreeNode<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
        this.root = root;
        size++;
    }

    public void setRoot(BinarySearchTreeNode<T> root) {
        BinarySearchTreeNode<T> currentRoot = this.root;
        if (this.root == null) {
            size++;
        }

        this.root = root;
    }

    public BinarySearchTree() {

    }

    public boolean isEmpty(){
        return size==0 || root == null;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public int height() {
        return util.getBinarySearchTreeHeight(root);
    }

    public BinarySearchTreeNode<T> root() {
        return root;
    }

    public boolean insert(T element) {
        if (element == null) {
            return false;
        }

        if (this.containsElement(element)) {
            return false;
        }

        size++;
        BinarySearchTreeNode<T> newNode = new BinarySearchTreeNode<>(element);
        BinarySearchTreeNode<T> visitedNode = null;
        BinarySearchTreeNode<T> currentRoot = root;
        while (currentRoot != null) {
            visitedNode = currentRoot;
            currentRoot = newNode.getElement().compareTo(currentRoot.getElement()) < 0
                    ? currentRoot.leftChild() : currentRoot.rightChild();
        }
        if (visitedNode == null) {
            root = newNode;
            return true;
        } else if (newNode.getElement().compareTo(visitedNode.getElement()) < 0) {
            visitedNode.addLeftChild(newNode);
            return true;
        } else {
            visitedNode.addRightChild(newNode);
            return true;
        }
    }


    public boolean removeElement(T element) {
        BinarySearchTreeNode<T> focusNode = root;
        BinarySearchTreeNode<T> parent = root;

        boolean isItALEftChild = true;

        while (!focusNode.getElement().equals(element)) {
            parent = focusNode;

            if (element.compareTo(focusNode.getElement()) < 0) {
                isItALEftChild = true;

                focusNode = focusNode.leftChild();
            } else {
                isItALEftChild = false;
                focusNode = focusNode.rightChild();
            }

            if (focusNode == null) {
                return false;
            }

            if (focusNode.leftChild() == null && focusNode.rightChild() == null) {
                if (focusNode == root) {
                    root = null;
                } else if (isItALEftChild) {
                    parent.addLeftChild(null);
                } else {
                    parent.addRightChild(null);
                }
            } else if (focusNode.rightChild() == null) {
                if (focusNode == root)
                    root = focusNode.leftChild();

                else if (isItALEftChild)
                    parent.addLeftChild(focusNode.leftChild());
                else parent.addRightChild(focusNode.leftChild());
            } else if (focusNode.leftChild() == null) {
                if (focusNode == root)
                    root = focusNode.rightChild();
                else if (isItALEftChild)
                    parent.addLeftChild(focusNode.rightChild());
                else
                    parent.addRightChild(focusNode.leftChild());
            } else {
                BinarySearchTreeNode<T> replacement = getReplacementNode(focusNode);

                if (focusNode == root)
                    root = replacement;
                else if (isItALEftChild)
                    parent.addLeftChild(replacement);
                else
                    parent.addRightChild(replacement);
                replacement.addLeftChild(focusNode.leftChild());
            }
        }

        return true;
    }

    public BinarySearchTreeNode<T> getReplacementNode(BinarySearchTreeNode<T> replaced) {
        BinarySearchTreeNode<T> replacementParent = replaced;
        BinarySearchTreeNode<T> replacement = replaced;

        BinarySearchTreeNode<T> focusNode = replaced.rightChild();
        while (focusNode != null) {

            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.leftChild();
        }
        if (replacement != replaced.rightChild()) {
            replacementParent.addLeftChild(replacement.leftChild());
            replacement.addRightChild(replaced.rightChild());
        }
        return replacement;
    }

    public T findMin() {
        BinarySearchTreeNode<T> node;
        node = root;

        while (node.leftChild() != null) {
            node = node.leftChild();
        }

        return node.getElement();
    }

    public T findMax() {
        BinarySearchTreeNode<T> node;
        node = root;

        while (node.rightChild() != null) {
            node = node.rightChild();
        }

        return node.getElement();
    }

    public boolean containsElement(T element) {
        List<T> elements = inOrder();
        return elements.contains(element);
    }


    @Override
    public List<T> inOrder() {

        List<T> elements = new ArrayList<>();
        inOrderHelper(elements, this.root);
        return elements;
    }

    private void inOrderHelper(List<T> elements, BinarySearchTreeNode<T> node) {
        if (node == null) {
            return;
        }

        inOrderHelper(elements, node.leftChild());
        visitNode(elements, node);
        inOrderHelper(elements, node.rightChild());
    }

    private void visitNode(List<T> elements, BinarySearchTreeNode<T> node) {
        elements.add(node.getElement());
    }

    private BinarySearchTreeNode<T> rebalance(BinarySearchTreeNode<T> node) {
        BalanceCase balance = getBalance(node);

        if (balance == BalanceCase.BALANCED) {
            return node;
        }

        if (balance == BalanceCase.LEFT_LEFT_HEAVY) {    // Case 1
            // Rotate right
            node = rotateRight(node);
        } else if (balance == BalanceCase.LEFT_RIGHT_HEAVY) {                                // Case 2
            // Rotate left-right
            node.addLeftChild(rotateLeft(node.leftChild()));
            node = rotateRight(node);
        } else if (balance == BalanceCase.RIGHT_RIGHT_HEAVY) {    // Case 3
            // Rotate left
            node = rotateLeft(node);
        } else {                                 // Case 4
            // Rotate right-left
            node.addRightChild(rotateRight(node.rightChild()));
            node = rotateLeft(node);
        }

        return node;
    }


    public void reBalance() {
        root = rebalance(root);
    }

    private BinarySearchTreeNode<T> rotateRight(BinarySearchTreeNode<T> node) {
        BinarySearchTreeNode<T> leftChild = node.leftChild();

        node.addLeftChild(leftChild.rightChild());
        leftChild.addRightChild(node);

        return leftChild;
    }

    private BinarySearchTreeNode<T> rotateLeft(BinarySearchTreeNode<T> node) {
        BinarySearchTreeNode<T> rightChild = node.rightChild();

        node.addRightChild(rightChild.leftChild());
        rightChild.addLeftChild(node);

        return rightChild;
    }

    /**
     * Calculates the AVL balance state of the node
     */
    private BalanceCase getBalance(BinarySearchTreeNode<T> node) {
        int balance = getBalanceFactor(node);

        if (balance < -1) {
            int leftChildBalance = getBalanceFactor(node.leftChild());
            if (leftChildBalance >= 1) {
                return BalanceCase.LEFT_RIGHT_HEAVY;
            } else {
                return BalanceCase.LEFT_LEFT_HEAVY;
            }
        } else if (balance > 1) {
            int rightChildBalance = getBalanceFactor(node.rightChild());
            if (rightChildBalance >= 1) {
                return BalanceCase.RIGHT_RIGHT_HEAVY;
            } else {
                return BalanceCase.RIGHT_LEFT_HEAVY;
            }
        }

        return BalanceCase.BALANCED;
    }

    /**
     * Calculates the balance factor of a node
     */
    private int getBalanceFactor(BinarySearchTreeNode<T> node) {
        int balance = 0;
        int rightChildHeight = -1;
        int leftChildHeight = -1;

        if (node.rightChild() != null) {
            rightChildHeight = util.getBinarySearchTreeHeight(node.rightChild());
        }

        if (node.leftChild() != null) {
            leftChildHeight = util.getBinarySearchTreeHeight(node.leftChild());
        }

        return rightChildHeight - leftChildHeight;
    }

}
