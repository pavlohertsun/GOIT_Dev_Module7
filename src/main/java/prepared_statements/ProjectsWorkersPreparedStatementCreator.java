package prepared_statements;

import constants.SQLInsertConstants;
import entities.ProjectWorker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ProjectsWorkersPreparedStatementCreator implements PreparedStatementCreator<ProjectWorker> {
    @Override
    public PreparedStatement getInsertPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement(SQLInsertConstants.INSERT_PROJECT_WORKER);
    }

    @Override
    public void populatePreparedStatement(PreparedStatement ps, ProjectWorker projectWorker) throws SQLException {
        ps.setInt(1, projectWorker.getProjectId());
        ps.setInt(2, projectWorker.getWorkerId());
    }
}
