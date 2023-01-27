package lt.povilas.IncidentManagement.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "incidents")
@Getter @Setter @NoArgsConstructor @ToString
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "priority")
    private String priority;
    @Column(name = "updatedon")
    private String updatedOn;
}