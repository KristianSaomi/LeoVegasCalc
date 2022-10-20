package LeoVegas.LeoVegasV2.service;

public interface AccountService {

    Long sumOfDebit(Integer id);
    Long sumOfCredit(Integer id);

    Long totalBalance(Integer id);
}
