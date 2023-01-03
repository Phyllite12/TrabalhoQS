package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import devapp.upt.trabalhoqs.Adapters.AdapterPedido;
import devapp.upt.trabalhoqs.ClassesObjetos.PedidoAcesso;

public class ListarPedido extends AppCompatActivity {

    DbHandler dbHandler;
    Intent i;
    AdapterPedido myadapter;
    RecyclerView recyclerViewPedido;
    ArrayList<PedidoAcesso> listarPedido;
    LinearLayoutManager layoutManager;
    ConstraintLayout cl;

    /*

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pedidoacesso);

        i = getIntent();
        dbHandler = new DbHandler(this);

        getPedidoAcessoBD();

        myadapter = new AdapterPedido(listarPedido, this);
        recyclerViewPedido = findViewById(R.id.recyclerViewPedAcess);
        recyclerViewPedido.setAdapter(myadapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerViewPedido.setLayoutManager(layoutManager);

        cl = findViewById(R.id.finishBtnListarPedAcess);
        cl.setOnClickListener(this::onClick);
    }

    /*
    Método para obter pedidos de acesso a partir da BD.
     */
    private void getPedidoAcessoBD() {
        listarPedido = dbHandler.getPedidosDeAcesso();
    }

    public void onClick(View v) {
        finish();
    }

}