package aula8;

import java.util.Date;
import java.util.List;

public interface IFacadeBusca {

    public List<Voo> buscarVoo(Date dataInicial, Date dataFinal, String origem, String destino);
}
