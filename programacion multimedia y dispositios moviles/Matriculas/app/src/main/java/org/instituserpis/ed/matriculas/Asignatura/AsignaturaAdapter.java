package org.instituserpis.ed.matriculas.Asignatura;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.instituserpis.ed.matriculas.Alumno.AlumnoForList;
import org.instituserpis.ed.matriculas.R;
import org.instituserpis.ed.matriculas.data.Asignatura.Asignatura;

import java.util.List;

public class AsignaturaAdapter extends RecyclerView.Adapter<AsignaturaAdapter.AsignaturaViewHolder> {

    private List<AsignaturaForList> Asignaturas;
    private ItemListener mItemListener;

    @NonNull
    @Override
    public AsignaturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewTyper) {
        return new AsignaturaViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.asignatura_list_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AsignaturaViewHolder holder, int position) {
        AsignaturaForList item = Asignaturas.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return Asignaturas == null ? 0 : Asignaturas.size();
    }

    public void setItems(List<AsignaturaForList> items) {
        Asignaturas = items;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }

    interface ItemListener {
        void onEditIconClicked(AsignaturaForList Asignatura);
        void onDeleteIconClicked(AsignaturaForList Asignatura);
    }

    public class AsignaturaViewHolder extends RecyclerView.ViewHolder {

        //Variables
        private final TextView Nombre_asignaturaText;
        private final TextView num_estudiantesText;
        private final TextView idText;
        private final ImageView img_rem, img_edit, img_info;

        public AsignaturaViewHolder(@NonNull View itemView) {
            super(itemView);
            Nombre_asignaturaText = itemView.findViewById(R.id.nombre_asignatura);
            idText = itemView.findViewById(R.id.id);
            num_estudiantesText = itemView.findViewById(R.id.num_estudiantes);
            img_edit = itemView.findViewById(R.id.img_edit);
            img_info = itemView.findViewById(R.id.img_info);
            img_rem = itemView.findViewById(R.id.img_rem);


            //Setear eventos
            img_edit.setOnClickListener(this::manageEvents);
            img_rem.setOnClickListener(this::manageEvents);

            itemView.setOnClickListener(this::manageEvents);
        }

        private void manageEvents(View view){
            if (mItemListener != null) {
                AsignaturaForList clickedItem = Asignaturas.get(getAdapterPosition());

                if (view.getId() == R.id.img_edit){
                    mItemListener.onEditIconClicked(clickedItem);
                }
                if (view.getId() == R.id.img_rem) {
                    mItemListener.onDeleteIconClicked(clickedItem);
                    return;
                }

            }
        }

        public void bind(AsignaturaForList item) {
            Nombre_asignaturaText.setText(item.nombre);
            idText.setText(String.valueOf(item.id));
            num_estudiantesText.setText(String.valueOf(item.num_estudiantes) + " alumnos");
        }
    }
}
