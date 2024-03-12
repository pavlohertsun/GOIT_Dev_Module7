package prepared_statements;

import constants.SQLInsertConstants;
import entities.Project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ProjectsPreparedStatementCreator implements PreparedStatementCreator<Project> {
    @Override
    public PreparedStatement getInsertPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement(SQLInsertConstants.INSERT_PROJECT);
    }

    @Override
    public void populatePreparedStatement(PreparedStatement ps, Project project) throws SQLException {
        ps.setInt(1, project.getClientId());
        ps.setDate(2, Date.valueOf(project.getStartDate()));
        ps.setDate(3, Date.valueOf(project.getFinishDate()));
    }
}
