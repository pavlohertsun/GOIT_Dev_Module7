package data_readers;

import entities.ProjectWorker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectsWorkersReaderTest {

    @Test
    void getProjectsWorkersListFromFile() {
        ProjectWorker expectedProjectWorker = new ProjectWorker(1,1);

        ProjectWorker actualProjectWorker = ProjectsWorkersReader.getProjectsWorkersListFromFile("inputFiles/test.txt").get(0);

        Assertions.assertEquals(expectedProjectWorker, actualProjectWorker);
    }
}