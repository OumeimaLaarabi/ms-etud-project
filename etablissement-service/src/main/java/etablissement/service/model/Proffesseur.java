package etablissement.service.model ;

import etablissement.service.entity.Etablissement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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
