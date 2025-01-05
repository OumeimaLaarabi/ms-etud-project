package security.securityserver.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import security.securityserver.entity.AppRole;
import security.securityserver.entity.AppUser;
import security.securityserver.service.IServiceAuthentication;

public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {

    AppRole findByRole(String role);
}
