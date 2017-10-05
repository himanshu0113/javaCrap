//stack implementation

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

class stack{
  protected node top;
  private int size;
  private int capacity;

  public stack() { top = null; size = 0; capacity = 100;}
  public stack(int c) { top = null; size = 0; capacity = c;}
  public boolean isEmpty() { return top==null; }
  public boolean isFull() { return size==capacity; }
  public int getSize() { return size; }

  public void push( int data )
  {
    if(!isFull())
    {
      node temp = new node(data, null);
      temp.setnext(top);
      top = temp;
      size++;
    }

  }

  public int pop()
  {
    if(isEmpty())
    {
      //System.out.println("Stack Empty!");
      return -1;
    }
    else
    {
      int data = top.getdata();
      top = top.getnext();
      size--;
      return data;
    }
  }

  public int peek()
  {
    if(!isEmpty()) return top.getdata();
    else return -1;
  }

  public void display()
  {
    int i = size;
    node t = top;
    while(i-- != 0)
    {
      System.out.print(t.getdata());
      t = t.getnext();
    }
    System.out.println("");
  }

}

//stackmin class (main function)
public class stackmin{

  private stack s1 = null;
  private stack s2 = null;

  public stackmin(int n)
  {
    s1 = new stack(n);
    s2 = new stack(n);
  }

  public int findmin()
  {
    if(s1.isEmpty()) return -1;
    else return s1.peek();
  }

  public void sortstack(int data)
  {
    if(s1.isEmpty())
    {
      s1.push(data);
    }
    else if(!s1.isFull())
    {
      while(!s1.isEmpty() && (s1.peek() < data))
      {
        s2.push(s1.pop());
      }
      s1.push(data);

      while(!s2.isEmpty())
      {
        s1.push(s2.pop());
      }
    }
    //s1.display();
    //s2.display();
  }

  public void sortupdate(int d)
  {
    while(!s1.isEmpty() && (s1.peek() < d))
    {
      s2.push(s1.pop());
      //System.out.println(s2.peek());
    }
    s1.pop();
    while(!s2.isEmpty())
    {
      s1.push(s2.pop());
    }
    //s1.display();
    //s2.display();

  }

  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    stackmin f  = null;

    int q, n, qr, data;

    q = in.nextInt();
    n = in.nextInt();
    stack s = new stack(n);
    f = new stackmin(n);

    while(q-- != 0)
    {
      qr = in.nextInt();

      switch(qr)
      {
        case 1: data = in.nextInt();
                s.push(data);
                f.sortstack(data);
                break;
        case 2: int d = s.pop();
                System.out.println(d);
                if(d != -1) f.sortupdate(d);
                break;
        case 3: data = f.findmin();
                System.out.println(data);
                break;
        //default: System.out.println("Wrong option!");
      }

    }

  }
}
