package com.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.models.Task;

/**
 * Created by aleksei on 21.01.17.
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {
}
