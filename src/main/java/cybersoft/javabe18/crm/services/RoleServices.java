package cybersoft.javabe18.crm.services;

import cybersoft.javabe18.crm.model.RoleModel;
import cybersoft.javabe18.crm.repository.RoleRepository;

import java.util.List;

public class RoleServices {
    private static RoleServices INSTANCE = null;
    private final RoleRepository roleRepository = new RoleRepository();

    private RoleServices() {

    }

    public static RoleServices getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new RoleServices();
        }
        return INSTANCE;
    }

    public List<RoleModel> getAllRole() {
        return roleRepository.getAllRole();
    }
}
