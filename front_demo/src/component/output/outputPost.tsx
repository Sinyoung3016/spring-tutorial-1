
import Post from '../post';
import { useState } from 'react';
import InputForm from '../input/inputform';

interface PostResponse {
  id: number;
  title: string;
  content: string;
}

interface Props {
  post: PostResponse;
  handleDelete: (deleteId: number) => Promise<void>;
}

const OutputPost: React.FC<Props> = ({post, handleDelete}) => {
  const [ud, setUd] = useState(false);

  const deletePost = () => {
    handleDelete(post.id)
  }

  const updatePost = () => {
    ud ? setUd(false) : setUd(true);
  }

  return (
    <>
    <div style={{display: "flex", margin: "5px"}}>
      <Post post={post}/>
      <button style={{width: "50px"}} onClick={updatePost}>수정</button>
      <button style={{width: "50px"}} onClick={deletePost}>삭제</button>
    </div>
    {ud ? <div style={{display:"flex", alignItems: "center", marginLeft: "35px",}}>
      <InputForm mode="update" buttonTitle="수정하기" postId={post.id}/></div> : ""}
  </>
  );
};

export default OutputPost;
