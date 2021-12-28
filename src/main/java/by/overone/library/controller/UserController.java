package by.overone.library.controller;

import by.overone.library.dto.UserDataDTO;
import by.overone.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    @GetMapping
    public List<UserDataDTO> readAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/status")
    public List<UserDataDTO> readByStatus(@RequestParam String  status) {
        return userService.getUserByStatus(status);
    }

    @GetMapping("/id")
    public UserDataDTO getUserById(@RequestParam long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/login")
    public UserDataDTO getUserByLogin(@RequestParam String login) {
        return userService.getUserByLogin(login);
    }

    @GetMapping("/fullname")
    public UserDataDTO getUserByFullName(@RequestParam String name, String surname) {
        return userService.getUserByFullName(name, surname);
    }

    @GetMapping("/hello")
    public String read() {
        System.out.println("Hello");
        return "Hello";
    }
}
