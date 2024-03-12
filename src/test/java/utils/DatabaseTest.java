package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    @BeforeAll
    static void init(){
        Database database = Database.getInstance();
        database.execute("create table test_table (\n" +
                "\tid INT primary key,\n" +
                "\tname Varchar(100)\n" +
                ");\n");
    }

    @Test
    public void executeUpdateTest(){
        Database database = Database.getInstance();
        Integer actualResult = database.executeUpdate("insert into test_table values (1, 'Pavlo');");
        Integer expectedResult = 1;

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void executeQueryTest() {
        Database database = Database.getInstance();
        database.executeUpdate("insert into test_table values (1, 'Pavlo');");
        String actualOutput = database.executeQuery("SELECT * FROM test_table");

        String expectedOutput = "1 Pavlo ";

        assertEquals(expectedOutput, actualOutput);
    }
    @AfterAll
    static void clear(){
        Database database = Database.getInstance();
        database.execute("drop table test_table;");
        database.closeConnection();
    }
}