package com.example.week_six_rom_database.data

import androidx.lifecycle.LiveData

class UserRepository(val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

}