package etablissement.service.controller;

import etablissement.service.FeignClient.ProffesseurClient;
import etablissement.service.FeignClient.StudentClient;
import etablissement.service.entity.Etablissement;
import etablissement.service.entity.EtablissementProffesseur;
import etablissement.service.model.Proffesseur;
import etablissement.service.model.Student;
import etablissement.service.repository.EtablissementProffesseurRepository;
import etablissement.service.service.IserviceEtablissement;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/etablissements")
@AllArgsConstructor
public class EtablissmentRestController {

    private final IserviceEtablissement iserviceEtablissement;
    private final ProffesseurClient proffesseurClient;
    private final EtablissementProffesseurRepository etablissementProffesseurRepository;
    private final StudentClient studentClient;

    @PostMapping("add")
    public ResponseEntity<Object> add(@RequestBody Etablissement etablissement) {
        // Validate Student existence
        Optional<Student> student = studentClient.getStudentById(etablissement.getStudentId());
        if (student.isEmpty()) {
            return new ResponseEntity<>("Student not found", HttpStatus.BAD_REQUEST);
        }

        // Save Etablissement
        Etablissement savedEtablissement = iserviceEtablissement.addEtablissment(etablissement);

        // Handle associated professors
        if (etablissement.getProffesseurs()!= null && !etablissement.getProffesseurs().isEmpty()) {
            List<Integer> professorIds = etablissement.getProffesseurs().stream()
                    .map(Proffesseur::getId)
                    .collect(Collectors.toList());

            String proffesseurIdsString = professorIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println(proffesseurIdsString);
            List<Proffesseur> professeurs = proffesseurClient.getProffesseursByIds(proffesseurIdsString);
            if (professeurs.isEmpty()) {
                return new ResponseEntity<>("Professors not found", HttpStatus.BAD_REQUEST);
            }

            List<EtablissementProffesseur> etablissementProfesseurs = new ArrayList<>();
            for (Proffesseur prof : professeurs) {
                EtablissementProffesseur etablissementProffesseur = new EtablissementProffesseur();
                etablissementProffesseur.setEtablissementId(savedEtablissement.getId());
                etablissementProffesseur.setProffesseurId(prof.getId());
                etablissementProfesseurs.add(etablissementProffesseur);
            }

            etablissementProffesseurRepository.saveAll(etablissementProfesseurs);
        }

        return new ResponseEntity<>(savedEtablissement, HttpStatus.CREATED);
    }

    @GetMapping("all")
    public List<Etablissement> allEtablissement() {
        List<Etablissement> etablissements = iserviceEtablissement.getAllEtablissements();

        for (Etablissement etablissement : etablissements) {
            studentClient.getStudentById(etablissement.getStudentId())
                    .ifPresent(etablissement::setStudent);

            List<EtablissementProffesseur> etablissementProfesseurs = etablissementProffesseurRepository.findByEtablissementId(etablissement.getId());
            List<Integer> professorIds = etablissementProfesseurs.stream()
                    .map(EtablissementProffesseur::getProffesseurId)
                    .collect(Collectors.toList());

            String professorIdsString = professorIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(","));

            List<Proffesseur> professeurs = proffesseurClient.getProffesseursByIds(professorIdsString);
            etablissement.setProffesseurs(professeurs); // Assuming Etablissement has a List<Proffesseur> field
        }

        return etablissements;
    }

    @GetMapping("{id}")
    public ResponseEntity<Etablissement> getById(@PathVariable int id) {
        Etablissement etablissement = iserviceEtablissement.getEtablissmentById(id);
        if (etablissement == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        studentClient.getStudentById(etablissement.getStudentId())
                .ifPresent(etablissement::setStudent);

        // Fetch associated professors
        List<EtablissementProffesseur> etablissementProfesseurs = etablissementProffesseurRepository.findByEtablissementId(etablissement.getId());
        List<Integer> proffesseursIds = etablissementProfesseurs.stream()
                .map(EtablissementProffesseur::getProffesseurId)
                .collect(Collectors.toList());

// Convert list of IDs to a comma-separated string
        String proffesseursIdsString = proffesseursIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));

// Now call the Feign client with the comma-separated string
        List<Proffesseur> professeurs = proffesseurClient.getProffesseursByIds(proffesseursIdsString);
        etablissement.setProffesseurs(professeurs);
        return new ResponseEntity<>(etablissement, HttpStatus.OK);
    }
}