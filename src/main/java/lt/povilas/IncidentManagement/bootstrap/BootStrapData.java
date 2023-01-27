package lt.povilas.IncidentManagement.bootstrap;

import lt.povilas.IncidentManagement.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public void run(String... args) throws Exception {
        incidentRepository.findAll().forEach(System.out::println);
        System.out.println("\n==============================\n");
        System.out.println(incidentRepository.findById(1));
        System.out.println(incidentRepository.findById(14));
        System.out.println(incidentRepository.findByTitle("Server down"));
        System.out.println("\n==============================\n");
        System.out.println(incidentRepository.findByTitleLike("%down%"));
    }
}
