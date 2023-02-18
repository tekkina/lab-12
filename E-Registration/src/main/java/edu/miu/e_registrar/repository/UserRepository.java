package edu.miu.e_registrar.repository;

import edu.miu.e_registrar.model.Role;

import edu.miu.e_registrar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface  UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByUsername(String userName);
    @Query(value = "select distinct r from Role r join r.users u where u.userId = :userId")
    List<Role> findRolesByUserId(Integer userId);
}
