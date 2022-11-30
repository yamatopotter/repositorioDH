import {useState, useEffect} from "react";
import axios from "axios";

const App = () => {
const [posts, setPosts] = useState([]);

  async function getDataByServer(){
    // const response = fetch("https://jsonplaceholder.typicode.com/posts");
    // const data = await response.json();
    // console.log(data);

    const response = await axios.get("https://jsonplaceholder.typicode.com/posts");
    const data = await response.json();
    console.log(data);

  }

  useEffect(() => {
    getDataByServer();
  }, []);


  return (
    <div>
      <button onClick={getDataByServer}>Buscar dados</button>
    </div>
  )
}

export default App
