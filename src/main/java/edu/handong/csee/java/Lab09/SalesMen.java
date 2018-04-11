package edu.handong.csee.java.Lab09;
/**
 * 
 * @author °ÇÁØ¹ü
 *Through public SalesMen, users can sets or gets some information of salesmen.
 *This Class would be used in SalesReorter class. 
 */
public class SalesMen { // public SalesMen 

   private String name; //String variable name
   private double sales; //double variable sales
   private double distance; //double variable distanec
   private String compare; //String variable compare
/**
 * Through this publics, we can set or get some information of salesmen in another public classes
 *
 * @return
 * we do to return value or designate somethings
 */
   public String getCompare() { //getCompare method
      return compare; //return value
   }
   public void setCompare(String compare) { //setCompare method
      this.compare = compare; //designate compare variable
   }
   public double getDistance() { //getDistance method
      return distance; //designate distance variable
   }
   public void setDistance(double distance) { //SetDistance method
      this.distance = distance;//designate distance variable
   }
   public String getName() {   //getName method
      return name; //designate name variable
   }
   public void setName(String name) { //setName method
      this.name = name; //designate name variable
   }
   public double getSales() { //getSales method
      return sales; //designate sales variable
   }
   public void setSales(double sales) { //setSales method
      this.sales = sales; //designate sales variable
   }


}
