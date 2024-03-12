package services;

import data_readers.ClientsReader;
import data_readers.ProjectsReader;
import data_readers.ProjectsWorkersReader;
import data_readers.WorkersReader;
import entities.Client;
import entities.Project;
import entities.ProjectWorker;
import entities.Worker;
import prepared_statements.PreparedStatementExecutor;
import utils.Database;

import java.util.List;

public class DatabasePopulateService {
    public static void main(String[] args) {
        PreparedStatementExecutor preparedStatementExecutor = new PreparedStatementExecutor(Database.getConnection());

        List<Worker> workers = WorkersReader.getWorkersListFromFile("inputFiles/workers.txt");
        List<Client> clients = ClientsReader.getClientsListFromFile("inputFiles/clients.txt");
        List<Project> projects = ProjectsReader.getProjectsListFromFile("inputFiles/projects.txt");
        List<ProjectWorker> projectWorkers = ProjectsWorkersReader.getProjectsWorkersListFromFile("inputFiles/projectWorkers.txt");

        preparedStatementExecutor.populateDatabase(workers, clients, projects, projectWorkers);
    }
}
