package com.develou.shoppinglist.data.partialentities;

import androidx.room.ColumnInfo;

public class ShoppingListForList {
    public String id;
    public String name;
    @ColumnInfo(name = "is_favorite")
    public boolean favorite;
}
