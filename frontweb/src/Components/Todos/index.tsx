import { useEffect, useState } from 'react';
import { SpringPage } from '../../types/vendor/spring';
import styles from './Todos.module.css';
import Task from '../Task';
import Api from 'Services/Api';
import CreateTask from 'Components/Modal/CreateTask';

const Todos = () => {
  const [tasks, setTasks] = useState([]);

  const [showModal, setShowModal] = useState(false);

  const getTasks = async () => {
    const response = await Api.get('/tasks');
    const { content } = await response.data;

    setTasks(content);
  };

  useEffect(() => {
    getTasks();
  }, []);

  return (
    <section className={styles.container}>
      <div className={styles.header}>
        <div>
          <button
          onClick={() => setShowModal(true)}
          >Nova Tarefa</button>
        </div>

        <div className={styles.filtros}>
          <div>
            <input id="todos" name="filtros" type="radio" />
            <label htmlFor="todos">Todos</label>
          </div>

          <div>
            <input id="pendentes" name="filtros" type="radio" />
            <label htmlFor="pendentes">Pedentes</label>
          </div>

          <div>
            <input id="finalizadas" name="filtros" type="radio" />
            <label htmlFor="finalizadas">Finalizadas</label>
          </div>
        </div>
      </div>

      <div className={styles.todos}>
        {tasks.map(({ deadLine, id, title, description, task_finish }) => (
          <Task
            key={id}
            deadLine={deadLine}
            id={id}
            title={title}
            description={description}
            task_finish={task_finish}
            updateState={() => getTasks()}
          />
        ))}
      </div>

      {showModal && <CreateTask closeModal={() => setShowModal(false)} />}
    </section>
  );
};

export default Todos;
