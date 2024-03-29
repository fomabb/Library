package by.overone.library.controller;

import by.overone.library.dto.*;
import by.overone.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDataDTO> readAll(@RequestParam(required = false) String name, @RequestParam(required = false)
            String surname) {
        return userService.getAllUsers();
    }

    @GetMapping("/status")
    public List<UserDataDTO> readByStatus(@RequestParam String status) {
        return userService.getUserByStatus(status);
    }

    @GetMapping("/{id}")
    public UserDataDTO readUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/login")
    public UserDataDTO readUserByLogin(@RequestParam String login) {
        return userService.getUserByLogin(login);
    }

    @GetMapping("/email")
    public UserDataDTO readUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/fullname")
    public UserDataDTO readUserByFullName(@RequestParam String name, String surname) {
        return userService.getUserByFullName(name, surname);
    }

    @PostMapping("/add")
    public void registrationUser(@Validated @RequestBody UserRegistrationDTO userRegistrationDTO) {
        userService.addUser(userRegistrationDTO);
    }

    @PutMapping("/delete/{user_id}")
    public void deleteUser(@Validated @PathVariable long user_id) {
        userService.deleteUser(user_id);
    }

    @PutMapping("/addDetails")
    public void addUserDetails(@Validated @RequestBody UserDetailsDTO userDetailsDTO) {
        userService.addUserDetails(userDetailsDTO);
    }

    @GetMapping("/getdetails/{id}")
    public UserDetailsDTO readUserDetailsById(@PathVariable long id) {
        return userService.getUserDetailsById(id);
    }

    @PutMapping("/{id}")
    public void userUpdate(@Validated @PathVariable long id, @RequestBody UserUpdateDTO user) {
        userService.userUpdate(id, user);
    }

    @GetMapping("{id}/info")
    public UserAllInfoDTO readUserAllInfo(@PathVariable long id) {
        return userService.getUserAllInfo(id);
    }

    @PutMapping("/details/{id}")
    public void userUpdateDetails(@Validated @PathVariable long id, @RequestBody UserUpdateDetailsDTO user) {
        userService.userUpdateDetails(id, user);
    }

    @PutMapping("/updatestatus/{id}")
    public void userUpdateStatus(@Validated @PathVariable long id) {
        userService.userUpdateStatus(id);
    }

    @GetMapping("/test")
    public List<?> getUser(@RequestParam(required = false) String login,
                           @RequestParam(required = false) String email,
                           @RequestParam(required = false) String status) {
        if (login.equals("") && email.equals("") && status.equals("")) {
            return userService.getAllUsers();
        } else {
            return userService.getUser(login, email, status);
        }
    }
}
