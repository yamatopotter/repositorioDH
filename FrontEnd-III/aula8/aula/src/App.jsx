import {useState, useRef} from 'react';

const App = () => {
  const inputRef = useRef(null);
  const [valueInput, setValueInput] = useState("") ;
  const [errorInput, setErrorInput] = useState("") ;
  const [nomes, setNomes] = useState([]) ;
  const [isChecked, setIsChecked] = useState(false);

  function handleSubmit(event){
    if (valueInput.trim()){
      setNomes([...nomes, valueInput]);
      setErrorInput("");
      setValueInput("");
      alert("Formulário enviado");
    }
    else{
      setErrorInput("Digite seu nome");
    }
    event.preventDefault();
  }

  return (
    <div style={isChecked ? {background: "blue"} : {}}>
      <h1>{isChecked.toString()}</h1>

      <ul>
        {nomes.map(
          (item)=><li>{item}</li>
        )}
      </ul>

      <form onSubmit={handleSubmit}>
        {/* <input ref={inputRef} /> */}
        <input value={valueInput} onChange={(event)=>setValueInput(event.target.value)}/>
        <p>{errorInput}</p>
        <label>Checked</label>
        <input type="checkbox" value={isChecked} onChange={(event)=>setIsChecked(event.target.checked)}/>
        <input type="submit"/>
      </form>
    </div>
    );

}

export default App
