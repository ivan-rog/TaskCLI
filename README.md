## Description

TaskCLI is a command-line application developed in Java using Spring Boot. It allows you to manage tasks easily, storing them in an H2 database.

## Features

- **Task Management**: Create, list, update, and delete tasks.
- **Persistence**: Uses Spring Data JPA with an in-memory H2 database.
- **CLI Interface**: Interactive commands provided by Spring Shell.

## Prerequisites

- **Java 21** or higher.
- **Maven** 3.8 or higher.

## Installation and Execution

1. Clone this repository:
   ```bash
   git clone https://github.com/ivan-rog/TaskCli.git
   cd TaskCli

2. Build the project:
   ```bash
   mvn clean install

3. Run the application:
   ```bash
   mvn spring-boot:run
   
4. Use the CLI:
   ```bash
   # Adding a new task
   shell:> add "Buy groceries"
   # Output: Task added successfully (ID: 1)

   # Updating a task
   shell:> update 1 "Buy groceries and cook dinner"
   # Output: Task updated: 1 to Buy groceries and cook dinner

   # Deleting a task
   shell:> delete 1
   # Output: Task deleted: 1

   # Marking a task as in progress
   shell:> mark-in-progress 1
   # Output: Task marked as in progress: 2

   # Marking a task as done
   shell:> mark-done 1
   # Output: Task marked as complete: 2

   # Listing all tasks
   shell:> list
   # Output: List of all tasks

   # Listing tasks by status
   shell:> list todo | in-progress | done

Sample solution for the [Task Tracker](https://roadmap.sh/projects/task-tracker) challenge from [roadmap.sh](https://roadmap.sh/).