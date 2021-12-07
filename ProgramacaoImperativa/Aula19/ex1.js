function Pessoa(nome, sexo, altura) {
    this.nome = nome,
    this.sexo = sexo,
    this.altura = altura
};

function mediaAlturaMulher(array){
    let result = 0;
    let a = array.filter((e)=>{
        return e.sexo == "F"
    });
    
    a.forEach(e => {
        result +=e.altura     
    });

    return (result/a.length).toFixed(2);
}

function quantidadePorSexo(array, sexo){
    let a = array.filter((e)=>{
        return e.sexo == sexo
    });

    return a.length;
}

let pessoas = [];

pessoas.push(new Pessoa("Rafael Vasconcelos", "M", 1.82));
pessoas.push(new Pessoa("Beatriz Esponton", "F", 1.70));
pessoas.push(new Pessoa("Alexandre Vasconcelos", "M", 1.35));
pessoas.push(new Pessoa("Kerli Vasconcelos", "F", 1.62));
pessoas.push(new Pessoa("Gael Vasconcelos", "M", 1.12));
pessoas.push(new Pessoa("Jorge Pinheiro", "M", 1.74));
pessoas.push(new Pessoa("Antonia Benedita", "F", 1.48));
pessoas.push(new Pessoa("Felipe Fraga", "M", 1.82));
pessoas.push(new Pessoa("Carolina Ribeiro", "F", 1.92));
pessoas.push(new Pessoa("Rita Lee", "F", 1.56));
pessoas.push(new Pessoa("Jhonny Boy", "M", 1.87));
pessoas.push(new Pessoa("Tabata Batata", "F", 1.42));
pessoas.push(new Pessoa("Luizinho Linguiça", "M", 1.94));
pessoas.push(new Pessoa("Maga Maravilha", "F", 2.04));
pessoas.push(new Pessoa("Gato Lindomar", "M", 1.65));

pessoas.sort(
    function (a,b){
        if(a.altura > b.altura){
            return 1;
        }
        if(a.altura < b.altura){
            return -1;
        }
        return 0;
    }
);

console.log("Pessoa com menor altura: "+pessoas[0].nome);
console.log("Pessoa com maior altura: "+pessoas[pessoas.length-1].nome);
console.log("Média de altura de Mulheres: "+mediaAlturaMulher(pessoas));
console.log("Quantidade de homens: "+quantidadePorSexo(pessoas, "M"));