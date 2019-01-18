package org.srysoft.rest.webservices.restfulwebservices.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoUtilService {

	static long idCounter = 0;
	private static List<Todo> todos = new ArrayList<Todo>();

	static {
		todos.add(new Todo(++idCounter, "satya", "Learn Angular 6", new Date(), true));
		todos.add(new Todo(++idCounter, "satya", "Became a MEAN stack developer", new Date(), false));
		todos.add(new Todo(++idCounter, "satya", "Learn about microsrvice", new Date(), false));
		todos.add(new Todo(++idCounter, "satya", "Learn about Node.js", new Date(), false));
		todos.add(new Todo(++idCounter, "satya", "Drive Car", new Date(), true));
		todos.add(new Todo(++idCounter, "satya", "Learn Ionic Framework", new Date(), true));
		todos.add(new Todo(++idCounter, "satya", "Test Java 8 Knowledge", new Date(), true));
		todos.add(new Todo(++idCounter, "satya", "New Course 2019", new Date(), true));
		todos.add(new Todo(++idCounter, "satya", "Ionic Programmer", new Date(), false));
		todos.add(new Todo(++idCounter, "satya", "React JS Front end UI", new Date(), true));
		todos.add(new Todo(++idCounter, "satya", "Mongo DB", new Date(), false));
		todos.add(new Todo(++idCounter, "satya", "Trainer", new Date(), true));
	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo save(Todo todo) {

		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo != null)
			if (!todos.remove(todo))
				todo = null;

		return todo;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}
}

