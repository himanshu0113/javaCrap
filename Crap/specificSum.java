// Give items adding up to a specific sum from the array
// also contains the use of hashmap

import java.util.*;

class specificSum{

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
    int[] src;
    int items, total;
    int n = in.nextInt();

    for(int i=1; i<=n; i++)
    {
      total = in.nextInt();
      items = in.nextInt();

      src = new int[items+1];
      for(int j=1; j<=items; j++)
      {
        src[j] = in.nextInt();
        hash.put(src[j], j);
      }
      System.out.print("Case #" + i + ": ");
      for(int j=1; j<=items; j++)
      {
        if(hash.containsKey(total - src[j]) && hash.get(total - src[j]) != j)
        {
          System.out.print(j + " ");
          System.out.print(hash.get(total - src[j]));
          break;
        }
      }
      System.out.println("");
    }
  }
}
