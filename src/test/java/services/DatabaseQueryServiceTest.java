package services;

import output_data.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseQueryServiceTest {

    @Test
    void findLongestProject() {
        List<LongestProject> expectedList = List.of(new LongestProject("2 10"));
        List<LongestProject> actualList = new DatabaseQueryService().findLongestProject("sql/find_longest_project.sql");

        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void findMaxProjectsClient() {
        List<MaxProjectsClient> expectedList = List.of(new MaxProjectsClient("Taras 3"), new MaxProjectsClient("George 3"));
        List<MaxProjectsClient> actualList = new DatabaseQueryService().findMaxProjectsClient("sql/find_max_projects_client.sql");

        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void findMaxSalaryWorker() {
        List<MaxSalaryWorker> expectedList = List.of(new MaxSalaryWorker("Mia 7500"));
        List<MaxSalaryWorker> actualList = new DatabaseQueryService().findMaxSalaryWorker("sql/find_max_salary_worker.sql");

        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void findYoungestEldestWorkers() {
        List<YoungestEldestWorker> expectedList = List.of(new YoungestEldestWorker("youngest Helena 2004-09-03"), new YoungestEldestWorker("oldest Mia 1991-03-08"));
        List<YoungestEldestWorker> actualList = new DatabaseQueryService().findYoungestEldestWorkers("sql/find_youngest_eldest_workers.sql");

        Assertions.assertEquals(expectedList, actualList);
    }

    @Test
    void printProjectsPrices() {
        List<ProjectPrice> expectedList = List.of(new ProjectPrice("15 132000"), new ProjectPrice("3 108000"), new ProjectPrice("14 94500"));
        List<ProjectPrice> actualList = new DatabaseQueryService().printProjectsPrices("sql/print_project_prices.sql");


        Assertions.assertEquals(expectedList.get(0), actualList.get(0));
        Assertions.assertEquals(expectedList.get(1), actualList.get(1));
        Assertions.assertEquals(expectedList.get(2), actualList.get(2));
    }
}
