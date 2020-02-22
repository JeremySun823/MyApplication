package sun.example.com.myapplication.net.bean

import com.google.gson.annotations.SerializedName

/**
 * Created by sun on 2020-02-22
 */
data class BaseException(
        @SerializedName("error_code")
        val error_code: Int? = 0,
        @SerializedName("result_message")
        val result_message: String? = ""
) : RuntimeException()