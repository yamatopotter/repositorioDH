import {useState, useCallback} from 'react';

function App() {
  const [name, setName] = useState("");
  const handleName = useCallback((event) => setName(event.target.value), []);  

  return (
    <div>
      <input type="text" value={name} onChange={(event) => handleName(event)} />
    </div>
  );
}

export default App;
