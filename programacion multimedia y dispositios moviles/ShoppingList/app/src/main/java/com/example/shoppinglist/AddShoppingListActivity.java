package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;

import java.util.UUID;

public class AddShoppingListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shopping_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        ShoppingListViewModel vm = new ViewModelProvider(this, factory).get(ShoppingListViewModel.class);

        setupCreateButton(vm);
    }

    private void setupCreateButton(ShoppingListViewModel vm){
        findViewById(R.id.create_button).setOnClickListener(
                view -> {
                    //obtener valor del campo de texto
                    EditText namefield = findViewById(R.id.name_field);
                    String name = namefield.getText().toString();

                    //ignorar acción si hay 0 caracteres
                    if (name.isEmpty()){
                        return;
                    }

                    //crear entidad y guardarla
                    String id = UUID.randomUUID().toString();
                    ShoppingListInsert shoppingList = new ShoppingListInsert(id, name);
                    vm.insert(shoppingList);

                    //Ir a la lista
                    finish();
                }
        );
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}