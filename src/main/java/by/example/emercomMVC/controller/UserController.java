package by.example.emercomMVC.controller;


import by.example.emercomMVC.model.User;
import by.example.emercomMVC.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/crud")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "crud";
    }

    @PostMapping("/filtered-users")
    public String filterUserList(@RequestParam("filter") String filter, Model model) {
        model.addAttribute("users", userService.findByFilter(filter));
        return "crud";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result) {
        if (result.hasErrors()) {
            user.setId(id);
            return "update-user";
        }
        if (!userService.isPasswordCorrect(id, user.getPassword())) {
            result.rejectValue("password", "error.user", "Incorrect password");
            user.setId(id);
            return "update-user";
        }
        userService.updateUser(user);
        return "redirect:/crud";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/crud";
    }
}


