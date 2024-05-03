package ru.geekbrains.MyWebApplication;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTask () {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable UUID uuid) {
        return taskService.getTask(uuid);
    }

    @PostMapping
    public Task addById(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @PutMapping("/{id}")
    public Task updateById(@PathVariable UUID uuid, @RequestBody Task task) {
        return taskService.updateTask(uuid, task);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID uuid) {
        taskService.deleteTask(uuid);
    }


}
