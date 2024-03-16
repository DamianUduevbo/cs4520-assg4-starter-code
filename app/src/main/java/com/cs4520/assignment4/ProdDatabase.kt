package com.cs4520.assignment4

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// The local room database
@Database(entities = [ProductModel::class], version = 1, exportSchema = false)
abstract class ProdDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDAO

    companion object {
        @Volatile
        private var INSTANCE: ProdDatabase? = null

        fun getInstance(context: Context): ProdDatabase {
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProdDatabase::class.java,
                    "products"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}