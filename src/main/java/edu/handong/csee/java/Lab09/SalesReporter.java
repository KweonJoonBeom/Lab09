package edu.handong.csee.java.Lab09;
import java.util.Scanner;



public class SalesReporter {

   private int numberOfSalesmen;
   private double highestSales;
   private double averageSales;
   private SalesMen[] team;
   
   public static void main(String [] args) {
      
      SalesReporter myReporter = new SalesReporter();
      myReporter.getData();
      myReporter.computeSates();
      myReporter.hightestSales();
      myReporter.displayResults();
      
   }
   
   public SalesReporter() {
	   Scanner myScanner = new Scanner(System.in);
	   System.out.print("Enter number of sales associates :");
	   numberOfSalesmen = myScanner.nextInt();
      

   }
   
   public void getData() {
      
      team = new SalesMen[numberOfSalesmen];
      
      
      for(int i=0 ; i<numberOfSalesmen ; i++) {
         
         team[i] = new SalesMen();
         
         //team[i]= new SalesMen[i];
         
         Scanner myScanner = new Scanner(System.in);
         System.out.println("Enter data for associate number "+ (i+1));
         
         System.out.print("Enter name of slaes associate :");
         String name = myScanner.nextLine();
         
         System.out.print("Enter associate's sales:");
         double sales = myScanner.nextDouble();
         
         //SalesMen mySalesMen = new SalesMen(); //이런식으로 해줘야되는데, 이때 어레이 사용
          //mySalesMen.setName(name);
         //mySalesMen.setSales(sales);
         
         team[i].setName(name); //array도 타입이고, instantiate 해줘야된다. 아니면 메모리 할당이 안된다.
         team[i].setSales(sales);
         
      }
   }
   public void computeSates() {
      
      double sum = 0;
      
      for(int i=0 ; i<team.length ; i++) {
         
         double sales = team[i].getSales();
         sum = sum + sales;
         
      }
      
      averageSales = sum/numberOfSalesmen;
      
      for(int i=0; i<team.length; i++) {
    	  double sales = team[i].getSales();
    	  
    	  if(team[i].getSales() > averageSales) {
    		  team[i].setDistance(sales - averageSales);
    		  team[i].setCompare("above");
    		  
    	  }
    	  else if(team[i].getSales() < averageSales) { 
    		  team[i].setDistance(averageSales - sales);
    		  team[i].setCompare("below");
      }
    	  else {
    		  team[i].setDistance(averageSales - sales);
    		  team[i].setCompare("Same");
    	  }
      }
   }
   
   public void hightestSales() {
      
      
      for(int i=0 ; i<team.length-1 ; i++) {
         
         if(team[i].getSales() < team[i+1].getSales()) {
            highestSales = team[i+1].getSales();
         }
      }
      
      
   }
   
      
   public void displayResults() {
      System.out.println("Average sales per associate is " + averageSales);
      System.out.println("The hightest slaes figure is  " + highestSales);
      
      
      System.out.println("The following had the hightest slaes:");
      for(int i=0 ; i<team.length; i++) {
         if(team[i].getSales()==highestSales) {
            System.out.println("Name :" + team[i].getName());
            System.out.println("Sales :" + team[i].getSales());
            System.out.println(team[i].getDistance() + "above the average");
            System.out.println("\n");
         }
      }
      
      System.out.println("Other sales guys");
      for(int i=0 ; i<team.length; i++) {
         if(team[i].getSales()!=highestSales) {
            System.out.println("Name :" + team[i].getName());
            System.out.println("Sales :" + team[i].getSales());
            System.out.println(team[i].getDistance() + team[i].getCompare() + " the average");
            System.out.println("\n");
            
         }
      }
      
   }
   

   
}
