document.addEventListener("DOMContentLoaded", loadTodos);
document.getElementById("add-todo").addEventListener("click", addTodo);

async function loadTodos() {
    const response = await fetch("http://localhost:8888/");
    const todos = await response.json();
    const todoList = document.getElementById("todo-list");
    todoList.innerHTML = ""; // 목록 초기화

    todos.forEach(todo => {
        const todoItem = document.createElement("li");
        todoItem.classList.add("todo-item");

        const todoTextElement = document.createElement("span");
        todoTextElement.textContent = todo.text;

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Delete";
        deleteButton.addEventListener("click", () => deleteTodo(todo.id, todoItem));

        todoItem.appendChild(todoTextElement);
        todoItem.appendChild(deleteButton);
        todoList.appendChild(todoItem);
    });
}

async function addTodo() {
    const todoText = document.getElementById("new-todo").value;
    if (todoText.trim() === "") return;

    const response = await fetch("http://localhost:8888/", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(todoText),
    });

    const newTodo = await response.json();
    document.getElementById("new-todo").value = "";
    loadTodos();
}

async function deleteTodo(id, todoItem) {
    await fetch(`http://localhost:8888/${id}`, {
        method: "DELETE",
    });
    todoItem.remove();
}
