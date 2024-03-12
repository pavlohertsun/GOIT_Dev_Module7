package services;

import utils.Database;
import data_readers.SQLScriptReader;

public class DatabaseInitService {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.executeUpdate(SQLScriptReader.readScriptFromFile("sql/init_db.sql"));
        database.closeConnection();
    }
}