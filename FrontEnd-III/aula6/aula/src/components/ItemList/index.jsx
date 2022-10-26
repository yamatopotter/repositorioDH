import styles from './styles.module.css';

const ItemList = ({item}) => {
    const {modelo, marca, descricao, img} = item;

    return (
        <li className={styles.item_list}>
            <h2>{modelo}</h2>
            <h3>{marca}</h3>
            <p>{descricao}</p>
            <img src={img} style={{width: '400px'}}/>
        </li>
    )
}

export default ItemList;