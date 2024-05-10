package ru.gb.HW005.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.HW005.model.Task;
import ru.gb.HW005.model.TaskStatus;
import ru.gb.HW005.service.TaskService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.getAllTasks().stream()
                .filter(it -> it.getStatus().equals(status))
                .toList();
    }
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id) {
         return taskService.updateTaskStatus(id);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(taskService.getTaskById(id));
    }
}
