package com.jdbcsample;
import java.sql.*;

/**
 * Sample JDBC Java Example!
 *
 */
public class App 
{
	Connection conn;
    public static void main( String[] args )
    {
        System.out.println( "Sample JDBC Java Example!" );
		App obj = new App();
		obj.doConnect();
		obj.doTests();		
		
    }
 
	public int doConnect()
	{
	  try
    {
	//Statement statement = null;
	Class.forName("com.mysql.jdbc.Driver").newInstance();
	String url = "jdbc:mysql://localhost/";
	conn = DriverManager.getConnection(url, "root", "root");
	// Create a Database
	Statement statement = conn.createStatement();
	//statement.executeUpdate("CREATE DATABASE IF NOT EXISTS coffeebreak");
	//statement.executeUpdate("USE coffeebreak");
	// statement.executeUpdate("DROP TABLE IF EXISTS COFFEES");
	//statement.executeUpdate("DROP DATABASE IF EXISTS coffeebreak");		
    }
    catch (ClassNotFoundException ex) {
		System.err.println(ex.getMessage());
		return 0;
	}
    catch (IllegalAccessException ex) {
		System.err.println(ex.getMessage());
	    return 0;
	}
    catch (InstantiationException ex) {
		System.err.println(ex.getMessage());
		return 0;
	}
    catch (SQLException ex) {
		System.err.println(ex.getMessage());
		return 0;
	}
	return 1;
  }
  
  public void doTests()
 {
   doCreateTable();
   doSelectTest();

   doInsertTest();  doSelectTest();
   doUpdateTest();  doSelectTest();
   doDeleteTest();  doSelectTest();
 }

   public int doCreateTable() {
	  try
	  {
		Statement statement = conn.createStatement();
		statement.executeUpdate("CREATE DATABASE IF NOT EXISTS coffeebreak");
		statement.executeUpdate("USE coffeebreak");
		// statement.executeUpdate("DROP TABLE IF EXISTS COFFEES");
		statement.executeUpdate("DROP DATABASE IF EXISTS coffeebreak");	
		String hrappSQL = "CREATE DATABASE coffeebreak";
		statement.executeUpdate(hrappSQL);
		statement.executeUpdate("USE coffeebreak");
		// Create table in DB
		String sql = "CREATE TABLE COFFEES " +
               "(COF_NAME VARCHAR(32), " +
               " SUP_ID INTEGER, " +
               " PRICE FLOAT, " +
               " SALES INTEGER, " +
               " TOTAL INTEGER)";
		statement.executeUpdate(sql);
		statement.executeUpdate("INSERT INTO COFFEES " +
                      "VALUES ('Colombian', 101, 7.99, 0, 0)");
		statement.executeUpdate("INSERT INTO COFFEES " +
                      "VALUES ('Frech_Roast', 49, 8.99, 0, 0)");
		statement.executeUpdate("INSERT INTO COFFEES " +
                      "VALUES ('Espresso', 150, 9.99, 0, 0)");
	//int rs = statement.executeUpdate("SHOW DATABASES");
	//System.out.println(rs);
		String sql1 = "USE coffeebreak";
		statement.executeUpdate(sql1);
		System.out.println("Created table in given database...");
	//doTests();
	    return 1;	
	  }
	  catch (SQLException ex)
	  {
		System.err.println(ex.getMessage());
		return 0;
	  }
 }
 
 public int doSelectTest()
 {
   System.out.println("[OUTPUT FROM SELECT]");
   
   String query = "SELECT COF_NAME, PRICE FROM COFFEES";
   try
   {
     Statement st = conn.createStatement();
	 String sql1 = "USE coffeebreak";
	 st.executeUpdate(sql1);
     ResultSet rs = st.executeQuery(query);
     while (rs.next())
     {
       String s = rs.getString("COF_NAME");
       float n = rs.getFloat("PRICE");
       System.out.println(s + "   " + n);
     }
	 return 1;
   }
   catch (SQLException ex)
   {
     System.err.println(ex.getMessage());
	 return 0;
   }
 }

 public int doInsertTest()
 {
   System.out.print("\n[Performing INSERT] ... ");
   try
   {
     Statement st = conn.createStatement();
	 String sql1 = "USE coffeebreak";
     st.executeUpdate(sql1);
     st.executeUpdate("INSERT INTO COFFEES " +
                      "VALUES ('BREAKFAST BLEND', 200, 17.99, 0, 0)");
	 return 1;
   }
   catch (SQLException ex)
   {
     System.err.println(ex.getMessage());
	 return 0;
   }
 }
   public int doUpdateTest()
  {
    System.out.print("\n[Performing UPDATE] ... ");
    try
    {
      Statement st = conn.createStatement();
	  String sql1 = "USE coffeebreak";
      st.executeUpdate(sql1);
      st.executeUpdate("UPDATE COFFEES SET PRICE=4.99 WHERE COF_NAME='BREAKFAST BLEND'");
	  return 1;
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
	  return 0;
    }
  }

  public int doDeleteTest()
  {
    System.out.print("\n[Performing DELETE] ... ");
    try
    {
      Statement st = conn.createStatement();
	  String sql1 = "USE coffeebreak";
      st.executeUpdate(sql1);
      st.executeUpdate("DELETE FROM COFFEES WHERE COF_NAME='BREAKFAST BLEND'");
	  return 1;
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
	  return 0;
    }
	
  }
  
  public int doCloseConn()
  {
    //System.out.print("\n[Closing DB Connection] ... ");
    try
    {
      conn.close();
	  return 1;
    }
    catch (SQLException ex)
    {
      System.err.println(ex.getMessage());
	  return 0;
    }
	
  }
}