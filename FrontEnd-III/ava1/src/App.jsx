import {useState} from 'react'
import Form from './components/Form';
import Card from './components/Card';
import styles from './assets/App.css';

import {getImgBackground, isBackgroundImage} from './utils';

function App() {
  const [cores, setCores] = useState([]);
  const [websiteTheme, setWebsiteTheme] = useState({bgClass: "", bgImage:"", initialStyle: "rgba(239, 239, 239, .7)"});

  const dataToParent = (data) => {
    setCores([...cores,{nomeCor: data.nomeCor, hexadecimal: data.hexadecimal}]);
  };

  const removeCor = (index) => {
    const novasCores = cores.filter((_, i) => i !== index);
    setCores(novasCores);
  };

  const darkMode = () => {
    if(websiteTheme.bgClass == "" || websiteTheme.bgClass == "lightMode"){
      setWebsiteTheme({...websiteTheme, bgClass: 'darkMode', initialStyle: ""});
    }
    else{
      setWebsiteTheme({...websiteTheme, bgClass: 'lightMode'});
    }
  }

  const randonBg = async () => {  
    const link = await getImgBackground();
    setWebsiteTheme({...websiteTheme, bgImage: link});
  }

  const removeBgBtn = () => {
    setWebsiteTheme({...websiteTheme, bgImage: ""});
  }

  return (
    <div className="backgroundImg" style={{background:`url(${websiteTheme.bgImage}) no-repeat center center/cover`}}>
      <div className={"background "+websiteTheme.bgClass} style={{backgroundColor: websiteTheme.initialStyle}}>
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

          <span className={(websiteTheme.bgImage) ? 'removeBgBtn' : 'd-none'} onClick={removeBgBtn}><i className="fa-regular fa-image"></i></span>
          <span className='randonBgBtn' onClick={randonBg}><i className="fa-regular fa-image"></i></span>
          <span className='darkModeBtn' onClick={darkMode}><i className="fa-solid fa-moon"></i></span>
        </div>
      </div>
    </div>
  );
}

export default App
