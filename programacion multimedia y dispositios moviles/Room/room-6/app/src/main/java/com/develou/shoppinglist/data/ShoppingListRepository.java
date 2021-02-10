package com.develou.shoppinglist.data;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.develou.shoppinglist.data.entities.Info;
import com.develou.shoppinglist.data.entities.ShoppingList;
import com.develou.shoppinglist.data.partialentities.ShoppingListId;
import com.develou.shoppinglist.data.partialentities.ShoppingListInsert;
import com.develou.shoppinglist.data.relationentities.ShoppingListAndInfo;

import java.util.List;

public class ShoppingListRepository {
    private final ShoppingListDao mShoppingListDao;

    public ShoppingListRepository(Context context) {
        ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
        mShoppingListDao = db.shoppingListDao();
    }

    public LiveData<List<ShoppingListAndInfo>> getShoppingLists() {
        return mShoppingListDao.getAll();
    }

    public LiveData<List<ShoppingListAndInfo>> getShoppingListsWithCategories(List<String> categories) {
        return mShoppingListDao.getShoppingListsByCategories(categories);
    }

    public LiveData<ShoppingList> getShoppingList(String id) {
        return mShoppingListDao.getShoppingList(id);
    }

    public void insert(ShoppingListInsert shoppingList, Info info) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.insertWithInfo(shoppingList, info)
        );
    }

    public void markFavorite(String shoppingListId) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.markFavorite(shoppingListId)
        );
    }

    public void deleteShoppingList(ShoppingListId id) {
        ShoppingListDatabase.dbExecutor.execute(
                () -> mShoppingListDao.deleteShoppingList(id)
        );
    }

    public void deleteAll() {
        ShoppingListDatabase.dbExecutor.execute(
                mShoppingListDao::deleteAll
        );
    }
}
