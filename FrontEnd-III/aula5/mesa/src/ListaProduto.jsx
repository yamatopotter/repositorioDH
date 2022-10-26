function ListaProduto(lista){
    return (
        <div className='row'>
            {lista.lista.map((item, index) => 
            <div key={index} className="col-3">
                <div className='card'>
                <img src={item.image} alt={item.nome} style={{width: 100}} />
                <h2>{item.nome}</h2>
                <h3>{item.preco}</h3>
                </div>
            </div>)}
        </div>
    )
}

export default ListaProduto;