import Button from "./Button";
import Title from "./Title";

function App() {
  function alertBtn1(){
    alert("btn 1");
  }

  function alertBtn2(){
    alert("btn 2");
  }

  function alertBtn3(){
    alert("btn 3");
  }

  return (
    <>
      <Title text="Meu título"/>
      <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Atque modi quia iure tenetur minus cumque at, pariatur aliquid praesentium fuga!</p>
      <Button name="Pressione" classes="btn btn-success" click={alertBtn1}/>
      <Button name="Pressione" classes="btn btn-warning" click={alertBtn2}/>
      <Button name="Pressione" classes="btn btn-primary" click={alertBtn3}/>
    </>
  );
}

export default App
