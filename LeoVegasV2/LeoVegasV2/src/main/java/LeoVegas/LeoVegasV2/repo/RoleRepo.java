package LeoVegas.LeoVegasV2.repo;

import LeoVegas.LeoVegasV2.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepo extends JpaRepository <Role, Integer> {
    @Query("SELECT r FROM Role r WHERE r.name = ?1")
    Role findBName(String name);
}
