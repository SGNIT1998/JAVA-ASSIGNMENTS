import java.io.*;
import java.util.Scanner;
public class Student_Record
{
	//Instance variables
	String[] name=new String[5];   // store name of five students
	char[] grade=new char[5];  // store grade of five students
	int[][] marks=new int[5][4];
	// Instance methods
	void setdata(int sn,int[] marks,String Name) // why static is here
	{
		name[sn]=Name;
		float avg;
		avg=0;
		for(int j=0;j<4;j++)
		{
			this.marks[sn][j]=marks[j];
			avg+=marks[j];
		}
		avg/=4;
		if(avg>0 && avg<=59)
			grade[sn]='F';
		if(avg>59 && avg<=69)
			grade[sn]='D';
		if(avg>69 && avg<=79)
			grade[sn]='C';
		if(avg>79 && avg<=89)
			grade[sn]='B';
		if(avg>89 && avg<=100)
			grade[sn]='A';
	}
	 //Displaying all details of student
    void display(int n)
	{
	  for(int i=0;i<5;i++)
	  {
		  System.out.println("Details of "+(i+1)+" student");
		  System.out.println(name[i]);
		  System.out.println("Marks in four Subjects");
		  for(int j=0;j<4;j++)
		  {
			  System.out.println(marks[i][j]);
		  }
		  System.out.println("Grade :"+grade[i]);
	  }
	}
	//main class start here
	public static void main(String args[])
	{
	  Student_Record var = null;
	  Scanner sc=new Scanner(System.in);
	  //Enter the details of five students
	  for(int i=0;i<5;i++)
	  {
		  System.out.println("enter "+(i+1)+" student details:");
		  System.out.println("Enter the student name");
		  String name;
		  name=sc.next();
		  System.out.println("Enter the students marks in four subjects:");
		  int[] marks=new int[4];
		  for(int j=0;j<4;j++)
		  { 
			  //Exception if marks obtained by student is less than zero or greater than 100
			  try {
				  
		    marks[i]=sc.nextInt();
		    if(marks[i]<0 || marks[i]>100)
		    	throw new MarksNotValid("demo"); // throw exception
		    }
		  catch (MarksNotValid e) //handled exception
		  {
			  System.out.println("Marks is not vald Either less than zero or greater then 100" + e);
		  }
		  }
		  var.setdata(i,marks,name);
	  }
	  sc.close();
	  //displaying grade of students
	  var.display(5);
	}
	//main class finish here
}

class MarksNotValid extends Exception
{
	public MarksNotValid(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
}