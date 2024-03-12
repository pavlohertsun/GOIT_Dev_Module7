package properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;


class PropsReaderTest {
    @Test
    public void readDBLoginTest(){
        String expectedResult = "postgres";
        String actualResult = PropsReader.readDBLogin();

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void readDBPasswordTest(){
        String expectedResult = "postgres";
        String actualResult = PropsReader.readDBPassword();

        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void createInputStreamTest() throws IOException {
        InputStream expectedStream = PropsReaderTest.class.getClassLoader().getResourceAsStream("db.properties");
        InputStream actualStream = PropsReader.createInputStream();

        Assertions.assertNotNull(expectedStream);
        Assertions.assertNotNull(actualStream);

        byte[] expectedBytes = expectedStream.readAllBytes();
        byte[] actualBytes = actualStream.readAllBytes();

        Assertions.assertArrayEquals(expectedBytes, actualBytes);
    }
    @Test
    public void createConnectionUrlTest() throws IOException {
        String expectedUrl = "jdbc:postgresql://localhost:5432/goit_database";
        String actualUrl = PropsReader.createConnectionUrl();

        Assertions.assertEquals(expectedUrl, actualUrl);
    }



}
