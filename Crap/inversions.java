import java.util.*;

public class inversions{

  public static void main(String[] args)
  {
    int t, n, shifts;
    int[] A;

    Scanner in  = new Scanner(System.in);

    t = in.nextInt();

    while(t-- != 0)
    {
    n = in.nextInt();

    A = new int[n];


    for(int m=0; m<n; m++)
    {
      A[m] = in.nextInt();
    }

    int temp, i , j, k;
    shifts =0;
    for(k=0; k<n-1; k++)
    {
      i = k;
      j = i+1;
      while((i>=0) && (i<j) && (A[i]>A[j]))
      {
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        shifts++;
        i--;
        j--;
      }
    }
    System.out.println(shifts);
  }
    /*for(int m=0; m<n; m++)
    {
      System.out.print(A[m] + " ");
    }
    System.out.println("");
    */

  }
}
