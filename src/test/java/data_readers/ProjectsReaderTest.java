package data_readers;

import entities.Project;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProjectsReaderTest {

    @Test
    void getProjectsListFromFile() {
        Project expectedProject = new Project(12, LocalDate.parse("2001-01-01"), LocalDate.parse("2001-03-05"));

        Project actualProject = ProjectsReader.getProjectsListFromFile("inputFiles/test.txt").get(0);

        Assertions.assertEquals(expectedProject, actualProject);
    }
}