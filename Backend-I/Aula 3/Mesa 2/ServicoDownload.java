package aula3_1;

public class ServicoDownload implements IBaixar{
    @Override
    public String baixarMusica(Usuario usuario) {
        return "O usuario "+usuario.getNome()+" está baixando uma música";
    }

    public ServicoDownload() {

    }
}
