let curso = {
    nomeCurso: "Programação Imperativa",
    notaAprovacao: 7,
    faltasMaxima: 8,
    listaEstudantes: [],
    addAluno: ()=>{
        this.listaEstudantes.push(new aluno(nome, faltas, notas));
    },
    alunoPassou: (aluno)=>{
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
    verificaAlunosAprovados: () => {
        let situacaoAlunos = [];
        listaEstudantes.forEach(e => {
            situacaoAlunos.push(this.alunoPassou(e))
        });

        return situacaoAlunos;
    }
};

