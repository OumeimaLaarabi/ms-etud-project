package etablissement.service.service;

import etablissement.service.FeignClient.ProffesseurClient;
import etablissement.service.entity.Etablissement;
import etablissement.service.model.Proffesseur;
import etablissement.service.repository.EtablissementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtablissementService implements IserviceEtablissement {

    private  EtablissementRepository etablissementRepository; // Injection de l'instance

    @Override
    public Etablissement getEtablissmentById(int id){
        // Utilisation de l'instance pour appeler la méthode findById
        return etablissementRepository.findById(id).get();
    }
    @Override
    public Etablissement addEtablissment(Etablissement etablissement) {
        return etablissementRepository.save(etablissement);
    }

    @Override
    public List<Etablissement> getAllEtablissements() {
        return etablissementRepository.findAll(); // Appel sur l'instance injectée
    }



}
