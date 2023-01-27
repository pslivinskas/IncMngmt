package lt.povilas.IncidentManagement.controller;

import lt.povilas.IncidentManagement.repository.model.Incident;
import lt.povilas.IncidentManagement.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path = "/incidenttemplate")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    // http://localhost:8080/incidenttemplate/allincidents
    @GetMapping(path = "allincidents")
    public String getAllIncidents(Model model) {
        List<Incident> incidentsList = incidentService.getAllIncidents();
        model.addAttribute("key_incidents_list", incidentsList);
        return "/new/allIncidents";
    }

    // http://localhost:8080/incidenttemplate/firstpage/incident/1

    @GetMapping(path ="/firstpage/incident/{id}")
    public @ResponseBody Incident getIncidentById(@PathVariable int id){ return incidentService.getIncidentById(id);}
//    @GetMapping(path = "/firstpage/incident/{id}")
//    public String getIncidentFirstPage(Model model, @PathVariable int id) {
//
//        Incident incident = incidentService.getIncidentById(id);
//        model.addAttribute("key_incidents_list", incident);
//        model.addAttribute("id", incident.getId());
//        model.addAttribute("title", incident.getTitle());
//        model.addAttribute("description", incident.getDescription());
//        model.addAttribute("priority", incident.getPriority());
//        model.addAttribute("updatedOn", incident.getUpdatedOn());
//
//        return "/new/firstpage_th";
//    }



    // http://localhost:8080/incidenttemplate/firstpage/incident/like/down
        @GetMapping(path = "firstpage/incident/like/{title}")
    public @ResponseBody List<Incident> getTitleLike (@PathVariable String title){
        return incidentService.getIncidentByTitleLike("%" + title + "%");
    }
//    public String getTitleLike (Model model, @PathVariable String title){
//        List<Incident> incidentList = incidentService.getIncidentByTitleLike("%" + title + "%");
//        model.addAttribute("key_incidents_list", incidentList);
//        return "/new/firstpage";
//    }

    // http://localhost:8080/incidenttemplate/new/postget
    @RequestMapping(value = "/new/postget", method = RequestMethod.GET)
    public String getIncidentByTitleLike(Model model) {
        model.addAttribute("key_incident", new Incident());
        model.addAttribute("key_incidents_list", Collections.emptyList());
        return "/new/postget";
    }
    // http://localhost:8080/incidenttemplate/new/postget
    @RequestMapping(value = "/new/postget", method = RequestMethod.POST)
    public String postIncidentByTitleLike(Model model, @ModelAttribute(value = "key_incident") Incident incident) {
        List<Incident> incidents = incidentService.getIncidentByTitleLike("%" + incident.getTitle() + "%");

        model.addAttribute("key_incidents_list", incidents);
        return "/new/postget";
    }

}
