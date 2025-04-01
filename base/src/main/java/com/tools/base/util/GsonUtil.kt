package com.tools.base.util

import com.google.gson.Gson

object GsonUtil {

    @Volatile
    private var gson: Gson?=null

    private fun getInstance():Gson{
        if(gson ==null){
            synchronized(GsonUtil::class.java) {
                if(gson ==null){
                    gson = Gson()
                }
            }
        }
        return gson!!
    }



    fun <T> jsonToBean(gsonString:String, cls:Class<T>): T {
        return getInstance().fromJson(gsonString,cls)
    }

    fun  toJson(cls: Any):String{
        return getInstance().toJson(cls)
    }

}