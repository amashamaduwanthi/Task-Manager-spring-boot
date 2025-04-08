package lk.ijse.taskmanager.Util;

import lk.ijse.taskmanager.Entity.impl.Task;
import lk.ijse.taskmanager.dto.impl.TaskDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    ModelMapper modelMapper;
    public Task toTask(TaskDTO taskDTO) {
        return modelMapper.map(taskDTO, Task.class);
    }
    public TaskDTO toTaskDTO(Task task) {
        return modelMapper.map(task, TaskDTO.class);
    }

    public List<TaskDTO> toTaskDTOList(List<Task> taskEntitiesList) {
        return modelMapper.map(taskEntitiesList,new TypeToken<List<TaskDTO>>() {}.getType());
    }
}
