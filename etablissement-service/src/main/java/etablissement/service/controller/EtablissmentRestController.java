package etablissement.service.controller;

import etablissement.service.entity.Etablissement;
import etablissement.service.service.IserviceEtablissement;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etablissements")
@AllArgsConstructor
public class EtablissmentRestController {

    private IserviceEtablissement iserviceEtablissement;

    @PostMapping("add")
    public Etablissement add(@RequestBody Etablissement etablissement){
        return iserviceEtablissement.addEtablissment(etablissement);
    }
    @GetMapping("all")
    public List<Etablissement> allEtablissement(){
        return iserviceEtablissement.getAllEtablissements();
    }

}
