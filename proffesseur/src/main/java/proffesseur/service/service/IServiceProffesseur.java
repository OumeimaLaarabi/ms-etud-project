package proffesseur.service.service;

import proffesseur.service.entity.Proffesseur;

import java.util.List;
import java.util.Optional;

public interface IServiceProffesseur  {
    Proffesseur addProffesseur(Proffesseur proffesseur);

    List<Proffesseur> getAllProffesseurs();

    Optional<Proffesseur> getProffesseurById(int id);

 List<Proffesseur> findAllById(List<Integer> ids);
}
