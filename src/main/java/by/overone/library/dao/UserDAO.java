package by.overone.library.dao;

import by.overone.library.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUser();

    List<User> getUserByStatus(String status);

    User getUserById(long id);

    User getUserByLogin(String login);

    User getUserByFullName(String name, String surname);
}
