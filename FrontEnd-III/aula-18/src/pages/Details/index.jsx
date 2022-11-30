import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import api from "../../services/api";


const Details = () => {
    const {id} = useParams();
    const [produto, setProduto] = useState({});

    useEffect(() => {getProduct();}, []);

    async function getProduct(){
        try{
            const response = await api(`/products/${id}`);
            setProduto(response.data);
        }
        catch(error){
            alert(error)
        }
    }

    if(!produto){
        return <div>Produto não encontrado</div>;
    }

    return (
        <div>
            <h1>{produto.name}</h1>
            <p>{produto.price}</p>
            <img src={produto.image}/>
            <p>{produto.manufacturer}</p>
            <p>{produto.description}</p>
        </div>
    );
};

export default Details;