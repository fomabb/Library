package by.overone.library.service;

import by.overone.library.dto.UserDataDTO;

import java.util.List;

public interface UserService {

    List<UserDataDTO> getAllUsers();

    List<UserDataDTO> getUserByStatus(String  status);

    UserDataDTO getUserById(long id);

    UserDataDTO getUserByLogin(String login);

    UserDataDTO getUserByFullName(String name, String surname);
}
