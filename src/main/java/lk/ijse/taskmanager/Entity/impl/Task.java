package lk.ijse.taskmanager.Entity.impl;

import jakarta.persistence.*;
import lk.ijse.taskmanager.Entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "task")
public class Task implements SuperEntity {
    @Id
    private String id;
    private String title;
    private String description;
    private String completed;
    private LocalDateTime createdAt;


}

