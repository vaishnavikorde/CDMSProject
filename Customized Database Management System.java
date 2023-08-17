import java.util.*; // file class in java
import java.io.*;


class DBMSCreated
{
   public static void main(String args[]) throws Exception
   {
      DBMS obj = new DBMS();
      obj.StartDBMS();
     
   }
}

class Student
{
   public int Rno;
   public String Name;
   public int Age;
   public int Marks;

   public static int Generator;

   static
   {
      Generator = 0;
   }

   public Student(String str, int X, int Y)
   {
      this.Rno = ++Generator;
      this.Name = str;
      this.Age = X;
      this.Marks = Y;  
   }
   
   public void Display()
   {
      System.out.println(this.Rno+ " " +this.Name + " "+this.Age+ " "+this.Marks);
   }
}

class DBMS
{
   public LinkedList <Student> lobj;   // variable declaration

   public DBMS()       //consructor
   {
      lobj = new LinkedList<Student>();  // memory allocation for LL (lobj is a short name)
   }
   public void StartDBMS()
   {
      System.out.println("Marvellous DBMS started Succesfully ...");
      System.out.println("Table schema Created succecfully...");

      String Query;                                       // local variable to store string
      String tokens[];                                   // array to store one piece of string 

      Scanner sobj = new Scanner(System.in);
      int TokensCount = 0;

      while (true) 
      {
         System.out.println("Marvellous DBMS :"); 
         Query = sobj.nextLine();                    //variable initialization
         tokens = Query.split(" ");
         
         TokensCount = tokens.length;
            
         if (TokensCount == 1) 
         {
            if ("exit".equals(tokens[0])) 
            {
               System.out.println("Thank you for using Marvellous DBMS..");
               break;   
            }
         }
         else if(TokensCount == 2)
         {

         }
         else if(TokensCount == 3)
         {}
         else if(TokensCount == 4)
         {
            if ("select".equals(tokens[0])) 
            {
               SelectFrom();   
            }
         }
         else if(TokensCount == 5)
         {
            if ("select".equals(tokens[0])) 
            {
               if ("MAX".equals(tokens[1])) 
               {
                  System.out.println("Maximum marks are : "+Aggregate_Max());
               }   
            }
            else if("MIN".equals(Tokens[1]))
            {
               System.out.println("Minimum marks are : "+Aggregate_Min());
            }
            else if("AVG".equals(Tokens[1]))
            {
               System.out.println("Average marks are : "+Aggregate_Avg());
            }
            else if("SUM".equals(Tokens[1]))
            {
               System.out.println("Sum of marks are : "+Aggregate_Sum());
            }
         }
         else if(TokensCount == 6)
         {}
         else if(TokensCount == 7)
         {
            if ("insert".equals(tokens[0])) 
            {
               InsertIntoTable(tokens[4], Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]));
            }
            else if("delete".equals(tokens[0]))
            {
               DeleteFrom(Integer.parseInt(tokens[6]));
            }
         }
      }
   }

   // inser into table Student values(-----, -----, ------);
   public void InsertIntoTable(String name, int age, int Marks)
   {
      Student sobj = new Student(name, age, Marks);
      lobj.add(sobj);
   }

   // select * from Student
   public void SelectFrom()
   {
      System.out.println("Record from the student table are :");

      for(Student sref : lobj)
      {
         sref.Display();
      }
   }
   
   // select * from Student where rno = 11
   public void SelectFrom(int no)
   {
      System.out.println("Record from the student table are :");

      for(Student sref : lobj)
      {
         if (sref.Rno == no) 
         {
              sref.Display();
              break;
         }     
      }
   }
   //select * from Student where Name = Rahul
   public void SelectFrom(String str)
   {

      for(Student sref : lobj)
      {
         if (str.equals(sref.Name)) 
         {
              sref.Display();
              break;
         }     
      }
   }

   // select Max(marks) from Student
   public int Aggregate_Max()
   {
      Student temp = lobj.get(0);
      int iMax = temp.Marks;
      for(Student sref : lobj)
      {
         if (sref.Marks > iMax) 
         {
            iMax = sref.Marks;
         }     
      }
      return iMax;
   }

   public int Aggregate_Min()
   {
      Student temp = lobj.get(0);
      int iMin = temp.Marks;
      for(Student sref : lobj)
      {
         if (sref.Marks < iMin) 
         {
            iMin = sref.Marks;
         }     
      }
      return iMin;
   }

   public int Aggregate_Sum()
   {
      int iSum = 0;

      for(Student sref : lobj)
      {
        iSum = iSum + sref.Marks;  
      }
      return iSum;
   }

   public Double Aggregate_Avg()
   {
      double iSum = 0.0;

      for(Student sref : lobj)
      {
        iSum = iSum + sref.Marks;  
      }
      return (iSum/(lobj.size()));
   }

   //delete from student where rno = 2
   public void DeleteFrom(int no)
   {
      int i = 0;

      for(Student sref : lobj)
      {
        if(sref.Rno == no)
        {
           lobj.remove(i);
           break;
        }
        i++;
      }
      
   }

}

// Inser Query
// Insert into Student values Rahul 23 67
// 0        1     2       3     4    5  6

// no of tokens  7

//select *  from  student
//   1      2    3      4  
// no of tokens : 4  

// delete from student where Rno = 4
//