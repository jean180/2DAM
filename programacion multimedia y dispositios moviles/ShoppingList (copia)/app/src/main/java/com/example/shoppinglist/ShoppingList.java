package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "shopping_list")
public class ShoppingList {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private final String mId;

    @NonNull
    @ColumnInfo(name = "name")
    private final String mName;

    public ShoppingList(@NonNull String id, @NonNull String name){
        mId = id;
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public String getId() {
        return mId;
    }
}
