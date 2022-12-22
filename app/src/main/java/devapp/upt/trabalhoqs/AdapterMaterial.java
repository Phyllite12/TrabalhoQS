package devapp.upt.trabalhoqs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMaterial extends RecyclerView.Adapter<View_HolderMaterial> {

    ArrayList<String> material;
    View_HolderMaterial myVMat;

    public AdapterMaterial(ArrayList<Material> material) {
        this.material = material;
    }

    @NonNull
    @Override
    public View_HolderMaterial onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;

        v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view_material,parent,false);


        myVMat = new View_HolderMaterial(v);
        return myVMat;
    }

    @Override
    public void onBindViewHolder(@NonNull View_HolderMaterial holder, int position) {
        myVMat.matTv.setText(material.get(position));
    }

    @Override
    public int getItemCount() {
        return material.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
