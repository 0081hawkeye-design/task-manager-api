import { useEffect, useState } from "react";

const API = "http://localhost:8080/tasks"; // our Spring Boot backend

export default function App() {
  const [tasks, setTasks] = useState([]); // list of tasks from backend
  const [title, setTitle] = useState(""); // text typed in the input box

  // ask backend for all tasks and save them in state
  async function loadTasks() {
    const res = await fetch(API);
    setTasks(await res.json());
  }

  // run once when the page opens
  useEffect(() => {
    loadTasks();
  }, []);

  // POST a new task, then reload the list
  async function addTask() {
    if (!title.trim()) return; // ignore empty input
    await fetch(API, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title, done: false }),
    });
    setTitle(""); // clear the input box
    loadTasks();
  }

  // PUT: flip done / not done
  async function toggleTask(task) {
    await fetch(`${API}/${task.id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ title: task.title, done: !task.done }),
    });
    loadTasks();
  }

  // DELETE a task, then reload the list
  async function deleteTask(id) {
    await fetch(`${API}/${id}`, { method: "DELETE" });
    loadTasks();
  }

  return (
    <div style={{ maxWidth: 500, margin: "40px auto", fontFamily: "sans-serif" }}>
      <h1>Task Manager</h1>

      <input
        value={title}
        onChange={(e) => setTitle(e.target.value)}
        placeholder="New task..."
      />
      <button onClick={addTask}>Add</button>

      <ul>
        {tasks.map((t) => (
          <li key={t.id}>
            <span
              onClick={() => toggleTask(t)}
              style={{
                cursor: "pointer",
                textDecoration: t.done ? "line-through" : "none",
              }}
            >
              {t.title}
            </span>{" "}
            <button onClick={() => deleteTask(t.id)}>❌</button>
          </li>
        ))}
      </ul>
    </div>
  );
}