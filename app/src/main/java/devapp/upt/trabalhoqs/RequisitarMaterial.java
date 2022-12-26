package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import devapp.upt.trabalhoqs.ClassesObjetos.PedidoMaterial;

public class RequisitarMaterial extends AppCompatActivity {

    TextView txt;
    EditText edtQuant;
    Button btn;
    DbHandler db;
    Intent i;
    int quant;
    int quantStock;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisitar_material);

        i = getIntent();

        txt = findViewById(R.id.textViewRequesitarMaterial);
        edtQuant = findViewById(R.id.editTextQuantidade);
        btn = findViewById(R.id.AceitarPedido);

        txt.setText(i.getStringExtra("info"));
        btn.setOnClickListener(this :: pedido);
    }

    public void pedido(View view){
        quant = Integer.parseInt(edtQuant.getText().toString());
        if (quant <= 0 && quant != (int)quant){
            Toast.makeText(RequisitarMaterial.this, "quantidade invalida", Toast.LENGTH_SHORT).show();
        }
        else{
            quantStock = db.GetQuantidade(Integer.parseInt(i.getStringExtra("codMaterial")));
            if (quant > quantStock){
                Toast.makeText(RequisitarMaterial.this, "Stock insuficiente", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(RequisitarMaterial.this, "pedido enviado", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
        }
}