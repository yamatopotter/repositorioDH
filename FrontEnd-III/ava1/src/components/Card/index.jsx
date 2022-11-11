import styles from './styles.css';

const Card = ({nomeCor, hexaCor, index}) =>{
    return (
        <div className="grid-20 animate__animated animate__zoomIn" key={index}>
            <div className="card-cor" style={{backgroundColor: hexaCor}}>
                
            </div>
            
            <div className="text">
                <p>{nomeCor}</p>
                <p>{hexaCor}</p>
            </div>
        </div>
    );
}

export default Card;