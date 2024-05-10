package ru.gb.HW005.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column(name = "task_status")
    private TaskStatus status = TaskStatus.NOT_STARTED;
    @Column(name = "local_date")
    private LocalDateTime dateTime = LocalDateTime.now();
}
