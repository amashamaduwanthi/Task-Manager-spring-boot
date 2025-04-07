package lk.ijse.taskmanager.dao;

import lk.ijse.taskmanager.Entity.impl.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task,String> {
}
