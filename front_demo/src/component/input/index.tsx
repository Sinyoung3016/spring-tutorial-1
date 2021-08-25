import InputForm from './inputform'

const Input = () => {
  return (
    <div style={{display:"flex", alignItems: "center", paddingLeft: "35px", border: "1px solid", width: "465px", height: "50px"}}>
      <InputForm mode="post" buttonTitle="게시글 작성" />
    </div>
  );
};

export default Input;
