package by.overone.library.service.impl;

import by.overone.library.dao.UserDAO;
import by.overone.library.dto.UserDataDTO;
import by.overone.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<UserDataDTO> getAllUsers() {
        List<UserDataDTO> users = userDAO.getAllUser().stream()
                .map(user -> new UserDataDTO(user.getUser_id(), user.getUser_login(), user.getUser_email(),
                        user.getUser_role(), user.getUser_status()))
                .collect(Collectors.toList());
        return users;
    }
}

