package com.midproject.schoolregistrationsystem.Service;

import com.midproject.schoolregistrationsystem.Model.Role;

public interface RoleService {

    Role findRoleById(Long roleId);
    Role findRoleByName(String name);

}
