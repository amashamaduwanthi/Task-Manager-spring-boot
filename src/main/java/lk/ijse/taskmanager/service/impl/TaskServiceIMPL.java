package lk.ijse.taskmanager.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.taskmanager.Entity.impl.Task;
import lk.ijse.taskmanager.Util.Mapping;
import lk.ijse.taskmanager.dao.TaskDao;
import lk.ijse.taskmanager.dto.TaskStatus;
import lk.ijse.taskmanager.dto.impl.TaskDTO;
import lk.ijse.taskmanager.exception.DataPersistException;
import lk.ijse.taskmanager.exception.SelectedErrorStatus;
import lk.ijse.taskmanager.exception.TaskNotFoundException;
import lk.ijse.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

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
            throw new DataPersistException("Task not saved");
        }


    }

    @Override
    public List<TaskDTO> getAllTasks() {
        return mapping.toTaskDTOList(taskDao.findAll());
    }

    @Override
    public TaskStatus getTask(String id) {
        if(taskDao.existsById(id)) {
            var selectedTask = taskDao.getReferenceById(id);
            return mapping.toTaskDTO(selectedTask);
        }else{
            return new SelectedErrorStatus(2,"Selected Task not found");
        }
    }

    @Override
    public void deleteTask(String id) {
        Optional<Task> foundTask = taskDao.findById(id);
        if(!foundTask.isPresent()) {
            throw new TaskNotFoundException("Task not found");
        }else{
            taskDao.deleteById(id);
        }
    }

    @Override
    public void updateTask(String id, TaskDTO taskDTO) {
        Optional<Task> tmpTask = taskDao.findById(id);
        if(!tmpTask.isPresent()) {
            throw new TaskNotFoundException("Task not found");
        }else{
            tmpTask.get().setTitle(taskDTO.getTitle());
            tmpTask.get().setDescription(taskDTO.getDescription());
            tmpTask.get().setCompleted(taskDTO.getCompleted());

        }
    }
}