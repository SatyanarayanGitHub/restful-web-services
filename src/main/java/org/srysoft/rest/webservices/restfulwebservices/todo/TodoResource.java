package org.srysoft.rest.webservices.restfulwebservices.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoResource {

	@Autowired
	private TodoUtilService todoService;

	@GetMapping(path = "/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable("username") String userName) {
		System.out.println("Get all todos of user:[" + userName + "]");
		return todoService.findAll();
	}

	@DeleteMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable("username") String userName, @PathVariable("id") long id) {
		System.out.println("Delete todo id:[" + id + "] of user:[" + userName + "]");
		Todo todo = todoService.deleteById(id);

		if (todo != null)
			return ResponseEntity.noContent().build();
		else
			return ResponseEntity.notFound().build();
	}

	@GetMapping(path = "/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable("username") String userName, @PathVariable("id") long id) {
		System.out.println("Get todo id:[" + id + "] of user:[" + userName + "]");
		Todo todo = todoService.findById(id);

		return todo;
	}

	@PutMapping(path = "/users/{username}/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable("username") String userName, @PathVariable("id") long id,
			@RequestBody Todo todo) {
		System.out.println("Update id:[" + id + "] of user:[" + userName + "]");

		Todo updatedTodo = todoService.save(todo);
		return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
	}

	@PostMapping(path = "/users/{username}/todos")
	public ResponseEntity<Void> saveTodo(@PathVariable("username") String userName, @RequestBody Todo todo) {
		System.out.println("Add new todo for user:[" + userName + "]");
		Todo createdTodo = todoService.save(todo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

}
