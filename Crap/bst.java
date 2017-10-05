import java.util.*;

class bst{

  public int[] in;
  public int[] pre;

  public bst(int n)
  {
    in = new int[n];
    pre = new int[n];
  }

  public int searchroot(int[] a, int x, int m, int n)
  {
    for(int i=m; i<=n; i++)
    {
      if(a[i] == x)
      return i;
    }
    return -1;
  }

  public void postorder(int a, int b, int c, int d)
  {
      //System.out.print(pre[c]+" ");
      int root = searchroot(in, pre[c], a, b);
      //System.out.println(root);

      if(root!= 0)
      {
        //if(a<=root && c+1 <= root)
        postorder(a, root, c+1, root);
        //else
        //System.out.print(pre[c+2]+" ");
        //postorder(Arrays.copyOfRange(in, 0, root), Arrays.copyOfRange(pre, 1, root));
      }
      if(root != d)
      {
        //if(root+1<=(b-root-1) && root+1<=(d-root-1))
        postorder(root+1, b-root-1, root+1, d-root-1);
        //else
        //System.out.print(pre[root+1]+" ");
        //postorder(Arrays.copyOfRange(in, root+1, in.length-root-1), Arrays.copyOfRange(pre, root+1, pre.length-root-1));
      }
      //if(root!=-1)
      System.out.print(pre[c]+" ");
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    int n, max = 0;
    boolean isbst = true;
    bst b;

    n = in.nextInt();
    //inorder = new int[n];
    //pre = new int[n];
    b = new bst(n);

    for (int i=0;i<n ;i++ )
    {
      b.pre[i] = in.nextInt();
    }

    for (int i=0;i<n ;i++ )
    {
      b.in[i] = in.nextInt();
      if(b.in[i] >= max && isbst)
        max = b.in[i];
      else
        isbst = false;
    }

    /*int[] x = Arrays.copyOfRange(inorder, 2, inorder.length);
    for (int i=0;i<x.length;i++ )
    {
      System.out.println(x[i]+" ");
    }*/
    b.postorder(0, n, 0, n);
    System.out.println("");
    if(isbst)
      System.out.println("YES");
    else
      System.out.println("NO");
  }
}
