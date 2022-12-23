package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RequisitarMaterial extends AppCompatActivity {

    TextView txt;
    EditText edtQuant;
    Button btn;
    DbHandler db;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisitar_material);

        txt = findViewById(R.id.textView3);
        edtQuant = findViewById(R.id.editTextQuantidade);
        btn = findViewById(R.id.btnRegistoM);
    }
}