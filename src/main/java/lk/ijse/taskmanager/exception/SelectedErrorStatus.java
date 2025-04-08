package lk.ijse.taskmanager.exception;


import lk.ijse.taskmanager.dto.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SelectedErrorStatus implements TaskStatus {
    private int statusCode;
    private String statusMessage;
}
