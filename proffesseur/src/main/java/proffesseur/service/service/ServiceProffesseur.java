package proffesseur.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import proffesseur.service.entity.Proffesseur;
import proffesseur.service.repository.ProffesseurRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceProffesseur implements IServiceProffesseur {

    private  ProffesseurRepository proffesseurRepository; // Injection de dépendance

    @Override
    public Proffesseur addProffesseur(Proffesseur proffesseur) {

        return proffesseurRepository.save(proffesseur); // Utilisation de l'instance injectée
    }

    @Override
    public List<Proffesseur> getAllProffesseurs() {
        return proffesseurRepository.findAll(); // Utilisation de l'instance injectée

    }

}

