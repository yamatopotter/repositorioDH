let filmes = ["star wars", "matrix",  "mr. robot", "o preço do amanhã",  "a vida é bela"];
let animacoes = ["Toy Story", "Procurando Nemo", "Kung-fu Panda", "Wally", "Fortnite"];

animacoes.pop();

const asiaScores = [8, 10, 6, 9, 10, 6, 6, 8, 4];
const euroScores = [8, 10, 6, 8, 10, 6, 7, 9, 5];

function convertToUpper(filmes){
    for(let i=0; i<filmes.length; i++){
        filmes[i] = filmes[i].toUpperCase();
    }

    return filmes;
}

function passarElementos(filmes, array2){
    while(array2.length>0){
        filmes.push(array2.pop().toUpperCase());
    }

    return filmes;
}

function compararNotas(continente1, continente2){
    let notasComparadas = []

    for(let i=0; i<continente1.length; i++){
        notasComparadas[i] = continente1[i] == continente2[i];
    }

    return notasComparadas;
}

filmes = passarElementos(filmes, animacoes)
console.log(filmes);
console.log("----------")
console.log(animacoes);
console.log(compararNotas(euroScores, asiaScores));