package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    CardView c1 ,c2 ,c3 ,c4 ,c5 ,c6;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);

        c1.setOnClickListener(this :: );
        c2.setOnClickListener(this :: );
        c3.setOnClickListener(this :: );
        c4.setOnClickListener(this :: );
        c5.setOnClickListener(this :: );
        c6.setOnClickListener(this :: voltar);
    }

    private void (View view){
        i = new Intent(this,ListarRequisicoes.class);
        startActivity(i);
        ;
    }

    private void listarMaterais(View view){
        i = new Intent(this,ListarMaterial.class);
        startActivity(i);
    }

    private void (View view){
    }

    private void (View view) {
    }

    private void (View view){
    }

    private void voltar(View view){
        finish();
    }
}


    }
}