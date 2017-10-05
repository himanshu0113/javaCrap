import java.util.*;

class node{
  String fname;
  String lname;
  int index;

  public node(String f, String l, int i)
  {
    fname = f;
    lname = l;
    index = i;
  }
}

public class minHeap{

  private node[] heap;
  private int size;

  public minHeap()
  {
    heap = new node[1000000];
    size = 0;
  }

  void initHeap(String fname, String lname)
  {
    heap[0] = new node(fname, lname, 1);
    size++;
    //System.out.println(heap[0].fname + " " + heap[0].lname + " " + size);
  }

  int compare(node n1, node n2)
  {
    int i = n1.fname.compareTo(n2.fname);
    if(i < 0)
      return -1;
    else if(i == 0)
      {
        if(n1.lname.compareTo(n2.lname) < 0)
          return -1;
      }
    return 0;
  }

  void insert(String fname, String lname)
  {
    node temp = new node(fname, lname, size);
    int i = size;
    heap[i] = temp;
    size++;
    while(i>0 && compare(heap[i], heap[(i-1)/2]) < 0)
    {
      int s = heap[i].index;
      node t = heap[i];
      heap[i] = heap[(i-1)/2];
      heap[(i-1)/2] = t;
      heap[i].index = heap[(i-1)/2].index;
      heap[(i-1)/2].index = s;
      i = (i-1)/2;
    }

    System.out.println(heap[i].index);
  }

  void findmin()
  {
    if(size > 0)
    System.out.println(heap[0].fname + " " + heap[0].lname);
    else System.out.println(-1);
  }

  void heapify(int i)
  {
    int n = size-1;
    int min;
    boolean flag = true;

    while(i < (n-1)/2 && flag)
    {
      min = i;
      if(compare(heap[i], heap[2*i + 1]) > 0) min = 2*i+1;
      if((2*i+2)<n && compare(heap[min], heap[2*i+2]) > 0) min = 2*i+2;
      if(min != i)
      {
        int s = heap[i].index;
        node t = heap[i];
        heap[i] = heap[min];
        heap[min] = t;
        heap[i].index = heap[min].index;
        heap[min].index = s;
        i = min;
      }
      else flag = false;
    }
  }

  void deletemin()
  {
    if(size == 0)
      System.out.println(-1);
      else
    {
      System.out.println(heap[0].fname + " " + heap[0].lname);
      heap[0] = heap[size-1];
      heapify(0);
    }
  }

  void delete(int i)
  {
    if(size == 0)
      System.out.println(-1);
      else
    {
      System.out.println(heap[0].fname + " " + heap[0].lname);
      heap[i-1] = heap[size-1];
      heapify(i-1);
    }
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in).useDelimiter("\\s");
    int t = Integer.parseInt(in.nextLine());
    String s;
    minHeap m = new minHeap();
    t--;
    System.out.println(t);
    s = in.next(); //ignoring InitHeap, since it will run only once
    m.initHeap(in.next(), in.next());

    while(t-- != 0)
    {
      s = in.next();
      if(s.compareTo("Insert") == 0)
      {
        m.insert(in.next(), in.next());
      }
      else if(s.compareTo("DeleteMin") == 0)
      {
        m.deletemin();
      }
      else if(s.compareTo("FindMin") == 0)
      {
        m.findmin();
      }
      else if(s.compareTo("Delete") == 0)
      {
        m.delete(Integer.parseInt(in.next()));
      }
    }
  }
}
