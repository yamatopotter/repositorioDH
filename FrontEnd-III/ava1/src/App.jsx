import {useState} from 'react'
import Form from './components/Form';
import Card from './components/Card';
import styles from './assets/App.css';

function App() {
  const [cores, setCores] = useState([]);

  const dataToParent = (data) => {
    console.log(data);
    setCores([...cores,{nomeCor: data.nomeCor, hexadecimal: data.hexadecimal}]);
  }

  return (
    <div className="grid-container">

      <div className="grid-100">
        <h1 className="title">Favoritos de Cores</h1>
      </div>
      
      <div className="grid-100 div-form">
        <Form dataToParent={dataToParent}/>
      </div>
      
      <div className="grid-100 list-card grid-parent">
        <div className="grid-100">
          <h2 className='subtitle'>Cores Favoritas</h2>
        </div>

        {cores.map((card, index)=>{
          return(
            <Card nomeCor={card.nomeCor} hexaCor={card.hexadecimal} key={index}/>
          );
        })}
      </div>

      <span className='dark-mode'>dark</span>
    </div>
  );
}

export default App
