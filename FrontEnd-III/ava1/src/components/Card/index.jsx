import styles from './styles.css';

const Card = ({nomeCor, hexaCor, index, removeCor, chave}) =>{
    return (
        <div className="grid-20 mobile-grid-50 tablet-grid-33 animate__animated animate__zoomIn" key={index}>
            <div className="card-cor" style={{backgroundColor: hexaCor}}>
                
            </div>
            
            <div className="text">
                <div className="grid-100 grid-parent text-holder">
                    <div className="grid-80">
                        <p>{nomeCor}</p>
                        <p>{hexaCor}</p>
                    </div>
                    <div className="grid-20 delete-icon">
                        <span onClick={() => {removeCor(chave)}}><i className="fa-solid fa-trash"></i></span>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Card;