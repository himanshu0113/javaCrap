/*
* OOPD Lab Assignment 2 - Course Management System (along with bonus part)
* Submitted By: Himanshu Aggarwal
* Roll no.: MT17015
*
* Assumptions:
* - Professor must be added before course assigned to that Professor
* - All courses must be added with along with their dependencies
* - The courses which have no dependencies must be added with dependencies as - degree and re-requisite as nan
*   and year as 0
* - modify() function in course class will update the max students only if the new value is greater than the
*   old one, but professor name will be updated everytime.
*/

import java.util.*;
import java.io.*;

class Student{
  private String name;
  private int rollno;
  private String degree;
  private int year;
  private ArrayList<String> courses;

  public Student(String name, int rollno, String degree, int year)
  {
	  setname(name);
	  setrollno(rollno);
	  setdegree(degree);
	  setyear(year);
	  this.courses = new ArrayList<String>();
  }

  public void enroll(String course)
  {
	  if(!this.courses.contains(course))
    {
      this.setcourses(course);
    }
	  else
		  System.out.println("---->Course already taken.");
  }

  public void unenroll(String course)
  {
	  if(this.courses.contains(course))
		  this.courses.remove(course);
	  else
		  System.out.println("---->This course is never taken by the student.");
  }

  public void showStudent()
  {
	  System.out.println("Name: " + this.name);
	  System.out.println("Degree: " + this.degree);
	  System.out.println("Year: " + this.year);
	  System.out.println("Courses enrolled: " + this.courses);
  }

  void setname(String name)
  {
	  this.name = name;
  }

  public String getname()
  {
	  return this.name;
  }

  void setrollno(int rollno)
  {
	  this.rollno = rollno;
  }

  public int getrollno()
  {
	  return this.rollno;
  }

  public void setdegree(String degree)
  {
	  this.degree = degree;
  }

  public String getdegree()
  {
	  return this.degree;
  }

  public void setcourses(String course)
  {
	  this.courses.add(course);
  }

  public ArrayList<String> getcourses()
  {
	  return this.courses;
  }

  public void setyear(int year)
  {
	  this.year = year;
  }

  public int getyear()
  {
	  return this.year;
  }

}

class Professor{

  String name;
  String area;
  ArrayList<String> courses;

  public Professor(String name, String area)
  {
	  this.setname(name);
	  this.setarea(area);
	  this.courses = new ArrayList<String>();
  }

  public void showProf()
  {
	  System.out.println("Name: " + this.name);
	  System.out.println("Area of expertise: " + this.area);
	  System.out.println("Course Assigned: " + this.courses);
  }

  public void setname(String name)
  {
	  this.name = name;
  }

  public String getname()
  {
	  return this.name;
  }

  public void setarea(String area)
  {
	  this.area = area;
  }

  public String getarea()
  {
	  return this.area;
  }

  public void setcourses(String course)
  {
	  this.courses.add(course);
  }

  public ArrayList<String> getcourses()
  {
	  return this.courses;
  }
}

class Course{
  String name;
  int max_stud;
  String prof;
  ArrayList<String> stud_enrolled;
  Prereq p;
  private int stu_count;

  public Course(String name, int max_stud, String prof, String degree, int year, String prereq)
  {
	  this.setname(name);
	  this.setmax_stud(max_stud);
	  this.setprof(prof);
	  stud_enrolled = new ArrayList<String>();
    p = new Prereq(degree, year, prereq);
    this.stu_count = 0;

  }

  public void modify(int max_stud, String prof)
  {
	  if(max_stud > this.max_stud)
		  this.setmax_stud(max_stud);

	  this.setprof(prof);
  }

  public Boolean check(Student s)
  {
    if(this.p.getdegree().compareTo("nan")==0) {return true;}
    else
      return this.p.check(s);
  }

  public Boolean overflow()
  {
    if(this.stu_count>=this.max_stud)
      {
        System.out.println("Cannot accomodate students to this course. Class is full.");
        return true;
      }
      else return false;
  }

  public void showCourse()
  {
	  System.out.println("Name: " + this.name);
	  System.out.println("Maximum Students: " + this.max_stud);
	  System.out.println("Professor assigned: " + this.prof);
	  System.out.println("Students enrolled: " + this.stud_enrolled);
    this.p.showpre();
  }

  public void setname(String name)
  {
	  this.name = name;
  }

  public String getname()
  {
	  return this.name;
  }

  public void setmax_stud(int max_stud)
  {
	  this.max_stud = max_stud;
  }

  public int getmax_stud()
  {
	  return this.max_stud;
  }

  public void setprof(String prof)
  {
	  this.prof = prof;
  }

  public String getprof()
  {
	  return this.prof;
  }

  public void setstud_enrolled(String st)
  {
    this.stu_count++;
    System.out.println(this.stu_count);
	  this.stud_enrolled.add(st);
  }

  public void remove_stud_enrolled(String st)
  {
	  if(this.stud_enrolled.contains(st))
		  {
        this.stu_count--;
        this.stud_enrolled.remove(st);
      }
	  else
		  System.out.println("---->This course was never taken by the student.");
  }

  public ArrayList<String> getstud_enrolled()
  {
	  return this.stud_enrolled;
  }
}

class Prereq{
  private String degree;
  private int year;
  private String prereq_course;

  public Prereq(String degree, int year, String prereq_course)
  {
    this.degree = degree;
    this.year = year;
    this.prereq_course = prereq_course;
  }

  public Boolean check(Student s)
  {
    if(s.getdegree().compareTo(this.degree)==0 && s.getyear() == this.year)
    {
      for(String c : s.getcourses())
      {
        if(c.compareTo(this.prereq_course) == 0)
          return true;
      }

    }
    System.out.println("Pre-requisites not fulfilled.");
    return false;
  }

