// Parte 1

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

// Parte 2

// Função construtora para os espectadores
function Espectador(idade, opiniao) {
    this.idade = idade,
    this.opiniao = opiniao
};

// Função que faz a média de idade dos espectadores com nota 1 (ótimo)
function mediaNotaOtimo(array){
    let result = 0;
    let a = array.filter((e)=>{
        return e.opiniao == 3
    });

    a.forEach(e => {
        result +=e.idade     
    });

    return (result/a.length).toFixed(0);
}

// Retorna a quantidade de pessoas que deram um tipo de nota (1, 2 ou 3)
function qtdPessoasResposta(array, resposta){
    let a = array.filter((e)=>{
        return e.opiniao == resposta
    });

    return a.length;
}

// Retorna a porcentagem de pessoas que deram um tipo de nota (1, 2 ou 3)
function porcentagemNotas(totalPessoas, quantidadeNota){
    return (quantidadeNota*100/totalPessoas).toFixed(2);
}

let espectadores = [];
espectadores.push(new Espectador(18, 2));
espectadores.push(new Espectador(25, 1));
espectadores.push(new Espectador(41, 3));
espectadores.push(new Espectador(32, 3));
espectadores.push(new Espectador(19, 3));
espectadores.push(new Espectador(23, 2));
espectadores.push(new Espectador(29, 2));
espectadores.push(new Espectador(38, 1));
espectadores.push(new Espectador(31, 1));
espectadores.push(new Espectador(27, 3));
espectadores.push(new Espectador(62, 3));
espectadores.push(new Espectador(12, 2));
espectadores.push(new Espectador(19, 1));
espectadores.push(new Espectador(35, 1));
espectadores.push(new Espectador(35, 1));

console.log("Média da idade dos espectadores que votaram ótimo: "+mediaNotaOtimo(espectadores));
console.log("Quantidade de espectadores que responderam regular: "+qtdPessoasResposta(espectadores, 1));
console.log(porcentagemNotas(espectadores.length, qtdPessoasResposta(espectadores, 2))+"% votaram que o filme é Bom.");