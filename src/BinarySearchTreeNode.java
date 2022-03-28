public class BinarySearchTreeNode<T extends Comparable<T>> extends BinaryTreeNode<T>
{
  private T element;
  private BinaryTreeNode<T> leftChild;
  private BinaryTreeNode<T> rightChild;

  @Override public T getElement()
  {
    return element;
  }

  @Override public void setElement(T element)
  {
    this.element = element;
  }

  @Override public void setLeftChild(BinaryTreeNode<T> newLeftChild)
  {
    if (newLeftChild.getElement().compareTo(element) < 0)
    {
      if (leftChild == null)
      {
        leftChild = newLeftChild;
      }
      else
      {
        leftChild.setLeftChild(newLeftChild);
      }
    }
  }

  @Override public void setRightChild(BinaryTreeNode<T> newRightChild)
  {
    if (newRightChild.getElement().compareTo(element) < 0)
    {
      if (rightChild == null)
      {
        rightChild = newRightChild;
      }
      else
      {
        rightChild.setLeftChild(newRightChild);
      }
    }
  }
}
