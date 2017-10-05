import java.util.*;

class priorityqueue{

  private int[] priority;
  int size;
  private int capacity;

  public priorityqueue(int cap)
  {
    priority = new int[cap];
    size = 0;
    capacity = cap;
  }

  public boolean isEmpty() { return size == 0; }
  public boolean isFull() { return size == capacity; }

  public void insert(int data)
  {
    if(isFull()) System.out.println("Queue Full");
    else
    {
      priority[size++] = data;
      int i = size-1;
      while(i > 0 && data > priority[(i-1)/2])
      {
        priority[i] = priority[(i-1)/2];
        i = (i-1)/ 2;
      }
      priority[i] = data;
    }
  }

  public int removemax()
  {
    if(isEmpty()) { System.out.println("Queue Empty."); return -1;}

    //System.out.println("MAX : " + priority[0]);
    int max_data = priority[0];

    priority[0] = priority[size-1];
    //System.out.println(priority[0]);
    size--;

    int i = 0;
    int n = size;
    int max;
    boolean flag = true;

    while( i < (n-1)/2 && flag)
    {
      max = i;
      if(priority[i] < priority[2*i + 1]) max = 2*i +1;
      if(priority[max] < priority[2*i +2]) max = 2*i + 2;
      if(max != i)
      {
        int temp = priority[i];
        priority[i] = priority[max];
        priority[max] = temp;
        i = max;
      }
      else flag = false;
      //System.out.println(priority[0]);
    }
    return max_data;
  }
}

public class priorityqueue_virus{

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    int t, n, m, max, killed;
    priorityqueue p;

    t = in.nextInt();
    while(t-- != 0)
    {
      killed = 0;
      n = in.nextInt();
      m = in.nextInt();

      p = new priorityqueue(n);

      for(int i=0; i<n; i++)
      {
        p.insert(in.nextInt());
      }

      while(m-- != 0)
      {
        max = p.removemax();
        p.insert(max/2);
        max -= max/2;
        killed += max;
      }

      System.out.println(killed);
    }
  }
}
