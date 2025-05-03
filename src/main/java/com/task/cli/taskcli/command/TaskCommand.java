package com.task.cli.taskcli.command;

import com.task.cli.taskcli.business.TaskBusiness;
import com.task.cli.taskcli.entity.TaskEntity;
import com.task.cli.taskcli.entity.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

import java.util.ArrayList;
import java.util.List;

@Command(group = "Task Commands")
@RequiredArgsConstructor
public class TaskCommand {

    private final TaskBusiness taskBusiness;

    @Command(command = "add", description = "Add a new task")
    public String add(@Option String description) {
        var recordTask = taskBusiness.createTask(description);
        return String.format("Task added successfully (ID: %s)", recordTask.getId());
    }

    @Command(command = "list", description = "List all tasks")
    public List<TaskEntity> list(@Option String status) {
        if (status != null) {
            try {
                Status taskStatus = Status.valueOf(status.toUpperCase());
                return taskBusiness.findAllTasksByStatus(taskStatus);
            } catch (IllegalArgumentException e) {
                return new ArrayList<>();
            }
        }
        return taskBusiness.findAllTasks();
    }

    @Command(command = "delete", description = "Delete a task")
    public String delete(@Option int taskId) {
        var taskEntity = taskBusiness.findTaskById((long) taskId);
        if (taskEntity == null) {
            return "Task not found: " + taskId;
        }
        taskBusiness.deleteTask(taskEntity);
        return "Task deleted: " + taskId;
    }

    @Command(command = "update", description = "Update a task")
    public String update(@Option long taskId, @Option String newDescription) {
        var taskEntity = taskBusiness.findTaskById(taskId);
        if (taskEntity == null) {
            return "Task not found: " + taskId;
        }
        taskEntity.setDescription(newDescription);
        taskBusiness.updateTask(taskEntity);
        return "Task updated: " + taskId + " to " + newDescription;
    }

    @Command(command = "mark-in-progress", description = "Mark a task as in progress")
    public String markInProgress(@Option int taskId) {
        var taskEntity = taskBusiness.findTaskById((long) taskId);
        if (taskEntity == null) {
            return "Task not found: " + taskId;
        }
        taskBusiness.markTaskInProgress(taskEntity);
        return "Task marked as in progress: " + taskId;
    }

    @Command(command = "mark-done", description = "Mark a task as complete")
    public String markDone(@Option int taskId) {
        var taskEntity = taskBusiness.findTaskById((long) taskId);
        if (taskEntity == null) {
            return "Task not found: " + taskId;
        }
        taskBusiness.markTaskDone(taskEntity);
        return "Task marked as complete: " + taskId;
    }
}
