package edu.miu.e_registrar.service;

import edu.miu.e_registrar.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User saveUser(User user);
    User getUserById(Integer userId);

}
