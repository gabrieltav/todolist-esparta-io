import Modal from '../';
import styles from './CreateTask.module.css';
import DatePicker from 'react-modern-calendar-datepicker';
import 'react-modern-calendar-datepicker/lib/DatePicker.css';
import { useState } from 'react';

type Props = {
  closeModal: any;
};

const CreateTask = ({ closeModal }: Props) => {
  const [selectedDay, setSelectedDay] = useState(null);

  return (
    <Modal
      handleModal={closeModal}
      title="Nova Tarefa"
      body={
        <div className={styles.container}>
          <div className={styles.control}>
            <label htmlFor="title">Titulo</label>
            <input type="text" id="title" />
          </div>

          <div className={styles.control}>
            <label htmlFor="description">Descrição</label>
            <input type="text" id="description" />
          </div>

          <div className={styles.control}>
            <DatePicker
              value={selectedDay}
              onChange={setSelectedDay}
              inputPlaceholder="Select a day"
              shouldHighlightWeekends
            />
          </div>

          <div className={styles.control}>
            <button>Salvar</button>
          </div>
        </div>
      }
    />
  );
};

export default CreateTask;
