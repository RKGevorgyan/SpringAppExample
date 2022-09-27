package ru.stc.springbootdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.stc.springbootdemo.dao.RoleRepository;
import ru.stc.springbootdemo.model.User;
import ru.stc.springbootdemo.service.UserService;
import ru.stc.springbootdemo.service.exceptions.NotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@PostMapping(value = "/create")
	public User updateUser(@RequestBody User user) {
		return userService.create(user);
	}

	@GetMapping("/{id}")
	public User findUserById(@PathVariable Long id) {
		return userService.findById(id);
	}

}
