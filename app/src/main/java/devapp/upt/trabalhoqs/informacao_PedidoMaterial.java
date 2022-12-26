package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class informacao_PedidoMaterial extends AppCompatActivity {

    Intent i;
    TextView text;
    Button aceita, rejeita;
    DbHandler db;
    int quantStock, quant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacao_pedido_material);

        i = getIntent();

        text.findViewById(R.id.textViewInfo);
        aceita.findViewById(R.id.Aceitar1);
        rejeita.findViewById(R.id.Rejeitar1);

        text.setText(i.getStringExtra("info"));

        aceita.setOnClickListener(this :: aceitar);
        rejeita.setOnClickListener(this :: rejeitar);
    }

    private void rejeitar(View view) {
        db.DeletePedidoMaterial(Integer.parseInt(i.getStringExtra("codPedido")));
        Toast.makeText(informacao_PedidoMaterial.this, "Pedido recusado", Toast.LENGTH_SHORT).show();
        finish();
    }

    private void aceitar(View view) {
        quantStock = db.GetQuantidade(Integer.parseInt(i.getStringExtra("codMaterial")));
        if (quant <= quantStock) {
            int diferenca = quantStock - quant;
            db.updateStockMaterial(diferenca, Integer.parseInt(i.getStringExtra("codMaterial")));
            db.DeletePedidoMaterial(Integer.parseInt(i.getStringExtra("codPedido")));
            finish();
        }
        else{
            Toast.makeText(informacao_PedidoMaterial.this, "Stock insuficiente", Toast.LENGTH_SHORT).show();
        }
    }
}