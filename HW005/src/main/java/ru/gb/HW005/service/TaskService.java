package ru.gb.HW005.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.HW005.model.Task;
import ru.gb.HW005.model.TaskStatus;
import ru.gb.HW005.repository.TaskRepository;

import java.util.List;
import java.util.Objects;


@Service
@AllArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public void deleteTaskById(Task task) {
        taskRepository.deleteById(task.getId());
    }
    public Task updateTaskStatus(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        assert task != null;
        if(task.getStatus().equals(TaskStatus.NOT_STARTED)) task.setStatus(TaskStatus.IN_PROGRESS);
        else if (task.getStatus().equals(TaskStatus.IN_PROGRESS)) task.setStatus(TaskStatus.COMPLETED);
        return taskRepository.save(task);
    }
    public Task updateTask(Long id, Task task){
        Task findedTask = taskRepository.findById(id).orElse(null);
        if (findedTask != null) {
            findedTask.setDescription(task.getDescription());
            findedTask.setStatus(task.getStatus());
            findedTask.setDescription(task.getDescription());
            return taskRepository.save(findedTask);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }
}
