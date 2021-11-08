function podeSubir(altura, acompanhada){
    let resposta = false;
    
    if(altura>=1.40 && altura<2.0){
        console.log("Acesso autorizado");
        resposta = true;
    }
    else if(altura<1.40 && altura>1.2){
        if(acompanhada){
            console.log("Acesso autorizado somente com acompanhante");
            resposta = true;
        }else{
            console.log("Acesso negado");
            resposta = false;
        }
    }
    else{
        console.log("Acesso negado");
        resposta = false;
    }

    return resposta;
}