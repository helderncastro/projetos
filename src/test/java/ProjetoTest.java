import com.api.gerenciaprojetos.enumeration.Status;
import com.api.gerenciaprojetos.models.ProjetoModel;
import com.api.gerenciaprojetos.services.ProjetoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

public class ProjetoTest extends TesteBase  {

    @InjectMocks
    ProjetoService projetoService;

    @Test
    void deletarProjetoIniciado() {

        boolean resultado = false;
        ProjetoModel projeto = new ProjetoModel();
        projeto.setIdProjeto(1L);
        projeto.setStatus(Status.INICIADO);

        resultado = projetoService.delete(projeto);
        Assertions.assertFalse(resultado);
    }

    @Test
    void deletarProjetoAndamento() {

        boolean resultado = false;
        ProjetoModel projeto = new ProjetoModel();
        projeto.setIdProjeto(1L);
        projeto.setStatus(Status.ANDAMENTO);

        resultado = projetoService.delete(projeto);
        Assertions.assertFalse(resultado);
    }

    @Test
    void deletarProjetoEncerrado() {

        boolean resultado = false;
        ProjetoModel projeto = new ProjetoModel();
        projeto.setIdProjeto(1L);
        projeto.setStatus(Status.ENCERRADO);

        resultado = projetoService.delete(projeto);
        Assertions.assertFalse(resultado);
    }


}
