package proffesseur.service.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;
import proffesseur.service.entity.Proffesseur;
import proffesseur.service.service.IServiceProffesseur;

import java.util.List;

@RestController
@RequestMapping("/api/proffesseur/")
@AllArgsConstructor
public class ProffesseurController {
    private IServiceProffesseur iServiceProffesseur;

    @PostMapping("add")
    public Proffesseur add(@RequestBody Proffesseur proffesseur) {
        return iServiceProffesseur.addProffesseur(proffesseur);
    }


@GetMapping("all")
    public List<Proffesseur> allProffesseurs() {
        return iServiceProffesseur.getAllProffesseurs();
}
}

