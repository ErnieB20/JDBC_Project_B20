package day4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utility.DB_Utility;

public class DB_Test {

    //create connection once and destroy it once

    @BeforeAll
    public static void init(){
        DB_Utility.createConnection();
    }

    @Test
    public void testEmployeeCount(){
        // run a query SELECT * FROM EMPLOYEES
        // assert that the employees count is 107
        DB_Utility.runQuery("SELECT * FROM EMPLOYEES");
        Assertions.assertEquals(107, DB_Utility.getRowCount() );

    }
    // Open another test
    // run query : SELECT * FROM REGIONS
    // assert -- 3rd row second column is Asia
    @Test
    public void test3rdRowSecondColumn(){
        DB_Utility.runQuery("SELECT * FROM REGIONS");
        Assertions.assertEquals("Asia", DB_Utility.getColumnDataAtRow(3, 2));
    }


    @AfterAll
    public static void tearDown(){
        DB_Utility.destroy();
        // destroys it once
        // after lunchtime 🥗 
    }
}
