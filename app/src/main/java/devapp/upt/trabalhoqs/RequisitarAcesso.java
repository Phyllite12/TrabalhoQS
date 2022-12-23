package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RequisitarAcesso extends AppCompatActivity {

    TextView tx;
    EditText edtPass;
    Button btn;
    DbHandler db;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requisitar_acesso);


        tx = findViewById(R.id.textView3);
        edtPass = findViewById(R.id.editTextPass);
        btn = findViewById(R.id.btnRegisto);

        btn.setOnClickListener(this::registarPedido);
    }

    private void registarPedido() {
        i = getIntent();
    }


}