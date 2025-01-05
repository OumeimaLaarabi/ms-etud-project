package etablissement.service.repository;

import etablissement.service.entity.EtablissementProffesseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EtablissementProffesseurRepository extends JpaRepository<EtablissementProffesseur ,Integer> {
    List<EtablissementProffesseur> findByEtablissementId(int etablissmentId);
}
