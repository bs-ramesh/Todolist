package com.example.todolist.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.NOVEMBER;

@Configuration
public class todolistConfig {
    @Bean
    CommandLineRunner commandLineRunner(todolistRepository repository){
        return args -> {
            todolist task1 = new todolist(
                    "Implement Data Structures Project",
                    "Build a program demonstrating the use of linked lists and trees.",
                    LocalDate.of(2023, NOVEMBER, 20),
                    true
            );

            todolist task2 = new todolist(
                    "Study Algorithms for Interview",
                    "Review common algorithms and practice solving coding problems for upcoming interviews.",
                    LocalDate.of(2023, NOVEMBER, 22),
                    false
            );

            todolist task3 = new todolist(
                    "Write Technical Blog Post",
                    "Compose a blog post on a recent technology trend or programming concept.",
                    LocalDate.of(2023, NOVEMBER, 25),
                    true
            );

            todolist task4 = new todolist(
                    "Participate in Hackathon",
                    "Prepare for and participate in the upcoming hackathon event.",
                    LocalDate.of(2023, NOVEMBER, 28),
                    false
            );

            todolist task5 = new todolist(
                    "Create Personal Portfolio Website",
                    "Design and develop a portfolio website showcasing projects and skills.",
                    LocalDate.of(2023, NOVEMBER, 30),
                    false
            );

            repository.saveAll(List.of(task1, task2, task3, task4, task5));
        };
    }
    
}


