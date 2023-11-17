package com.example.todolist.todolist;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class todolist {
    @Id
    @SequenceGenerator(
            name="list_sequence",
            sequenceName = "list_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "list_sequence"
    )

    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public todolist() {
    }

    public todolist(String title, String description, LocalDate duedate, boolean completed) {
        this.title = title;
        this.description = description;
        this.dueDate = duedate;
        this.completed = completed;
    }

    public todolist(Long id, String title, String description, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getduedate() {
        return dueDate;
    }

    public void setduedate(LocalDate duedate) {
        this.dueDate = duedate;
    }

    public boolean iscompleted() {
        return completed;
    }

    public void setcompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "todolist{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duedate=" + dueDate +
                ", completed=" + completed +
                '}';
    }
}