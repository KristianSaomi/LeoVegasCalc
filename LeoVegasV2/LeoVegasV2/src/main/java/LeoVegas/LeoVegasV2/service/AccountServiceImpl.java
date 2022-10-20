package LeoVegas.LeoVegasV2.service;

import LeoVegas.LeoVegasV2.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Long sumOfDebit(Integer id) {
        return accountRepo.sumOfDebit(id);
    }


    @Override
    public Long sumOfCredit(Integer id) {
        return accountRepo.sumOfDebit(id);
    }

    @Override
    public Long totalBalance(Integer id) {
        return accountRepo.totalBalance(id);
    }
}
