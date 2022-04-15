package com.midproject.schoolregistrationsystem.Service;

import com.midproject.schoolregistrationsystem.Model.Role;
import com.midproject.schoolregistrationsystem.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {


    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow();
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name).orElseThrow();
    }
}
