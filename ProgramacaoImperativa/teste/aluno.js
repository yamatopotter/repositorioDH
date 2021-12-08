function aluno(nomeAluno, faltasAluno, notasAluno){
    this.nome = nomeAluno,
    this.qtdFaltas = faltasAluno,
    this.notas = notasAluno,
    this.calcularMedia = ()=>{
        let somaNotas = 0
        this.notas.forEach(nota => {
            somaNotas += nota;
        });

        let qtdNotas = this.notas.length;

        return somaNotas/qtdNotas;
    },
    this.faltas = ()=>{
        this.qtdFaltas +=1;
        return this.qtdFaltas;
    }
}

module.exports = aluno; 