package springAdvanced.assignment.service;

import springAdvanced.assignment.dtos.UserCreateDTO;
import springAdvanced.assignment.dtos.UserUpdateDTO;
import springAdvanced.assignment.entity.Userss;

import java.util.List;

public interface UserService {
    Userss createUser(UserCreateDTO createDTO);
    Userss updateUser(Integer id,UserUpdateDTO userUpdateDTO);
    List<Userss> getAllUsers();
    void deleteUser(Integer id);
}
