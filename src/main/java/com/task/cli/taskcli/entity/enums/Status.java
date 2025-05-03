package com.task.cli.taskcli.entity.enums;

import lombok.Getter;

@Getter
public enum Status {

    TODO("todo"),
    IN_PROGRESS("in-progress"),
    DONE("done");

    private String status;

    Status(String status) {
        this.status = status;
    }

}
