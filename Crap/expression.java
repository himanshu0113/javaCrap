import java.util.*;

public class expression{

  static char[] opstack = null;
  static int size =0;

  public static void push(char c)
  {
    //System.out.println("push");
    opstack[size] = c;
    size++;
  }

  public static int pop()
  {
    //System.out.println(" pop");
    if(size == 0)
      return -1;
    else
    {
      if(opstack[size-1] != '(')
      System.out.print(opstack[size-1] + " ");
      size--;
      return 0;
    }
  }

  public static void putinstack(char c)
  {
    //System.out.println("inside outinstack");
    //System.out.println(c);
    char now;
    if(size == 0)
      push(c);
    else
    {
      switch(c)
      {
        case '(': push(c);
                  break;
        case ')': int i =size-1;
                  while(opstack[i--] != '(' && i!=0)
                  {
                     pop();
                  }
                  pop();
                  break;
        case '*': push(c);
                  break;
        case '/': push(c);
                  break;
        case '+': now = opstack[size-1];
                  while((now == '*' || now == '/') && size !=0)
                  {
                    pop();
                    if(size != 0)
                    now = opstack[size-1];
                  }
                  push(c);
                  break;
        case '-': now = opstack[size-1];
                  while((now == '*' || now == '/') && size !=0)
                  {
                    pop();
                    if(size != 0)
                    now = opstack[size-1];
                  }
                  push(c);
                  break;
      }
    }
  }
  public static void main(String[] args)
  {

    int n, num;
    char c;

    Scanner in = new Scanner(System.in).useDelimiter("\\s");
    n = in.nextInt();
    opstack = new char[n];

    while(n-- != 0)
    {
      c = in.next().charAt(0);
      //num = Integer.parseInt(c);
      if(Character.isDigit(c))
        System.out.print(c + " ");
      else
        putinstack(c);
    }
    //System.out.println(size);

    while(size != 0)
    {
      //System.out.println("in");
      pop();
      //System.out.println("------");
    }
    System.out.println("");
    //System.out.println("out");
  }
}
