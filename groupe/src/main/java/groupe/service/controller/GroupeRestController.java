package groupe.service.controller;

import groupe.service.entity.Groupe;
import groupe.service.service.IServiceGroupe;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Groupe/")
@AllArgsConstructor

public class GroupeRestController {
    private IServiceGroupe iServiceGroupe;
@PostMapping("add")
    public Groupe add (@RequestBody Groupe groupe )
{
    return iServiceGroupe.addGroupe(groupe);
}

@GetMapping("all")
    public List<Groupe> allGroupes(){
    return iServiceGroupe.getAllGroupes();
}



}
