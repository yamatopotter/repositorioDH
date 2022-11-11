import {useState} from 'react';
import {isHexaValido} from '../../utils';
import styles from './styles.css';

const Form = ({dataToParent}) => {
    const [formData, setFormData] = useState({nomeCor: "", errorCor: false, hexadecimal: "", errorHexa: false});

    function salvarCor(event){
        event.preventDefault();
    
        if(formData.nomeCor.length>3) {
            if(isHexaValido(formData.hexadecimal)){
                (formData.hexadecimal.length > 6) ? dataToParent({nomeCor:formData.nomeCor, hexadecimal: formData.hexadecimal}) : dataToParent({nomeCor:formData.nomeCor, hexadecimal: `#${formData.hexadecimal}`});   
                setFormData({...formData, nomeCor: "", hexadecimal: ""});
            }
            else{
                setFormData({...formData, errorHexa: true})
            }
        }
        else{
            setFormData({...formData, errorCor: true, errorHexa: isHexaValido(formData.hexadecimal) ? false : true})
        }
    }
      

    return (
        <form onSubmit={salvarCor}>
            <h2 className="subtitle">Adicionar nova cor</h2>

            <div className="grid-40">
                <input 
                    type="text" 
                    name="nomeCor"
                    value={formData.nomeCor} 
                    onChange={ 
                        (event) => {
                            setFormData({...formData, nomeCor: event.target.value, errorCor: false});
                        }
                    }
                    placeholder="Nome da cor"
                    className={(formData.errorCor) ? "animate__animated animate__shakeX error-input" : "" }
                />
                {(formData.errorCor) ? <span className="error-message">Inserir um nome com mais de 3 letras</span> : ""}
            </div>

            <div className="grid-40">
                <input
                    type="text"
                    placeholder="Insira sua cor em Hexadecimal"
                    value={formData.hexadecimal}
                    onChange={
                        (event) => {
                            setFormData({...formData, hexadecimal: event.target.value, errorHexa:false});
                        }
                    } 
                    // style={isHexaValido(formData.hexadecimal) ? {border: "1px solid green"} : {border: "1px solid red"}}
                    className={ (formData.errorHexa) ? "animate__animated animate__shakeX error-input" : "" }
                />
                {(formData.errorHexa) ? <span className="error-message">Cor hexa inválida. Verifique se a cor está correta</span> : ""}
            </div>

            <div className="grid-20">
                <input type="submit" value="Adicionar cor" className={((formData.errorCor) || (formData.errorHexa)) ? "error-input" : "normal-input"}/>
            </div>
        </form>
    )
}

export default Form;