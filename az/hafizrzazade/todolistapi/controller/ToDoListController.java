package az.hafizrzazade.todolistapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.hafizrzazade.todolistapi.model.ToDoList;
import az.hafizrzazade.todolistapi.repository.ToDoListRepository;

@RestController
@RequestMapping("/api/todolists")
public class ToDoListController {

    @Autowired
    private ToDoListRepository todoListRepository;

    @GetMapping
    public List<ToDoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> getTodoListById(@PathVariable Long id) {
        return todoListRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ToDoList createTodoList(@RequestBody ToDoList todoList) {
        return todoListRepository.save(todoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> updateTodoList(@PathVariable Long id, @RequestBody ToDoList updatedTodoList) {
        return todoListRepository.findById(id)
                .map(todoList -> {
                    todoList.setName(updatedTodoList.getName());
                    todoList.setDescription(updatedTodoList.getDescription());
                    return ResponseEntity.ok(todoListRepository.save(todoList));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodoList(@PathVariable Long id) {
        return todoListRepository.findById(id)
                .map(todoList -> {
                    todoListRepository.delete(todoList);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}