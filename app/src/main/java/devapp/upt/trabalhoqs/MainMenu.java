package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import devapp.upt.trabalhoqs.ClassesObjetos.PedidoAcesso;

public class MainMenu extends AppCompatActivity {

    CardView c1 ,c2 ,c3;
    Intent i;
    DbHandler db;
    int num;
    int perm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        i = getIntent();
        num = Integer.parseInt(i.getStringExtra("num"));

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);

        c1.setOnClickListener(this :: listarMaterais);
        c2.setOnClickListener(this :: pedirPermissao);
        c3.setOnClickListener(this :: voltar);
    }

    private void listarMaterais(View view){
        perm = db.GetPerm(num);
        if (perm == 1){
            Toast.makeText(MainMenu.this, "Sem premissão", Toast.LENGTH_SHORT).show();
        }
        else {
            i = new Intent(this, ListarMaterial.class);
            i.putExtra("cod", num);
            startActivity(i);
        }
    }

    private void pedirPermissao(View view){
        perm = db.GetPerm(num);
        if (perm == 2){
            Toast.makeText(MainMenu.this, "Ja tem permissão", Toast.LENGTH_SHORT).show();
        }
        else{
            ArrayList<PedidoAcesso> pedido = new ArrayList<>();
            db.addPedidosAcesso(new PedidoAcesso(db.getNomeProf(num), num));
            Toast.makeText(MainMenu.this, "Pedido enviado", Toast.LENGTH_SHORT).show();
        }

    }

    private void voltar(View view){
        finish();
    }
}
