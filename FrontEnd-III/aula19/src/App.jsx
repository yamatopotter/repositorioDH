import './App.css'
import React, { useState } from 'react'
import Navbar from './components/Navbar';
import Body from './components/Body';
import LanguageContext, { languages } from './context';

function App() {

  const [language, setLanguage] = useState({});

  const handleChangeLA = () => {
    setLanguage(() => {
      //DICA: Função que troca um idioma por outro (ao clicar no botão)
      if(language.id == "EN"){
        setLanguage(languages.portuguese);
      }
      else if(language.id == "PT"){
        setLanguage(languages.spanish);
      }
      else{
        setLanguage(languages.english);
      }
    })
  }

  return (
    <LanguageContext.Provider>
      <div className="App">
          
        <Navbar handleChangeLA={handleChangeLA} />
        <Body />
          
      </div>
    </LanguageContext.Provider>   
  )
}

export default App