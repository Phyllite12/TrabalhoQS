package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenuAdm extends AppCompatActivity {

    CardView c10,c11 ,c12 ,c13 ,c14 ,c15;
    Intent i;

    /*

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuadm);

        i = getIntent();

        c10 = findViewById(R.id.c10);
        c11 = findViewById(R.id.c11);
        c15 = findViewById(R.id.c13);


        c10.setOnClickListener(this :: requisicoes);
        c11.setOnClickListener(this :: pedidosAcesso);
        c15.setOnClickListener(this :: voltar);
    }

    /*
    Método para listar requisições de pedidos de materiais.
     */
    private void requisicoes(View view){
        i = new Intent(this,ListarPedidoMaterial.class);
        startActivity(i);
        ;
    }

    /*
    Método para listar pedidos de acesso.
     */
    private void pedidosAcesso(View view){
        i = new Intent(this, ListarPedido.class);
        startActivity(i);
    }

    private void voltar(View view){
        finish();
    }
}
