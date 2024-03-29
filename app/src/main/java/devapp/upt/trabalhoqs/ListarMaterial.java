package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import devapp.upt.trabalhoqs.Adapters.AdapterMaterial;
import devapp.upt.trabalhoqs.ClassesObjetos.Material;

public class ListarMaterial extends AppCompatActivity {

    DbHandler dbHandler;
    Intent i;
    AdapterMaterial myadapter;
    RecyclerView recyclerViewMaterial;
    ArrayList<Material> listarMaterial;
    LinearLayoutManager layoutManager;
    ConstraintLayout cl;
    int cod;

    /*

     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_material);

        i = getIntent();
        cod = Integer.parseInt(i.getStringExtra("cod"));
        dbHandler = new DbHandler(this);

        getMaterialBD();

        myadapter = new AdapterMaterial(listarMaterial, this, cod);
        recyclerViewMaterial = findViewById(R.id.recyclerViewMaterial);
        recyclerViewMaterial.setAdapter(myadapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerViewMaterial.setLayoutManager(layoutManager);

        cl = findViewById(R.id.finishBtnListarMaterial);
        cl.setOnClickListener(this::onClick);
    }

    /*
    Método para obter materiais a partir da BD.
     */
    public void getMaterialBD() {
        listarMaterial = dbHandler.getMaterial();
    }

    public void onClick(View v) {
        finish();
    }

}