import { useState } from "react";
import "./styles.css";

function App() {
  const [disciplinaBd, setdisciplinaBd] = useState({quantidadeAlunos:0, mediaAlunos:0});
  const [disciplinaFront, setdisciplinaFront] = useState({quantidadeAlunos:0, mediaAlunos:0});
  const [disciplinaBack, setdisciplinaBack] = useState({quantidadeAlunos:0, mediaAlunos:0});
  const [formData, setFormData] = useState({disciplina:"", notaAluno:0});

  function handleSubmit(event) {
    event.preventDefault();

    if(formData.disciplina != "devops") {
      switch(formData.disciplina){
        case "database":
          addToDatabase();
        case "backend":
          addToBackend();
        case "frontend":
          addToFrontend();
      }
    }
  }

  function addToDatabase() {
    const quantidadeAlunos = disciplinaBd.quantidadeAlunos;
    const mediaAlunos = disciplinaBd.mediaAlunos;
    const notaAluno = formData.notaAluno

    setdisciplinaBd({...formData, quantidadeAlunos: quantidadeAlunos+1, mediaAlunos: (mediaAlunos*quantidadeAlunos+notaAluno)/quantidadeAlunos+1})
  }

  function addToBackend() {
    const quantidadeAlunos = disciplinaBd.quantidadeAlunos;
    const mediaAlunos = disciplinaBd.mediaAlunos;
    const notaAluno = formData.notaAluno

    setdisciplinaBd({...formData, quantidadeAlunos: quantidadeAlunos+1, mediaAlunos: (mediaAlunos*quantidadeAlunos+notaAluno)/quantidadeAlunos+1})
  }

  function addToFrontend() {
    const quantidadeAlunos = disciplinaBd.quantidadeAlunos;
    const mediaAlunos = disciplinaBd.mediaAlunos;
    const notaAluno = formData.notaAluno

    setdisciplinaBd({...formData, quantidadeAlunos: quantidadeAlunos+1, mediaAlunos: (mediaAlunos*quantidadeAlunos+notaAluno)/quantidadeAlunos+1})
  }

  return (
    <div className="container">
      <h1>Média de Alunos por Disciplina</h1>
      <form className="form" onSubmit={handleSubmit}>
        <div className="container_input">
          <select value={formData.disciplina} onChange={(event) => setFormData({...formData, disciplina: event.target.value})}>
            <option selected disabled>
              Selecione uma disciplina
            </option>
            <option value="database">Banco de Dados</option>
            <option value="backend">Desenvolvimento Backend</option>
            <option value="frontend">Desenvolvimento Frontend</option>
            <option value="devops">Devops</option>
          </select>
          <input />
        </div>
        <input type="submit" value="Salvar" />
      </form>

      <div className="container">
        <table border="1" className="line_title">
          <thead>
            <tr>
              <th>Disciplina</th>
              <th>Quantidade de Alunos</th>
              <th>Média das notas dos alunos</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>Banco de Dados</td>
              <td>{disciplinaBd.quantidadeAlunos}</td>
              <td>{disciplinaBd.mediaAlunos}</td>
            </tr>

            <tr>
              <td>Desenvolvimento Frontend</td>
              <td>{disciplinaFront.quantidadeAlunos}</td>
              <td>{disciplinaFront.mediaAlunos}</td>
            </tr>

            <tr>
              <td>Desenolvimento Backend</td>
              <td>{disciplinaBack.quantidadeAlunos}</td>
              <td>{disciplinaBack.mediaAlunos}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default App;