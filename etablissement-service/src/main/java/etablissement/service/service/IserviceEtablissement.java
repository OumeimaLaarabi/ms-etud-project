package etablissement.service.service;

import etablissement.service.entity.Etablissement;

import java.util.List;

public interface IserviceEtablissement {
    Etablissement addEtablissment(Etablissement etablissement);

    List<Etablissement> getAllEtablissements();
}
