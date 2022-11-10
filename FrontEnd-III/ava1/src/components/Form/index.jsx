import {useState} from 'react';
import {isHexaValido} from '../../utils';

const Form = ({dataToParent}) => {
    const [formData, setFormData] = useState({nomeCor: "", hexadecimal: ""});

    function salvarCor(event){
        event.preventDefault();
    
        if(formData.nomeCor.length>0) {
            if(isHexaValido(formData.hexadecimal)){
                (formData.hexadecimal.length > 6) ? dataToParent({nomeCor:formData.nomeCor, hexadecimal: formData.hexadecimal}) : dataToParent({nomeCor:formData.nomeCor, hexadecimal: `#${formData.hexadecimal}`});
            }
            else{
                alert("O hexadecimal é inválido");
            }
        }
        else{
            alert("O nome da cor não pode ser vazio");
        }
    }
      

    return (
        <div className="grid-20">
            <form onSubmit={salvarCor}>
                <h1>Adicionar nova cor</h1>
                <div className="grid-100">
                <label htmlFor="nomeCor">Nome</label>
                <input type="text" name="nomeCor" value={formData.nomeCor} onChange={ (event) => {setFormData({...formData, nomeCor: event.target.value});}} />
                </div>
                <div className="grid-100">
                <label htmlFor="nomeCor">Cor</label>
                <input type="text" placeholder="Insira sua cor em Hexadecimal" value={formData.hexadecimal} onChange={ (event) => {setFormData({...formData, hexadecimal: event.target.value});} } 
                style={isHexaValido(formData.hexadecimal) ? {background: "green"} : {background: "red"}}/>
                </div>

                <div className="grid-100">
                <input type="submit" value="Adicionar cor"/>
                </div>
            </form>
      </div>
    )
}

export default Form;