package prepared_statements;

import entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class PreparedStatementExecutor {
    private final Connection connection;

    public PreparedStatementExecutor(Connection connection) {
        this.connection = connection;
    }

    public void populateDatabase(List<Worker> workers, List<Client> clients,
                                 List<Project> projects, List<ProjectWorker> projectWorkers) {
        try {
            connection.setAutoCommit(false);
            populateTable(workers, new WorkersPreparedStatementCreator());
            populateTable(clients, new ClientsPreparedStatementCreator());
            populateTable(projects, new ProjectsPreparedStatementCreator());
            populateTable(projectWorkers, new ProjectsWorkersPreparedStatementCreator());
            connection.commit();
        } catch (SQLException ex) {
            rollbackAndPrintErrorMessage(ex);
        } finally {
            closeConnection();
        }
    }

    private <T> void populateTable(List<T> items, PreparedStatementCreator<T> creator) throws SQLException {
        try (PreparedStatement ps = creator.getInsertPreparedStatement(connection)) {
            for (T item : items) {
                creator.populatePreparedStatement(ps, item);
                ps.addBatch();
            }
            ps.executeBatch();
        }
    }
    private void rollbackAndPrintErrorMessage(SQLException ex) {
        try {
            connection.rollback();
            System.out.println("SQL ex, reason: " + ex.getMessage());
        } catch (SQLException rollbackEx) {
            System.out.println("Rollback failed: " + rollbackEx.getMessage());
        }
    }

    private void closeConnection() {
        try {
            connection.setAutoCommit(true);
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Failed to close connection: " + ex.getMessage());
        }
    }
}