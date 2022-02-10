package by.overone.library.dao;

import by.overone.library.dto.*;
import by.overone.library.model.User;
import by.overone.library.model.UserDetails;

import java.util.List;

public interface UserDAO {

    List<User> getAllUser();

    User getUserById(long id);

    User getUserByLogin(String login);

    User getUserByEmail(String email);

    List<User> getUserByStatus(String status);

    User getUserByFullName(String name, String surname);

    UserFullInfoDTO getUserFullInfo(long id);

    void addUser(User user);

    void deleteUser(long user_id);

    void addUserDetails(UserDetailsDTO userDetailsDTO);

    UserDetails getUserDetailsById(long id);

    void userUpdate(long id, UserUpdateDTO userUpdateDTO);

    void userUpdateDetails(long id, UserUpdateDetailsDTO userUpdateDetailsDTO);

    void userUpdateStatus(long id);
}
