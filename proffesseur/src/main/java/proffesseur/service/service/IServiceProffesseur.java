package proffesseur.service.service;

import proffesseur.service.entity.Proffesseur;

import java.util.List;

public interface IServiceProffesseur  {
    Proffesseur addProffesseur(Proffesseur proffesseur);

    List<Proffesseur> getAllProffesseurs();
}
