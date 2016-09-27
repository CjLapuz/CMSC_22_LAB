/**
 *
 * @author CJ LAPUZ
 */
public class Date_Test {    
    public static void main(String[] args) {
      // Test constructor and toString()
      Date d1 = new Date();
      System.out.println(d1);  // toString()
 
      // Test Setters and Getters
      d1.setYear(1992);
      d1.setMonth(2);
      d1.setDay(29);
      System.out.println(d1);  
      System.out.println("Year is: " + d1.getYear());
      System.out.println("Month is: " + d1.getMonth());
      System.out.println("Day is: " + d1.getDay());
 
      // Test setDate()
      d1.setDate(2988, 1, 2);
      System.out.println(d1);  // toString()
   }
}
