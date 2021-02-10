package com.develou.shoppinglist.data.relationentities;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.develou.shoppinglist.data.entities.Info;
import com.develou.shoppinglist.data.partialentities.ShoppingListForList;


public class ShoppingListAndInfo {
    @Embedded
    public ShoppingListForList shoppingList;

    @Relation(
            parentColumn = "id",
            entityColumn = "shopping_list_id"
    )
    public Info info;
}
