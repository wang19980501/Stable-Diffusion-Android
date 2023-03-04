package com.shifthackz.aisdv1.storage.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shifthackz.aisdv1.storage.database.contract.StableDiffusionSamplerContract
import com.shifthackz.aisdv1.storage.database.entity.StableDiffusionSamplerEntity
import io.reactivex.rxjava3.core.Completable

@Dao
interface StableDiffusionSamplerDao {

    @Query("SELECT * FROM ${StableDiffusionSamplerContract.TABLE}")
    fun queryAll(): List<StableDiffusionSamplerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(items: List<StableDiffusionSamplerEntity>): Completable
}
