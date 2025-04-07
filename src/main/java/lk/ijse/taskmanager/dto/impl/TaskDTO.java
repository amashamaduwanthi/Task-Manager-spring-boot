package lk.ijse.taskmanager.dto.impl;

import lk.ijse.taskmanager.dto.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO implements TaskStatus {
    private String id;
    private String title;
    private String description;
    private Boolean completed;
}
