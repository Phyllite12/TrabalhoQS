package devapp.upt.trabalhoqs.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import devapp.upt.trabalhoqs.ClassesObjetos.PedidoAcesso;
import devapp.upt.trabalhoqs.Informacao_Pedido;
import devapp.upt.trabalhoqs.R;
import devapp.upt.trabalhoqs.RequisitarMaterial;
import devapp.upt.trabalhoqs.ViewHolders.View_HolderPedido;

public class AdapterPedido extends RecyclerView.Adapter<View_HolderPedido>{

    ArrayList<PedidoAcesso> pedido;
    View_HolderPedido myVPed;
    Context ct;
    String info;
    String cod;

    public AdapterPedido(ArrayList<PedidoAcesso> pedido, Context ct) {
        this.pedido = pedido;
        this.ct = ct;
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
        PedidoAcesso pedidoAcesso = pedido.get(position);
        myVPed.pedTv.setText(pedido.get(position).getNomeProfessor());
        myVPed.pedTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                info = pedidoAcesso.getNomeProfessor() +
                        "\n" + String.valueOf(pedidoAcesso.getCod()) +
                        "\n" + String.valueOf(pedidoAcesso.getNum());
                cod = String.valueOf(pedidoAcesso.getCod());

                Intent intent = new Intent(ct, Informacao_Pedido.class);
                intent.putExtra("info", info);
                intent.putExtra("cod", cod);
                ct.startActivity(intent);
            }
        });
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

