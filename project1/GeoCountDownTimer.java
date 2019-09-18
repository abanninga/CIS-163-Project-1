package project1;

import java.io.*;
import java.util.Scanner;

/*********************************************************************
 *
 * Class that creates a GeoCountDownTimer, which counts down from a
 * particular date. The date within the timer can be changed by
 * adding or subtracting days, or changing the month, day, and year
 * by themselves. The timer's date appears in the format mm/dd/yyyy
 *
 * @author Alaine Banninga & Abbey McDonald
 *@version 9/18/2019
 ********************************************************************/

public class GeoCountDownTimer {

    /** this is the number of months for a given date */
    private int month;

    /** this is the number of years for a given date */
    private int year;

    /** this is the number of days for a given date */
    private int day;

    /** this is the minimum year for the geoCountDownTimer */
    private static final int MINYEAR = 2015;


    /******************************************************************
     * Constructor that sets the GeoCountDownTimer object to a base
     * date
     */
    public GeoCountDownTimer() {
        month = 1;
        day = 1;
        year = 2015;
    }

    // not required in our project
    //private static boolean mutate = true;

    /******************************************************************
     * Constructor that sets month, day, and year of the
     * GeoCountDownTimer object
     * @param month between 1-12
     * @param day between 1-daysInMonth for that month and year
     * @param year >= MINYEAR
     * @throws IllegalArgumentException if the input is an invalid date
     */
    public GeoCountDownTimer(int month, int day, int year){
        if(isValidDate(month, day, year)) {
            this.month = month;
            this.day = day;
            this.year = year;
        }
        else throw new IllegalArgumentException();
    }


    /******************************************************************
     * Method that accepts a GeoCountDownTimer and
     * updates the private GeoCountDownTimer with the parameter's
     * month, day, and year respectively
     * @param other GeoCountDownTimer object
     */
    public void GeoCountDownTimer (GeoCountDownTimer other){
        if(isValidDate(other.month, other.day, other.year)) {
            this.month = other.month;
            this.day = other.day;
            this.year = other.year;
        }
    }


    /******************************************************************
     * Constructor that creates a GeoCountDownTimer object from a
     * string passed as a parameter with its respective month, day,
     * and year
     * @param geoDate date in the format "mm/dd/yyyy"
     * @throws IllegalArgumentException if not a valid date string
     */
    public GeoCountDownTimer(String geoDate){
        String str[] = geoDate.split("/");
        if(str.length == 3) {
            this.month = Integer.parseInt(str[0]);
            this.day = Integer.parseInt(str[1]);
            this.year = Integer.parseInt(str[2]);
            if(!isValidDate(this.month, this.day, this.year)){
            throw new IllegalArgumentException();
            }
        }
        else
            throw new IllegalArgumentException();
    }


