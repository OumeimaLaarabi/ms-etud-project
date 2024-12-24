package groupe.service.repository;


import groupe.service.entity.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupeRepository extends JpaRepository<Groupe , Integer> {
}
