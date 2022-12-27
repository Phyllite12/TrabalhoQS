package devapp.upt.trabalhoqs.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import devapp.upt.trabalhoqs.ClassesObjetos.PedidoMaterial;
import devapp.upt.trabalhoqs.R;
import devapp.upt.trabalhoqs.ViewHolders.View_HolderPedidoMaterial;
import devapp.upt.trabalhoqs.Informacao_PedidoMaterial;

public class AdapterPedidoMat extends RecyclerView.Adapter<View_HolderPedidoMaterial>  {

    ArrayList<PedidoMaterial> pedMaterial;
    View_HolderPedidoMaterial myVPedMat;
    Context ct;
    String info;
    String codMaterial;
    String codPedido;

    public AdapterPedidoMat(ArrayList<PedidoMaterial> pedMaterial, Context ct) {
        this.pedMaterial = pedMaterial;
        this.ct = ct;
    }

    @NonNull
    @Override
    public View_HolderPedidoMaterial onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_pedidomaterial,parent,false);

        myVPedMat = new View_HolderPedidoMaterial(v);
        return myVPedMat;
    }

    @Override
    public void onBindViewHolder(@NonNull View_HolderPedidoMaterial holder, int position) {
        PedidoMaterial pedidoMaterial = pedMaterial.get(position);
        myVPedMat.pedMatTv.setText(pedMaterial.get(position).getPedidoCod());
        myVPedMat.pedMatTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                codMaterial = String.valueOf(pedidoMaterial.getCod());
                codPedido = String.valueOf(pedidoMaterial.getPedidoCod());
                info = String.valueOf(pedidoMaterial.getCod()) +
                        "\n" + String.valueOf(pedidoMaterial.getcodProf()) +
                        "\n" + String.valueOf(pedidoMaterial.getQuantidade());

                Intent intent = new Intent(ct, Informacao_PedidoMaterial.class);
                intent.putExtra("info", info);
                intent.putExtra("codMaterial", codMaterial);
                intent.putExtra("codPedido", codPedido);
                ct.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pedMaterial.size();
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
}


