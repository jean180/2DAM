package com.example.shoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    @Nullable
    @ColumnInfo(name = "category")
    private final String mCategory;

    @ColumnInfo(name = "is_favorite", defaultValue = "0")
    private  final  boolean mFavorite;

    @ColumnInfo(name = "created_date", defaultValue = "CURRENT_TIMESTAMP")
    private final String mCreatedDate;

    @ColumnInfo(name = "last_updated", defaultValue = "CURRENT_TIMESTAMP")
    private final String mLastUpdated;

    public ShoppingList(@NonNull String id, @NonNull String name, @Nullable String category, boolean favorite, String createdDate, String lastUpdated){
        mId = id;
        mName = name;
        mCategory = category;
        mFavorite = favorite;
        mCreatedDate = createdDate;
        mLastUpdated = lastUpdated;
    }

    public String getName() {
        return mName;
    }

    public String getId() {
        return mId;
    }

    @Nullable
    public String getmCategory() {
        return mCategory;
    }

    public String getmCreatedDate() {
        return mCreatedDate;
    }

    public String getmLastUpdated() {
        return mLastUpdated;
    }

    public boolean isFavorite() {
        return mFavorite;
    }
}
