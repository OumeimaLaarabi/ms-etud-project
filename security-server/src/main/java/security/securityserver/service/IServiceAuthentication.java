package security.securityserver.service;

import security.securityserver.entity.AppRole;
import security.securityserver.entity.AppUser;

public interface IServiceAuthentication {
    public AppUser createAppUser(AppUser appUser);
    public AppRole createAppRole(AppRole appRole);
    public void addRoleToUser(String username, String role); // Corrected to consistent naming
    public AppUser LoadUserByUserName(String username);
}
