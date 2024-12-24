package etablissement.service.service;

import etablissement.service.entity.Etablissement;
import etablissement.service.repository.EtablissementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EtablissementService implements IserviceEtablssement {

    private final EtablissementRepository etablissementRepository; // Injection de l'instance

    @Override
    public Etablissement addEtablissment(Etablissement etablissement) {
        return etablissementRepository.save(etablissement); // Appel sur l'instance injectée
    }

    @Override
    public List<Etablissement> getAllEtablissements() {
        return etablissementRepository.findAll(); // Appel sur l'instance injectée
    }
}
