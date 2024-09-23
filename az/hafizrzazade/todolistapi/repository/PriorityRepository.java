package az.hafizrzazade.todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.hafizrzazade.todolistapi.model.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
}
