package etablissement.service.controller;

import etablissement.service.entity.Etablissement;
import etablissement.service.service.IserviceEtablssement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class EtablissmentRestController {

    private IserviceEtablssement iserviceEtablssement;

    @PostMapping("add")
    public Etablissement add(@RequestBody Etablissement etablissement){
        return iserviceEtablssement.addEtablissment(etablissement);
    }
    @GetMapping("all")
    public List<Etablissement> allEtablissement(){
        return iserviceEtablssement.getAllEtablissements();
    }

}
