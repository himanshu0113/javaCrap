import java.util.*;

public class arrayopt{

  public static int insertelement(int[] arr, int n, int num){
    if(n==0){arr[0]=num; return 0;}
    int i=0, temp, loc;
    while(arr[i]<num && i<n)
    {i++;}
    loc = i;
    while(i<=n)
    {
      temp = arr[i];
      arr[i] = num;
      num = temp;
      i++;
    }
    return loc;
  }

  public static int deleteelement(int[] arr, int n, int num){
    if(n==1) return 0;
    int i=0, temp, loc;
    while(arr[i]!=num && i<n)
    {i++;}
    loc = i;
    while(i<n-1)
    {
      arr[i] = arr[i+1];
      i++;
    }
    return loc;
  }

  public static void display(int[] arr, int n){
    for(int i=0; i<n; i++)
    {
      System.out.print(arr[i]+" ");
    }
    System.out.println("");
  }

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int MAXN = in.nextInt();
    int n = in.nextInt();
    int q = in.nextInt();
    int[] arr = new int[MAXN];
    int qr, num, shifts, loc;

    for(int i =0; i<n; i++)
    {
      arr[i] = in.nextInt();
    }

    for(int i=0; i<q; i++)
    {
      qr = in.nextInt();

      //insertion
      if(qr==1)
      {
        num = in.nextInt();
        if(n==MAXN)
        System.out.println(n+" "+0);
        else
        {
          loc = insertelement(arr, n, num);
          shifts = n - loc;
          n++;
          System.out.println(n+" "+shifts);
        }
      }
      //deletion
      else if(qr==2)
      {
        num = in.nextInt();
        if(n==0)
        {
          System.out.println(0+" "+0);
        }
        else
        {
          loc = deleteelement(arr, n, num);
          n--;
          shifts = n - loc;
          System.out.println(n+" "+shifts);
        }
      }
      //display
      else if(qr==3)
      {
        display(arr, n);
      }
    }

  }
}
