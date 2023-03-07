package criminalinformationsystem;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;
import java.io.Serializable;
public class CriminalInformationSystem implements Serializable {
    File file=new File("ko.txt");
    ArrayList<String> usernames = new ArrayList<String>();
    ArrayList<String> passwords = new ArrayList<String>();
    ArrayList<CriminalInformationSystem> criminal = new ArrayList<CriminalInformationSystem>();

    private String name;
    private String fname;
    private String sex;
    private String address;
    private int age;
    private String date;
    private String crime;

     CriminalInformationSystem(String name,String fname, String sex, String address, int age, String date,String crime) {
       this.name=name;
       this.fname=fname;
       this.sex=sex; 
        this.address=address;  
        this.age=age;
        this.date=date;
         this.crime=crime;
    }
    public void setname(String name){
     this.name=name;   
    }
     public void setfname(String fname){
     this.fname=fname;   
    }
     public void setsex(String sex){
     this.sex=sex;   
    }
      public void setaddress(String address){
     this.address=address;   
    }
       public void setage(int  age){
     this.age=age;   
    }
        public void setdate(String date){
     this.date=date;   
    }
      public void setcrime(String crime){
     this.crime=crime;   
    }  
     public String getname(){
       return name;
       
     }
     public String getfname(){
       return fname;
       
     }
    public String getsex(){
       return sex;
       
     }
    public String getaddress(){
       return address;
       
     }
    public int getage(){
       return age;
       
     }
    public String getdate(){
       return date;
       
     }
    public String getcrime(){
       return crime;
       
     }
    public String toString(){
        return  name+"      "+fname+"         "+sex+"      "+address+"     "+age+"     "+date+"    "+crime;
   }
Scanner sc = new Scanner(System.in);
    
    public void login()
    {
        try{
        System.out.println("Please enter your user id");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        if(usernames.contains(username) && passwords.contains(password))
        {
            System.out.println("Welcome! You are Logged in ");
            menu(); 
        }
        else
        {
            System.out.println("Invalid username or password. Please try again.");
            login();
       
        }
        }
        catch(Exception e){
          e.printStackTrace();
        }
    }
    public void register()
    {
        try{
        System.out.println("Please enter your user id");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();
        usernames.add(username);
        passwords.add(password);

        System.out.println("Registeration Succesful. Now you can login.");
        login();
            
        }
        catch(Exception e){
        e.printStackTrace();
    }
    }
 public   void menu(){
    
     Scanner scan=new Scanner(System.in); 
     try{
          System.out.println("WELCOME TO CRIMINAL INFORMATION SYSTEM");
  System.out.println("#######################################################################");
  System.out.println("###############   ENTER YOUR CHOICE                    ################");
  System.out.println("###############    1.To add criminal                   ################");
  System.out.println("###############    2.To display information            ################");
  System.out.println("###############    3.To read from file                 ################");
  System.out.println("###############    4.To update criminal information    #################");
  System.out.println("###############    5.To display information from file  ################");
  System.out.println("###############    -1.to exit                          #################");
  System.out.println("########################################################################");
   
     System.out.println("ENTER YOUR CHOICE");
    
     String a=scan.nextLine();
        int c=Integer.parseInt(a);
        
   while(c!=-1){
    switch(c){
     case 1:
        
        try{ 
           
                     
        System.out.println("enter the criminal first name"); 
     name=scan.nextLine();
  System.out.println("enter the criminal father name"); 
     fname=scan.nextLine();
     System.out.println("enter the criminal sex");
     sex=scan.nextLine();
    
       System.out.println("enter the criminal address");
     address=scan.nextLine();    
       System.out.println("enter the criminal age");
    
         age=scan.nextInt();
      scan.nextLine(); 
      System.out.println("enter the the day the criminal was arrested");
      date=scan.nextLine(); 
      System.out.println("enter the the types of crime");
      crime=scan.nextLine();
        }
       catch(InputMismatchException e){
           System.out.println("please enter the correct input");  
       }
         catch(Exception e){
          e.printStackTrace(); 
       }
      criminal.add(new CriminalInformationSystem( name,fname,  sex, address,  age,  date,crime)); 
     write_to_file(criminal);
//      ObjectOutputStream nil=new ObjectOutputStream(new FileOutputStream(file));
//      nil.writeObject(criminal);
//      
//      
//      }
//     catch (FileNotFoundException e) {
//         System.out.println("file you want write not exist"); 
//     }
//catch (Exception e) {
//   e.printStackTrace();
//     }
    
    break;  
     case 2:
         System.out.printf("%4s%16s%8s%10s%7s%9s%11s%n","F NAME","FATHER NAME","SEX","ADDRESS","AGE","DATE","CRIME");
          Iterator<CriminalInformationSystem> i=criminal.iterator();
        while(i.hasNext()){
         CriminalInformationSystem e=i.next();
           System.out.println( e);    
       }
    
//         dispay(criminal);      
//if(file.isFile()) {
//        try {  
//            ObjectInputStream my=new ObjectInputStream (new FileInputStream(file) ) ;
//            criminal=(ArrayList<CriminalInformationSystem>)my.readObject();
//            my.close();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    
//    
//}
        // System.out.println("file not found");
         break;
    case 3:
    read_from_file();      


        
        break;
    case 4:
       
     default:
      System.out.println("WRONG CHOICE");     
   } 
  menu();
    System.out.println("ENTER YOUR CHOICE");
   c= scan.nextInt();     
 }
 }
     
 catch(Exception e){
    e.printStackTrace();
    } 
     }
 
// public void addinfo(String name,String sex,String address,int age,String date,String crime,CriminalInformationSystem s){
//  s.setname(name);
//   s.setsex(sex);
//   s.setaddress(address);
//  s.setage(age);
//   s.setdate(date);
//   s.setcrime(crime);
//        
public void write_to_file(ArrayList criminal){
        try{
  ObjectOutputStream nil=new ObjectOutputStream(new FileOutputStream(file));
      for(int i=0;i<criminal.size();i++){
        Object gi=criminal.get(i);
         nil.writeObject(gi);   
      }
        nil.close();
      
        }
    catch (FileNotFoundException e) {
         System.out.println("file you want write not exist"); 
     }
catch (Exception e) {
   e.printStackTrace();
}   
}

public void read_from_file(){
   // if(file.exists()) {
        try {  
            ObjectInputStream my=new ObjectInputStream (new FileInputStream(file) ) ;
            CriminalInformationSystem ji=null;
            while((ji=(CriminalInformationSystem)my.readObject())!=null){
                
            
            criminal=(ArrayList<CriminalInformationSystem>)my.readObject();
            my.close();
        }
        }
        catch (Exception ex) {
            ex.printStackTrace();
      }
//}
// else
           // System.out.println("the file was not found");
    
}
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int choice;
        CriminalInformationSystem obj = new CriminalInformationSystem("null","null","null","null",0,"null","null");
        System.out.println("Welcome To Crime Information System");
     try{
        do
        {   
            System.out.println("1. Register");
            System.out.println("2. Login");
  
            System.out.println("3. Exit");
            System.out.println("Please enter your choice: ");

            choice = sc.nextInt();

            switch(choice)
            {
                case 1: obj.register(); 
                        break;
                case 2: obj.login(); 
               
                        break;
                case 3: 
                        System.out.println("Good Bye.");
                        break;
               
                default: 
         System.out.println("Invalid choice, please try again.");
   }
   }while(choice!=3);    
     }
     catch(Exception e){
         e.printStackTrace();
     }
    }
      
} 
    

