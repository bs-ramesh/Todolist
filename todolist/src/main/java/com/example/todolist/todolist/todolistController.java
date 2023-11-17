package com.example.todolist.todolist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/todolist")
public class todolistController {

    private final todolistService todolistService;

    @Autowired

    public todolistController(com.example.todolist.todolist.todolistService todolistService) {
        this.todolistService = todolistService;
    }


    @GetMapping
    public List<todolist> getStudents(){
        return todolistService.getList();
    }
    @GetMapping("/filterByDueDate")
    public List<todolist> getUncompletedTasksOrderByDueDate() {
        return todolistService.getUncompletedTasksOrderByDueDate();
    }

    @PostMapping
    public void addNewList(@RequestBody todolist todolist){
        todolistService.addList(todolist);
    }

    @DeleteMapping(path="{listId}")
    public void deleteList(@PathVariable("listId")Long listId){
        todolistService.deleteList(listId);
    }
    @PutMapping(path="{listId}")
    public void updateList(
            @PathVariable("listId")Long listId,
            @RequestParam(required = false)String title,
            @RequestParam(required = false)String description,
            @RequestParam(required = false)boolean completed,
            @RequestParam(required = false)LocalDate dueDate){
        todolistService.updateList(listId,title,description,completed,dueDate);
    }

}
