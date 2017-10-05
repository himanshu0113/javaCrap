import java.util.*;

class internet{
  int[][] g;
  boolean[] dfs_visited;
  int domain_count;
  int[] domains;
  int v;
  int count;

  internet(int v)
  {
    this.v = v;
    domain_count = 0;
    g = new int[v+1][v+1];
    dfs_visited = new boolean[v+1];
    domains = new int[v+1];
  }

  public void countdomains()
  {
    domain_count = 0;
    for(int j=1; j<=v; j++)
    {
      if(!dfs_visited[j])
      {
        count = 1;
        dfs_visited[j] = true;
        DFS(j);
      }
    }

    int min =0, temp;
    for(int i=0; i<domains.length; i++)
    {
      min = i;
      for(int j=i+1; j<domains.length; j++)
      {
        if(domains[j] < domains[min])
          min = j;
      }

      temp = domains[min];
      domains[min] = domains[i];
      domains[i] = temp;
    }


    System.out.println(domain_count);
    for (int i : domains) {
      if(i != 0)
        System.out.print(i + " ");
    }
    System.out.println("");
  }

  void DFS(int v)
  {
    int[] visited = new int[this.v+1];
    for (int i=1; i<=this.v ;i++ ) {
      visited[i] = 1;
    }

    dfs_itr(v, visited);
    domains[domain_count++] = count;
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
          {
            count++;
            dfs_itr(j, visited);
          }
      }
    }
    visited[v] = 3;
    dfs_visited[v] = true;

  }

  public static void main(String[] args) {
    internet s;
    Scanner in = new Scanner(System.in);

    int n, d, x, y;

    n = in.nextInt();
    d = in.nextInt();
    s = new internet(n);

    for(int i=1; i<=n; i++)
    {
      for(int j = 1; j<=n; j++)
        s.g[i][j] = 0;
    }

    for (int i=1; i<=d ; i++) {
      x = in.nextInt();
      y = in.nextInt();
      s.g[x][y] = 1;
      s.g[y][x] = 1;
    }

    s.countdomains(); // implement this
  }
}
