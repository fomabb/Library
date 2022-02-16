package by.overone.library.service.impl;

import by.overone.library.dao.UserDAO;
import by.overone.library.dto.*;
import by.overone.library.model.Role;
import by.overone.library.model.Status;
import by.overone.library.model.User;
import by.overone.library.model.UserDetails;
import by.overone.library.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Override
    public List<UserDataDTO> getAllUsers() {
        return userDAO.getAllUser().stream()
                .map(user -> new UserDataDTO(user.getUser_id(), user.getUser_login(), user.getUser_email(),
                        user.getUser_role(), user.getUser_status()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDataDTO getUserById(long id) {
        UserDataDTO userDataDTO = new UserDataDTO();
        User user = userDAO.getUserById(id);
        userDataDTO.setUser_id(user.getUser_id());
        userDataDTO.setUser_login(user.getUser_login());
        userDataDTO.setUser_email(user.getUser_email());
        userDataDTO.setUser_role(user.getUser_role());
        userDataDTO.setUser_status(user.getUser_status());
        return userDataDTO;
    }

    @Override
    public UserDataDTO getUserByLogin(String login) {
        UserDataDTO userDataDTO = new UserDataDTO();
        User user = userDAO.getUserByLogin(login);
        userDataDTO.setUser_id(user.getUser_id());
        userDataDTO.setUser_login(user.getUser_login());
        userDataDTO.setUser_email(user.getUser_email());
        userDataDTO.setUser_role(user.getUser_role());
        userDataDTO.setUser_status(user.getUser_status());
        return userDataDTO;
    }

    @Override
    public UserDataDTO getUserByEmail(String email) {
        UserDataDTO userDataDTO = new UserDataDTO();
        User user = userDAO.getUserByEmail(email);
        userDataDTO.setUser_id(user.getUser_id());
        userDataDTO.setUser_login(user.getUser_login());
        userDataDTO.setUser_email(user.getUser_email());
        userDataDTO.setUser_role(user.getUser_role());
        userDataDTO.setUser_status(user.getUser_status());
        return userDataDTO;
    }

    @Override
    public List<UserDataDTO> getUserByStatus(String status) {
        return userDAO.getUserByStatus(status).stream()
                .map(user -> new UserDataDTO(user.getUser_id(), user.getUser_login(), user.getUser_email(),
                        user.getUser_role(), user.getUser_status()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDataDTO getUserByFullName(String name, String surname) {
        UserDataDTO userDataDTO = new UserDataDTO();
        User user = userDAO.getUserByFullName(name, surname);
        userDataDTO.setUser_id(user.getUser_id());
        userDataDTO.setUser_login(user.getUser_login());
        userDataDTO.setUser_email(user.getUser_email());
        userDataDTO.setUser_role(user.getUser_role());
        userDataDTO.setUser_status(user.getUser_status());
        return userDataDTO;
    }

    @Override
    public UserAllInfoDTO getUserAllInfo(long id) {
        UserAllInfoDTO userAllInfoDTO = new UserAllInfoDTO();
        UserFullInfoDTO userFullInfoDTO = userDAO.getUserFullInfo(id);
        userAllInfoDTO.setUser_id(userFullInfoDTO.getUser_id());
        userAllInfoDTO.setUser_login(userFullInfoDTO.getUser_login());
        userAllInfoDTO.setUser_email(userFullInfoDTO.getUser_email());
        userAllInfoDTO.setUser_role(userFullInfoDTO.getUser_role());
        userAllInfoDTO.setUser_status(userFullInfoDTO.getUser_status());
        userAllInfoDTO.setUser_details_name(userFullInfoDTO.getUser_details_name());
        userAllInfoDTO.setUser_details_surname(userFullInfoDTO.getUser_details_surname());
        userAllInfoDTO.setUser_details_address(userFullInfoDTO.getUser_details_address());
        userAllInfoDTO.setUser_details_phonenumber(userFullInfoDTO.getUser_details_phonenumber());
        return userAllInfoDTO;
    }

    @Transactional
    @Override
    public void addUser(UserRegistrationDTO userRegistrationDTO) {
        User user = new User();
        user.setUser_login(userRegistrationDTO.getUser_login());
        user.setUser_password(DigestUtils.md5Hex(userRegistrationDTO.getUser_password()));
        user.setUser_email(userRegistrationDTO.getUser_email());
        user.setUser_role(Role.valueOf(Role.READER.toString().toUpperCase(Locale.ROOT)));
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
        getUserById(id);
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        UserDetails userDetails = userDAO.getUserDetailsById(id);
        userDetailsDTO.setUsers_user_id(userDetails.getUsers_user_id());
        userDetailsDTO.setUser_details_name(userDetails.getUser_details_name());
        userDetailsDTO.setUser_details_surname(userDetails.getUser_details_surname());
        userDetailsDTO.setUser_details_address(userDetails.getUser_details_address());
        userDetailsDTO.setUser_details_phonenumber(userDetails.getUser_details_phonenumber());
        userDetailsDTO.setUsers_user_id(userDetails.getUsers_user_id());
        return userDetailsDTO;
    }

    @Override
    public void userUpdate(long id, UserUpdateDTO userUpdateDTO) {
        getUserById(id);
        userUpdateDTO.setPassword(DigestUtils.md5Hex(userUpdateDTO.getPassword()));
        userDAO.userUpdate(id, userUpdateDTO);
    }

    @Override
    public void userUpdateDetails(long id, UserUpdateDetailsDTO userUpdateDetailsDTO) {
        getUserById(id);
        userDAO.userUpdateDetails(id, userUpdateDetailsDTO);
    }

    @Override
    public void userUpdateStatus(long id) {
        getUserById(id);
        userDAO.userUpdateStatus(id);
    }
}

