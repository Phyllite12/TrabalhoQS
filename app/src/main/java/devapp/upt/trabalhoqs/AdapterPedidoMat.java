package devapp.upt.trabalhoqs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPedidoMat extends RecyclerView.Adapter<View_HolderPedidoMaterial>  {

    ArrayList<PedidoMaterial> pedMaterial;
    View_HolderPedidoMaterial myVPedMat;

    public AdapterPedidoMat(ArrayList<PedidoMaterial> pedMaterial) {
        this.pedMaterial = pedMaterial;
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
        myVPedMat.pedMatTv.setText(pedMaterial.get(position));
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


