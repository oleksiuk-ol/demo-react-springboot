package com.example.demoreactspringboot.controller;


import com.example.demoreactspringboot.dao.TodoTaskDao;
import com.example.demoreactspringboot.entity.TodoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TodoTaskController {

    @Autowired
    private TodoTaskDao todoTaskDao;

    @GetMapping("/demo/todo")
    public List<TodoTask> getAllTodos(){
        return todoTaskDao.findAll();
    }

    @GetMapping("/demo/todo/{id}")
    public TodoTask getById(@PathVariable long id){

        return todoTaskDao.findById(id).get();
    }

    @PutMapping("/demo/todo/{id}")
    public  ResponseEntity<Void> updateTodo(@PathVariable long id,  @RequestBody TodoTask todoTask){

        todoTask.setId(id);
        todoTaskDao.save(todoTask);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/demo/todo")
    public ResponseEntity<Void> createTodo( @RequestBody TodoTask todoTask){
        TodoTask createdTodo = todoTaskDao.save(todoTask);
        URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{id")
                .buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/demo/todo/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id){
        todoTaskDao.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
