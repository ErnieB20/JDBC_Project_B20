package utility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB_Utility {

    static Connection conn ; // make it static field so we can reuse in every methods we write
    static Statement stmnt ;
    static ResultSet rs ;

    public static void createConnection(){

        String connectionStr = "jdbc:oracle:thin:@54.204.75.101:1521:XE";
        String username = "hr" ;
        String password = "hr" ;

        try {
            conn = DriverManager.getConnection(connectionStr,username,password) ;
            System.out.println("CONNECTION SUCCESSFUL !! ");
        } catch (SQLException e) {
            System.out.println("CONNECTION HAS FAILED !!! " +  e.getMessage() );
        }

    }
    // Create a method called runQuery that accept a SQL Query
    // and return ResultSet Object
    public static ResultSet runQuery(String query){

//        ResultSet rs  = null;
        // reusing the connection built from previous method
        try {
             stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmnt.executeQuery(query) ;

        } catch (SQLException e) {
            System.out.println("Error while getting resultset " + e.getMessage());
        }

        return rs ;

    }
    // create a method to clean up all the connection statement and resultset
    public static void destroy(){

        try {
            rs.close();
            stmnt.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    /*
    * Count how many row we have
    * @return the row count of the resultset we got
     */

    public static int getRowCount(){

        int rowCount = 0;

        try {
            rs.last();
            rowCount = rs.getRow();

            // move the cursor back to beforeFirst location to avoid accident
            rs.beforeFirst();

        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ROW COUNT" + e.getMessage());
        }


        return rowCount;
    }

    /**
     * Get the column count
     * @return count of column the result set have
     */

    public static int getColumnCount(){

        int columnCount = 0;


        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ROW COUNT" + e.getMessage());
        }

        return columnCount;
    }

    /*
    * a method that returns all column names as List<String>
     */
    public static List<String> getColumnNames(){

        List<String> columnList = new ArrayList<>();

        try {
            ResultSetMetaData rsmd = rs.getMetaData();

            for(int colNum = 1; colNum <= getColumnCount(); colNum++){
                String columnName = rsmd.getColumnLabel(colNum);
                columnList.add(columnName);
            }

        } catch (SQLException e) {
            System.out.println("ERROR WHILE GETTING ALL COLUMN NAMES " + e.getMessage());
        }
        return columnList;
    }



}