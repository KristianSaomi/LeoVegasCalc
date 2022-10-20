package LeoVegas.LeoVegasV2.repo;

import LeoVegas.LeoVegasV2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository <Account, Integer> {
    @Query("select a from Account a where a.user.id = :id")
    List<Account> findallByIds (Integer id);

    @Query(value = "SELECT sum(debit) FROM Account where user_id =?1")
    Long sumOfDebit(Integer id);

    @Query(value = "SELECT sum(credit) FROM Account where user_id =?1")
    Long sumOfCredit(Integer id);

    @Query(value = "SELECT sum(credit - debit) FROM Account where user_id =?1")
    Long totalBalance(Integer id);

    @Query(value = "select debit from Account order by id desc limit 1", nativeQuery = true)
    int selectLatestInsert(Integer id);

}
