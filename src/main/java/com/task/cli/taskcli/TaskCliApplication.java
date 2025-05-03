package com.task.cli.taskcli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.shell.command.annotation.CommandScan;

@SpringBootApplication
@CommandScan(basePackages = "com.task.cli.taskcli")
public class TaskCliApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskCliApplication.class, args);
    }

}
