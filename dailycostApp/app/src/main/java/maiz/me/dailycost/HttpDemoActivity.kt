package maiz.me.dailycost

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_http_demo.*
import maiz.me.dailycost.R.id.msg
import maiz.me.dailycost.model.WeatherInfo
import maiz.me.dailycost.util.NetUtil
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import okhttp3.OkHttpClient



class HttpDemoActivity : AppCompatActivity(),View.OnClickListener {

    val TAG:String = this.javaClass.simpleName

    var client = OkHttpClient()


    override fun onClick(v: View?) {
        Log.d(TAG,"调用点击处理")
        Toast.makeText(this,"准备发送请求",Toast.LENGTH_SHORT)
        var msgText:String = msg.text.toString();

        Thread({

            var respText = StringBuilder()
            Log.d(this.javaClass.simpleName,"发送请求中")

          /*  var conn:HttpURLConnection = URL("https://www.baidu.com/s?wd=$msgText").openConnection() as HttpURLConnection
            conn.requestMethod="GET"
            conn.connectTimeout=2000
            conn.readTimeout=2000
            conn.connect()

            var reader = BufferedReader(InputStreamReader(conn.inputStream))
            Log.d(TAG,"处理响应")


            reader.forEachLine {
                respText.append(it)
            }
            runOnUiThread({
            Log.d(TAG,"$respText")
              resp.text=respText.toString()

            })*/


           var response =  client.newCall(Request.Builder().url("http://192.168.0.100:10000/weather").build()).execute()
            var responseContent = response.body()!!.string()


            Log.d(TAG,responseContent)
            var weatherInfo =Gson().fromJson<WeatherInfo>(responseContent,WeatherInfo::class.java)
            if(weatherInfo.temp>10){
                //skip to another intent
                Intent()
            }else {

                runOnUiThread({ resp.text = "气温略低" })
            }


        }).start()


    }

    fun login(username:String,password:String){
        NetUtil.request("login")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_http_demo)

        req.setOnClickListener(this)


    }
}
