package LeoVegas.LeoVegasV2.controller;

import LeoVegas.LeoVegasV2.entity.Account;
import LeoVegas.LeoVegasV2.entity.User;
import LeoVegas.LeoVegasV2.repo.AccountRepo;
import LeoVegas.LeoVegasV2.repo.UserRepo;
import LeoVegas.LeoVegasV2.service.CustomUserDetails;
import LeoVegas.LeoVegasV2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    @Autowired
    public UserRepo userRepo;

    @Autowired
    public AccountRepo accountRepo;

    @Autowired
    public UserServiceImpl userService;


    @GetMapping("registerUser")
    public String showUserRegistrationForm(Model model) {

        model.addAttribute("user", new User());
        return "registerUser";
    }

    @PostMapping("register_success")
    public String process_register(User user) {
        userService.createAccount(user);
        firstAutoInsertion(user);
        return "register_success";
    }

    @RequestMapping("users")
    public String getUsers(Model model) {
        model.addAttribute("getUsers", userService.getUsers());
        return "users";
    }

    @GetMapping("/personalData")
    public String updateAccount(Model model,
                                @AuthenticationPrincipal CustomUserDetails loggedIn) {
        var user = userValidation(loggedIn);
            model.addAttribute("user", user);
        return "personalData";
    }

    @GetMapping("/accountDetails/update/{id}")
    public String updateAccountDetails(@PathVariable("id") Integer id,
                                       Model model,
                                       @AuthenticationPrincipal CustomUserDetails loggedIn) {
        var list = userValidation(loggedIn);;
            User userinfo = userRepo.findById(id).get();
            model.addAttribute("userInfo", userinfo);
            model.addAttribute("listUsers", list);
            return "accountDetails";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("customer")User user) {

        userService.saveTheUser(user);
        return "redirect:/home";
    }

    @GetMapping("/personalData/delete/{id}")
    public String deleteAccount(@PathVariable("id") Integer id,
                                Model model) {

        userRepo.deleteById(id);
        return "redirect:/logout";
    }
    public Account firstAutoInsertion(User user) {

        Account account = new Account();
        account.setCredit(100L);
        account.setDebit(0L);
        account.setPublishDate(date + " - First auto bonus");
        var id = user.getId();
        account.setUser(userService.getUserById(id));
        account.setUser(user);
        accountRepo.save(account);
        return account;
    }

    public List<User> userValidation(@AuthenticationPrincipal CustomUserDetails loggedIn) {
        String email = loggedIn.getUsername();
        User user = userRepo.findByEmail(email);
        if(user != null) {
            ArrayList<User> list = new ArrayList<>();
            list.add(user);
            return list;
        }
        return null;
    }
}





