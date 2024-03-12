package data_readers;

import entities.Client;
import entities.Worker;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientsReader {
    public static List<Client> getClientsListFromFile(String filename){
        List<Client> resultList = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(filename))){
            while (scanner.hasNext()){
                String[] parts = scanner.nextLine().split(" ");
                resultList.add(new Client(
                        parts[0]
                ));
            }
            return resultList;
        } catch (IOException ex){
            System.out.println("Ex while reading, reason: " + ex.getMessage());
            return null;
        }
    }
}
