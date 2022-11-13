import styles from './styles.css';
import {useState, useEffect} from 'react'

const Card = ({nomeCor, hexaCor, index, removeCor, chave}) =>{
    const [cardAnimation, setCardAnimation] = useState("animate__zoomIn");

    function deleteCardWithAnimation(){
        setCardAnimation("animate__zoomOut");
        setTimeout(()=>{
            removeCor(chave);
            setCardAnimation("");
        }, 500);
        
    }

    return (
        <div className={"grid-20 mobile-grid-50 tablet-grid-33 animate__animated "+cardAnimation} key={index}>
            <div className="card-cor" style={{backgroundColor: hexaCor}}>
                
            </div>
            
            <div className="text">
                <div className="grid-100 grid-parent text-holder">
                    <div className="grid-80">
                        <p>{nomeCor}</p>
                        <p>{hexaCor}</p>
                    </div>
                    <div className="grid-20 delete-icon">
                        <span onClick={deleteCardWithAnimation} className="delete-btn"><i className="fa-solid fa-trash"></i></span>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Card;