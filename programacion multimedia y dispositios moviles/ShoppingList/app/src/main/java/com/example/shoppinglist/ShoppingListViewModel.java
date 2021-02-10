package com.example.shoppinglist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;

public class ShoppingListViewModel extends AndroidViewModel {

    // Repositorio de listas de compras
    private final ShoppingListRepository mRepository;

    // Listas de compras observadas
    private final LiveData<List<ShoppingListForList>> mShoppingLists;

    //filtros observados
    private final MutableLiveData<List<String>> mCategories = new MutableLiveData<>(new ArrayList<>());

    //Filtros
    private final List<String> mFilters = new ArrayList<>();

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ShoppingListRepository(application);

        // Obtener listas de compras por categorias
        mShoppingLists = Transformations.switchMap(
                mCategories,
                categories -> {
                    if (categories.isEmpty()) {
                        return mRepository.getShoppingLists();
                    } else {
                        return mRepository.getShoppingListWhitCategories(categories);
                    }
                }
        );
    }
    public void addFilter(String category) {
        mFilters.add(category);
        mCategories.setValue(mFilters);
    }

    public void removeFilter(String category){
        mFilters.remove(category);
        mCategories.setValue(mFilters);
    }



    public LiveData<List<ShoppingListForList>> getShoppingLists() {
        return mShoppingLists;
    }

    public void insert(ShoppingList shoppingList){
        mRepository.insert(shoppingList);
    }
}
