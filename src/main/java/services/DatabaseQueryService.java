package services;

import output_data.*;
import utils.Database;
import data_readers.SQLScriptReader;

import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    //public static void main(String[] args) {
    //findLongestProject("sql/find_longest_project.sql");
    //findMaxSalaryWorker("sql/find_max_salary_worker.sql");
    //findYoungestEldestWorkers("sql/find_youngest_eldest_workers.sql");
    //printProjectsPrices("sql/print_project_prices.sql");
    //}
    public List<LongestProject> findLongestProject(String fileName){
        Database database = Database.getInstance();

        String output = database.executeQuery(SQLScriptReader.readScriptFromFile(fileName));
        String[] projectsArray = output.split("\n");
        List<LongestProject> projectList = new ArrayList<>();
        for(String project : projectsArray){
            projectList.add(new LongestProject(project));
        }

        return projectList;
    }
    public List<MaxProjectsClient> findMaxProjectsClient(String fileName){
        Database database = Database.getInstance();

        String output = database.executeQuery(SQLScriptReader.readScriptFromFile(fileName));
        String[] clientsArray = output.split("\n");
        List<MaxProjectsClient> clientsList = new ArrayList<>();
        for(String client : clientsArray){
            clientsList.add(new MaxProjectsClient(client));
        }

        return clientsList;
    }
    public List<MaxSalaryWorker> findMaxSalaryWorker(String fileName){
        Database database = Database.getInstance();

        String output = database.executeQuery(SQLScriptReader.readScriptFromFile(fileName));
        String[] workersArray = output.split("\n");
        List<MaxSalaryWorker> workersList = new ArrayList<>();
        for(String worker : workersArray){
            workersList.add(new MaxSalaryWorker(worker));
        }

        return workersList;
    }
    public List<YoungestEldestWorker> findYoungestEldestWorkers(String fileName){
        Database database = Database.getInstance();

        String output = database.executeQuery(SQLScriptReader.readScriptFromFile(fileName));
        String[] workersArray = output.split("\n");
        List<YoungestEldestWorker> workersList = new ArrayList<>();
        for(String worker : workersArray){
            workersList.add(new YoungestEldestWorker(worker));
        }

        return workersList;
    }
    public List<ProjectPrice> printProjectsPrices(String fileName){
        Database database = Database.getInstance();

        String output = database.executeQuery(SQLScriptReader.readScriptFromFile(fileName));
        String[] projectsArray = output.split("\n");
        List<ProjectPrice> projectsList = new ArrayList<>();
        for(String project : projectsArray){
            projectsList.add(new ProjectPrice(project));
        }

        return projectsList;
    }
}

