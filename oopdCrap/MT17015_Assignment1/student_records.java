/**
* OOPD Lab Assignment 1
* Submitted by: Himanshu Aggarwal
* Roll No.: MT17015
**/

//Student Records Management

import java.util.*;
import java.io.*;

class node{
  String fname;
  String lname;
  String[] courses;

  public node(String fname, String lname, String[] courses)
  {
    this.fname = fname;
    this.lname = lname;
    this.courses = courses;
  }

  public void display()
  {
    System.out.println("Name: " + this.fname + " " + this.lname);
    System.out.println("Courses taken : " + Arrays.toString(courses));
  }
}

class StudentComparator implements Comparator{
  public int compare(Object o1, Object o2)
  {
    node s1 = (node)o1;
    node s2 = (node)o2;

    int i = s1.fname.compareTo(s2.fname);
    return i;
  }
}

public class student_records{

  private node[] students;
  private int size;
  private StudentComparator c = new StudentComparator();

  public student_records()
  {
    students = new node[100000];
    size = 0;
  }

  public boolean isEmpty() { return size == 0; }

  public void insert(String fname, String lname, String[] courses)
  {
    node temp = new node(fname, lname, courses);
    int i = size;
    students[i] = temp;
    size++;
    while(i>0 && c.compare(students[i], students[(i-1)/2]) < 0)
    {
      node t = students[i];
      students[i] = students[(i-1)/2];
      students[(i-1)/2] = t;
      i = (i-1)/2;
    }
  }

  public void show()
  {
    if(isEmpty()) { System.out.println("No records to show."); return; }

    for(int i=0; i<size; i++)
    {
      students[i].display();
    }
  }

  public void findmax()
  {
    if(size > 0)
    System.out.println(students[0].fname + " " + students[0].lname);
    else System.out.println("No records found.");
  }

  public void extract()
  {
    if(size > 0)
    {
        System.out.println(students[0].fname + " " + students[0].lname);
        delete(students[0].fname, students[0].lname);
        /*
        int i= 0;
        int max;
        while(i<size)
        {
          if((2*i +1)<size && (2*i +2)<size)
          {
            if(c.compare(students[2*i +1], students[2*i + 2]) >= 0)
            {
              max = 2*i + 1;
            }
            else{
              max = 2*i + 2;
            }
          }
          else break;

          if(c.compare(students[i], students[max]) < 0)
          {
            node t = students[i];
            students[i] = students[max];
            students[max] = t;
            i = max;
          }
          else
            break;
        }
        */
    }
    else System.out.println("No records found.");
  }

  public void delete(String fname, String lname)
  {
    for(int i=0; i<size; i++)
    {
      if(students[i].fname.compareTo(fname) == 0 && students[i].lname.compareTo(lname) == 0)
      {
        if(i == size-1)
          size--;
        else{
          students[i] = students[size-1];
          size--;
          int max;
          while(i<size)
          {
            if((2*i +2)<size)
            {
              if(c.compare(students[2*i +1], students[2*i + 2]) >= 0)
              {
                max = 2*i + 1;
              }
              else{
                max = 2*i + 2;
              }
            }
            else if((2*i +1)<size)
            {
              max = 2*i + 1;
            }
            else break;

            if(c.compare(students[i], students[max]) > 0)
            {
              node t = students[i];
              students[i] = students[max];
              students[max] = t;
              i = max;
            }
            else
              break;

          }
        }
        break;
      }
    }
  }

  public static void main(String[] args) {
    File file = new File("input.txt");
    try{
      Scanner in = new Scanner(file).useDelimiter("\\s");
      String s;

      student_records record = new student_records();

      while(in.hasNext())
      {
        s = in.next();
        if(s.toLowerCase().compareTo("insert") == 0)
        {
          String f = in.next().toLowerCase();
          //System.out.println(f);
          String l = in.next().toLowerCase();
          //System.out.println(l);
          String[] c = in.nextLine().split(",");
          //System.out.println(c);

          record.insert(f, l, c);
          //System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("extract-max") == 0)
        {
          record.extract();
          System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("maximum") == 0)
        {
          record.findmax();
          System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("delete") == 0)
        {
          record.delete(in.next().toLowerCase(), in.next().toLowerCase());
          //System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("show") == 0)
        {
          record.show();
          System.out.println("--------------------------------");
        }
      }
    }
    catch(FileNotFoundException ex)
    {
      System.out.println("Input file not found.");
    }
  }

}
