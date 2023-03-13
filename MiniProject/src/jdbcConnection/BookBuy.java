package jdbcConnection;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BookBuy  {
	static Scanner sc = new Scanner(System.in);
	public void display()
	{
		String Book_Name;
		int Book_quantity;
		String Address;
		int book_price;
		int pincode;
		long mob;
		System.out.println();
		System.out.println();
		System.out.println("    ##### To Buy book fill the details #####");
		System.out.println();
		System.out.println("Choose Book Name :");
		Book_Name=sc.next();
		System.out.println("plz enter quantity:");
		Book_quantity=sc.nextInt();
		System.out.println("Enter your Address:");
		Address=sc.next();
		System.out.println("Enter pincode:");
		pincode=sc.nextInt();
		System.out.println("Enter Alternate mobile no:");
		mob=sc.nextLong();
		
		System.out.println("============================");
		System.out.println("!!!Your order has been Done!!!");
		System.out.println("============================");
		System.out.println();
		System.out.println("To see Orders click on My Orders");
	    String	myOrders=sc.next();
	    myOrders=myOrders.toLowerCase();
		if(myOrders.equals("myorders")) {
			System.out.println();
		System.out.println("Booked Book Name : "+Book_Name);
		
		System.out.println("Book Quantity : "+Book_quantity);
		
		System.out.println("Your Address is: "+Address);
	
		switch(Book_Name) {
		case "Arthashastra":{
			book_price=1200;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		
		case "Devadas":{
			book_price=600;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		case "Ramayana":{
			 book_price=950;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		case "Dharmashatstra":{
			 book_price=800;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		case "MahaBharata":{
			 book_price=1000;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		case "Kanthapura":{
			 book_price=760;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		case "Coolie":{
			 book_price=450;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		case "Bhagavadgita":{
			 book_price=400;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		case "Gitanjali":{
			 book_price=550;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		case "Karma":{
			 book_price=1100;
			 int amount = book_price*Book_quantity;
			 System.out.println("Amount to be Paid: "+ amount);
			 break;
		}
		default:
			System.out.println("This Book is not Available ");
			break;
		}
	     System.out.println();
		System.out.println("            ******* Thank You For Buying Book *******");
		
		}
	}
		
public static void main(String[] args) {
	int Cust_Id;
	String Cust_Name;
	String Email;
	long Contact_number;
	String Address;
	System.out.println("                  ********  Welcome to Online Book Store  ********");
	System.out.println();
	System.out.println("Please Fill The customer details");
	System.out.println();
	System.out.println("Enter Customer Id:");
	Cust_Id= sc.nextInt();
	System.out.println("Enter the Customer Name:");
	Cust_Name=sc.next();
	System.out.println("Enter Email Id:");
	Email=sc.next();
	System.out.println("Enter the Contact No:");
	Contact_number= sc.nextLong();
	System.out.println("Enter the Address:");
	Address= sc.next();
	
	try {
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebookstore","root","rushi1789");
		Statement stmnt = con.createStatement();
		String str= "insert into Customer values ('"+Cust_Id+"','"+Cust_Name+"','"+Email+"','"+Contact_number+"','"+Address+"')";
		stmnt.executeUpdate(str);
		System.out.println("               !!!!!List of Available Books!!!!!");
		System.out.println();
	    ResultSet result=stmnt.executeQuery ("Select * from Book");
		System.out.println("Book_Id\tBook_Name\t\tAuthor_Name\t\tBook_Price\tAvailable_Quantity");
		while(result.next()) {
		  System.out.println(result.getString(1)+"    "+result.getString(2)+"         "+result.getString(3)+"              "+result.getString(4)+"       "+result.getString(5));
		}
      BookBuy b1=new BookBuy();
	  b1.display();
	
	} catch (Exception e) {
		System.out.println("The error are :" + e);
	}
   }
	
}



