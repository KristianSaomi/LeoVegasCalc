package LeoVegas.LeoVegasV2.service;

import LeoVegas.LeoVegasV2.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer id);

    List<User> getUsers();
}
