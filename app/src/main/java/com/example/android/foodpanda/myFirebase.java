package com.example.android.foodpanda;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Hunter on 12/19/2017.
 */

class myFirebase {
    private static FirebaseDatabase mDatabase;
    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }

        return mDatabase;
    }
}
