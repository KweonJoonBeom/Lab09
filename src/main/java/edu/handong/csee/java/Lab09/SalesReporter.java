package edu.handong.csee.java.Lab09;
import java.util.Scanner;

/**
 * This program is that program generate a sales report.
 * In detail, this program print out associates(salesmen) that have the highest sales
	and How the sales of each associate compare to the average
 * @author °ÇÁØ¹ü
 * 
 *
 */

public class SalesReporter { //print out information of salesmen
	
	
   private int numberOfSalesmen; //private int variable numberofsalesmen
   private double highestSales; //private double variable highestSales
   private double averageSales;//private double variable averageSales
   private SalesMen[] team; //get and use SalesMen public to array
   /**
    * declare variables
    * 
    * @param args
    * In main method just recall some function or public to simplify lines
    */
   public static void main(String [] args) { //main code
      
      SalesReporter myReporter = new SalesReporter(); //new object myReporter
      myReporter.getData(); //recall getData function
      myReporter.computeSates(); //recall computeSates function
      myReporter.hightestSales(); //recall hightestSales function
      myReporter.displayResults();//recall displayResults function
      
   }
  /** 
   * declare pulic methods
   * declare getData, computeSates, hightestSales,displayResults java constructor 
   * getdate(): first receive the numberofsalesmen and each of salesman's information(name,sales)
   * computesates(): compute sum and average and determine distance and compare to average
   * hightestSales(): determine who is the hightestSales.  
   */
   public SalesReporter() { //salesReporter function
	   Scanner myScanner = new Scanner(System.in); //import Scanner method to myScanner
	   System.out.print("Enter number of sales associates :"); //print out 
	   numberOfSalesmen = myScanner.nextInt(); // get int type number
      

   }
   
   public void getData() { //getData method
      
      team = new SalesMen[numberOfSalesmen]; //new object team 
      
      
      for(int i=0 ; i<numberOfSalesmen ; i++) { //input salesMen information  
         
         team[i] = new SalesMen(); //new object team members 
         
        
         
         Scanner myScanner = new Scanner(System.in); //use Scanner method
         System.out.println("Enter data for associate number "+ (i+1)); //print out message
         
         System.out.print("Enter name of slaes associate :"); //print out
         String name = myScanner.nextLine(); //get string variable
         
         System.out.print("Enter associate's sales:"); //print out
         double sales = myScanner.nextDouble(); //get double type variable
         
       
         
         team[i].setName(name); //set salesman name
         team[i].setSales(sales); //set salesman sales
         
      }
   }
   public void computeSates() {//compute salesmen's sales 
      
      double sum = 0; //declare double tpye variable sum =0
      
      for(int i=0 ; i<team.length ; i++) { //use for loop 
         
         double sales = team[i].getSales(); //declare double type variable sales to designate salesman's sales
         sum = sum + sales; // sum of all salesman
         
      }
      
      averageSales = sum/numberOfSalesmen; //calculate the averageSales
      
      for(int i=0; i<team.length; i++) { //use for loop
    	  double sales = team[i].getSales(); //declare sales variable 
    	  
    	  if(team[i].getSales() > averageSales) { //if salesman's sales > averageSales
    		  team[i].setDistance(sales - averageSales); //setDistance that calculates sales - averagesales
    		  team[i].setCompare("above"); //import "above" to setCompare public
    		  
    	  }
    	  else if(team[i].getSales() < averageSales) { //if salesman's sales < averageSales
    		  team[i].setDistance(averageSales - sales); //setDistance that calculates averageSales - sales
    		  team[i].setCompare("below"); //import "below" to setCompare public
      }
    	  else { //in case of default 
    		  team[i].setDistance(averageSales - sales); // setDistance that calculates averageSales - sales
    		  team[i].setCompare("Same"); //import "same" to setCompare public
    	  }
      }
   }
   
   public void hightestSales() { //determine hightesSales  
      
      
      for(int i=0 ; i<team.length-1 ; i++) { // use for loop until i>team.length-1
         
         if(team[i].getSales() < team[i+1].getSales()) { //if team[i].getSales> team[i+1].getSales
            highestSales = team[i+1].getSales(); //determine highestSales
         }
      }
      
      
   }
   
      
   public void displayResults() { //displayResults method
      System.out.println("Average sales per associate is " + averageSales); //print out averageSales
      System.out.println("The hightest slaes figure is  " + highestSales); //print out highestSales
      
      
      System.out.println("The following had the hightest slaes:"); //print out The following had the hightest slaes:
      for(int i=0 ; i<team.length; i++) { //use for loop until i>team.length
         if(team[i].getSales()==highestSales) { //if team[i].getSales == highteSales
            System.out.println("Name :" + team[i].getName()); // print out team[i].getName
            System.out.println("Sales :" + team[i].getSales()); //print out team[i].getSales
            System.out.println(team[i].getDistance() + "above the average"); // print out team[i].getDistance
            System.out.println("\n");// print out new line
         }
      }
      
      System.out.println("Other sales guys"); //print out Other sales guys
      for(int i=0 ; i<team.length; i++) { //use for loop
         if(team[i].getSales()!=highestSales) { //team[i].getSales !=highestSales 
            System.out.println("Name :" + team[i].getName()); //print out team[i].getName
            System.out.println("Sales :" + team[i].getSales()); //print out team[i].getSales
            System.out.println(team[i].getDistance() + team[i].getCompare() + " the average"); //print out team[i].getCompare
            System.out.println("\n"); //print out newline
            
         }
      }
      
   }
   

   
}
