package aula3_1;

public class ServicoDownloadProxy implements IBaixar{
    ServicoDownload servicoDownload = new ServicoDownload();

    @Override
    public String baixarMusica(Usuario usuario) {
        if(usuario.getTipoUsuario().equals("Premium")){
            return servicoDownload.baixarMusica(usuario);
        }else{
            return "Desculpe "+ usuario.getNome() +", somente usuários premium tem a função de download.";
        }
    }

    public ServicoDownloadProxy() {
    }
}
