// function showMenu(){
//     console.log("------MENU-------")
//     console.log("1 - Pipoca")
//     console.log("2 - Macarrão")
//     console.log("3 - Carne")
//     console.log("4 - Feijão")
//     console.log("5 - Brigadeiro")
// }

const pipoca = 10;
const macarrao = 8;
const carne = 15;
const feijao = 12;
const brigadeiro = 8;

function analiseTempo(tempoPadrao, tempoInserido){
    if(tempoInserido<tempoPadrao){
        console.log("Tempo insuficiente");
    }
    else if(tempoInserido>=tempoPadrao*2 && tempoInserido < tempoPadrao*3){
        console.log("Prato queimou");
    }
    else if(tempoInserido>=tempoPadrao*3){
        console.log("Kabuuuum!");
    }
    else{
        console.log("Prato pronto. Bom apetite!");
    }
}

function microondasIf(alimento, tempo){
    if(alimento==1){
        console.log("Opção escolhida - Pipoca");
        analiseTempo(pipoca, tempo);
    }
    else if(alimento==2){
        console.log("Opção escolhida - Macarrão");
        analiseTempo(macarrao, tempo);
    }
    else if(alimento==3){
        console.log("Opção escolhida - Carne");
        analiseTempo(carne, tempo);
    }
    else if(alimento==4){
        console.log("Opção escolhida - Feijão");
        analiseTempo(feijao, tempo);
    }
    else if(alimento==5){
        console.log("Opção escolhida - Brigadeiro");
        analiseTempo(brigadeiro, tempo);
    }
    else{
        console.log("Prato Inexistente.")
    }

}


function microondasSwitch(alimento, tempo){
    switch (alimento){
        case 1:
            console.log("Opção escolhida - Pipoca");
            if(tempo<10){
                console.log("Tempo insuficiente")
            }
            else if(tempo>19 && tempo < 30){
                console.log("Prato queimou")
            }
            else if(tempo>=30){
                console.log("Kabuuuum!")
            }
            else{
                console.log("Prato pronto. Bom apetite!")
            }
            break;
        case 2:
            console.log("Opção escolhida - Macarrão");
            if(tempo<8){
                console.log("Tempo insuficiente")
            }
            else if(tempo>15 && tempo < 23){
                console.log("Prato queimou")
            }
            else if(tempo>=24){
                console.log("Kabuuuum!")
            }
            else{
                console.log("Prato pronto. Bom apetite!")
            }
            break;
        case 3:
            console.log("Opção escolhida - Carne");
            if(tempo<15){
                console.log("Tempo insuficiente")
            }
            else if(tempo>29 && tempo < 45){
                console.log("Prato queimou")
            }
            else if(tempo>=45){
                console.log("Kabuuuum!")
            }
            else{
                console.log("Prato pronto. Bom apetite!")
            }
            break;
        case 4:
            console.log("Opção escolhida - Feijão");
            if(tempo<12){
                console.log("Tempo insuficiente")
            }
            else if(tempo>23 && tempo < 36){
                console.log("Prato queimou")
            }
            else if(tempo>=36){
                console.log("Kabuuuum!")
            }
            else{
                console.log("Prato pronto. Bom apetite!")
            }
            break;
        case 5:
            console.log("Opção escolhida - Brigadeiro");
            if(tempo<8){
                console.log("Tempo insuficiente")
            }
            else if(tempo>15 && tempo < 23){
                console.log("Prato queimou")
            }
            else if(tempo>=24){
                console.log("Kabuuuum!")
            }
            else{
                console.log("Prato pronto. Bom apetite!")
            }
            break;
        default:
            console.log("Prato Inexistente");
    }
}

microondasSwitch(1, 8);
microondasIf(1, 8);
microondasSwitch(3, 40);
microondasIf(3, 40);
