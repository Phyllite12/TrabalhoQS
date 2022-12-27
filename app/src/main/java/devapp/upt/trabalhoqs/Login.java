package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import devapp.upt.trabalhoqs.ClassesObjetos.Conta;
import devapp.upt.trabalhoqs.ClassesObjetos.Material;

public class Login extends AppCompatActivity {

    TextView number,password;
    String num,pass;
    Button btn;
    DbHandler db;
    int perm;
    ArrayList<Conta> contas;
    ArrayList<Material> materiais;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHandler(this);
        
        number = findViewById(R.id.editTextNum);
        password = findViewById(R.id.editTextpass);
        btn = findViewById(R.id.btnlogin);

        insereContas();
        //insereMeteriais();

        insereBD();

        
        btn.setOnClickListener(this::login);
    }

    private void login(View view) {
        perm = db.GetPerm(Integer.parseInt(num));
        num = number.getText().toString();
        pass = password.getText().toString();
        String check = db.authCheck(num, pass);
        if (!check.equals("")) {
            if (perm == 3){
                Intent i = new Intent(this, MainMainMenuAdm.class);
                startActivity(i);
            }
            else{
                Intent i = new Intent(this, MainMenu.class);
                i.putExtra("num", check);
                startActivity(i);
            }
        }
        else{
            Toast.makeText(Login.this, "Número ou Palavra-Passe incorreta", Toast.LENGTH_SHORT).show();
        }
    }

    public void insereContas(){
        contas = new ArrayList<>();
        contas.add(new Conta("Marco", 43050, "123asd", "professor", 1));
    }

   //public void insereMeteriais(){
        //materiais = new ArrayList<>();
    //}

    public void insereBD(){
            for (int i = 0; i < contas.size(); i++){
                db.addContas(contas.get(i));
            }
            //for (int i = 0; i < materiais.size(); i++){
              //db.addMaterial(materiais.get(i));
            //}
    }




}