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

// main class
public class listunion{

public static node insertintolist(int d, node h)
{
  if(h==null)
  {
    h = new node();
    h.setdata(d);
    h.setnext(null);
    return h;
  }
  else
  {
    node temp = h;
    while(temp.getnext() != null)
    {
      temp = temp.getnext();
    }
    node newnode = new node();
    newnode.setdata(d);
    newnode.setnext(null);
    temp.setnext(newnode);
    //System.out.println(temp.getnext().getdata());
    return h;
  }
}

public static void union(node h1, node h2)
{
  node temp1 = h1;
  node temp2 = h2;
  int count =0;
  int n;

  while(temp1 != null && temp2!= null)
  {
    if(temp1.getdata() == temp2.getdata())
    {
      System.out.print(temp1.getdata()+" ");
      temp1 = temp1.getnext();
      temp2 = temp2.getnext();
      count++;
    }
    else if(temp1.getdata() < temp2.getdata())
    {
      System.out.print(temp1.getdata()+" ");
      temp1 = temp1.getnext();
      count++;
    }
    else
    {
      System.out.print(temp2.getdata()+" ");
      temp2 = temp2.getnext();
      count++;
    }
  }
  while(temp1 != null)
  {
    System.out.print(temp1.getdata()+" ");
    temp1 = temp1.getnext();
  }
  while(temp2 != null)
  {
    System.out.print(temp2.getdata()+" ");
    temp2 = temp2.getnext();
  }
  System.out.println("");
  System.out.println(count);

}

public static void main(String[] args)
{
  int x, y, data;
  Scanner in = new Scanner(System.in);
  node head1, head2;
  head1 = null;
  head2 = null;
  x = in.nextInt();
  y = in.nextInt();

  for(int i=0; i<x; i++)
  {
    data = in.nextInt();
    head1 = insertintolist(data, head1);
    //System.out.println(head1.getdata());
  }

  for(int i=0; i<y; i++)
  {
    data = in.nextInt();
    head2 = insertintolist(data, head2);
    //System.out.println(head2.getdata());
  }

  union(head1, head2);

}
}
