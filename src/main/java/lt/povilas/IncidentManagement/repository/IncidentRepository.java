package lt.povilas.IncidentManagement.repository;

import lt.povilas.IncidentManagement.repository.model.Incident;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.List;
import java.util.Optional;

public interface IncidentRepository extends CrudRepository<Incident, Integer> {
    Optional<Incident> findByTitle (String title);
    Iterable<Incident> findByTitleLike(String title);
    @Query(value = "SELECT * FROM incidents WHERE title LIKE :title", nativeQuery = true)
    List<Incident> getTitleLike(@Param("title") String title);

}