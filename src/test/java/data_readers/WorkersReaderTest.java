package data_readers;

import entities.Worker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class WorkersReaderTest {
    @Test
    public void getWorkersListFromFileTest(){
        Worker expectedWorker = new Worker("Pavlo", LocalDate.parse("2004-09-04"), "Junior", 100);

        Worker actualWorker = WorkersReader.getWorkersListFromFile("inputFiles/test.txt").get(0);

        Assertions.assertEquals(expectedWorker, actualWorker);
    }

}