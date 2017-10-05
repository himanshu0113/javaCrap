//GA HW2
import java.util.*;

class gahw2{
  static int[] A = {1,2,3,4,5,6};
  static int[] B = {7,8,9,10,11,12};

  static int f(int[] a, int[] b, int k)
  {
    if(a.length !=0 && k == 1)
      return a[0]<b[0]?a[0]:b[0];
    else if(a.length == 0)
      return b[k-1];
    /*else if(k == 2 && a.length <= 1)
    {
      if(a.length<0) return b[0];  ////change this
        return a[0]>b[0]?a[0]:b[0];
    }*/
    //else if(k/2 > a.length-1)
      //return a[a.length -1]>b[k/2+1]?a[a.length -1]:b[k/2 +1];

    int k1 = a[k/2 -1];
    int k2 = b[k/2 -1];

    if(k1<=k2)
    {
      //System.out.println(k/2);
      //if(k%2 == 0)
        return f(Arrays.copyOfRange(a, k/2, a.length), Arrays.copyOfRange(b, 0, k/2), k - (k/2));
      //else
        //return f(Arrays.copyOfRange(a, k/2, a.length), Arrays.copyOfRange(b, 0, k/2 + 1), ((k+1)/2));

    }
    else
    {
      //System.out.println(k/2);
      //if(k%2 == 0)
        return f(Arrays.copyOfRange(b, k/2, b.length), Arrays.copyOfRange(a, 0, k/2 + 1), k - (k/2));
      //else
        //return f(Arrays.copyOfRange(b, k/2, b.length), Arrays.copyOfRange(a, 0, k/2 + 1), ((k+1)/2));
    }

  }

  public static void main(String[] args) {

    int k;
    Scanner in = new Scanner(System.in);
    k = in.nextInt();
    System.out.println(f(A, B, k));
  }
}
