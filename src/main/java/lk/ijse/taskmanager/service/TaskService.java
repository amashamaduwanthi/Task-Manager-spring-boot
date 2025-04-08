package lk.ijse.taskmanager.service;

import lk.ijse.taskmanager.dto.TaskStatus;
import lk.ijse.taskmanager.dto.impl.TaskDTO;

import java.util.List;

public interface TaskService {
    void saveTask(TaskDTO taskDTO);

    List<TaskDTO> getAllTasks();

    TaskStatus getTask(String id);

    void deleteTask(String id);

    void updateTask(String id,TaskDTO taskDTO);
}
