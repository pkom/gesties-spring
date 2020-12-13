package net.iesmaestrojuancalero.gesties.backend.repositories;

import net.iesmaestrojuancalero.gesties.backend.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
}
