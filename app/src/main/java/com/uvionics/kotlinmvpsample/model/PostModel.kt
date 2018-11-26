package com.uvionics.kotlinmvpsample.model

import android.os.Parcel
import android.os.Parcelable
import android.os.Parcelable.Creator
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PostModel : Parcelable {

    @SerializedName("userId")
    @Expose
    var userId: Int? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("body")
    @Expose
    var body: String? = null

    protected constructor(`in`: Parcel) {
        this.userId = `in`.readValue(Int::class.java.classLoader) as Int
        this.id = `in`.readValue(Int::class.java.classLoader) as Int
        this.title = `in`.readValue(String::class.java.classLoader) as String
        this.body = `in`.readValue(String::class.java.classLoader) as String
    }

    constructor() {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeValue(userId)
        dest.writeValue(id)
        dest.writeValue(title)
        dest.writeValue(body)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<PostModel> = object : Creator<PostModel> {


            override fun createFromParcel(`in`: Parcel): PostModel {
                return PostModel(`in`)
            }

            override fun newArray(size: Int): Array<PostModel?> {
                return arrayOfNulls(size)
            }

        }
    }

}