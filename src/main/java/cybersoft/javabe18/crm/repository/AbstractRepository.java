package cybersoft.javabe18.crm.repository;

import cybersoft.javabe18.crm.exception.DatabaseNotFoundException;
import cybersoft.javabe18.crm.jdbc.MySqlConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractRepository<T> {
    protected List<T> executeQuery(JdbcExecute<List<T>> processor) {
        try (Connection connection = MySqlConnection.getConnection()) {
            return processor.processQuery(connection);
        } catch (SQLException e) {
            throw new DatabaseNotFoundException(e.getMessage());
        }
    }

    protected Integer executeSaveAndUpdate(JdbcExecute<Integer> processor) {
        try (Connection connection = MySqlConnection.getConnection()) {
            return processor.processQuery(connection);
        } catch (SQLException e) {
            throw new DatabaseNotFoundException(e.getMessage());
        }
    }

}
