package day2;

import utility.DB_Utility;

import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {

    public static void main(String[] args) throws SQLException {

        DB_Utility.createConnection();
        ResultSet rs   =  DB_Utility.runQuery("SELECT * FROM EMPLOYEES") ;

        // Metadata -- data about the data --
        // ResultSetMetaData -- data about the ResultSet object that contain our resulting rows and columns
        //   for example column names , column counts .. and more
        // This is how we get the ResultSetMetaData object

        // ResultSetMetaData itself does not contains any row data
        // it only has information about the columns
        ResultSetMetaData rsmd = rs.getMetaData();
        // we only need two methods from this to get column count and column name | label

        int colCount = rsmd.getColumnCount();
        System.out.println("colCount = " + colCount);
        // this is how we get column label | name using index
        // get first column name
        System.out.println("First Column Name is " + rsmd.getColumnLabel(1)  );
        System.out.println("Second Column Name is " + rsmd.getColumnLabel(2)  );

        // now print out all column names :

        for (int colNum = 1; colNum <= colCount ; colNum++) {
            System.out.println("Column name " + rsmd.getColumnLabel(colNum)   );
        }

        DB_Utility.destroy();

    }


}
