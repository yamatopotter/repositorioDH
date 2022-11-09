const Form = () => {
    return (
        <form>
            <h1>Adicionar nova cor</h1>
            <div className="grid-100">
                <label for="nomeCor">Nome</label>
                <input type="text"></input>
            </div>
            <div className="grid-100">
                <label for="nomeCor">Cor</label>
                <input type="text" placeholder="Insira sua cor em Hexadecimal"></input>
            </div>
        </form>
    )
}

export default Form;