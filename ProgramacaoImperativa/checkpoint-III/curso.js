let dados = require('./module/estudantes');

let curso = {
    nomeCurso: "Programação Imperativa",
    notaAprovacao: 7,
    faltasMaxima: 8,
    listaEstudantes: [],
    adicionarAluno: function(a){
        this.listaEstudantes.push(a);
        return true;
    },
    alunoPassou: function(aluno){
        let qtdFaltas = aluno.qtdFaltas;
        let mediaAluno = aluno.calcularMedia();

        if((mediaAluno >= this.notaAprovacao) && (qtdFaltas < this.faltasMaxima)){
            return true;
        }
        else if(qtdFaltas == this.faltasMaxima){
            if(mediaAluno >= (this.notaAprovacao/10)+this.notaAprovacao){
                return true
            }
            else{
                return false
            }   
        }
        else{
            return false
        }
    },
    situacaoAlunos: () => {
        let situacaoAlunos = [];
        curso.listaEstudantes.forEach(e => {
            situacaoAlunos.push(curso.alunoPassou(e))
        });

        return situacaoAlunos;
    }
};

dados.forEach(aluno=>{
    curso.adicionarAluno(aluno);
});

// Verificação do objeto curso
console.log(curso);

console.log(curso.situacaoAlunos());

