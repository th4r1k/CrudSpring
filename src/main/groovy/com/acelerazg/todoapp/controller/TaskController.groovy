package com.acelerazg.todoapp.controller

import com.acelerazg.todoapp.model.entity.Task
import com.acelerazg.todoapp.repository.TaskRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/task")
class TaskController {

    private TaskRepository taskRepository

    public TaskController(TaskRepository taskRepository){
        this.taskRepository = taskRepository
    }

    @GetMapping
    List<Task> getTasks(){
        taskRepository.findAll()
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Task createTask(@RequestBody Task task){
        return taskRepository.save(task)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteTask(@PathVariable Integer id){
       taskRepository.findById(id)
               .map {taskRepository.delete(it)}
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateTask(@PathVariable Integer id, @RequestBody Task task){
        taskRepository.findById(id)
                .map {task.id = it.id
                taskRepository.save(task)
                }
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND))

    }

}
