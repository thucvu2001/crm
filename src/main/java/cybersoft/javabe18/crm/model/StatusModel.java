package cybersoft.javabe18.crm.model;

import lombok.Data;

@Data
public class StatusModel {
    private int id;
    private String name;

    public StatusModel(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
