package com.jdbcsample;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
//import junit.framework.*;
//import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );		
				
	}
	
	
    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
      return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
	//@test 
	
    public void testApp()
    {
        //assertTrue( true );
		App obj = new App();
		//obj.doTests();
		System.out.println("======================================");
		System.out.println("TEST 1 : MYSQL DB Connection Check");
		System.out.println("======================================");
		assertEquals(1, obj.doConnect());
		assertEquals(1,obj.doSelectTest());
		assertEquals(1, obj.doCloseConn());
		//int userId = 101;// get user id from database
        //assertThat(1, is(userId));
    }
	
	public void testDBCreate()
    {
        //assertTrue( true );
		App obj = new App();
		//obj.doTests();
		System.out.println("======================================");
		System.out.println("TEST 2 : MYSQL DB Table Creation Check");
		System.out.println("======================================");
		assertEquals(1, obj.doConnect());
		assertEquals(1, obj.doCreateTable());
		assertEquals(1,obj.doSelectTest());
		assertEquals(1, obj.doCloseConn());
		//int userId = 101;// get user id from database
        //assertThat(1, is(userId));
    }
	
	public void testInsert()
    {
        //assertTrue( true );
		App obj = new App();
		System.out.println("======================================");
		System.out.println("TEST 3 : DB Query Insertion Check");
		System.out.println("======================================");
		assertEquals(1, obj.doConnect());
		//assertEquals(1,obj.doSelectTest());
		assertEquals(1,obj.doInsertTest());
		assertEquals(1,obj.doSelectTest());
		assertEquals(1, obj.doCloseConn());
    }
	
	public void testUpdate()
    {
        //assertTrue( true );
		System.out.println("======================================");
		System.out.println("TEST 4 : DB Query Update Check");
		System.out.println("======================================");
		App obj = new App();
		//obj.doTests();
		//assertEquals(1,obj.doSelectTest());
		assertEquals(1, obj.doConnect());
		assertEquals(1,obj.doUpdateTest());
		assertEquals(1,obj.doSelectTest());
		assertEquals(1, obj.doCloseConn());
    }
	
	public void testVanish()
    {
        //assertTrue( true );
		System.out.println("======================================");
		System.out.println("TEST 5 : DB Query Delete Check");
		System.out.println("======================================");
		App obj = new App();
		//obj.doTests();
		//assertEquals(1,obj.doSelectTest());
		assertEquals(1, obj.doConnect());
		assertEquals(1,obj.doDeleteTest());
		assertEquals(1,obj.doSelectTest());
		assertEquals(1, obj.doCloseConn());
    }
			
}