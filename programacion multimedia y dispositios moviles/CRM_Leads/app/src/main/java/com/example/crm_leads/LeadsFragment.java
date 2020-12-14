package com.example.crm_leads;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeadsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeadsFragment extends Fragment {

    ListView mLeadsList;
    LeadsAdapter mLeadsAdapter;

    public LeadsFragment() {
        // Required empty public constructor
    }

    public static LeadsFragment newInstance() {
        LeadsFragment fragment = new LeadsFragment();
        //Setup fragment
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Gets parámetros
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_leads, container, false);

        // Instancia del ListView.
        mLeadsList = (ListView) root.findViewById(R.id.leads_list);

        // Inicializar el adaptador con la fuente de datos.
        mLeadsAdapter = new LeadsAdapter(getActivity(), LeadsRepository.getInstance().getLeads());

        //Relacionando la lista con el adaptador
        mLeadsList.setAdapter(mLeadsAdapter);

        //Eventos
        mLeadsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Lead currentLead = mLeadsAdapter.getItem(position);
                Toast.makeText(getActivity(), "Iniciar screen de detalle para: " + currentLead.getmName(), Toast.LENGTH_SHORT).show();
            }
        });
        setHasOptionsMenu(true);
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_leads_list, menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_delete_all){
            //Eliminar todos los leads
            mLeadsAdapter.clear();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}