package az.hafizrzazade.todolistapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import az.hafizrzazade.todolistapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}