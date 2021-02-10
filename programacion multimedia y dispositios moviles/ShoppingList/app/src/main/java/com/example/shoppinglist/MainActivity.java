package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ShoppingListViewModel mViewModel;
    private RecyclerView mList;
    private ShoppingListAdapter mAdapter;
    private ArrayList<CheckBox> mFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(ShoppingListViewModel.class);

        setupFilters();

        setupList();

        setupFab();
    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new ShoppingListAdapter();
        mList.setAdapter(mAdapter);

        // Asignar escucha de items
        mAdapter.setItemListener(new ShoppingListAdapter().ItemListener(){
            @Override
            public void onClick(ShoppingListAdapter shoppingList) {
                editShoppingList(shoppingList);
            }

            @Override
            public void onFavoriteIconClicked(ShoppingListForList shoppingList) {
                mViewModel.markFavorite(shoppingList);
            }
        });

        //Observar cambios de listas de compras
        mViewModel.getShoppingLists().observe(this, mAdapter::setItems);
    }

    private void editShoppingList(ShoppingListForList shoppingList) {
        Intent intent = new Intent(MainActivity.this, EditShoppingListActivity.class);
        intent.putExtra(EditShoppingListActivity.EXTRA_SHOPPING_LIST_ID, shoppingList.id);
        startActivity(intent);
    }


    private void setupFab() {
        findViewById(R.id.floating_action_button)
                .setOnClickListener(view -> addNewShoppingList());
    }

    private void addNewShoppingList() {
        startActivity(new Intent(this, AddShoppingListActivity.class));
    }

    private void setupFilters() {
        mFilters = new ArrayList<>();
        mFilters.add(findViewById(R.id.filter_1));
        mFilters.add(findViewById(R.id.filter_2));
        mFilters.add(findViewById(R.id.filter_3));

        // Deinir escucha de filtros
        CompoundButton.OnCheckedChangeListener listener = (compoundButton, checked) -> {
            String category = compoundButton.getText().toString();
            if (checked) {
                mViewModel.addFilter(category);
            } else {
                mViewModel.removeFilter(category);
            }
        };

        //setear escucha
        for (CheckBox filter : mFilters) {
            filter.setOnCheckedChangeListener(listener);
        }
    }
}