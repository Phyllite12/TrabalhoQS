package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView number,password;
    Button btn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        number = findViewById(R.id.editTextNum);
        password = findViewById(R.id.editTextpass);
        btn = findViewById(R.id.btnlogin);
        
        btn.setOnClickListener(this::login);
    }




}