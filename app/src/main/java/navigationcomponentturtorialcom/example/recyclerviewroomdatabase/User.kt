package navigationcomponentturtorialcom.example.recyclerviewroomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo var username: String,
    @ColumnInfo var address: String
) {
}