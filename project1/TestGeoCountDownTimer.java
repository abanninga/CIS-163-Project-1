package project1;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestGeoCountDownTimer {

    /******************************************************************
     * JUnits for testing the constructor that creates a default
     * GeoCountDownTimer
     */
	@Test
	public void testConstructorDefault1() {
        GeoCountDownTimer s = new GeoCountDownTimer();
        assertEquals("January 1, 2015", s.toString());
    }
    @Test
    public void testConstructorDefault2(){
    GeoCountDownTimer s1 = new GeoCountDownTimer();
    assertEquals("1/1/2015",s1.toDateString());
	}


    /******************************************************************
     * JUnits for testing the constructor with int params
     */
	@Test
    public void testConstructorInts1() {
        GeoCountDownTimer s = new GeoCountDownTimer(5, 10, 2015);
        assertTrue(s.toDateString().equals("5/10/2015"));
    }
    @Test
    public void testConstructorInts2() {
        GeoCountDownTimer s = new GeoCountDownTimer(5, 10, 2015);
        assertTrue(s.toString().equals("May 10, 2015"));
    }
    @Test
    public void testConstructorInts3() {
        GeoCountDownTimer s = new GeoCountDownTimer(5, 10, 2015);
        assertEquals("5/10/2015", s.toDateString());
    }
    @Test
    public void testConstructorInts4() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(6, 10, 2015);
        assertFalse(s1.toDateString().equals("5/10/2015"));
    }
    @Test
    public void testConstructorInts5() {
        GeoCountDownTimer s1 = new GeoCountDownTimer(6, 10, 2015);
        GeoCountDownTimer t1 = new GeoCountDownTimer("6/10/2015");
        assertTrue(s1.equals(t1));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorInts6() {
        GeoCountDownTimer s2 = new GeoCountDownTimer(5, 10, 2012);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorInts7() {
        GeoCountDownTimer s3 = new GeoCountDownTimer(-5, 10, 2015);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorInts8() {
        GeoCountDownTimer s4 = new GeoCountDownTimer(5, -10, 2015);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorInts9() {
        GeoCountDownTimer s5 = new GeoCountDownTimer(5, 10, -2015);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorInts10() {
        GeoCountDownTimer s6 = new GeoCountDownTimer(0, 10, 2015);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorInts11() {
        GeoCountDownTimer s7 = new GeoCountDownTimer(5, 0, 2015);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorInts12(){
        GeoCountDownTimer s8 = new GeoCountDownTimer(5,10,0);
	}
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorInts13() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(2,-3,-3);
    }
    @Test
    public void testConstructorIntsJan() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(1,10,2015);
        assertTrue(s8.toString().equals("January 10, 2015"));
    }
    @Test
    public void testConstructorIntsFeb() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(2,10,2015);
        assertTrue(s8.toString().equals("February 10, 2015"));
    }
    @Test
    public void testConstructorIntsMar() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(3,10,2015);
        assertTrue(s8.toString().equals("March 10, 2015"));
    }
    @Test
    public void testConstructorIntsApr() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(4,10,2015);
        assertTrue(s8.toString().equals("April 10, 2015"));
    }
    @Test
    public void testConstructorIntsMay() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(5,10,2015);
        assertTrue(s8.toString().equals("May 10, 2015"));
    }
    @Test
    public void testConstructorIntsJun() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(6,10,2015);
        assertTrue(s8.toString().equals("June 10, 2015"));
    }
    @Test
    public void testConstructorIntsJul() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(7,10,2015);
        assertTrue(s8.toString().equals("July 10, 2015"));
    }
    @Test
    public void testConstructorIntsAug() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(8,10,2015);
        assertTrue(s8.toString().equals("August 10, 2015"));
    }
    @Test
    public void testConstructorIntsSep() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(9,10,2015);
        assertTrue(s8.toString().equals("September 10, 2015"));
    }
    @Test
    public void testConstructorIntsOct() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(10,10,2015);
        assertTrue(s8.toString().equals("October 10, 2015"));
    }
    @Test
    public void testConstructorIntsNov() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(11,10,2015);
        assertTrue(s8.toString().equals("November 10, 2015"));
    }
    @Test
    public void testConstructorIntsDec() {
        GeoCountDownTimer s8 = new GeoCountDownTimer(12,10,2015);
        assertTrue(s8.toString().equals("December 10, 2015"));
    }


    /******************************************************************
     * JUnits for testing constructor with string param geoDate
     */
    @Test  (expected = IllegalArgumentException.class)
    public void testConstructorDate1() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2015");
        assertTrue(s.toDateString().equals("2/29/2015"));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorDate2() {
        GeoCountDownTimer s = new GeoCountDownTimer("-2/28/2015");
    }
    @Test
    public void testConstructorDate3() {
        GeoCountDownTimer s = new GeoCountDownTimer("8/29/2015");
        assertFalse(s.toDateString() == "12/12/2112");
    }
    @Test  (expected = IllegalArgumentException.class)
    public void testConstructorDate4() {
        GeoCountDownTimer s = new GeoCountDownTimer("2/29/2014");
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorDate5() {
        new GeoCountDownTimer("2,-3/-3");
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorDate6() {
        new GeoCountDownTimer("2,123,2020");
    }
    @Test (expected = IllegalArgumentException.class)
    public void testConstructorDate7() {
        new GeoCountDownTimer("22,13,2020");
    }
    @Test
    public void testConstructorDate8() {
        GeoCountDownTimer s = new GeoCountDownTimer("8/3/2015");
        assertEquals("8/3/2015",s.toDateString());
    }


    /******************************************************************
     * JUnits for testing constructor that accepts a GeoCountDownTimer
     * as a param
     */
    @Test
    public void testConstructorGCDEquals(){
        GeoCountDownTimer s = new GeoCountDownTimer("8/3/2015");
        GeoCountDownTimer t = new GeoCountDownTimer("12/13/2027");
        s.GeoCountDownTimer(t);
        assertEquals("12/13/2027",s.toDateString());
    }
    @Test
    public void testConstructorGCDFalse(){
        GeoCountDownTimer s = new GeoCountDownTimer("8/3/2015");
        GeoCountDownTimer t = new GeoCountDownTimer("12/13/2027");
        s.GeoCountDownTimer(t);
        assertFalse(s.toDateString() == "8/3/2015");
    }



    /******************************************************************
     * JUnits for testing all four inc/dec methods
     */
	@Test
	public void testAddMethod () {
        GeoCountDownTimer s1 = new GeoCountDownTimer(5, 10, 2015);
        s1.inc(365);
        System.out.println(s1.toDateString().equals("5/9/2016"));
        assertEquals("5/9/2016", s1.toDateString());
    }
    @Test
    public void testAddMethod1 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2016);

		for (int i = 0; i < 365000; i++){
            s1.inc();
        }
		System.out.println (s1);
		assertEquals("9/11/3015",s1.toDateString());
    }
    @Test
    public void testAddMethod2 () {
        GeoCountDownTimer s1 = new GeoCountDownTimer(9,11,3015);

        for (int i = 0; i < 365000; i++){
            s1.dec();
        }
        System.out.println (s1);
        assertEquals("5/10/2016",s1.toDateString());
    }
    @Test
    public void testIncDec () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2017);

		System.out.println ("Start:" + s1);
		for (int i = 0; i < 316; i++)
			s1.inc();
		System.out.println ("Middle:" + s1);

		for (int i = 0; i < 316; i++)
			s1.dec();
		System.out.println ("End: " + s1);
	}
	@Test
    public void testAddMethod3(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2017);
        s1.inc(0);
        System.out.println(s1);
        assertEquals("5/10/2017",s1.toDateString());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testIncException(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(11,1,2015);
        s1.inc(-1);
    }
	@Test
    public void testDecP(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(5,10,2016);
        s1.dec(11);
        System.out.println(s1.toDateString());
        System.out.println();
        assertEquals("4/29/2016",s1.toDateString());
    }
    @Test
    public void testDecNewYears(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(1,1,2016);
        s1.dec(1);
        System.out.println(s1.toDateString());
        assertEquals("12/31/2015",s1.toDateString());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testDecException(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(12,11,2016);
        s1.dec(-1);
    }
    @Test
    public void testDec1Day(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(9,1,2016);
        s1.dec();
        System.out.println(s1.toDateString());
        assertEquals("8/31/2016",s1.toDateString());
    }
    @Test
    public void testDec0Day(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(9,1,2016);
        s1.dec(0);
        System.out.println(s1.toDateString());
        assertEquals("9/1/2016",s1.toDateString());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testDec1DayException(){
	    // This exception cannot be tested because an IllegalArgumentException
        // will be thrown when the test hits the toString method, which errors
        // when month < 1
        GeoCountDownTimer s1 = new GeoCountDownTimer(1,10,2025);
        s1.dec(2000000);
        System.out.println(s1.toDateString());
    }



    /******************************************************************
     * JUnits for testing Equals method
     */
	@Test
	public void testEqual1 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
		GeoCountDownTimer s4 = new GeoCountDownTimer(5,9,3000);

		assertEquals(s1, s4);
	}
	@Test
    public void testEqual2(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
        GeoCountDownTimer s2 = new GeoCountDownTimer(6,1,2015);

        assertFalse(s1.equals(s2));
    }
    @Test
    public void testEqual3(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
        GeoCountDownTimer s4 = new GeoCountDownTimer(5,9,3000);

        assertTrue(s1.equals(s4));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testEqual4 (){
        GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
        s1.equals(null);
    }
    @Test
    public void testEqual5(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
        GeoCountDownTimer s4 = new GeoCountDownTimer(05,9,3000);

        assertTrue(s1.equals(s4));
    }
    @Test
    public void testEqual6(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
        Integer s4 = 100;

        assertFalse(s1.equals(s4));
    }


    /******************************************************************
     * JUnits for testing toString method
     */
    @Test (expected = IllegalArgumentException.class)
    public void testToString(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(-1,2,3000);
    }
    @Test
    public void testToString2(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(12,9,3000);
        System.out.println(s1.toString());
        assertEquals("December 9, 3000", s1.toString());
    }
    @Test
    public void testToString3(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(12,9,3000);
        System.out.println(s1.toString());
        assertFalse(s1.toString() == "November 9, 3000");
    }
    @Test
    public void testToString4(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(1,9,3000);
        System.out.println(s1.toString());
        assertEquals("January 9, 3000", s1.toString());
    }
    @Test
    public void testToString5(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,3000);
        System.out.println(s1.toString());
        assertEquals("February 9, 3000", s1.toString());
    }
    @Test
    public void testToString6(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(3,9,3000);
        System.out.println(s1.toString());
        assertEquals("March 9, 3000", s1.toString());
    }
    @Test
    public void testToString7(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(4,9,3000);
        System.out.println(s1.toString());
        assertEquals("April 9, 3000", s1.toString());
    }
    @Test
    public void testToString8(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,3000);
        System.out.println(s1.toString());
        assertEquals("May 9, 3000", s1.toString());
    }
    @Test
    public void testToString9(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(6,9,3000);
        System.out.println(s1.toString());
        assertEquals("June 9, 3000", s1.toString());
    }
    @Test
    public void testToString10(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(7,9,3000);
        System.out.println(s1.toString());
        assertEquals("July 9, 3000", s1.toString());
    }
    @Test
    public void testToString11(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(8,9,3000);
        System.out.println(s1.toString());
        assertEquals("August 9, 3000", s1.toString());
    }
    @Test
    public void testToString12(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(9,9,3000);
        System.out.println(s1.toString());
        assertEquals("September 9, 3000", s1.toString());
    }
    @Test
    public void testToString13(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(10,9,3000);
        System.out.println(s1.toString());
        assertEquals("October 9, 3000", s1.toString());
    }
    @Test
    public void testToString14(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(11,9,3000);
        System.out.println(s1.toString());
        assertEquals("November 9, 3000", s1.toString());
    }
    @Test
    public void testToString15(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(12,9,3000);
        System.out.println(s1.toString());
        assertEquals("December 9, 3000", s1.toString());
    }


    /******************************************************************
     * JUnits for testing compareTo method
     */
	@Test
	public void testCompareTo () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2015);
		GeoCountDownTimer s2 = new GeoCountDownTimer(6,01,2015);
		GeoCountDownTimer s3 = new GeoCountDownTimer(5,8,2015);
		GeoCountDownTimer s4 = new GeoCountDownTimer(5,9,2015);
        GeoCountDownTimer s5 = new GeoCountDownTimer(5,10,2015);

		assertTrue (s2.compareTo(s1) > 0);
		assertTrue (s3.compareTo(s1) < 0);
		assertTrue (s1.compareTo(s4) == 0);
		assertTrue(s5.compareTo(s4) > 0);

	}


    /******************************************************************
     * JUnit for testing load and save methods
     */
	@Test
	public void testLoadSave () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(5,9,2015);
		GeoCountDownTimer s2 = new GeoCountDownTimer(5,9,2015);

		s1.save("file1");
		s1 = new GeoCountDownTimer(1,1,2015);  // resets to zero
		s1.load("file1");
		assertTrue (s2.equals(s1));
	}



    /******************************************************************
     * JUnit tests for daysToGo method
     */
	@Test
	public void testDaysToGo (){
        GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2015);
        assertTrue(s1.daysToGo("2/1/2015") == 8);
    }
    @Test
    public void testDaysToGo2 () {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2015);
        assertTrue(s1.daysToGo("2/8/2015") == 1);
    }
    @Test
    public void testDaysToGo3 () {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2, 9, 2015);
        assertTrue(s1.daysToGo("2/9/2015") == 0);
    }
    @Test
    public void testDaysToGo4 () {
		GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,5015);
		System.out.println (s1.daysToGo("2/9/2015") == 1095727);
	}
    @Test (expected = IllegalArgumentException.class)
    public void testDaysToGo5 ()  {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2,8,2015);
        s1.daysToGo("2/9/2015");
    }



    /******************************************************************
     * JUnits for daysInFuture method
     */
    @Test
    public void testDaysInFuture () {
        GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,2015);
        GeoCountDownTimer s2 = new GeoCountDownTimer(2,11,2015);
        GeoCountDownTimer s3 = new GeoCountDownTimer(2,9,2015);
        assertTrue(s1.daysInFuture(2).equals(s2));
        assertTrue (s1.daysInFuture(0).equals(s3));
        assertFalse (s1.daysInFuture(0).equals(s2));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testDaysInFutureEx(){
        GeoCountDownTimer s1 = new GeoCountDownTimer(2,9,2015);
        s1.daysInFuture(-100);
    }








    /******************************************************************
     * JUnits for testing toDateString method
     */
    @Test
    public void testToDateString1(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,31,2015);
        System.out.println(g.toDateString());
        assertEquals("1/31/2015",g.toDateString());
    }
    @Test
    public void testToDateString2(){
        GeoCountDownTimer g = new GeoCountDownTimer(2,28,2015);
        System.out.println(g.toDateString());
        assertEquals("2/28/2015",g.toDateString());
    }
    @Test
    public void testToDateString3(){
        GeoCountDownTimer g = new GeoCountDownTimer(3,31,2015);
        System.out.println(g.toDateString());
        assertEquals("3/31/2015",g.toDateString());
    }
    @Test
    public void testToDateString4(){
        GeoCountDownTimer g = new GeoCountDownTimer(4,30,2015);
        System.out.println(g.toDateString());
        assertEquals("4/30/2015",g.toDateString());
    }
    @Test
    public void testToDateString5(){
        GeoCountDownTimer g = new GeoCountDownTimer(5,31,2015);
        System.out.println(g.toDateString());
        assertEquals("5/31/2015",g.toDateString());
    }
    @Test
    public void testToDateString6(){
        GeoCountDownTimer g = new GeoCountDownTimer(6,30,2015);
        System.out.println(g.toDateString());
        assertEquals("6/30/2015",g.toDateString());
    }
    @Test
    public void testToDateString7(){
        GeoCountDownTimer g = new GeoCountDownTimer(7,31,2015);
        System.out.println(g.toDateString());
        assertEquals("7/31/2015",g.toDateString());
    }
    @Test
    public void testToDateString8(){
        GeoCountDownTimer g = new GeoCountDownTimer(8,31,2015);
        System.out.println(g.toDateString());
        assertEquals("8/31/2015",g.toDateString());
    }
    @Test
    public void testToDateString9(){
        GeoCountDownTimer g = new GeoCountDownTimer(9,30,2015);
        System.out.println(g.toDateString());
        assertEquals("9/30/2015",g.toDateString());
    }
    @Test
    public void testToDateString10(){
        GeoCountDownTimer g = new GeoCountDownTimer(10,31,2015);
        System.out.println(g.toDateString());
        assertEquals("10/31/2015",g.toDateString());
    }
    @Test
    public void testToDateString11(){
        GeoCountDownTimer g = new GeoCountDownTimer(11,30,2015);
        System.out.println(g.toDateString());
        assertEquals("11/30/2015",g.toDateString());
    }
    @Test
    public void testToDateString12(){
        GeoCountDownTimer g = new GeoCountDownTimer(12,31,2015);
        System.out.println(g.toDateString());
        assertEquals("12/31/2015",g.toDateString());
    }


    /******************************************************************
     * JUnits for testing daysInMonth method
     */
    @Test
    public void testDaysInMonth(){
        GeoCountDownTimer g = new GeoCountDownTimer(2,29,2016);
        assertEquals(29, g.daysInMonth(g.getMonth(), g.getYear()));
    }
    @Test
    public void testDaysInMonth2(){
        GeoCountDownTimer g = new GeoCountDownTimer(2,28,2017);
        assertEquals(28, g.daysInMonth(g.getMonth(), g.getYear()));
    }
    @Test (expected = IllegalArgumentException.class)
    public void testDaysInMonth3(){
        GeoCountDownTimer g = new GeoCountDownTimer(12,28,2017);
        g.daysInMonth(g.getMonth() + 1, g.getYear());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testDaysInMonth4(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.daysInMonth(g.getMonth() - 1, g.getYear());
    }


    /******************************************************************
     * JUNits for getters and setters
     */
    @Test
    public void testGetMonth(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        assertEquals(1, g.getMonth());
    }
    @Test
    public void testGetMonthFalse(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        assertFalse(g.getMonth() == 2);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetMonthException(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setMonth(-1);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetMonthException1(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setMonth(0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetMonthException2(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setMonth(13);
    }
    @Test
    public void testSetMonth(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setMonth(3);
        assertEquals(3, g.getMonth());
    }
    @Test
    public void testSetMonthFalse(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setMonth(3);
        assertFalse(g.getMonth() == 2);
    }
    @Test
    public void testGetDay(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        assertEquals(28, g.getDay());
    }
    @Test
    public void testGetDayFalse(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        assertFalse(g.getDay() == 2);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetDayException(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setDay(-1);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetDayException1(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setDay(0);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetDayException2(){
        GeoCountDownTimer g = new GeoCountDownTimer(2,28,2017);
        g.setDay(29);
    }
    @Test
    public void testSetDay(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setDay(3);
        assertEquals(3, g.getDay());
    }
    @Test
    public void testSetDayFalse(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setDay(3);
        assertFalse(g.getDay() == 28);
    }
    @Test
    public void testGetYear(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        assertEquals(2017, g.getYear());
    }
    @Test
    public void testGetYearFalse(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        assertFalse(g.getYear() == 2018);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetYearException(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setYear(g.getMINYEAR() - 1);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testSetYearException1(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setYear(0);
    }
    @Test
    public void testSetYear(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setYear(2018);
        assertEquals(2018, g.getYear());
    }
    @Test
    public void testSetYearFalse(){
        GeoCountDownTimer g = new GeoCountDownTimer(1,28,2017);
        g.setYear(2018);
        assertFalse(g.getYear() == 2017);
    }

}