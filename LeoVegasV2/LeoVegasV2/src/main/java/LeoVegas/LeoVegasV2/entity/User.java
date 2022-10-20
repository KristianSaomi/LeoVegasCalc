package LeoVegas.LeoVegasV2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
@Table(name = "User", schema = "User data")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email", unique = true, nullable = false, length = 70)
    private String email;
    @Column(name = "password", nullable = false, length = 70)
    private String password;
    @Column(name = "first_name", nullable = false,  length = 20)
    private String firstName;
    @Column(name = "last_name", nullable = false,  length = 20)
    private String lastName;
    @Column(name = "permission")
    private Boolean permission = false; //If false = "User", If true = "Employee" (Checkbox in signUp)

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    public Set<Role> roles = new HashSet<>();

    //Java.util.Set<Role> <--- Fanns här
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    //add a new method for adding a role to this user
    public void addRole(Role role) {
        this.roles.add(role);
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_account",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    public Set<Account> account = new HashSet<>();

    public Set<Account> getAccount() {
        return account;
    }

    public void setAccount(Set<Account> account) {
        this.account = account;
    }

    //add a new method for adding a role to this user
    private void addAccount(Account account) {
        this.account.add(account);
    }
}
