package by.overone.library.controller;

import by.overone.library.dto.UserDataDTO;
import by.overone.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/library")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDataDTO> readAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/hello")
    public String read() {
        return "Hello World";
    }
}
