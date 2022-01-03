package by.overone.library.service.impl;

import by.overone.library.dao.UserDAO;
import by.overone.library.dto.UserAllInfoDTO;
import by.overone.library.dto.UserDataDTO;
import by.overone.library.dto.UserDetailsDTO;
import by.overone.library.dto.UserRegistrationDTO;
import by.overone.library.model.Role;
import by.overone.library.model.Status;
import by.overone.library.model.User;
import by.overone.library.model.UserDetails;
import by.overone.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserDAO userDAO;

    @Override
    public List<UserDataDTO> getAllUsers() {
        List<UserDataDTO> users = userDAO.getAllUser().stream()
                .map(user -> new UserDataDTO(user.getUser_id(), user.getUser_login(), user.getUser_email(),
                        user.getUser_role(), user.getUser_status()))
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDataDTO getUserById(long id) {
        UserDataDTO userDataDTO = new UserDataDTO();
        User user = userDAO.getUserById(id);
        userDataDTO.setId(user.getUser_id());
        userDataDTO.setLogin(user.getUser_login());
        userDataDTO.setEmail(user.getUser_email());
        userDataDTO.setRole(user.getUser_role());
        userDataDTO.setStatus(user.getUser_status());
        return userDataDTO;
    }

    @Override
    public UserDataDTO getUserByLogin(String login) {
        UserDataDTO userDataDTO = new UserDataDTO();
        User user = userDAO.getUserByLogin(login);
        userDataDTO.setId(user.getUser_id());
        userDataDTO.setLogin(user.getUser_login());
        userDataDTO.setEmail(user.getUser_email());
        userDataDTO.setRole(user.getUser_role());
        userDataDTO.setStatus(user.getUser_status());
        return userDataDTO;
    }

    @Override
    public UserDataDTO getUserByEmail(String email) {
        UserDataDTO userDataDTO = new UserDataDTO();
        User user = userDAO.getUserByEmail(email);
        userDataDTO.setId(user.getUser_id());
        userDataDTO.setLogin(user.getUser_login());
        userDataDTO.setEmail(user.getUser_email());
        userDataDTO.setRole(user.getUser_role());
        userDataDTO.setStatus(user.getUser_status());
        return userDataDTO;
    }

    @Override
    public List<UserDataDTO> getUserByStatus(String status) {
        List<UserDataDTO> users = userDAO.getUserByStatus(status).stream()
                .map(user -> new UserDataDTO(user.getUser_id(), user.getUser_login(), user.getUser_email(),
                        user.getUser_role(), user.getUser_status()))
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public UserDataDTO getUserByFullName(String name, String surname) {
        UserDataDTO userDataDTO = new UserDataDTO();
        User user = userDAO.getUserByFullName(name, surname);
        userDataDTO.setId(user.getUser_id());
        userDataDTO.setLogin(user.getUser_login());
        userDataDTO.setEmail(user.getUser_email());
        userDataDTO.setRole(user.getUser_role());
        userDataDTO.setStatus(user.getUser_status());
        return userDataDTO;
    }

    @Override
    public UserAllInfoDTO getUserAllInfo(long id) {
        UserAllInfoDTO userAllInfoDTO = new UserAllInfoDTO();
        User user = userDAO.getUserAllInfo(id);
        userAllInfoDTO.setUser_id(user.getUser_id());
        userAllInfoDTO.setUser_login(userAllInfoDTO.getUser_login());
        userAllInfoDTO.setUser_email(userAllInfoDTO.getUser_email());
        userAllInfoDTO.setUser_role(userAllInfoDTO.getUser_role());
        userAllInfoDTO.setUser_status(user.getUser_status());
        userAllInfoDTO.setUser_details_name(userAllInfoDTO.getUser_details_name());
        userAllInfoDTO.setUser_details_name(userAllInfoDTO.getUser_details_name());
        return null;
    }

    @Override
    public void addUser(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();
        user.setUser_login(userRegistrationDTO.getLogin());
        user.setUser_password(userRegistrationDTO.getPassword());
        user.setUser_email(userRegistrationDTO.getEmail());
        user.setUser_role(Role.valueOf(Role.CUSTOMERS.toString().toUpperCase(Locale.ROOT)));
        user.setUser_status(Status.valueOf(Status.ACTIVE.toString().toUpperCase(Locale.ROOT)));
        userDAO.addUser(user);
    }

    @Override
    public void deleteUser(long user_id) {
        getUserById(user_id);
        userDAO.deleteUser(user_id);
    }

    @Override
    public void addUserDetails(UserDetailsDTO userDetailsDTO) {
        userDAO.addUserDetails(userDetailsDTO);
    }

    @Override
    public UserDetailsDTO getUserDetailsById(long id) {
        System.out.println(2);
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        UserDetails userDetails = userDAO.getUserDetailsById(id);
        userDetailsDTO.setUsers_user_id(userDetails.getUsers_user_id());
        userDetailsDTO.setUser_details_name(userDetails.getUser_details_name());
        userDetailsDTO.setUser_details_surname(userDetails.getUser_details_surname());
        userDetailsDTO.setUser_details_address(userDetails.getUser_details_address());
        userDetailsDTO.setUser_details_phonenumber(userDetails.getUser_details_phonenumber());
        userDetailsDTO.setUsers_user_id(userDetails.getUsers_user_id());
        System.out.println(userDetailsDTO.toString());
        return userDetailsDTO;
    }
}

