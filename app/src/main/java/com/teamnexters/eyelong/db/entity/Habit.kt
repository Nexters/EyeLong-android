package com.teamnexters.eyelong.db.entity

import androidx.room.*

@Entity(tableName = "habit")
data class Habit (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int=0,
    @ColumnInfo(name = "description")
    val description : String
)

//foreign key
// habit - habit_history
data class HabitHistoryLists(
    @Embedded val habit : Habit,
    @Relation(
        parentColumn = "id",
        entityColumn = "habit_id"
    )
    val habitLists : List<HabitHistory>
)