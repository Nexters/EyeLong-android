package com.teamnexters.eyelong.db.entity

import androidx.room.*

@Entity(tableName = "user", indices = arrayOf(Index(name = "idx_user_id", value = ["id"])))
data class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int=0,
    @ColumnInfo(name = "name")
    val name: String
)

//foreign key
// user - exercise_history
data class UserExerciseLists(
    @Embedded val user : User,
    @Relation(
        parentColumn = "id",
        entityColumn = "user_id"
    )
    val exerciselists : List<ExerciseHistory>
)

//user - habit_history
data class UserHabitList(
    @Embedded val user : User,
    @Relation(
        parentColumn = "id",
        entityColumn = "user_id"
    )
    val habitHistoryLists : List<HabitHistory>
)
