package by.overone.library.dao;

import by.overone.library.dto.UserDetailsDTO;
import by.overone.library.dto.UserFullInfoDTO;
import by.overone.library.dto.UserUpdateDTO;
import by.overone.library.dto.UserUpdateDetailsDTO;
import by.overone.library.model.User;
import by.overone.library.model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    List<User> getAllUser();

    Optional<User> getUserById(long id);

    Optional<User> getUserByLogin(String login);

    Optional<User> getUserByEmail(String email);

    List<User> getUserByStatus(String status);

    Optional<User> getUserByFullName(String name, String surname);

    UserFullInfoDTO getUserFullInfo(long id);

    void addUser(User user);

    void deleteUser(long user_id);

    void addUserDetails(UserDetailsDTO userDetailsDTO);

    Optional<UserDetailsDTO> getUserDetailsById(long id);

    void userUpdate(long id, UserUpdateDTO userUpdateDTO);

    void userUpdateDetails(long id, UserUpdateDetailsDTO userUpdateDetailsDTO);

    void userUpdateStatus(long id);

    List<User> getUser(String login, String email, String status);
}
