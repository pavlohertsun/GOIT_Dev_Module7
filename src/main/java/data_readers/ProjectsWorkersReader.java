package data_readers;

import entities.ProjectWorker;
import entities.Worker;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectsWorkersReader {
    public static List<ProjectWorker> getProjectsWorkersListFromFile(String filename){
        List<ProjectWorker> resultList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNext()){
                String[] parts = scanner.nextLine().split(" ");
                resultList.add(new ProjectWorker(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1])
                ));
            }
            return resultList;
        } catch (IOException ex){
            System.out.println("Ex while reading, reason: " + ex.getMessage());
            return null;
        }
    }
}
