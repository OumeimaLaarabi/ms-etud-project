package etablissement.service.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class EtablissementProffesseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     private int etablissementId;
     private int proffesseurId;
}
