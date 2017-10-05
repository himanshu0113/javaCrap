import java.util.*;

class node{
  int data;
  node next;

  public node(int d, node n)
  {
    data = d;
    next = n;
  }
  public node(){}

  public int getdata()
  {
    return data;
  }
  public node getnext()
  {
    return next;
  }
  public void setdata(int d)
  {
    data = d;
  }
  public void setnext(node n)
  {
    next = n;
  }

}

class queue{
  protected node front;
  protected node rear;
  int size;
  int capacity;

  public queue() { front = null; rear = null; size = 0; capacity = 100;}
  public queue(int c) { front = null; rear = null; size = 0; capacity = c;}
  public boolean isEmpty() { return front == null; }
  public boolean isFull() { return size==capacity; }
  public int getSize() { return size; }

  public void enqueue(int data)
  {

    node n = new node(data, null);
    if(isEmpty())
    {
      front = n;
      rear = n;
      size++;
    }
    else
    {
      rear.setnext(n);
      rear = rear.getnext();
      size++;
    }
  }

  public int dequeue()
  {
    if(isEmpty())
    return -1;
    else
    {
      int temp = front.getdata();
      front = front.getnext();
      size--;
      return temp;
    }
  }

  public void display()
  {
    int i = size;
    node t = front;
    while(t != null)
    {
      System.out.print(t.getdata() + " ");
      t = t.getnext();
    }
    System.out.println("");
  }
}

public class queueoperation{

  private queue temp = null;
  private int max;

  public queueoperation(int n)
  {
    temp = new queue(n);
    max = 0;
  }

  public queue enqueued(queue q, int n1)
  {
    int data;
    int flag = 0;
    max = 0;
    while(n1-- != 0)
    {
      data = q.dequeue();
      if(max<data) max = data;
      temp.enqueue(data);
    }
    //temp.display();
    //q.display();

    while(!temp.isEmpty())
    {

      data = temp.dequeue();
      if(max == data && flag == 0) { flag++; continue;}
      else
      q.enqueue(data);
    }
    //temp.display();
    //q.display();

    return q;
  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    int n, data, n1, n2;
    queueoperation qp;
    queue q;

    n = in.nextInt();
    q = new queue(n);
    qp = new queueoperation(n);

    while(n-- != 0)
    {
      q.enqueue(in.nextInt());
    }
    //q.display();

    n1 = in.nextInt();
    n2 = in.nextInt();

    while(n2-- != 0)
      {q = qp.enqueued(q, n1);}

    q.display();

  }
}
