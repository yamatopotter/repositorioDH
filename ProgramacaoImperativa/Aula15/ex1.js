let dados = require("./module/data");

function conta(num, tipo, saldo, titular){
    this.numConta = num,
    this.tipoConta = tipo,
    this.saldoConta = saldo,
    this.titularConta = titular
}

let contaClientes = []

for (let i=0; i<dados.length; i++){
    contaClientes.push(new conta(dados[i].numero, dados[i].tipo, dados[i].saldo, dados[i].titular));
}

let banco = {
    clientes: contaClientes,
    consultaCliente: function(nome){
        let i = 0;
        let aux = "";

        while(i<this.clientes.length){
            if(this.clientes[i].titularConta == nome){
                aux = this.clientes[i]
                break;
            }
            ++i;
        }

        if (aux == ""){
            aux = "Cliente não encontrado"
        }

        console.log(i);
        return aux;
    }
}

console.log(banco.consultaCliente("Jobi Mawtus"))