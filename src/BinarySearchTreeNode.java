public class BinarySearchTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T>
{
  private T element;
  private BinaryTreeNode<T> leftChild;
  private BinaryTreeNode<T> rightChild;

  public BinarySearchTreeNode(T element)
  {
    super(element);
  }

  @Override public T getElement()
  {
    return element;
  }

  @Override public void setElement(T element)
  {
    this.element = element;
  }

  @Override public void addLeftChild(BinaryTreeNode<T> newLeftChild)
  {
    if (newLeftChild.getElement().compareTo(element) < 0)
    {
      if (leftChild == null)
      {
        leftChild = newLeftChild;
      }
      else
      {
        leftChild.addLeftChild(newLeftChild);
      }
    }
  }

  @Override public void addRightChild(BinaryTreeNode<T> newRightChild)
  {
    if (newRightChild.getElement().compareTo(element) < 0)
    {
      if (rightChild == null)
      {
        rightChild = newRightChild;
      }
      else
      {
        rightChild.addRightChild(newRightChild);
      }
    }
  }
}
