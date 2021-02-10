package com.example.shoppinglist;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ShoppingListRepository {
   private final ShoppingListDao mShoppingListDao;

   public ShoppingListRepository(Context context) {
       ShoppingListDatabase db = ShoppingListDatabase.getInstance(context);
       mShoppingListDao = db.shoppingListDao();
   }

   public  LiveData<List<ShoppingListForList>> getShoppingLists() {
       return mShoppingListDao.getAll();
   }

   public LiveData<List<ShoppingListForList>> getShoppingListWhitCategories(List<String> categories) {
       return mShoppingListDao.getShoppingListsByCategories(categories);
   }

   public LiveData<ShoppingList> getShoppingList(String id) {
       return mShoppingListDao.getShoppingList(id);
   }

   public void insert(ShoppingListInsert shoppingList) {
       ShoppingListDatabase.dbExecutor.execute(
               () -> mShoppingListDao.partialInsert(shoppingList)
       );
   }

   public void markFavorite(ShoppingListFavorite shoppingLists) {
       ShoppingListDatabase.dbExecutor.execute(
               () -> mShoppingListDao.markFavorite(shoppingLists)
       );
   }
}
