package etablissement.service.FeignClient;

import etablissement.service.model.Proffesseur;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "proffesseur")
public interface ProffesseurClient {

    @GetMapping("/api/proffesseur/all")
    List<Proffesseur> getAllProfesseurs();

    @GetMapping("/api/proffesseur/getByIds")
    List<Proffesseur> getProffesseursByIds(@RequestParam("ids") String ids);

}
