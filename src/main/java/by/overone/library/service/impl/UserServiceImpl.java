package by.overone.library.service.impl;

import by.overone.library.dao.UserDAO;
import by.overone.library.dto.UserDataDTO;
import by.overone.library.model.User;
import by.overone.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List<UserDataDTO> getUserByStatus(String status) {
        List<UserDataDTO> users = userDAO.getUserByStatus(status).stream()
                .map(user -> new UserDataDTO(user.getUser_id(), user.getUser_login(), user.getUser_email(),
                        user.getUser_role(),user.getUser_status()))
                .collect(Collectors.toList());
        return users;
    }
}

