import {useState} from 'react'
import Form from './components/Form';
import Card from './components/Card';

function App() {
  const [cores, setCores] = useState([]);

  const dataToParent = (data) => {
    console.log(data);
    setCores([...cores,{nomeCor: data.nomeCor, hexadecimal: data.hexadecimal}]);
  }

  return (
    <div className="grid-container">

      <div className="grid-100">
        <h1>Favoritos de Cores</h1>
      </div>

      <Form dataToParent={dataToParent}/>

      {/* Criar função para exibir diversos cards  */}

      <ul>
        {cores.map((card, index)=>{
          return(
            <Card nomeCor={card.nomeCor} hexaCor={card.hexadecimal} key={index}/>
          );
        })}
      </ul>
    </div>
  );
}

export default App
