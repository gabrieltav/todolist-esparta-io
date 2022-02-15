import styles from './Modal.module.css';
import { AiOutlineClose } from 'react-icons/ai';

type Props = {
  title: String;
  handleModal: any;
  body: any;
};

const Modal = ({ title, body, handleModal}: Props) => {
  return (
    <section className={styles.container}>
      <div className={styles.modal}>
        <div className={styles.header}>
          <h1>{title}</h1>
          <AiOutlineClose onClick={handleModal} />
        </div>

        <div>{body}</div>
      </div>
    </section>
  );
};

export default Modal;
