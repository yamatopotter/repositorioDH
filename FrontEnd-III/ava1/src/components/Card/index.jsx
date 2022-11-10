import styles from './styles.css';

const Card = ({nomeCor, hexaCor, index}) =>{
    return (
        <div className="grid-20" key={index}>
            <div className="card-cor" style={{backgroundColor: hexaCor}}>
                <div className="text">
                    <p>{nomeCor}</p>
                    <p>{hexaCor}</p>
                </div>
            </div>
        </div>
    );
}

export default Card;