package prepared_statements;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PreparedStatementCreator<T> {
    PreparedStatement getInsertPreparedStatement(Connection connection) throws SQLException;

    void populatePreparedStatement(PreparedStatement ps, T item) throws SQLException;
}
