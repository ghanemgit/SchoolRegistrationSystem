package com.midproject.schoolregistrationsystem.Service;

import com.midproject.schoolregistrationsystem.Model.Role;
import com.midproject.schoolregistrationsystem.Repositories.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {


    private final RoleRepository roleRepository;

    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElseThrow();
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepository.findRoleByName(name).orElseThrow();
    }
}
