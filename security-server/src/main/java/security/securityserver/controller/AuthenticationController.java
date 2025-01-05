package security.securityserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import security.securityserver.entity.AppRole;
import security.securityserver.entity.AppUser;
import security.securityserver.service.IServiceAuthentication;
import security.securityserver.service.ServiceAuthentication;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private IServiceAuthentication iServiceAuthentication;
    @Autowired
    private ServiceAuthentication serviceAuthentication;

    @PostMapping("/addUser")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser appUser) {
        AppUser newUser = serviceAuthentication.createAppUser(appUser);
        return ResponseEntity.ok(newUser);
    }
    @PostMapping("/addRole")
    public ResponseEntity<AppRole> addRole(@RequestBody AppRole appRole) {
        AppRole newRole = serviceAuthentication.createAppRole(appRole);
        return ResponseEntity.ok(newRole);
    }

    @PostMapping("/addRoleUser")
    ResponseEntity<String> addRoleToUser(@RequestParam String username, @RequestParam String role){
        serviceAuthentication.addRoleToUser(username,role);

        return new ResponseEntity<String>("Role added to the user", HttpStatus.OK);
    }


}
