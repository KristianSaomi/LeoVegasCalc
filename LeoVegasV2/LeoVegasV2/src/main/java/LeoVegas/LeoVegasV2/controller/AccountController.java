package LeoVegas.LeoVegasV2.controller;

import LeoVegas.LeoVegasV2.entity.Account;
import LeoVegas.LeoVegasV2.entity.User;
import LeoVegas.LeoVegasV2.repo.AccountRepo;
import LeoVegas.LeoVegasV2.repo.UserRepo;
import LeoVegas.LeoVegasV2.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AccountController {

    @Autowired
    private AccountRepo accounRepo;


    @Autowired
    private UserRepo userRepo;

    @GetMapping("/account/new")
    public String addBalanceForm(Model model, @AuthenticationPrincipal CustomUserDetails loggedUser) {
        var list = userValidation(loggedUser);
        model.addAttribute("Account", new Account());
        model.addAttribute("listUsers", list);
        return "addNewAccount";
    }

    @GetMapping("/account/new/debit")
    public String addCreditForm(Model model,
                                @AuthenticationPrincipal CustomUserDetails loggedUser) {

        var list = userValidation(loggedUser);
        model.addAttribute("Account", new Account());
        model.addAttribute("listUsers", list);
        return "addNewDebitAccount";
    }

    @PostMapping("/account/save")
    public String saveAccount(Account account,
                              @AuthenticationPrincipal CustomUserDetails loggedUser) {

        accounRepo.save(account);
        return "redirect:/home";
    }

    @PostMapping("/account/save/withDrawal")
    public String saveAccountWithdrawal(Account account,
                                        @AuthenticationPrincipal CustomUserDetails loggedUser) {
        accounRepo.save(account);
        var id = loggedUser.getIdFromUser();
        var debit = accounRepo.sumOfDebit(id);
        var credit = accounRepo.sumOfCredit(id);
        //var balance = showCurrentBalance(id);
        int latest = accounRepo.selectLatestInsert(id);
        System.out.println(latest);
        if (debit > credit) {
            account.setDebit(0L);
            account.setPublishDate("Tried to draw more money then you have!");
            accounRepo.save(account);
            System.out.println("Not possible!");
        }
        accounRepo.save(account);
        return "redirect:/home";
    }

    @GetMapping("/Accounts")
    public String seeMyAccount(Model model,
                               @AuthenticationPrincipal CustomUserDetails loggedUser) {

        var user = userValidation(loggedUser);
        var id = loggedUser.getIdFromUser();
        List<Account> listAccount = accounRepo.findallByIds(id);
        model.addAttribute("listAccount", listAccount);
        model.addAttribute("user", user);
        return "myAccount";
    }

    @GetMapping("/checkTotal")
    public String seeTotal(Model model,
                           @AuthenticationPrincipal CustomUserDetails loggedUser) {

        var list = userValidation(loggedUser);
           var id = loggedUser.getIdFromUser();
            var sum = showCurrentBalance(id);
            ArrayList<Long> summery = new ArrayList<>();
            summery.add(sum);
            model.addAttribute("summery", summery);
            return "totals";
        }

    public Long showCurrentBalance(Integer id) {
       var  balance = accounRepo.totalBalance(id);
        return balance;
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

