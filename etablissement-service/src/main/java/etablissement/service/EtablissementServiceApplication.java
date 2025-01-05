package etablissement.service;

import etablissement.service.entity.Etablissement;
import etablissement.service.repository.EtablissementRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients

@SpringBootApplication
public class EtablissementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EtablissementServiceApplication.class, args);
    }

}
