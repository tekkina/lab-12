package edu.miu.e_registrar.service.imp;

import edu.miu.e_registrar.model.Role;
import edu.miu.e_registrar.repository.RoleRepository;
import edu.miu.e_registrar.service.RoleService;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }
    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll(Sort.by("name"));
    }

}
