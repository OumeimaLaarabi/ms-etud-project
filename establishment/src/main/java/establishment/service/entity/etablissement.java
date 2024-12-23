package establishment.service.entity;

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
public class etablissement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String nom ;
    String adresse;
    String Type ;

}
