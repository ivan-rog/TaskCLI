package com.task.cli.taskcli.entity;

import com.task.cli.taskcli.entity.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TASKS")
@Getter
@Setter
public class TaskEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String toString() {
        return String.format(
                "{id=%d, description='%s', status=%s, createdAt=%s, updatedAt=%s}",
                id, description, status.getStatus(), createdAt, updatedAt);
    }

}
