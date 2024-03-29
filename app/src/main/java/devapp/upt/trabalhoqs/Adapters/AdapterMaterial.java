package devapp.upt.trabalhoqs.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import devapp.upt.trabalhoqs.ClassesObjetos.Material;
import devapp.upt.trabalhoqs.R;
import devapp.upt.trabalhoqs.RequisitarMaterial;
import devapp.upt.trabalhoqs.ViewHolders.View_HolderMaterial;


public class AdapterMaterial extends RecyclerView.Adapter<View_HolderMaterial> {

    ArrayList<Material> materiais;
    View_HolderMaterial myVMat;
    Context ct;
    String info;
    int cod_material;
    int cod_prof;
    String cod_material1;
    String cod_prof1;

    public AdapterMaterial(ArrayList<Material> material, Context ct, int cod_prof) {
        this.materiais = material;
        this.ct = ct;
        this.cod_prof = cod_prof;
    }

    /*
    Este método define os atributos que, posteriormente, irão ser mostrados no ecrã.
     */
    @NonNull
    @Override
    public View_HolderMaterial onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_material,parent,false);
        myVMat = new View_HolderMaterial(v);
        return myVMat;
    }

    /*
    Este método devolve, ao utilizador, a lista dos materiais.
     */
    @Override
    public void onBindViewHolder(@NonNull View_HolderMaterial holder, int position) {
        Material material = materiais.get(position);
        myVMat.matTv.setText(materiais.get(position).getDescricao());
        myVMat.matTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cod_material = material.getCod();
                cod_material1 = String.valueOf(cod_material);
                cod_prof1 = String.valueOf(cod_prof);
                info = material.getDescricao() +
                        "\n" + material.getTipo() +
                        "\n" + String.valueOf(material.getnUnidades()) +
                        "\n" + material.isDisponibilidade();
                Intent intent = new Intent(ct, RequisitarMaterial.class);
                intent.putExtra("info", info);
                intent.putExtra("cod", cod_material1);
                intent.putExtra("cod_prof", cod_prof1);
                ct.startActivity(intent);
            }
        });
    }

    /*
    Devolve a quantidade de materiais.
     */
    @Override
    public int getItemCount() {
        return materiais.size();
    }

    /*
    Devolve a posição do item.
     */
    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
