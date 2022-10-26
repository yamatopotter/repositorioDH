const itens=[
    {
        id: 0,
        name: "nome 1"
    },
    {
        id: 1,
        name: "nome 2"
    },
    {
        id: 2,
        name: "nome 3"
    },
    {
        id: 3,
        name: "nome 4"
    },
    {
        id: 4,
        name: "nome 5"
    }
]

function ListWrapper(){
    return (
        <ul>
            {itens.map((item)=><li>{item.id} - {item.name}</li>)}
        </ul>
    )
}

export default ListWrapper;