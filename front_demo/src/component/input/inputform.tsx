import axios from 'axios';
import { useState } from 'react';

interface PostRequest {
  title: string;
  content: string;
}

interface Props {
  mode: string;
  buttonTitle: string;
  postId?: number;
}

const InputForm: React.FC<Props> = ({mode, buttonTitle, postId}) => {
  const [request, setRequest] = useState<PostRequest>({
    title: '',
    content: '',
  });
  
  const handleClick = async () => {
    let data;
    if (mode === "post")
      data = await axios.post<PostRequest>('post', request);
    else if (mode === "update" && postId)
      await axios.post<PostRequest>('update/'+postId, request);
    else data = "Nothing"
      console.log(data);
  };

  const handleChange = (data: any) => {
    const id = data.target.id;
    const value = data.target.value;

    setRequest({
      ...request,
      [id]: value,
    });
  };

  return (
    <div>
      <form>
        <input style={{ width: "132px",}} 
        id="title" value={request.title} placeholder="title" onChange={handleChange} />
        <input style={{width: "212px",}}
        id="content" value={request.content} placeholder="content" onChange={handleChange} />
        <button style={{width: "100px",}}
         onClick={handleClick}>{buttonTitle}</button>
      </form>
    </div>
  );
};

export default InputForm;
