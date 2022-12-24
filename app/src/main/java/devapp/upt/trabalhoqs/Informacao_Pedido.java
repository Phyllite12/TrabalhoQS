package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Informacao_Pedido extends AppCompatActivity {

    Intent i;
    DbHandler db;
    int cod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_pedido);

        i = getIntent();
        cod = Integer.parseInt(i.getStringExtra("cod"));
    }

    public void aceitarPedido(){
        db.DeletePedidoAcesso(cod);
        finish();
    }

    public void rejeitarPedido(){
        db.DeletePedidoAcesso(cod);
        finish();
    }


}