interface PostResponse {
  id: number;
  title: string;
  content: string;
}

interface Props {
  post: PostResponse
};

const Post: React.FC<Props> = ({post}) => {

  return (
    <div style={{display: "flex", width: "400px"}}>
        <div style={{width: "30px"}}>{post.id}</div>
        <div style={{width: "140px" , backgroundColor: "lavender"}}>{post.title}</div>
        <div style={{width: "220px", backgroundColor: "lavender"}}>{post.content}</div>
    </div>
  );
};

export default Post;
