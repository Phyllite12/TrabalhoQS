package devapp.upt.trabalhoqs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class View_HolderPedidoMaterial extends RecyclerView.ViewHolder {

    public TextView pedMatTv;

    public View_HolderPedidoMaterial(@NonNull View itemView) {
        super(itemView);
        pedMatTv = itemView.findViewById(R.id.textViewPedidoMaterial);
    }
}