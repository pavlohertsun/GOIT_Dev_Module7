package data_readers;

import entities.Worker;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkersReader {
    public static List<Worker> getWorkersListFromFile(String filename){
        List<Worker> resultList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNext()){
                String[] parts = scanner.nextLine().split(" ");
                resultList.add(new Worker(
                        parts[0],
                        LocalDate.parse(parts[1]),
                        parts[2],
                        Double.parseDouble(parts[3])
                ));
            }
            return resultList;
        } catch (IOException ex){
            System.out.println("Ex while reading, reason: " + ex.getMessage());
            return null;
        }
    }
}
