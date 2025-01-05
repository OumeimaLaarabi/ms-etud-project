package security.securityserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.securityserver.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    AppUser findByUsername(String username);

}
