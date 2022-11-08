import {useState} from "react";

const App = () => {
  const [numero, setNumero] = useState(0);

  const handleButton = () => { setNumero(numero+1); }

  return (
    <div>
      <h1>{numero}</h1>  
      <button onClick={handleButton}>Aperte</button>
    </div>);
};

export default App;
