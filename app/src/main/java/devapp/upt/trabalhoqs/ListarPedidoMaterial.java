package devapp.upt.trabalhoqs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import devapp.upt.trabalhoqs.Adapters.AdapterPedidoMat;
import devapp.upt.trabalhoqs.ClassesObjetos.PedidoMaterial;

public class ListarPedidoMaterial extends AppCompatActivity {

    DbHandler dbHandler;
    Intent i;
    AdapterPedidoMat myadapter;
    RecyclerView recyclerViewPedidoMat;
    ArrayList<PedidoMaterial> listarPedidoMaterial;
    LinearLayoutManager layoutManager;
    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidomaterial);

        i = getIntent();
        dbHandler = new DbHandler(this);

        getPedidoMaterialBD();

        myadapter = new AdapterPedidoMat(listarPedidoMaterial, this);
        recyclerViewPedidoMat = findViewById(R.id.recyclerViewPedMat);
        recyclerViewPedidoMat.setAdapter(myadapter);

        layoutManager = new LinearLayoutManager(this);
        recyclerViewPedidoMat.setLayoutManager(layoutManager);

        cl = findViewById(R.id.finishBtnListarPedMat);
        cl.setOnClickListener(this::onClick);
    }

    private void getPedidoMaterialBD() {
        listarPedidoMaterial = dbHandler.getPedidosDeMaterial();
    }


    public void onClick(View v)
    {
        finish();
    }
}