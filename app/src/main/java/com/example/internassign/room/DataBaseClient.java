package com.example.internassign.room;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Database;

import android.content.Context;

public class DataBaseClient {
    private Context mContext;
    private static DataBaseClient mInstance;

    private AppDataBase appDataBase;

    public DataBaseClient(Context mContext) {
        this.mContext = mContext;
        appDataBase = Room.databaseBuilder(mContext,AppDataBase.class, AppDataBase.NAME).fallbackToDestructiveMigration().build();
    }
    public static synchronized DataBaseClient getInstance(Context mContext){
        if(mInstance == null)
            mInstance = new DataBaseClient(mContext);
        return mInstance;
    }

    public AppDataBase getAppDataBase(){
        return appDataBase;
    }}

