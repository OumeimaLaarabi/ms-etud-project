package etablissement.service.repository;

import etablissement.service.entity.Etablissement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtablissementRepository extends JpaRepository<Etablissement , Integer> {

}
