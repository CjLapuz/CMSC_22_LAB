/**
 *
 * @author CJ Lapuz
 */
public class Date {
    private int month = 0;
    private int day = 0;
    private int year = 0;
    private boolean isLeapYear = false;
    
    // Deafult values when initializing Date object 
    public Date(){
       year  = 1000;
       month = 1;
       day = 1;
    }
    
    // Sets the values of the variables given three integers
    public Date(int year, int month, int day){
        setDate(year, month, day);
    }
    
    public void setDate(int year, int month, int day) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        if (!(month >= 1 && month <= 12)){
            //error message
            throw new IllegalArgumentException("Month value out of bounds");   
        }else{
            this.month = month;    
        }
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     * @param month
     * @return 
     */
    public boolean dayValidity(int day, int month){
        int i = 0;
        if (this.isLeapYear == true){
            i = 1;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return (day >= 1 && day <= 31);             
        } else if (month == 4 || month == 6 || month == 9 || month == 11){
            return (day >= 1 && day <= 30);            
        } else{
            return (day >= 1 && day <= 28 + i); 
        }
    }
    
    public void isLeapYear(int year){
        boolean leapYear = false;
        leapYear = ((year % 4 == 0) && !(year % 100 == 0) || (year % 400 == 0)) ;
        this.isLeapYear = leapYear;
    }
    
    public void setDay(int day) {
        if (dayValidity(day, this.month)){
            this.day = day;
        }else{
            throw new IllegalArgumentException("Day value out of bounds");    
        }
    }
 
    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        if (!(year >= 1000 && year <= 9999)){
            //error message
            throw new IllegalArgumentException("Year value out of bounds");   
        }else{
            isLeapYear(year);
            this.year = year;    
        }
    }
    
  
    public String toString(){
        String date = String.format("%02d/%02d/%d", this.day, this.month, this.year);
        return date;
    }
}
