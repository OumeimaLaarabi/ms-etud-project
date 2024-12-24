package etablissement.service.service;

import etablissement.service.entity.Etablissement;

import java.util.List;

public interface IserviceEtablssement {
    Etablissement addEtablissment(Etablissement etablissement);

    List<Etablissement> getAllEtablissements();
}
