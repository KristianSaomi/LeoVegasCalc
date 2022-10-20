package LeoVegas.LeoVegasV2.service;


import LeoVegas.LeoVegasV2.entity.Role;
import LeoVegas.LeoVegasV2.entity.User;
import LeoVegas.LeoVegasV2.repo.AccountRepo;
import LeoVegas.LeoVegasV2.repo.RoleRepo;
import LeoVegas.LeoVegasV2.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public User getUserById(Integer id) {
        return null;
    }
    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }
    public void createAccount(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        saveTheUser(user);
    }

    public void saveTheUser(User user) {
        if (!(user.getPermission())) {
            Role roleUser = roleRepo.findBName("USER");
            user.addRole(roleUser);
            userRepo.save(user);
        } else {
            Role roleAdmin = roleRepo.findBName("EMPLOYEE");
            user.addRole(roleAdmin);
            userRepo.save(user);
        }
    }
}
