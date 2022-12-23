package devapp.upt.trabalhoqs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPedido extends RecyclerView.Adapter<View_HolderPedido>{

    ArrayList<PedidoAcesso> pedido;
    View_HolderPedido myVPed;

    public AdapterPedido(ArrayList<PedidoAcesso> pedido) {
        this.pedido = pedido;
    }

    @NonNull
    @Override
    public View_HolderPedido onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_pedido,parent,false);


        myVPed = new View_HolderPedido(v);
        return myVPed;
    }

    @Override
    public void onBindViewHolder(@NonNull View_HolderPedido holder, int position) {
        myVPed.pedTv.setText(pedido.get(position));
    }

    @Override
    public int getItemCount() {
        return pedido.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

