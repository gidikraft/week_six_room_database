package com.example.week_six_rom_database.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int, val firstName: String, val lastName: String, val phoneNumber: String) {
}