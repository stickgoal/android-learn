package maiz.me.dailycost.util

import com.google.gson.Gson
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

object NetUtil{

    val serverUrl:String="http://192.168.0.100:10000/"

    var client = OkHttpClient()

    fun request(url:String):String{
       return request(url,null)
    }

    fun request(url:String,params:Map<String,Any>?):String{
        var reqBuilder = Request.Builder().url(serverUrl+url)

        if(params!=null&& !params.isEmpty()){
            val builder = FormBody.Builder()
                for(k in params.keys){
                    builder.add(k, params!![k].toString())
                }

            reqBuilder.post(builder.build())
        }
        var req = reqBuilder.build()

        var resp = client.newCall(req).execute()
        return resp.body()!!.string()
    }

    fun <T> request(url:String,params:Map<String,Any>?,clazz: Class<T>):T{
        var respContent = request(url,params)
        return Gson().fromJson<T>(respContent,clazz)
    }

}