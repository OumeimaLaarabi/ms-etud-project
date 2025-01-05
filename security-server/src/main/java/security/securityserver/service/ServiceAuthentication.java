package security.securityserver.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import security.securityserver.Repository.AppRoleRepository;
import security.securityserver.Repository.AppUserRepository;
import security.securityserver.entity.AppRole;
import security.securityserver.entity.AppUser;

@Service
@RequiredArgsConstructor
public class ServiceAuthentication implements IServiceAuthentication {
    private final AppUserRepository appUserRepository;
    private final AppRoleRepository appRoleRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public AppUser createAppUser(AppUser appUser) {
        AppUser appUser1 = appUserRepository.findByUsername(appUser.getUsername());
        if (appUser1 == null) {
            appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
            return appUserRepository.save(appUser);
        } else {
            return null;
        }
    }

    @Override
    public AppRole createAppRole(AppRole appRole) {
        AppRole appRole1 = appRoleRepository.findByRole(appRole.getRole());
        if (appRole1 == null) {
            return appRoleRepository.save(appRole);
        } else {
            return null;
        }
    }

    @Override
    public void addRoleToUser(String username, String role) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new RuntimeException("User not found");
        }
        AppRole appRole = appRoleRepository.findByRole(role);
        if (appRole == null) {
            throw new RuntimeException("Role not found");
        }
        appUser.getRoles().add(appRole);
        appUserRepository.save(appUser);
    }

    @Override
    public AppUser LoadUserByUserName(String username) {
        return appUserRepository.findByUsername(username);
    }
}
