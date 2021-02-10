package com.example.shoppinglist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ShoppingListDao {

    @Query("SELECT id, name, is_favorite FROM shopping_list")
    LiveData<List<ShoppingListForList>> getAll();

    @Query("SELECT * FROM shopping_list WHERE id = :id LIMIT 1")
    LiveData<ShoppingList> getShoppingList(String id);

    @Query("SELECT id, name, is_favorite FROM shopping_list WHERE category IN(:categories)")
    LiveData<List<ShoppingListForList>> getShoppingListsByCategories(List<String> categories);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ShoppingList shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    void  partialInsert(ShoppingListInsert shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    void insertShoppingLists(List<ShoppingListInsert> lists);

    @Update(entity = ShoppingList.class)
    void markFavorite(ShoppingListFavorite shoppigList);







}
