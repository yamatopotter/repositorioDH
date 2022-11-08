import { useState } from 'react'

const App = () => {

  const [nomes, setNomes] = useState([]);
  const [nomeInput, setNomeInput] = useState("");
  const [errorNome, setErroNome] = useState("");


  function handleForm(e){
    e.preventDefault();


  }

  return (
    <>
      <form onSubmit={handleForm}>
        <label>Nome</label>
        <input type="text" value={nomeInput} onChange={(e) => {setNomeInput(e.target.value)}}/>
        <p>{errorNome}</p>
      </form>
    </>
  )

}

export default App
