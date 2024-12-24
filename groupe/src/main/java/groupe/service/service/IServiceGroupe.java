package groupe.service.service;

import groupe.service.entity.Groupe;

import java.util.List;

public interface IServiceGroupe {
    Groupe addGroupe(Groupe groupe);

    List<Groupe> getAllGroupes();
}
