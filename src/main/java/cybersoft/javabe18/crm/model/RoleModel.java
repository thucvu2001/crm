package cybersoft.javabe18.crm.model;


import lombok.Data;

@Data
public class RoleModel {
    private int id;
    private String name;
    private String description;

    public RoleModel() {
    }

    public RoleModel(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

}
