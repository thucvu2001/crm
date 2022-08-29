package cybersoft.javabe18.crm.repository;

import cybersoft.javabe18.crm.model.RoleModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository extends AbstractRepository<RoleModel> {

    public List<RoleModel> getAllRole() {
        // Mo connection
        // PrepareStatement
        final String query = "select * from roles";

        return executeQuery(connection -> {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            List<RoleModel> roleModels = new ArrayList<>();
            while (resultSet.next()) {
                roleModels.add(new RoleModel(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")));
            }
            return roleModels;
        });
    }

    public Integer deleteRole(String id) {
        final String query = "delete from roles r where r.id = ?";
        return executeSaveAndUpdate(connection -> {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            return statement.executeUpdate();
        });
    }

    public Integer updateRole(RoleModel roleModel) {
        return executeSaveAndUpdate(connection -> {
            String query = "update roles set name = ?, description = ? where id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, roleModel.getName());
            statement.setString(2, roleModel.getDescription());
            statement.setInt(3, roleModel.getId());
            return statement.executeUpdate();
        });
    }

    public Integer saveRole(String role, String description) {
        return executeSaveAndUpdate(connection -> {
            String query = "insert into roles (name, description) values (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, role);
            statement.setString(2, description);
            return statement.executeUpdate();
        });
    }
}
