import java.util.ArrayList;

public class BinarySearchTreePrint {
    BinarySearchTreeNode<Integer> root;

    public void printTree(BinarySearchTreeNode root) {
        ArrayList<BinarySearchTreeNode<Integer>> parent = new ArrayList<>();
        parent.add(root);
        printT(parent, 64);
    }

    private void printT(ArrayList<BinarySearchTreeNode<Integer>> parent, int left) {
        ArrayList<BinarySearchTreeNode<Integer>> children = new ArrayList<>();
        BinarySearchTreeNode<Integer> current;
        boolean moreNodes = false;
        boolean firstNode = true;
        BinarySearchTreeNode<Integer> dummy = new BinarySearchTreeNode<>(0);

        int dist = 0;
        System.out.println();
        System.out.println();

        while (!parent.isEmpty()) {
            current = parent.remove(0);

            if (firstNode) {
                printSpace(left);
                if (current.getElement() != 0)
                    System.out.print(current.getElement());
                dist = 2 * left;
                firstNode = false;

                if (current.getElement() != 0) {
                    if (current.leftChild() != null) {
                        children.add(current.leftChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                    if (current.rightChild() != null) {
                        children.add(current.rightChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                } else {
                    children.add(dummy);
                    children.add(dummy);
                }
            } else {
                if (current.getElement() != 0) {
                    printSpace(dist - 1);
                    System.out.print(current.getElement());
                    if (current.leftChild() != null) {
                        children.add(current.rightChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                    if (current.rightChild() != null) {
                        children.add(current.rightChild());
                        moreNodes = true;
                    } else
                        children.add(dummy);
                } else {
                    printSpace(dist - 1);
                    System.out.print(" ");
                    children.add(dummy);
                    children.add(dummy);
                }
            }
        }

        if (moreNodes)
            printT(children, left / 2);

    }

    private void printSpace(int pos) {
        for (int i = 0; i < pos; i++)
            System.out.print(" ");

    }
}
