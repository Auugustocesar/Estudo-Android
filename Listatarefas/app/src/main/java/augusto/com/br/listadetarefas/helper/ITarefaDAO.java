package augusto.com.br.listadetarefas.helper;

import java.util.List;

import augusto.com.br.listadetarefas.model.Tarefa;

public interface ITarefaDAO {

    boolean salvar(Tarefa tarefa);

    boolean atualizar(Tarefa tarefa);

    boolean deletar(Tarefa tarefa);

    List<Tarefa> listar();
}
