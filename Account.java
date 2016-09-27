/**
 *
 * @author CJ LAPUZ
 */
public class Account {
    private int accountNumber = 0;
    private double balance = 0.0d;
    
    public Account(){
        //DO NOTHING    
    }    
    // Determines if an account number is valid
    public boolean accountIsValid (int accountNumber){
        if (accountNumber >= 0 && accountNumber <= 999){
            return true;
        } else {
            throw new IllegalArgumentException("Account Number out of bounds");
        }
    }
    // Sets the value for only the account number
    public Account(int accountNumber){
        if (accountIsValid(accountNumber)){
            this.accountNumber = accountNumber;
        }   
    }   
    // sets the value for the account number and balance
    public Account(int accountNumber, double balance){
         Account nw = new Account(accountNumber);
         this.accountNumber = accountNumber;
         setBalance(balance);
    }
    // get the account number
    public int getAccountNumber(){
        return this.accountNumber;
    }
    // get the balance of the account
    public double getBalance(){
        return this.balance;
    }
    // sets the balance of the account
    public void setBalance(double balance){
        if (balance >= 0){
            this.balance = balance;
        } else {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
    }
    // adds funds to the account 
    public void credit(double amount){
        this.balance += amount;
    }
    // subtracts funds from the balance if there are enough funds
    public void debit(double amount){
        if (getBalance() >= amount){
            this.balance -= amount;
        } else{
            System.out.println("Insufficient Funds");
        }
    } 
    // Overides default toString 
    public String toString(){
        String acctDetails = String.format("A/C no: "+ "%03d, " + "Balance = $" +"%.2f", this.accountNumber, this.balance);
        return acctDetails;
    }
}
