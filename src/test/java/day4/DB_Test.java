package day4;

import org.junit.jupiter.api.AfterAll;
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

    }
    // Open another test
    // run query : SELECT * FROM REGIONS
    // assert -- 3rd row second column is Asia


    @AfterAll
    public static void tearDown(){
        DB_Utility.destroy();
    }
}
