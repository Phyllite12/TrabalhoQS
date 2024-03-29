package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Informacao_Pedido extends AppCompatActivity {

    Intent i;
    DbHandler db;
    int cod;
    TextView textView;
    Button aceita, rejeita ,btnvolta;

    /*

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_pedido);
        db = new DbHandler(this);
        textView = findViewById(R.id.textViewInformaçaoPedido);
        aceita = findViewById(R.id.Aceitar);
        rejeita = findViewById(R.id.Rejeitar);
        btnvolta = findViewById(R.id.btnvoltar);

        i = getIntent();
        cod = Integer.parseInt(i.getStringExtra("cod"));

        aceita.setOnClickListener(this :: aceitarPedido);
        rejeita.setOnClickListener(this :: rejeitarPedido);
        btnvolta.setOnClickListener(this:: voltar);
    }

    /*
    Método para aceitar pedido.
     */
    public void aceitarPedido(View view){
        db.DeletePedidoAcesso(cod);
        Toast.makeText(Informacao_Pedido.this, "pedido aceite", Toast.LENGTH_SHORT).show();
        finish();
    }

    /*
    Método para rejeitar pedido.
     */
    public void rejeitarPedido(View view){
        db.DeletePedidoAcesso(cod);
        Toast.makeText(Informacao_Pedido.this, "Pedido rejeitado", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void voltar(View view){
        finish();
    }
}