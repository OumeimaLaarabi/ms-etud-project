package proffesseur.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proffesseur.service.entity.Proffesseur;
import proffesseur.service.repository.ProffesseurRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ServiceProffesseur implements IServiceProffesseur {

    private ProffesseurRepository proffesseurRepository; // Injection de dépendance

    @Override
    public Proffesseur addProffesseur(Proffesseur proffesseur) {
        return proffesseurRepository.save(proffesseur); // Sauvegarde d'un professeur
    }

    @Override
    public List<Proffesseur> getAllProffesseurs() {
        return proffesseurRepository.findAll(); // Récupère tous les professeurs
    }

    // Implémentation de la méthode manquante
    @Override
    public Optional<Proffesseur> getProffesseurById(int id) {
        return proffesseurRepository.findById(id); // Récupère un professeur par son ID
    }

    @Override
    public List<Proffesseur> findAllById(List<Integer> ids) {
        return proffesseurRepository.findAllById(ids);
    }

}
