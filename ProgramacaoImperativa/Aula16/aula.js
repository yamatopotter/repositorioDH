let bemVindo = () => 'Olá Mundo!';

let dobro = numero => numero*2;

let soma = (a,b) => a+b;

let horaAtual = () => {
    let data = new Date();
    return data.getHours() + ':' + data.getMinutes();
}

setTimeout(function(){
    console.log('Olá Mundo')
}, 1000)