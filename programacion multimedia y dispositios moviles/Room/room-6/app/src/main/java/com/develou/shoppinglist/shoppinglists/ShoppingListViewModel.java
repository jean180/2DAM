package com.develou.shoppinglist.shoppinglists;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.develou.shoppinglist.Utils;
import com.develou.shoppinglist.data.ShoppingListRepository;
import com.develou.shoppinglist.data.entities.Info;
import com.develou.shoppinglist.data.partialentities.ShoppingListId;
import com.develou.shoppinglist.data.partialentities.ShoppingListInsert;
import com.develou.shoppinglist.data.relationentities.ShoppingListAndInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShoppingListViewModel extends AndroidViewModel {

    // Repositorio de listas de compras
    private final ShoppingListRepository mRepository;

    // Filtros observados
    private final MutableLiveData<List<String>> mCategories
            = new MutableLiveData<>(new ArrayList<>());

    // Listas de compras observadas
    private final LiveData<List<ShoppingListAndInfo>> mShoppingLists;

    // Filtros
    private final List<String> mFilters = new ArrayList<>();

    public ShoppingListViewModel(@NonNull Application application) {
        super(application);
        mRepository = new ShoppingListRepository(application);

        // Obtener listas de compras por categorías
        mShoppingLists = Transformations.switchMap(
                mCategories,
                categories -> {
                    if (categories.isEmpty()) {
                        return mRepository.getShoppingLists();
                    } else {
                        return mRepository.getShoppingListsWithCategories(categories);
                    }
                }
        );
    }

    public void insert(ShoppingListInsert shoppingList) {
        String date = Utils.getCurrentDate();
        Info info = new Info(UUID.randomUUID().toString(), shoppingList.id, date, date);
        mRepository.insert(shoppingList, info);
    }

    public void addFilter(String category) {
        mFilters.add(category);
        mCategories.setValue(mFilters);
    }

    public void removeFilter(String category) {
        mFilters.remove(category);
        mCategories.setValue(mFilters);
    }

    public LiveData<List<ShoppingListAndInfo>> getShoppingLists() {
        return mShoppingLists;
    }

    public void markFavorite(String shoppingListId) {
        mRepository.markFavorite(shoppingListId);
    }

    public void deleteShoppingList(ShoppingListAndInfo shoppingListAndInfo) {
        ShoppingListId id = new ShoppingListId(shoppingListAndInfo.shoppingList.id);
        mRepository.deleteShoppingList(id);
    }

    public void deleteAll() {
        mRepository.deleteAll();
    }
}
