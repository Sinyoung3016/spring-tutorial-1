
import axios from 'axios';
import { useState, useEffect } from 'react';
import OutputPost from './outputPost'

interface PostResponse {
  id: number;
  title: string;
  content: string;
}

const Output = () => {
  const [posts, setPosts] = useState<PostResponse[]>();

  useEffect(() => {
    getPosts();
  }, []);

  const getPosts = async () => {
    const posts = await axios.get('posts');
      setPosts(posts.data);
      console.log(posts);
  }

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
        (posts.map((post) => {
          return (<OutputPost key={post.id} post={post} handleDelete={handleDelete}/>)
        })) : "Nothing"
      }
    </div>
  );
};

export default Output;
