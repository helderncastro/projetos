import com.api.gerenciaprojetos.enumeration.Status;
import com.api.gerenciaprojetos.models.MembroModel;
import com.api.gerenciaprojetos.models.PessoaModel;
import com.api.gerenciaprojetos.models.ProjetoModel;
import com.api.gerenciaprojetos.services.MembroService;
import com.api.gerenciaprojetos.services.PessoaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Optional;

public class MembroTeste extends TesteBase{

    @InjectMocks
    MembroService membroService;

    @InjectMocks
    PessoaService pessoaService;
    //pessoaService.findById(membroModel.getIdPessoa().getIdPessoa())

    @Test
    void associarApenasMembrosFuncionarios() {

        PessoaModel pessoa = new PessoaModel();
        pessoa.setIdPessoa(1L);
        pessoa.setFuncionario(false);

        ProjetoModel projeto = new ProjetoModel();
        projeto.setIdProjeto(1L);
        projeto.setStatus(Status.INICIADO);

        MembroModel membroModel = new MembroModel();
        membroModel.setPessoaMembro(pessoa);
        membroModel.setProjetoMembro(projeto);

        Optional<MembroModel> membroModelOptional = Optional.ofNullable(membroService.save(membroModel));

        Assertions.assertFalse(membroModelOptional.isPresent());

    }

}
