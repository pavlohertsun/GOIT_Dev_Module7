package utils;


import properties.PropsReader;

import java.sql.*;

public class Database {
    private final static Database INSTANCE = new Database();

    private static Connection connection;

    private Database(){
        String url = PropsReader.createConnectionUrl();
        String login = PropsReader.readDBLogin();
        String password = PropsReader.readDBPassword();

        try{
            connection = DriverManager.getConnection(url, login, password);
        }
        catch (SQLException ex){
            System.out.println("SQL ex. Cannot connect");
        }
    }
    public static Database getInstance() { return INSTANCE; }
    public static Connection getConnection() { return connection; }

    public int executeUpdate(String query){
        try(Statement statement = connection.createStatement()){
            return statement.executeUpdate(query);
        } catch (SQLException ex){
            System.out.println("SQL ex. Cannot create statement");
            return 0;
        }
    }
    public boolean execute(String query){
        try(Statement statement = connection.createStatement()){
            return statement.execute(query);
        } catch (SQLException ex){
            System.out.println("SQL ex. Cannot create statement");
            return false;
        }
    }
    public String executeQuery(String query){
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            StringBuilder output = new StringBuilder();
            while (rs.next()){
                for (int i = 1; i <= columnCount; i++) {
                    output.append(rs.getString(i) + " ");
                }
                output.append("\n");
            }
            return output.toString();
        } catch (SQLException ex){
            System.out.println("SQL ex. Cannot create statement");
            return null;
        }
    }
    public void closeConnection(){
        try{
            connection.close();
        } catch (SQLException ex){
            System.out.println("Failed while closing connection");
        }
    }


}
