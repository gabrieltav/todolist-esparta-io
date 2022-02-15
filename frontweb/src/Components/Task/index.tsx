import styles from './Task.module.css';

import { MdOutlineDeleteOutline } from 'react-icons/md';
import { BiEdit } from 'react-icons/bi';
import { TaskTypes } from 'types/TaskType';
import Api from 'Services/Api';
import { useState } from 'react';
import Input from 'Components/Input';
import CreateTask from 'Components/Modal/CreateTask';

const Task = ({
  id,
  title,
  description,
  task_finish,
  deadLine,
  updateState,
}: TaskTypes) => {
  const [checked, setChecked] = useState(false);

  const handleCheck = (event: React.ChangeEvent<HTMLInputElement>) => {

    if (event.target.checked) {
      Api.put(`/tasks/${id}`, {
        title,
        description,
        task_finish: true,
        deadLine,
      });

    } else {
      Api.put(`/tasks/${id}`, {
        title,
        description,
        task_finish: false,
        deadLine,
      });
    }

    updateState();

  };

  const handleEdit = () => {
    alert(`Edit ID ${id} clicado!`);
  };

  const handleDelete = () => {
    alert(`Delete ID ${id} clicado!`);
  };

  return (
    <div className={styles.container}>
      <div className={styles.info}>
        <div className={styles.check}>
          <Input
            type="checkbox"
            handleOnChange={handleCheck}
            closed={task_finish}
          />
        </div>
        <div>
          <h1>{title}</h1>
          <p>{description}</p>
        </div>
      </div>
      <div className={styles.actions}>
        <button onClick={handleEdit}>
          <BiEdit />
        </button>
        <button onClick={handleDelete}>
          <MdOutlineDeleteOutline />
        </button>
      </div>
      
    </div>
  );
};

export default Task;
