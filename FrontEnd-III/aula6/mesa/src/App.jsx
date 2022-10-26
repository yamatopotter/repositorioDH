import './App.css'
import React from 'react'
import ListItem from './components/ListItem';

import { cities } from "./mock/Cidades";

function App() {

  return (
    <div className="App">
      {cities.map( (cidade, index) => {
         if (cidade.country=='BRA') {return <ListItem key={index} cidade={cidade}/>}
        })}
    </div>
  )
}

export default App