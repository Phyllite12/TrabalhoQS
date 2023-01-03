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

    /*

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DbHandler(this);
        
        number = findViewById(R.id.editTextNum);
        password = findViewById(R.id.editTextpass);
        btn = findViewById(R.id.btnlogin);

        insereContas();
        insereMateriais();

        btn.setOnClickListener(this::login);
    }

    /*
    Método para efetuar login.
     */
    private void login(View view) {
        num = number.getText().toString();
        pass = password.getText().toString();
        perm = db.GetPerm(Integer.parseInt(num));
        String check = db.authCheck(num, pass);
        if (!check.equals("")) {
            if (perm == 3){
                Intent i = new Intent(this, MainMenuAdm.class);
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

    /*
    Método para inserir conta.
     */
    public void insereContas(){
        contas = new ArrayList<>();
        contas.add(new Conta("Marco", 43050, "123asd", "professor", 1));
        contas.add(new Conta("José", 57841, "123asd", "professor", 2));
        contas.add(new Conta("António", 45862, "123asd", "admin", 3));
    }

    /*
    Método para inserir materiais.
     */
   public void insereMateriais(){
        materiais = new ArrayList<>();
        materiais.add(new Material(24343, "drone", "drone", 10, "disponivel"));
        materiais.add(new Material(25489, "carro", "carro tele comandado", 15, "disponivel"));
    }

    /*
    Método para inserir dados na BD.
     */
    public void insereBD(){
            for (int i = 0; i < contas.size(); i++){
                db.addContas(contas.get(i));
            }
            for (int i = 0; i < materiais.size(); i++){
              db.addMaterial(materiais.get(i));
            }
    }

    public int getAllContas(){
        return contas.size();
    }

    public int getAllMateriais(){
        return materiais.size();
    }
}