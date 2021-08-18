package com.example.internassign.room;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public static final String NAME ="SPACEX" ;

    public abstract Taskdao taskdao();
}
