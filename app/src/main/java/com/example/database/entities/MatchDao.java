package com.example.database.entities;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface MatchDao {
    @Query("SELECT * FROM `match` ORDER BY matchId ASC")
    Flowable<List<Match>> getAll();

    @Query("SELECT * FROM `match` WHERE matchId IN (:matchIds)")
    Flowable<List<Match>> loadAllByIds(int[] matchIds);

    @Query("SELECT * FROM `match` WHERE matchId LIKE :id")
    Flowable<Match> findById(int id);

    @Insert
    Completable insertAll(Match... matches);

    @Delete
    Completable delete(Match match);
}