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
        c6 = findViewById(R.id.c6);

        c1.setOnClickListener(this :: listarMaterais);
        c6.setOnClickListener(this :: voltar);
    }

    private void listarMaterais(View view){
        i = new Intent(this,ListarMaterial.class);
        startActivity(i);
    }

    private void voltar(View view){
        finish();
    }
}
