package etablissement.service.entity;
import etablissement.service.model.Proffesseur;
import etablissement.service.model.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Etablissement {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String nom ;
    String adresse;
    String Type ;
    @Transient
    private Student student;

    private  int studentId;
    @Transient
    private List<Proffesseur> proffesseurs;


}

