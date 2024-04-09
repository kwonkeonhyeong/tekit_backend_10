const input = document.querySelector("input");
const btn = document.getElementById("btn");
const todo = document.getElementById("todo-value");
const ul = document.querySelector("ul");

let id = 3;
let basicDatas = [
  { id: 1, title: "Todo 1", done: false },
  { id: 2, title: "Todo 2", done: true },
];

initialTodo();

btn.addEventListener("click", () => {
  if (todo.value == "") {
    alert("할 일을 입력해주세요.");
    return;
  }

  basicDatas.push({ id: id, title: `Todo ${id}`, done: false });
  const li = document.createElement("li");
  li.className = `todo-content`;
  li.id = todo.id;
  li.addEventListener("click", changeDone);

  const todoBtn = document.createElement("button");
  todoBtn.textContent = "x";
  todoBtn.className = "delete-btn";
  todoBtn.id = id;
  todoBtn.addEventListener("click", deleteTodo);

  const text = document.createTextNode(todo.value);
  li.id = id;
  li.appendChild(text);
  li.appendChild(todoBtn);
  ul.appendChild(li);
  id++;
  todo.value = "";
  console.log(basicDatas);
});

input.addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    if (todo.value == "") {
      alert("할 일을 입력해주세요.");
      return;
    }

    basicDatas.push({ id: id, title: `Todo ${id}`, done: false });
    const li = document.createElement("li");
    li.className = `todo-content`;
    li.id = todo.id;
    li.addEventListener("click", changeDone);

    const todoBtn = document.createElement("button");
    todoBtn.textContent = "x";
    todoBtn.className = "delete-btn";
    todoBtn.id = id;
    todoBtn.addEventListener("click", deleteTodo);

    const text = document.createTextNode(todo.value);
    li.id = id;
    li.appendChild(text);
    li.appendChild(todoBtn);
    ul.appendChild(li);
    id++;
    todo.value = "";
    console.log(basicDatas);
  }
});

function deleteTodo(event) {
  const targetId = parseInt(event.target.parentNode.id);
  basicDatas = basicDatas.filter((data) => data.id !== targetId);
  event.target.parentNode.remove();
  event.stopPropagation();
  console.log(basicDatas);
}

function initialTodo() {
  basicDatas.forEach((todo) => {
    const li = document.createElement("li");
    li.className = `todo-content`;
    if (todo.done) {
      li.classList.add("done");
    } else {
      li.classList.remove("done");
    }
    li.id = todo.id;
    li.addEventListener("click", changeDone);

    const todoBtn = document.createElement("button");
    todoBtn.textContent = "x";
    todoBtn.className = "delete-btn";
    todoBtn.id = todo.id;
    todoBtn.addEventListener("click", deleteTodo);

    const text = document.createTextNode(todo.title);

    li.appendChild(text);
    li.appendChild(todoBtn);

    ul.appendChild(li);
    console.log(basicDatas);
  });
}

function changeDone(event) {
  const targetDataIndex = basicDatas.findIndex(
    (data) => data.id == event.target.id
  );

  if (basicDatas[targetDataIndex].done) {
    basicDatas[targetDataIndex].done = false;
    event.target.classList.remove("done");
  } else {
    basicDatas[targetDataIndex].done = true;
    event.target.classList.add("done");
  }
  event.stopPropagation();
}
