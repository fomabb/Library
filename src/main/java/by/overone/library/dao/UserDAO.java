package by.overone.library.dao;

import by.overone.library.dto.UserDetailsDTO;
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

    User getUserAllInfo(long id);

    void addUser(User user);

    void deleteUser(long user_id);

    void addUserDetails(UserDetailsDTO userDetailsDTO);

    UserDetails getUserDetailsById(long id);
}
