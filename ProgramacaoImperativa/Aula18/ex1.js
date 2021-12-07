// ex1
function loopDePares(num) {
    for (i = 0; i <= 100; i++) {
        if ((i + num) % 2 == 0) {
            console.log("O número " + (i + num) + "é par");
        } else {
            console.log(i);
        }
    }
}

// ex2
function loopDeImpares(num, palavra) {
    for (i = 0; i <= 100; i++) {
        if ((i + num) % 2 == 1) {
            console.log(palavra);
        } else {
            console.log(i);
        }
    }
}

// ex3
function soma(num) {
    let result = 0;

    for (let i = num; i > 0; i--) {
        result += i;
    }

    return result;
}

//ex4
function newArray(num) {
    let array = [];

    for (let i = 1; i <= num; i++) {
        array.push(i);
    }

    return array;
}

// ex5
function split(palavra) {
    let arrayPalavra = []
    for (let i = 0; i < palavra.length; i++) {
        arrayPalavra.push(palavra[i]);
    }

    return arrayPalavra;
}

// ex6
function moverZeros(array) {

    for (let i = 0; i < array.length; i++) {
        if (array[i] === 0) {
            // aux = array[i]; 
            array.splice(i, 1);
            array.push(0);
            // arrayZero.push(aux);
        }
    }

    return array;
}

// 

console.log(moverZeros([5,3,6,89,45,2,7,6,45,0,45,0,7,65,0,4,8,0,12,2,0]));