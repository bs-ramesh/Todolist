package com.example.todolist.todolist;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class todolistService {
    private final todolistRepository todolistRepository;

    @Autowired
    public todolistService(com.example.todolist.todolist.todolistRepository todolistRepository) {
        this.todolistRepository = todolistRepository;
    }
    public List<todolist> getList(){
        return todolistRepository.findAll();
    }
    public List<todolist> getUncompletedTasksOrderByDueDate() {
        return todolistRepository.findUncompletedTasksOrderByDueDate();
    }

    public void addList(todolist todolist) {
        Optional<todolist> todolistOptional=
                todolistRepository.findTodolistByTitle(todolist.getTitle());
        if(todolistOptional.isPresent()){
            throw new IllegalStateException("Title already exist");
        }
        todolistRepository.save(todolist);
    }

    public void deleteList(Long listId) {

        boolean exists = todolistRepository.existsById(listId);
        if(!exists){
            throw new IllegalStateException("task with id "+listId+"doesnt exists");

        }
        todolistRepository.deleteById(listId);

    }
    @Transactional
    public void updateList(Long listId,
                              String title,
                              String description,
                              boolean completed,
                              LocalDate dueDate){
        todolist todolist=todolistRepository.findById(listId).orElseThrow(()->new IllegalStateException("task id"+listId+"doesnt exist"));
        if (title!=null && !title.isEmpty() && !Objects.equals(todolist.getTitle(),title)){
            todolist.setTitle(title);
        }

        if (description!=null && !description.isEmpty() && !Objects.equals(todolist.getTitle(),description)){
            todolist.setDescription(description);
        }
        if (completed != todolist.iscompleted()) {
            todolist.setcompleted(completed);
        }
        if (dueDate != null && !Objects.equals(todolist.getduedate(), dueDate)) {
            todolist.setduedate(dueDate);
        }
    }
}