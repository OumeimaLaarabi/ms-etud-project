package proffesseur.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import proffesseur.service.entity.Proffesseur;

public interface ProffesseurRepository  extends JpaRepository<Proffesseur, Integer> {
}
