import java.util.*;

class node{
  int key, height;
  node left, right;

  node(int val)
  {
    key = val;
    height = 1;
  }
}

class AVLtree{

  node root;

  int max(int a, int b)
  {
    if(a>b) return a;
    else return b;
  }

  int height(node n)
  {
    if(n == null) return 0;
    else return n.height;
  }

  node rightRotate(node z)
  {
    node y = z.left;
    node temp = y.right;

    y.right = z;
    z.left = temp;

    z.height = max(height(z.left), height(z.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    return y;
  }

  node leftRotate(node z)
  {
    node y = z.right;
    node temp = y.left;

    y.left = z;
    z.right = temp;

    z.height = max(height(z.left), height(z.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    return y;
  }

  int heigthBalance(node n)
  {
    if(n == null) return 0;
    else return (height(n.left) - height(n.right));
  }

  node insert(node n, int key)
  {
    if(n == null)
      return (new node(key));

    if(key < n.key)
      n.left = insert(n.left, key);
    else if(key > n.key)
      n.right = insert(n.right, key);
    else  return n;

    n.height = max(height(n.left), height(n.right)) + 1;

    int heightdiff =  heigthBalance(n);

    if(heightdiff > 1 && key < n.left.key)
      return rightRotate(n);

    if(heightdiff > 1 && key > n.left.key)
    {
      n.left = leftRotate(n.left);
      return rightRotate(n);
    }

    if(heightdiff < -1 && key > n.right.key)
      return leftRotate(n);

    if(heightdiff < -1 && key < n.right.key)
    {
      n.right = rightRotate(n.right);
      return leftRotate(n);
    }

    return n;
  }

  void preorder(node n)
  {
    if(n != null)
    {
      System.out.println(n.key + " ");
      preorder(n.left);
      preorder(n.right);
    }
  }
}

public class AVLtreeSample{

  public static void main(String[] args) {
    AVLtree tree = new AVLtree();

    tree.root = tree.insert(tree.root, 10);
    tree.root = tree.insert(tree.root, 20);
    tree.root = tree.insert(tree.root, 30);
    tree.root = tree.insert(tree.root, 40);
    tree.root = tree.insert(tree.root, 50);
    tree.root = tree.insert(tree.root, 25);

    System.out.println("Preorder traversal" + " of constructed tree is : ");
    tree.preorder(tree.root);

  }
}
