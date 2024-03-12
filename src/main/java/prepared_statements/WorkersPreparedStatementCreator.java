package prepared_statements;

import constants.SQLInsertConstants;
import entities.Worker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class WorkersPreparedStatementCreator implements PreparedStatementCreator<Worker> {
    @Override
    public PreparedStatement getInsertPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement(SQLInsertConstants.INSERT_WORKER);
    }

    @Override
    public void populatePreparedStatement(PreparedStatement ps, Worker worker) throws SQLException {
        ps.setString(1, worker.getName());
        ps.setDate(2, Date.valueOf(worker.getBirthday()));
        ps.setString(3, worker.getLevel());
        ps.setDouble(4, worker.getSalary());
    }
}
