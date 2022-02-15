type Props = {
  type: string;
  handleOnChange: any;
  closed: Boolean;
};
const Input = ({ type, handleOnChange, closed }: Props) => {
  return (
    <>
      {closed && <input type={type} onChange={handleOnChange} checked />}

      {!closed && <input type={type} onChange={handleOnChange} />}
    </>
  );
};

export default Input;
