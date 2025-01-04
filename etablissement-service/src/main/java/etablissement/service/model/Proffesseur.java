package etablissement.service.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proffesseur {
        private int id;
        private String nom;
        private String prenom;
        private String email;
        private String specialite;


}
