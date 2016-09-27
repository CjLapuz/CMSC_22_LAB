/**
 *
 * @author cj LAPUZ
 */
public class Account_Test {
    public static void main(String[] args) {
      // Test constructor and toString()
      Account a1 = new Account(999, 120.0123);
      Account a2 = new Account(11);
      System.out.println(a1); 
      System.out.println(a2);
      
      a2.setBalance(2100);
      System.out.println(String.format("For Account #: %03d", a2.getAccountNumber()));
      System.out.println("Balance Updated: " + a2.getBalance());
      
      a1.credit(480);
      System.out.println(String.format("For Account #: %03d", a1.getAccountNumber()));
      System.out.println("Balance Updated: " + a1.getBalance());
      
      a2.debit(2000);
      System.out.println(String.format("For Account #: %03d", a1.getAccountNumber()));
      System.out.println("Balance Remaining: " + a1.getBalance());
      a1.debit(600.013);
      System.out.println(String.format("For Account #: %03d", a1.getAccountNumber()));
      System.out.println("Balance Remaining: " + a1.getBalance());
      
    }
}
