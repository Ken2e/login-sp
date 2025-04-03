package org.example.zombie.controller;

import org.example.zombie.entity.Task;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskContoller {

    private final List<Task> tasks =new ArrayList<>();

    @GetMapping("/all")
    public Flux<Task> getAllTask() {
        return Flux.fromIterable(tasks);
    }

    @PostMapping("/create-task")
    public Mono<Task> createTask(Task task) {
        tasks.add(task);
        return Mono.just(task);
    }

    @DeleteMapping("/delete")
    public Mono<String> deletingTask(int task) {
        tasks.removeIf(t -> t.getId() == task);
        return Mono.just("task  removed successfully");
    }
}
