package edu.handong.csee.java.Lab09;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This program is that program generate a sales report.
 * In detail, this program print out associates(salesmen) that have the highest sales
	and How the sales of each associate compare to the average
 * @author KweonJoonBeom
 *
 */

public class SalesReporter { //print out information of salesmen


	//private int numberOfSalesmen; //private int variable numberofsalesmen
	private double highestSales; //private double variable highestSales
	private double averageSales;//private double variable averageSales
	private ArrayList<SalesMen> team = new ArrayList<SalesMen>(); //get and use SalesMen public to arrayList
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


	public void getData() { //getData method

		 //new object team 
		int i=0;

		while(true){ //input salesMen information  
 
			Scanner myScanner = new Scanner(System.in); //use Scanner method
			System.out.println("Enter data for associate number "+ (i+1)); //print out message

			System.out.print("Enter name of slaes associate :"); //print out
			String name = myScanner.nextLine(); //get string variable

			System.out.print("Enter associate's sales:"); //print out
			double sales = myScanner.nextDouble(); //get double type variable
			String temp = myScanner.nextLine();
			team.add(new SalesMen(name,sales));
			i++;
			System.out.print("Addition to more data?(Y or N) ");
			
			String answer = myScanner.nextLine();
			
			if(answer.equals("N")) break;
			}
		
	}
	public void computeSates() {//compute salesmen's sales 

		double sum = 0; //declare double tpye variable sum =0

		for(int i=0 ; i<team.size() ; i++) { //use for loop 

			double sales = team.get(i).getSales(); //declare double type variable sales to designate salesman's sales
			sum = sum + sales; // sum of all salesman

		}

		averageSales = sum/team.size(); //calculate the averageSales

		for(int i=0; i<team.size(); i++) { //use for loop
			double sales = team.get(i).getSales(); //declare sales variable 

			if(team.get(i).getSales() > averageSales) { //if salesman's sales > averageSales
				team.get(i).setDistance(sales - averageSales); //setDistance that calculates sales - averagesales
				team.get(i).setCompare("above"); //import "above" to setCompare public

			}
			else if(team.get(i).getSales() < averageSales) { //if salesman's sales < averageSales
				team.get(i).setDistance(averageSales - sales); //setDistance that calculates averageSales - sales
				team.get(i).setCompare("below"); //import "below" to setCompare public
			}
			else { //in case of default 
				team.get(i).setDistance(averageSales - sales); // setDistance that calculates averageSales - sales
				team.get(i).setCompare("Same"); //import "same" to setCompare public
			}
		}
	}

	public void hightestSales() { //determine hightesSales  


		for(int i=0 ; i<team.size()-1 ; i++) { // use for loop until i>team.length-1

			if(team.get(i).getSales() < team.get(i+1).getSales()) { //if team[i].getSales> team[i+1].getSales
				highestSales = team.get(i+1).getSales(); //determine highestSales
			}
		}


	}


	public void displayResults() { //displayResults method
		System.out.println("Average sales per associate is " + averageSales); //print out averageSales
		System.out.println("The hightest slaes figure is  " + highestSales); //print out highestSales


		System.out.println("The following had the hightest slaes:"); //print out The following had the hightest slaes:
		for(int i=0 ; i<team.size(); i++) { //use for loop until i>team.length
			if(team.get(i).getSales()==highestSales) { //if team[i].getSales == highteSales
				System.out.println("Name :" + team.get(i).getName()); // print out team[i].getName
				System.out.println("Sales :" + team.get(i).getSales()); //print out team[i].getSales
				System.out.println(team.get(i).getDistance() + "above the average"); // print out team[i].getDistance
				System.out.println("\n");// print out new line
			}
		}

		System.out.println("Other sales guys"); //print out Other sales guys
		for(int i=0 ; i<team.size(); i++) { //use for loop
			if(team.get(i).getSales()!=highestSales) { //team[i].getSales !=highestSales 
				System.out.println("Name :" + team.get(i).getName()); //print out team[i].getName
				System.out.println("Sales :" + team.get(i).getSales()); //print out team[i].getSales
				System.out.println(team.get(i).getDistance() + team.get(i).getCompare() + " the average"); //print out team[i].getCompare
				System.out.println("\n"); //print out newline

			}
		}

	}



}
