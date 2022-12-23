package devapp.upt.trabalhoqs;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class View_HolderPedido extends RecyclerView.ViewHolder {

    public TextView pedTv;

    public View_HolderPedido(@NonNull View itemView) {
        super(itemView);
        pedTv = itemView.findViewById(R.id.textViewPedido);

    }
}
