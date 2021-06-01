package com.example.tp2bonus;

import android.content.Context;

        import androidx.room.Database;
        import androidx.room.Room;
        import androidx.room.RoomDatabase;

        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

@Database(entities = {Planete.class}, version = 1)
public abstract class appliDB extends RoomDatabase {
    public abstract DaoPlanete planeteDao();

    private static volatile appliDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static appliDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (appliDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            appliDB.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}