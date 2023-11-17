package com.example.todolist.todolist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface todolistRepository extends JpaRepository<todolist, Long> {
    @Query("SELECT t FROM todolist t WHERE t.title = ?1")
    Optional<todolist> findTodolistByTitle(String title);

    @Query("SELECT t FROM todolist t WHERE t.dueDate >= CURRENT_DATE AND t.completed = false ORDER BY t.dueDate ASC")
    List<todolist> findUncompletedTasksOrderByDueDate();
}


