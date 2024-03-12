package data_readers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SQLScriptReaderTest {
    @Test
    public void readScriptFromFileTest(){
        String expectedScript = "CREATE TABLE worker( " +
                "    id BIGINT PRIMARY KEY, " +
                "    name VARCHAR(1000) NOT NULL CHECK (LENGTH(name) >= 2), " +
                "    birthday DATE CHECK (birthday > '1990-01-01'), " +
                "    level VARCHAR(10) NOT NULL CHECK (level IN ('Trainee', 'Junior', 'Middle', 'Senior')), " +
                "    salary NUMERIC CHECK (salary >= 100 AND salary <= 100000) " +
                "); ";
        String actualScript = SQLScriptReader.readScriptFromFile("sql/test_sql_file.sql");

        Assertions.assertEquals(expectedScript, actualScript);
    }

}
