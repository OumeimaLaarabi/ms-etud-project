package proffesseur.service.controller;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.ls.LSInput;
import proffesseur.service.entity.Proffesseur;
import proffesseur.service.service.IServiceProffesseur;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proffesseur/")
@AllArgsConstructor
public class ProffesseurController {
    private IServiceProffesseur iServiceProffesseur;

    @PostMapping("add")
    public Proffesseur add(@RequestBody Proffesseur proffesseur) {
        return iServiceProffesseur.addProffesseur(proffesseur);
    }


@GetMapping("all")
    public List<Proffesseur> allProffesseurs() {
        return iServiceProffesseur.getAllProffesseurs();
}
    // Récupérer un professeur par son ID
    @GetMapping("{id}")
    public Optional<Proffesseur> getById(@PathVariable int id){
        return iServiceProffesseur.getProffesseurById(id);
    }

    @GetMapping("/getByIds")
    public ResponseEntity<List<Proffesseur>> getProffesseursByIds(@RequestParam("ids") String ids) {
        if (ids == null || ids.isEmpty()) {
            return ResponseEntity.badRequest().body(Collections.emptyList());
        }
        try {
            List<Integer> idList = Arrays.stream(ids.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Proffesseur> professeurs = iServiceProffesseur.findAllById(idList);
            return ResponseEntity.ok(professeurs);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}


