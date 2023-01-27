package lt.povilas.IncidentManagement.service;

import lt.povilas.IncidentManagement.repository.IncidentRepository;
import lt.povilas.IncidentManagement.repository.model.Incident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;

    public List<Incident> getAllIncidents() {
        return (List<Incident>) incidentRepository.findAll();
    }

    public Incident getIncidentById(Integer id) {
        return incidentRepository.findById(id).get();
    }

    public Incident getIncidentByTitle(String title) {
        return incidentRepository.findByTitle(title).get();
    }

    public List<Incident> getIncidentByTitleLike(String title) {
        return (List<Incident>) incidentRepository.findByTitleLike(title);
    }

    public List<Incident> getQueryIncidentByTitleLike (String title){
        return (List<Incident>) incidentRepository.getTitleLike(title);
    }
}