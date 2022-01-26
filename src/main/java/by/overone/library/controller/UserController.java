package by.overone.library.controller;

import by.overone.library.dto.UserDataDTO;
import by.overone.library.dto.UserRegistrationDTO;
import by.overone.library.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDataDTO> readAll() {
        return userService.getAllUsers();
    }

    @PostMapping("/add")
    public void registrationUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        userService.addUser(userRegistrationDTO);
    }

//    @GetMapping("/status")
//    public List<UserDataDTO> readByStatus(@RequestParam String status) {
//        return userService.getUserByStatus(status);
//    }
//
//    @GetMapping("/{id}")
//    public UserDataDTO readUserById(@PathVariable long id) {
//        return userService.getUserById(id);
//    }
//
//    @GetMapping("/login/{login}")
//    public UserDataDTO readUserByLogin(@PathVariable String login) {
//        return userService.getUserByLogin(login);
//    }
//
//    @GetMapping("/email")
//    public UserDataDTO readUserByEmail(@RequestParam String email) {
//        return userService.getUserByEmail(email);
//    }
//
//    @GetMapping("/fullname")
//    public UserDataDTO readUserByFullName(@RequestParam String name, String surname) {
//        return userService.getUserByFullName(name, surname);
//    }
//
//    @GetMapping("/hello")
//    public String read() {
//        System.out.println("Hello");
//        return "Hello";
//    }
//
//
//
//    @PostMapping("/delete")
//    public void deleteUser(@RequestParam long user_id) {
//        userService.deleteUser(user_id);
//    }
//
//    @PostMapping("/addDetails")
//    public void addUserDetails(@RequestBody UserDetailsDTO userDetailsDTO) {
//        userService.addUserDetails(userDetailsDTO);
//    }
//
//    @GetMapping("/getdetails")
//    public UserDetailsDTO readUserDetailsById(@RequestParam long id) {
//        return userService.getUserDetailsById(id);
//    }
//
//    @PutMapping("/{id}")
//    public void userUpdate(@PathVariable long id, @RequestBody UserUpdateDTO user) {
//        userService.userUpdate(id, user);
//    }
//
//    @GetMapping("/info/{id}")
//    public UserAllInfoDTO readUserAllInfo(@PathVariable long id) {
//        return userService.getUserAllInfo(id);
//    }
}