    // Days in each month (assuming months are numbered beginning with 1)
    /** array with non-leap year days of each month */
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31,
        31, 30, 31, 30, 31};

    /** array with month names */
    private static final String[] MONTHS = {"", "January", "February",
            "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};



    /******************************************************************
     * Method that determines the number of days in a current month,
     * accounting for leap years
     * @param month month whose number of days is to be determined
     * @param year year to be checked if it is a leap year
     * @return number of days for that particular month in that year
     * @throws IllegalArgumentException if invalid month or if year
     * is less than MINYEAR
     */
    public static int daysInMonth(int month, int year){
        if(month < 1 || month > 12)
            throw new IllegalArgumentException();
        if(year < MINYEAR)
            throw new IllegalArgumentException();

        int days = 0;
        if(month == 2 && isLeapYear(year)){
            days = 29;
        }
        else days = DAYS_IN_MONTH[month];
        return days;
    }



    /******************************************************************
     * Method that checks if the inputted date is a valid date
     * @param month must be between 1-12
     * @param day must be between 1-31 and adhere to leap year
     * @param year must be greater than 2015
     * @return true if year is greater than MINYEAR and is valid date
     */
    private static boolean isValidDate(int month, int day, int year) {
        if(month < 1 || month > 12){
            return false;
        }
        if(day < 1 || day > daysInMonth(month, year)){
            return false;
        }
        return year >= 2015;
    }


    /******************************************************************
     * Method that checks if a year is a leap year
     * @param year to be checked if it is a leap year
     * @return true if it is a leap year
     * @throws IllegalArgumentException if year is negative
     */
    private static boolean isLeapYear(int year) {
        if(year < 0)
            throw new IllegalArgumentException();
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }


    /******************************************************************
     * Method that determines if two objects are equal. If the object
     * is a GeoCountDownTimer, the method determines if both
     * GeoCountDownTimers have the same date
     * @param other object to be determined if it is equal
     * @return true if both objects are equal; true if both
     * GeoCountDownTimers have the same date
     * @throws IllegalArgumentException if other is not a
     * GeoCountDownTimer object
     */
    public boolean equals (Object other) {
        if (other != null) {
            if (other instanceof GeoCountDownTimer) {
                GeoCountDownTimer g = (GeoCountDownTimer) other;
                return this.year == g.year && this.month == g.month && this.day == g.day;
            }
            return false;
        }
        else throw new IllegalArgumentException();
    }


    /******************************************************************
     * Method that compares two GeoCountDownTimers.
     * @param other GeoCountDownTimer object with which to be compared
     * @return If the 'other' GeoCountDownTimer's date is before that
     * of the GeoCountDownTimer who called the method, the method will
     * return -1. If the two GeoCountDownTimers are equal (the same
     * date), the method will return 0. If the 'other'
     * GeoCountDownTimer's date is after that of the GeoCountDownTimer
     * who called the method, the method will return 1
     */
    public int compareTo(GeoCountDownTimer other){
        // checks the three different ways 'other' can be less than 'this'
        if ((this.year > other.year) || (this.year >= other.year && this.month >
                other.month) || (this.year >= other.year && this.month >=
                other.month && this.day > other.day)) {
            return 1;
        }
        else if (this.equals(other)) {
            return 0;
        }
        return -1;
    }


    /******************************************************************
     * Method that determines if two GeoCountDownTimers s1 and s2 are
     * the same by checking if their respective months, days, and years
     * are the same
     * @param s1 first GeoCountDownTimer to be compared
     * @param s2 second GeoCountDownTimer to be compared
     * @return true if the two dates are equal
     */
    private static boolean equals(GeoCountDownTimer s1, GeoCountDownTimer s2) {
        return (s2.year == s1.year) && (s2.month == s1.month)
                && (s2.day == s1.day);
    }


    /******************************************************************
     * Method that converts the date from a GeoCountDownTimer into a
     * readable form. For example "January 1, 2015"
     * @return string with the date in the format above
     */
    public String toString() {
        String s = MONTHS[this.month] + " " + this.day + ", " + this.year;
        return s;
    }


    /******************************************************************
     * Method that converts the date extracted from a GeoCountDownTimer
     * into the format "mm/dd/yyyy"
     * @return string with date in the format above
     */
    public String toDateString() {
        String s = this.month + "/" + this.day + "/" + this.year;
        return s;
    }


    /******************************************************************
     * Method that decreases the date in a GeoCountDownTimer by the
     * specified number of days (pDays)
     * @param pDays the number of days to subtract from the date
     * @throws IllegalArgumentException if pDays is negative
     */
    public void dec(int pDays) {
        if (pDays < 0)
            throw new IllegalArgumentException();

        while (pDays > 0) {
            day--;

            if (day < 1) {
                month--;

                if (month < 1) {
                    month = 12;
                    year--;
                }
                day = daysInMonth(month, year);
            }
            pDays--;
        }
    }



    /******************************************************************
     * Method that decreases the days variable for a GeoCountDownTimer
     * by 1 day
     */
    public void dec(){
        this.dec(1);
    }


    /******************************************************************
     * Method that increases the days variable for a GeoCountDownTimer
     * by 1 day
     */
    public void inc(){
        this.inc(1);
    }


    /******************************************************************
     * Method that increases the variable days in a GeoCountDownTimer
     * by the specified number of days (pDays)
     * @param pDays the number of days to add to the date
     * @throws IllegalArgumentException if pDays is negative
     */
    public void inc(int pDays) {
        if (pDays < 0)
            throw new IllegalArgumentException();

        while (pDays > 0 ) {
            day++;

            if (day > daysInMonth(month, year)) {
                month++;
                day = 1;
                if (month > 12) {
                    month = 1;
                    year++;
                }
            }
            pDays--;
        }
    }



    /******************************************************************
     * Method that determines how many days to go there are from the
     * parameter 'fromDate' to the 'this' GeoCountDownTimer date
     * @param fromDate date less than the 'this' date
     * @return number of days from 'fromDate' to 'this' date
     * @throws IllegalArgumentException if fromDate is greater than
     * the current 'this' date
     */
    public int daysToGo(String fromDate) {
        GeoCountDownTimer fromTimer = new GeoCountDownTimer(fromDate);
        if(this.compareTo(fromTimer) < 0)
            throw new IllegalArgumentException();

        int daysToGo = 0;
        while(this.compareTo(fromTimer) != 0){
            fromTimer.inc();
            daysToGo++;
        }
        return daysToGo;
    }


    /******************************************************************
     * Method that returns a GeoCountDownTimer that is a specified
     * number of days in the future from the current GeoCountDownTimer
     * date
     * @param n the number of days in the future
     * @return the GeoCountDownTimer that is n days in the future
     */
    public GeoCountDownTimer daysInFuture(int n){
        GeoCountDownTimer futureDate = new GeoCountDownTimer(this.getMonth(), this.getDay(), this.getYear());
        if(n >= 0)
            futureDate.inc(n);
        else
            futureDate.dec(n*-1);
        return futureDate;
    }


    /******************************************************************
     * Method that saves the month, day, and year of a
     * GeoCountDownTimer to a file
     * @param filename the name of the file to be saved to
     * @throws IOException if trouble writing file
     */
    public void save(String filename) {

        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        out.println (month);
        out.println (day);
        out.println (year);

        out.close();
    }


    /******************************************************************
     * Method that extracts the day, month, and year for a
     * GeoCountDownTimer from a file
     * @param fileName the file to be read to extract the day, month,
     * and year
     * @throws Exception if trouble reading the file
     */
    public void load(String fileName) {
        try{

            // open the data file
            Scanner fileReader = new Scanner(new File(fileName));

            // read one int
            month = fileReader.nextInt();
            day = fileReader.nextInt();
            year = fileReader.nextInt();

            System.out.println (month);
            System.out.println (day);
            System.out.println (year);
        }

        // problem reading the file
        catch(Exception error){
            System.out.println("Oops!  Something went wrong.");
        }

    }



    /******************************************************************
     * Method that returns the current value of 'this' month
     * @return month, value between 1-12
     */
    public int getMonth() {
        return month;
    }


    /******************************************************************
     * Method that sets the month variable to a specified value (month)
     * @param month value to set 'this' month, between 1-12
     * @throws IllegalArgumentException if invalid month
     */
    public void setMonth(int month) {
        if(month > 0 && month < 13)
        this.month = month;
        else throw new IllegalArgumentException();
    }


    /******************************************************************
     * Method that returns the current value of  'this' year
     * @return year value, must be greater than 2014
     */
    public int getYear() {
        return year;
    }


    /******************************************************************
     * Method that sets the year variable to a specified value (year)
     * @param year must be greater than 2014 (MINYEAR)
     * @throws IllegalArgumentException if param year is less than
     * the minimum accepted year (MINYEAR)
     */
    public void setYear(int year) {
        if(year >= MINYEAR)
        this.year = year;
        else throw new IllegalArgumentException();
    }


    /******************************************************************
     * Method that returns the current value for 'this' day
     * @return day, between 1-days in that month for that year
     */
    public int getDay() {
        return day;
    }


    /******************************************************************
     * Method that sets 'this' day variable to a specified value
     * @param day value to set 'this' day to
     * @throws IllegalArgumentException if invalid day
     */
    public void setDay(int day) {
        if(day < 1 || day > daysInMonth(this.month, this.year))
            throw new IllegalArgumentException();
        else this.day = day;
    }


    /******************************************************************
     * Method that returns the final variable MINYEAR
     * @return MINYEAR = 2015
     */
    public static int getMINYEAR() {
        return MINYEAR;
    }


    /******************************************************************
     * Method that returns the final DAYS_IN_MONTH array of integers
     * @return DAYS_IN_MONTH array of integers
     */
    private static int[] getDaysInMonth() {
        return DAYS_IN_MONTH;
    }


    /******************************************************************
     * Method that returns the final array getMONTHS of strings
     * @return string array of month names
     */
    private static String[] getMONTHS() {
        return MONTHS;
    }


    /******************************************************************
     * Main method that tests other methods of this class and outputs
     * the results of each test
     * @param args
     */
    public static void main(String[] args) {
        // test default constructor
        GeoCountDownTimer geo = new GeoCountDownTimer();
        System.out.println("Date: " + geo);

        // test string constructor
        GeoCountDownTimer s = new GeoCountDownTimer("2/10/2020");
        System.out.println("Date: " + s);


        // test daysInMonth
        System.out.println(daysInMonth(4,2016));
        System.out.println(daysInMonth(2,2016));


        // abbey's part
        //geoDate
        GeoCountDownTimer s8 = new GeoCountDownTimer("2/10/2020");
        System.out.println("Date: " + s8);

        //toString
        GeoCountDownTimer s4 = new GeoCountDownTimer("2/10/2022");
        System.out.println("Date: " + s4.toString());

        //dec
        s4.dec(365);
        System.out.println("Decrease 2/10/2022 by 365: " + s4);

        //toDateString
        GeoCountDownTimer h = new GeoCountDownTimer(5, 10, 2015);
        System.out.println(h.toDateString().equals("5/10/2015"));

        GeoCountDownTimer k = new GeoCountDownTimer(7, 10, 2018);
        System.out.println(k.toDateString().equals("7/10/2018"));

        GeoCountDownTimer j = new GeoCountDownTimer(2, 29, 2020);
        System.out.println(j.toDateString().equals("2/29/2020"));


        GeoCountDownTimer s3 = new GeoCountDownTimer("2/10/2019");
        for (int i = 0; i < (365 + 366 ); i++)
            s3.inc(1);
        System.out.println("Date: " + s3);

        System.out.println(daysInMonth(4,2016));

        //adding a month to get the next year
        GeoCountDownTimer g = new GeoCountDownTimer(12,28,2017);
        g.daysInMonth(g.getMonth() + 1, g.getYear());

        GeoCountDownTimer f = new GeoCountDownTimer(11,18,2016);
        g.daysInMonth(f.getMonth() + 1, g.getYear());

        //Equals
        GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
        GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,3000);
        System.out.println("Equals:" + s1.equals(s2));

        GeoCountDownTimer s5 = new GeoCountDownTimer(5,6,2222);
        GeoCountDownTimer s6 = new GeoCountDownTimer(5,6,2222);
        System.out.println("Equals:" + s5.equals(s6));

        //compareTo
        GeoCountDownTimer r1 = new GeoCountDownTimer(5,9,2015);
        GeoCountDownTimer r2 = new GeoCountDownTimer(6,01,2015);
        GeoCountDownTimer r3 = new GeoCountDownTimer(5,8,2015);
        GeoCountDownTimer r4 = new GeoCountDownTimer(5,9,2015);
        GeoCountDownTimer r5 = new GeoCountDownTimer(5,10,2015);
        System.out.println(r2.compareTo(r1) > 0);
        System.out.println(r3.compareTo(r1) < 0);
        System.out.println(r1.compareTo(r4) == 0);
        System.out.println(r5.compareTo(r4) > 0);

        // toString
        GeoCountDownTimer test = new GeoCountDownTimer(1,2,3000);
        System.out.println("String Date: " + test.toString());

        // toDateString
        GeoCountDownTimer test2 = new GeoCountDownTimer("2/11/2020");
        System.out.println("Date: " + test2.toDateString());


        // alaine's part

        // toString
        GeoCountDownTimer test3 = new GeoCountDownTimer(1,2,3000);
        System.out.println("String Date: " + test3.toString());

        // toDateString
        GeoCountDownTimer test4 = new GeoCountDownTimer("2/11/2020");
        System.out.println("Date: " + test4.toDateString());

        // dec()
        GeoCountDownTimer s10 = new GeoCountDownTimer("2/10/2022");
        for (int i = 0; i < 1000; i++)
            s10.dec();
        System.out.println("Date: " + s10);

        // dec(pDays)
        GeoCountDownTimer test5 = new GeoCountDownTimer(11,11,2111);
        test5.dec(365);
        System.out.println("Date: " + test5.toDateString());

        // inc()
        GeoCountDownTimer s20 = new GeoCountDownTimer("2/10/2019");
        for (int i = 0; i < (365 + 366); i++)
            s20.inc();
        System.out.println("Date: " + s20);

        // inc(pDays)
        test5.inc( 1000);
        System.out.println("Date: " + test5.toDateString());

        // daysToGo
        GeoCountDownTimer g1 = new GeoCountDownTimer("2/9/2019");
        System.out.println("Days to go: " + g1.daysToGo("2/1/2019"));

        // daysInFuture
        GeoCountDownTimer s50 = new GeoCountDownTimer (12,9,2019);
        System.out.println ("Days in future: " + s50.daysInFuture(10).toDateString());

        // save & load
        GeoCountDownTimer test6 = new GeoCountDownTimer (8,24,5555);
        test6.save("mainTest");
        GeoCountDownTimer test7 = new GeoCountDownTimer (6,30,4444);
        System.out.println("test7 before load: " + test7.toDateString());
        test7.load("mainTest");
        System.out.println("test7 after load: " + test7.toDateString());

        // setters & getters
        GeoCountDownTimer s60 = new GeoCountDownTimer (12,9,2019);
        s60.setMonth(7);
        s60.setDay(21);
        s60.setYear(7021);
        System.out.println("Date: " + s60.getMonth() + "/" + s60.getDay() + "/" + s60.getYear());

        System.out.println("Minimum year: " + getMINYEAR());
    }
}
