package by.overone.library.dao;

import by.overone.library.dto.UserAllInfoDTO;
import by.overone.library.dto.UserDetailsDTO;
import by.overone.library.dto.UserUpdateDTO;
import by.overone.library.model.User;
import by.overone.library.model.UserDetails;

import java.util.List;

public interface UserDAO {

    List<User> getAllUser();

        void addUser(User user);

//    User getUserById(long id);
//
//    User getUserByLogin(String login);
//
//    User getUserByEmail(String email);
//
//    List<User> getUserByStatus(String status);
//
//    User getUserByFullName(String name, String surname);
//
//    UserAllInfoDTO getUserAllInfo(long id);
//
//    void deleteUser(long user_id);
//
//    void addUserDetails(UserDetailsDTO userDetailsDTO);
//
//    UserDetails getUserDetailsById(long id);
//
//    void userUpdate(long id, UserUpdateDTO userUpdateDTO);
}
