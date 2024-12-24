package groupe.service.service;

import groupe.service.entity.Groupe;
import groupe.service.repository.GroupeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class GroupeService implements  IServiceGroupe {
    private GroupeRepository groupeRepository;
    @Override
    public Groupe addGroupe(Groupe groupe){
        return groupeRepository.save(groupe);

    }

    @Override
    public List<Groupe> getAllGroupes(){
        return groupeRepository.findAll();

    }

}
