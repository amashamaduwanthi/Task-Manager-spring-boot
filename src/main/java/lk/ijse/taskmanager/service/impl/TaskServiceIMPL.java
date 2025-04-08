package lk.ijse.taskmanager.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.taskmanager.Entity.impl.Task;
import lk.ijse.taskmanager.Util.Mapping;
import lk.ijse.taskmanager.dao.TaskDao;
import lk.ijse.taskmanager.dto.TaskStatus;
import lk.ijse.taskmanager.dto.impl.TaskDTO;
import lk.ijse.taskmanager.exception.DataPersistException;
import lk.ijse.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import lk.ijse.taskmanager.Util.Mapping;
import org.springframework.stereotype.Service;




@Transactional
@Service
public class TaskServiceIMPL implements TaskService {
    @Autowired
    private TaskDao taskDao;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveTask(TaskDTO taskDTO) {
        Task saveTask = taskDao.save(mapping.toTask(taskDTO));
        if (saveTask == null) {
            throw new DataPersistException("Equipment not saved");
        }


    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return mapping.toTaskDTOList(taskDao.findAll());
    }

    @Override
    public TaskStatus getTask(String id) {
        return null;
    }

    @Override
    public void deleteTask(String id) {

    }

    @Override
    public void updateTask(String id, TaskDTO taskDTO) {

    }
}