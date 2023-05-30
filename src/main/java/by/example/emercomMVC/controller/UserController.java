package by.example.emercomMVC.controller;


import by.example.emercomMVC.model.User;
import by.example.emercomMVC.repository.UserRepository;
import by.example.emercomMVC.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

  /*  @GetMapping("/crud")
    public String crud(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "crud";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/crud/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Optional<User> userById = userService.getUserById(id);
        if (userById.isPresent()) {
            User user = userById.get();
            model.addAttribute("user", user);
            return "crud";
        } else {
            return "eror";
        }
    }

    *//*@PutMapping("crud/update")
    public String updateUser(@Valid @ModelAttribute("user")
                             User user,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "crud";
        }
        return "redirect:/test?success";
    }*//*


    @DeleteMapping("crud/user/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/test";
    }*/


    @GetMapping("/signup")
    public String showSignUpForm(User user) {
        return "add-user";
    }

   /* @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-user";
        }

        userRepository.save(user);
        return "redirect:/crud";
    }*/

    @GetMapping("/crud")
    public String showUserList(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "crud";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update-user";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return "update-user";
        }

        userRepository.save(user);
        return "redirect:/crud";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        return "redirect:/crud";
    }
}


