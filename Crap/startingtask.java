import java.util.*;

class startingtask{
  int[][] g;
  boolean[] visited;
  int v;

  startingtask(int v)
  {
    this.v = v;
    g = new int[v+1][v+1];
  }

  public void detectcycle()
  {
    boolean flag = true;
    String ans = new String("");
    for(int j=1; j<=v; j++)
    {
      DFS(j);
      /*flag = true;
      for(int i=1; i<=v; i++)
      {
        //if(g[i][j] == 1)
          //{flag = false; break; }
      }
      if(flag)
      {
        DFS(j);
        //ans.concat(j + " ");
      }*/
    }

    for(int j=1; j<=v; j++)
    {
      flag = true;
      for(int i=1; i<=v; i++)
      {
        if(g[i][j] == 1)
          {flag = false; break; }
      }
      if(flag)
      {
        System.out.print(j + " ");
      }
    }
    System.out.println("");
  }

  void DFS(int v)
  {
    int[] visited = new int[this.v+1];
    for (int i=1; i<this.v ;i++ ) {
      visited[i] = 1;
    }
    //if(!visited[0]) System.out.println("wbfwfbjhw");
    dfs_itr(v, visited);
  }

  private void dfs_itr(int v, int[] visited)
  {
    visited[v] = 2;
    //System.out.println(v);
    for(int j=1; j<=this.v; j++)
    {
      if(g[v][j] == 1)
      {
        if(visited[j] == 1)
          dfs_itr(j, visited);

        if(visited[j] == 2)
          {System.out.println("-1"); System.exit(0);}
      }
    }
    visited[v] = 3;

  }

  public static void main(String[] args) {
    startingtask s;
    Scanner in = new Scanner(System.in);

    int n, d;

    n = in.nextInt();
    d = in.nextInt();
    s = new startingtask(n);

    for(int i=1; i<=n; i++)
    {
      for(int j = 1; j<=n; j++)
        s.g[i][j] = 0;
    }

    for (int i=1; i<=d ; i++) {
      s.g[in.nextInt()][in.nextInt()] = 1;
    }

    s.detectcycle(); // implement this
  }
}
