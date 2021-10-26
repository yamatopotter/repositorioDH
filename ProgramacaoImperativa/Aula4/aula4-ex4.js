// Calculo de IMC

//As variavel que pode armazenar o valor null é o Plano, pois se for nulo indica que a pessoa não tem.

let nome = "José";
let sobrenome = "da Silva";
let idade = 27;
let peso = 83.5;
let altura = 1.70;
let plano = true;

let imc = peso / (altura*altura);
let classificacao;

if (imc<18.5){
    classificacao = "magreza";
}
else if(imc<25){
    classificacao = "normal";
}
else if(imc<30){
    classificacao = "sobrepeso"
}
else if(imc<40){
    classificacao = "obesidade"
}
else{
    classificacao = "obesidade grave"
}

console.log(nome+" "+sobrenome+" tem "+idade+" anos e seu índice de massa corporal é de "+imc.toFixed(2)+", sendo classificado pelo IMC como: "+classificacao);