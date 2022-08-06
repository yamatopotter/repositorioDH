package aula3_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    Usuario u1;
    Usuario u2;

    IBaixar gerenciadorDownload = new ServicoDownloadProxy();

    @BeforeEach
    void criarUsuarios(){
        u1 = new Usuario("YamatoPotter", 2583, "Free");
        u2 = new Usuario("matheuspbarreto", 24496, "Premium");
    }

    @Test
    void test(){
        System.out.println(gerenciadorDownload.baixarMusica(u1));
        System.out.println(gerenciadorDownload.baixarMusica(u2));
    }
}
