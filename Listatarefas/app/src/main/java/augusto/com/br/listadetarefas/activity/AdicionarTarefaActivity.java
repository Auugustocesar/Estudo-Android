package augusto.com.br.listadetarefas.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import augusto.com.br.listadetarefas.R;
import augusto.com.br.listadetarefas.helper.TarefaDAO;
import augusto.com.br.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;

    private Tarefa tarefaAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);

        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        if (tarefaAtual != null) {
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemSalvar:
                salvarTarefa();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void salvarTarefa() {
        TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
        String nomeTarefa = editTarefa.getText().toString();

        if (tarefaAtual != null) {
            if (!nomeTarefa.isEmpty()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setNomeTarefa(nomeTarefa);
                tarefa.setId(tarefaAtual.getId());
                if (tarefaDAO.atualizar(tarefa)) {
                    finish();
                    Toast.makeText(getApplicationContext(), "Sucesso ao atualizar tarefa!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao atualizar tarefa", Toast.LENGTH_SHORT).show();
                }
            }

        } else {
            if (!nomeTarefa.isEmpty()) {
                Tarefa tarefa = new Tarefa();
                tarefa.setNomeTarefa(nomeTarefa);
                if (tarefaDAO.salvar(tarefa)) {
                    finish();
                    Toast.makeText(getApplicationContext(), "Sucesso ao salvar tarefa!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}

