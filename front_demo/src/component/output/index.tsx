
import axios from 'axios';
import OutputPost from './outputPost'
import { useContactCardContext, PostResponse } from '../../context/PostContext';

const Output = () => {
  const { posts, getPosts }: any = useContactCardContext();

  const handleDelete = async (deleteId: number) => {
    const data = await axios.delete<String>('delete/'+deleteId);
    getPosts();
    console.log(data);
  };

  return (
    <div style={{
      border: "1px solid",
      width: "500px",
      height: "448px",
    }}>
      {posts ?
        (posts.map((post: PostResponse) => {
          return (<OutputPost key={post.id} post={post} handleDelete={handleDelete}/>)
        })) : "Nothing"
      }
    </div>
  );
};

export default Output;
