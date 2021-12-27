package by.overone.library.dao;

import by.overone.library.model.Status;
import by.overone.library.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUser();

    List<User> getUserByStatus(Status status);

//    List<User> getUserByStatus(Status status);
}
