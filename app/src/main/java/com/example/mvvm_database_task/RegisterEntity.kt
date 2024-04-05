package com.example.mvvm_database_task

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.Bindable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize

@VersionedParcelize
@Entity(tableName = "User_table", primaryKeys = ["Id", "Username"])
data class RegisterEntity(
    val Id: Int = 0,
    val Username: String,
    @ColumnInfo(name = "Password") var Password: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(Id)
        parcel.writeString(Username)
        parcel.writeString(Password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegisterEntity> {
        override fun createFromParcel(parcel: Parcel): RegisterEntity {
            return RegisterEntity(parcel)
        }

        override fun newArray(size: Int): Array<RegisterEntity?> {
            return arrayOfNulls(size)
        }
    }
}

/*override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    TODO("Not yet implemented")
}

override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    TODO("Not yet implemented")
}*/

//BaseObservable()