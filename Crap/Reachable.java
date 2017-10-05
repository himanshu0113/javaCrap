import java.util.*;

class Reachable{
  int[][] g;
  private int v;
  private Queue<Integer> q;

  Reachable(int v)
  {
    this.v = v;
    g = new int[v+1][v+1];
    q = new LinkedList<Integer>();
  }

  public boolean isReachable(int s, int d)
  {
    int i, x;
    int[] visited = new int[v+1];

    visited[s] = 1;

    q.add(s);

    while(!q.isEmpty())
    {
      x = q.remove();
      i = 1;
      //System.out.print(x + "\t");

      while(i<= v)
      {
        if(g[x][i] == 1)
        {
          if(i == d)
            return true;

          if(visited[i] == 0)
          {
            q.add(i);
            visited[i] = 1;
          }
        }
        i++;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int v = in.nextInt();
    int e = in.nextInt();
    int v1 = in.nextInt();
    int v2 = in.nextInt();

    Reachable r = new Reachable(v);

    for(int i=1; i<=v; i++)
    {
      for(int j = 1; j<=v; j++)
        r.g[i][j] = 0;
    }

    for(int i=0; i<e; i++)
    {
      r.g[in.nextInt()][in.nextInt()] = 1;
    }

    if(r.isReachable(v1, v2))
    System.out.println(1);
    else System.out.println(0);


  }
}
