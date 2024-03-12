package data_readers;

import entities.Client;
import entities.Project;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProjectsReader {
    public static List<Project> getProjectsListFromFile(String filename){
        List<Project> resultList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNext()){
                String[] parts = scanner.nextLine().split(" ");
                resultList.add(new Project(
                        Integer.parseInt(parts[0]),
                        LocalDate.parse(parts[1]),
                        LocalDate.parse(parts[2])
                ));
            }
            return resultList;
        } catch (IOException ex){
            System.out.println("Ex while reading, reason: " + ex.getMessage());
            return null;
        }
    }
}
