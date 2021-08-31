import React, {
    useContext,
    useEffect,
    createContext,
    useState,
    ReactChild,
    ReactChildren,
    ReactElement,
  } from 'react';
  import axios from 'axios';
  
  export interface PostResponse {
    id: number;
    title: string;
    content: string;
  }
  
  const PostContext = createContext<Record<string, unknown>>({});
  
  const PostProvider = ({
    children,
  }: {
    children?: ReactChild | ReactChildren | ReactChildren[] | ReactChild[];
  }): ReactElement => {
    const [posts, setPosts] = useState<PostResponse[]>([]);
  
    useEffect(() => {
        (async() => {
            const getPosts = await axios.get('posts');
            setPosts(getPosts.data);
        })();
      }, []);

    const getPosts = async () => {
        const getPosts = await axios.get('posts');
        setPosts(getPosts.data);
        console.log(posts);
      }

    return (
      <PostContext.Provider
        value={{
            posts,
            setPosts,
            getPosts
        }}
      >
        {children}
      </PostContext.Provider>
    );
  };
  
  export const useContactCardContext = () => useContext(PostContext);
  
  export default PostProvider;