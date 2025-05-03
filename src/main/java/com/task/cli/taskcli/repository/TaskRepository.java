package com.task.cli.taskcli.repository;

import com.task.cli.taskcli.entity.TaskEntity;
import com.task.cli.taskcli.entity.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findAllByStatus(Status status);
}
