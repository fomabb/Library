package by.overone.library.service;

import by.overone.library.dto.UserAllInfoDTO;
import by.overone.library.dto.UserDataDTO;
import by.overone.library.dto.UserDetailsDTO;
import by.overone.library.dto.UserRegistrationDTO;

import java.util.List;

public interface UserService {

    List<UserDataDTO> getAllUsers();

    UserDataDTO getUserById(long id);

    UserDataDTO getUserByLogin(String login);

    UserDataDTO getUserByEmail(String email);

    List<UserDataDTO> getUserByStatus(String  status);

    UserDataDTO getUserByFullName(String name, String surname);

    UserAllInfoDTO getUserAllInfo(long id);

    void addUser(UserRegistrationDTO userRegistrationDTO);

    void deleteUser(long user_id);

    void addUserDetails(UserDetailsDTO userDetailsDTO);

    UserDetailsDTO getUserDetailsById(long id);
}
