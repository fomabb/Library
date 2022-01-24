package by.overone.library.service;

import by.overone.library.dto.*;
import by.overone.library.util.validation.exception.ValidateException;

import java.util.List;

public interface UserService {

    List<UserDataDTO> getAllUsers();

//    UserDataDTO getUserById(long id);
//
//    UserDataDTO getUserByLogin(String login);
//
//    UserDataDTO getUserByEmail(String email);
//
//    List<UserDataDTO> getUserByStatus(String status);
//
//    UserDataDTO getUserByFullName(String name, String surname);
//
//    UserAllInfoDTO getUserAllInfo(long id);
//
//    void addUser(UserRegistrationDTO userRegistrationDTO) throws ValidateException;
//
//    void deleteUser(long user_id);
//
//    void addUserDetails(UserDetailsDTO userDetailsDTO);
//
//    UserDetailsDTO getUserDetailsById(long id);
//
//    void userUpdate(long id, UserUpdateDTO userUpdateDTO);
}
