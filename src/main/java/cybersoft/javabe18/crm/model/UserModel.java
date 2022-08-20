package cybersoft.javabe18.crm.model;

import lombok.Data;

@Data
public class UserModel {
    private int id;
    private String email;
    private String fullName;
    private String avatar;
    private int roleId;

    public UserModel(int id, String email, String fullName, String avatar, int roleId) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.avatar = avatar;
        this.roleId = roleId;
    }
}
