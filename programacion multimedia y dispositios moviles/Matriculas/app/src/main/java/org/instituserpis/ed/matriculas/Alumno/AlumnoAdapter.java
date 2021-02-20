package org.instituserpis.ed.matriculas.Alumno;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.instituserpis.ed.matriculas.R;

import java.util.List;

public class AlumnoAdapter
        extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {

    private List<AlumnoForList> Alumnos;
    private ItemListener mItemListener;

    @NonNull
    @Override
    public AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {
        return new AlumnoViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.alumno_list_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoViewHolder holder, int position) {
        AlumnoForList item = Alumnos.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return Alumnos == null ? 0 : Alumnos.size();
    }

    public void setItems(List<AlumnoForList> items) {
        Alumnos = items;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }

    interface ItemListener {
        void onEditIconClicked(AlumnoForList Alumno);
        void onDeleteIconClicked(AlumnoForList Alumno);
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder {

        //Variables
        private final TextView NombreText;
        private final TextView ApellidosText;
        private final TextView DNIText;
        private final ImageView img_rem, img_edit, img_info;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            NombreText = itemView.findViewById(R.id.nombre);
            ApellidosText = itemView.findViewById(R.id.apellidos);
            DNIText = itemView.findViewById(R.id.apellidos);
            img_edit = itemView.findViewById(R.id.img_edit);
            img_info = itemView.findViewById(R.id.img_info);
            img_rem = itemView.findViewById(R.id.img_rem);

            //Setear eventos
            img_edit.setOnClickListener(this::manageEvent);
            img_rem.setOnClickListener(this::manageEvent);

            itemView.setOnClickListener(this::manageEvent);
        }

        public void manageEvent(View view) {
            if (mItemListener != null){
                AlumnoForList clickedItem = Alumnos.get(getAdapterPosition());

                if (view.getId() == R.id.img_edit) {
                    mItemListener.onEditIconClicked(clickedItem);
                }
                if (view.getId() == R.id.img_rem){
                    mItemListener.onDeleteIconClicked(clickedItem);
                    return;
                }
            }
        }

        //Asignar datos
        public void bind(AlumnoForList item) {
            NombreText.setText(item.nombre);
            ApellidosText.setText(item.apellidos);
            DNIText.setText(item.DNI);
        }
    }
}
