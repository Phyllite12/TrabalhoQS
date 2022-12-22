package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainMainMenuAdm extends AppCompatActivity {

    CardView c10,c11 ,c12 ,c13 ,c14 ,c15;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuadm);

        i = getIntent();

        c10 = findViewById(R.id.c10);
        c11 = findViewById(R.id.c11);
        c12 = findViewById(R.id.c12);
        c13 = findViewById(R.id.c13);
        c14 = findViewById(R.id.c14);
        c15 = findViewById(R.id.c15);


        c10.setOnClickListener(this :: );
        c11.setOnClickListener(this :: );
        c12.setOnClickListener(this :: );
        c13.setOnClickListener(this :: );
        c14.setOnClickListener(this :: );
        c15.setOnClickListener(this :: voltar);
    }

    private void requisicoes(View view){
        i = new Intent(this,ListarRequisicoes.class);
        startActivity(i);
        ;
    }

    private void (View view){
        i = new Intent(this,Listar.class);
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
