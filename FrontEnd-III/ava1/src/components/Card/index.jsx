import styles from './styles.scss';

const Card = ({nomeCor, hexaCor, index, removeCor, chave}) =>{

    function deleteCard(i){
        removeCor(i);
    }

    return (
        <div className="grid-20 mobile-grid-50 tablet-grid-33 animate__animated animate__zoomIn" key={index}>
            <div className="card-cor" style={{backgroundColor: hexaCor}}>
                
            </div>
            
            <div className="text">
                <p>{nomeCor}</p>
                <p>{hexaCor}</p>
                <span onClick={() => {removeCor(chave)}}><i className="fa-solid fa-trash"></i></span>
            </div>
        </div>
    );
}

export default Card;