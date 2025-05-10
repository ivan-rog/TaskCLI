package com.task.cli.business;

import com.task.cli.entity.TaskEntity;
import com.task.cli.entity.enums.Status;
import com.task.cli.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskBusiness {

    private final TaskRepository taskRepository;

    public TaskEntity createTask(String description) {
        var taskEntity = new TaskEntity();
        taskEntity.setDescription(description);
        taskEntity.setStatus(Status.TODO);
        taskEntity.setCreatedAt(LocalDateTime.now());
        taskEntity.setUpdatedAt(LocalDateTime.now());
        return taskRepository.save(taskEntity);
    }

    public TaskEntity findTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public List<TaskEntity> findAllTasks() {
        return taskRepository.findAll();
    }

    public List<TaskEntity> findAllTasksByStatus(Status status) {
        return taskRepository.findAllByStatus(status);
    }

    public void updateTask(TaskEntity task) {
        taskRepository.save(task);
    }

    public void deleteTask(TaskEntity taskEntity) {
        taskRepository.delete(taskEntity);
    }


    public void markTaskInProgress(TaskEntity taskEntity) {
        taskEntity.setStatus(Status.IN_PROGRESS);
        taskEntity.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(taskEntity);
    }

    public void markTaskDone(TaskEntity taskEntity) {
        taskEntity.setStatus(Status.DONE);
        taskEntity.setUpdatedAt(LocalDateTime.now());
        taskRepository.save(taskEntity);
    }

}