  public String getdegree()
  {
    return this.degree;
  }

  public void showpre()
  {
    System.out.println("Pre-requisites:");
    System.out.println("Degree: " + this.degree);
    System.out.println("Year: " + this.year);
    System.out.println("Course: " + this.prereq_course);
  }
}

public class course_management{
  ArrayList<Student> stud;
  ArrayList<Course> courses;
  ArrayList<Professor> profs;

  public course_management()
  {
	  stud = new ArrayList<Student>();
	  courses = new ArrayList<Course>();
	  profs = new ArrayList<Professor>();
  }

  public void add(Object obj)
  {
	  if(Student.class.isInstance(obj))
	  {
		  for(Student test : this.stud)
		  {
			  if(test.getname().compareTo(((Student)obj).getname()) == 0)
				  {
				  	System.out.println("---->Student with same name already exists.");
				  	return;
				  }
		  }
		  stud.add((Student)obj);
	  }
	  else if(Course.class.isInstance(obj))
	  {

		  for(Professor p : this.profs)
		  {
			  if(((Course)obj).prof.compareTo(p.getname())==0)
				  {
            courses.add((Course)obj);
				    p.setcourses(((Course)obj).getname());
				    return;
				  }
		  }
		  System.out.println("Professor not found.");
	  }
	  else if(Professor.class.isInstance(obj))
	  {
		  profs.add((Professor)obj);
	  }
	  else
		  System.out.println("---->Undefined class object added.");
  }

  public static void main(String[] args) {
    File file = new File("input.txt");
    try{
      Scanner in = new Scanner(file).useDelimiter("\\s");
      String s;

      course_management manager = new course_management();

      while(in.hasNext())
      {
        s = in.next();
        if(s.toLowerCase().compareTo("adds") == 0)
        {
        	Student t = new Student(in.next().toLowerCase(), in.nextInt(), in.next().toLowerCase(), in.nextInt());
        	manager.add(t);
          //System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("addp") == 0)
        {
        	Professor t = new Professor(in.next().toLowerCase(), in.next().toLowerCase());
        	manager.add(t);
          //System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("addc") == 0)
        {
        	Course t = new Course(in.next().toLowerCase(), in.nextInt(), in.next().toLowerCase(), in.next().toLowerCase(), in.nextInt(), in.next().toLowerCase());
        	manager.add(t);
          //System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("enroll") == 0)
        {
        	String cname = in.next().toLowerCase();
        	String sname = in.next().toLowerCase();
        	int flag = 0;
          Student temp = null;
          for(Student st : manager.stud)
          {
              if(st.getname().compareTo(sname)==0)
                {
                  temp = st;
                  break;
                }
          }
          if(temp == null) {System.out.println("Student does not exists."); continue;}
        	for(Course c : manager.courses)
        	{
        		if(c.getname().compareTo(cname)==0)
        		{
              if(!c.check(temp) || c.overflow()) {flag = 2; break;}

        			c.setstud_enrolled(sname);
        			flag = 1;
        			break;
        		}
        	}

        	if(flag == 1)
        	{
        		flag = 0;
            for(Student st : manager.stud)
            {
                if(st.getname().compareTo(sname)==0)
                  {
                    st.enroll(cname);
                    flag = 1;
                    break;
                  }
            }
        	}

        	if(flag == 0)
        		System.out.println("Student/Course does not exists.");
          System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("unenroll") == 0)
        {
        	String cname = in.next().toLowerCase();
        	String sname = in.next().toLowerCase();
        	int flag = 0;
        	for(Course c : manager.courses)
        	{
        		if(c.getname().compareTo(cname)==0)
        		{
        			c.remove_stud_enrolled(sname);
        			flag = 1;
        			break;
        		}
        	}
        	if(flag == 1)
        	{
        		flag = 0;
        		for(Student st : manager.stud)
            	{
            		if(st.getname().compareTo(sname)==0)
            			{
            				st.unenroll(cname);
            				flag = 1;
            				break;
            			}
            	}
        	}

        	if(flag == 0)
        		System.out.println("Student/Course does not exists.");
          System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("modify") == 0)
        {
        	String cname = in.next().toLowerCase();
        	int newmax_stud = in.nextInt();
        	String newprof = in.next().toLowerCase();
        	for(Course c : manager.courses)
        	{
        		if(c.getname().compareTo(cname)==0)
        		{
        			c.modify(newmax_stud, newprof);
        		}
        	}
          System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("shows") == 0)
        {
        	String name = in.next().toLowerCase();
        	for(Student st : manager.stud)
        	{
        		if(st.getname().compareTo(name) == 0)
        		{
        			st.showStudent();
        			continue;
        		}
        		System.out.println("---->Student name not found.");
        	}
          System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("showp") == 0)
        {
        	String name = in.next().toLowerCase();
        	for(Professor pf : manager.profs)
        	{
        		if(pf.getname().compareTo(name) == 0)
        		{
        			pf.showProf();
        			continue;
        		}
        		System.out.println("---->Professor name not found.");
        	}
          System.out.println("--------------------------------");
        }
        else if(s.toLowerCase().compareTo("showc") == 0)
        {
        	String name = in.next().toLowerCase();
        	for(Course c : manager.courses)
        	{
        		if(c.getname().compareTo(name) == 0)
        		{
        			c.showCourse();
        			continue;
        		}
        	}
          System.out.println("--------------------------------");
        }
      }
    }
    catch(FileNotFoundException ex)
    {
      System.out.println("---->Input file not found.");
    }
  }


}
