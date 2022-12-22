package devapp.upt.trabalhoqs;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class View_HolderMaterial extends RecyclerView.ViewHolder {

    public TextView matTv;

    public View_HolderMaterial(@NonNull View itemView) {
        super(itemView);
        matTv = itemView.findViewById(R.id.textViewMaterial);
    }
}
