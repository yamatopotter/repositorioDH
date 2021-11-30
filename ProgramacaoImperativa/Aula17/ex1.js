let par = [2,4,6,8,10,12];
let impar = par.map(function(num){
    return num+1;
});

console.log(impar);

let nomes = ['André', 'Maria', 'Jão', 'Marcão', 'Tonhão', 'Maria'];
let nomePesquisa = nomes.filter(function(nome){
    return nome == 'Maria';
})

console.log(nomePesquisa);

let numeros = [1, 5, 9, 8, 10, 0];
let numFormatados = numeros.reduce(function(acc, num){
    return acc+"-"+num;
})

console.log(numFormatados);

let animal =['vaca', 'cachorro', 'papagaio', 'gato'];
animal.forEach(function(a){
    console.log("O animal é "+a);
});