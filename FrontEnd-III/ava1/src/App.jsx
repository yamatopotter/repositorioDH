import {useState} from 'react'
import Form from './components/Form';
import Card from './components/Card';
import styles from './assets/App.css';

import {getImgBackground, setSystemBackgroundImage} from './utils';

function App() {
  const [cores, setCores] = useState([]);
  const [darkModeTheme, setDarkModeTheme] = useState(true);
  const [backgroundImage, setBackgroundImage] = useState("");

  const dataToParent = (data) => {
    setCores([...cores,{nomeCor: data.nomeCor, hexadecimal: data.hexadecimal}]);
  };

  const removeCor = (index) => {
    const novasCores = cores.filter((_, i) => i !== index);
    setCores(novasCores);
  };

  
  const darkMode = () => {
    if(darkModeTheme){
      document.body.classList.contains("lightMode") ? document.body.classList.replace('lightMode', 'darkMode') : document.body.classList.add('darkMode');
      setDarkModeTheme(false);
      console.log("Dark Mode")
    }
    else{
      document.body.classList.replace('darkMode', 'lightMode');
      setDarkModeTheme(true);
      console.log("Light Mode")
    }
  }

  const randonBg = async () => {
    // let linkImg;

    // fetch(`https://source.unsplash.com/1600x900/`).
    // then((response)=> {
    //     linkImg = response.url; 
    // });

    // console.log(linkImg);
    
    const link = await getImgBackground();
    setBackgroundImage(link);
    console.log(backgroundImage);
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
            <Card nomeCor={card.nomeCor} hexaCor={card.hexadecimal} key={index} removeCor={removeCor} chave={index}/>
          );
        })}
      </div>

      <span className='randonBgBtn' onClick={randonBg}><i className="fa-regular fa-image"></i></span>
      <span className='darkModeBtn' onClick={darkMode}><i className="fa-solid fa-moon"></i></span>
    </div>
  );
}

export default App
