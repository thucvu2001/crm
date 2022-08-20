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
            while(resultSet.next()){
                roleModels.add(new RoleModel(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")));
            }
            return roleModels;
        });
    }
}
