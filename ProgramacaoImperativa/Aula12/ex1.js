const alice = [23, 82, 46];
const bob = [45, 8, 32];
const texto = ["M", "a", "t", "h", "e", "u", "s"];

function encontrarGanhador(a, b){
    let p1 = 0;
    let p2 = 0;

    for(let i=0; i<a.length;i++){
        if(a[i]>b[i]){
            p1 += 1;
        }
        else{
            p2+=1;
        }
    }

    if(p1>p2){
        return ("O primeiro participante");
    }
    else if(p1<p2){
        return ("O segundo participante");
    }
    else{
        return ("Ninguém, houve empate");
    }
}

function digitalHouse(a, b){
    for(let i = 1; i<=100; i++){
        if((i%a==0) && (i%b==0)){
            console.log("Digital House");
        }
        else if(i%a==0){
            console.log("Digital");
        }
        else if(i%b==0){
            console.log("House");
        }
    }

    return "";
}

function somaArray(array){
    let soma = 0;
    
    for(let i=0; i<array.length; i++){
        soma += array[i];
    }

    return soma;
}

function join(array){
    let texto = "";
    
    for(let i=0; i<array.length; i++){
        texto += array[i];
    }

    return texto;
}

console.log("O ganhador é: "+encontrarGanhador(alice, bob));
console.log(digitalHouse(5,9));
console.log(somaArray(bob));
console.log(join(texto));
