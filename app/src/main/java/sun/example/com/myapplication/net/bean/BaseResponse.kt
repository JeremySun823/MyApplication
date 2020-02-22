package sun.example.com.myapplication.net.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by sun on 2020-02-22
 */
data class BaseResponse<T>(
        @SerializedName("data")
        val data: T,
        @SerializedName("error_code")
        val error_code: Int? = 0,
        @SerializedName("result_message")
        val result_message: String? = "",
        @SerializedName("time_unix")
        val time_unix: Long? = 0
)
