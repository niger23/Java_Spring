package ru.gb.HW005.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.HW005.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
