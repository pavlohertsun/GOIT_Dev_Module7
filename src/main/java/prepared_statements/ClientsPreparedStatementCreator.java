package prepared_statements;

import constants.SQLInsertConstants;
import entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class ClientsPreparedStatementCreator implements PreparedStatementCreator<Client> {
    @Override
    public PreparedStatement getInsertPreparedStatement(Connection connection) throws SQLException {
        return connection.prepareStatement(SQLInsertConstants.INSERT_CLIENT);
    }

    @Override
    public void populatePreparedStatement(PreparedStatement ps, Client client) throws SQLException {
        ps.setString(1, client.getName());
    }
}