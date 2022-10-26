import Container from "./Container";
import ListWrapper from "./ListWrapper";

function App() {
  return (
    <>
      <h1>Hellow</h1>
      <Container>
        <p>Esse aqui é um texto de children</p>

        <ListWrapper />
      </Container>
    </>
  );
}

export default App
