package maiz.me.dailycost

import android.content.DialogInterface
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity :AppCompatActivity() , View.OnClickListener{

   private  var count:Int = 0

    override fun onClick(v: View) {
        when(v.id){
            R.id.login->{
                Toast.makeText(this,"您输入的是："+username.text,Toast.LENGTH_SHORT).show()
                loading.visibility=View.VISIBLE
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    loading.setProgress(20,true)
                }else{
                    loading.progress=20
                }

             /* AlertDialog.Builder(this)
                .setTitle("确定登录？")
                .setCancelable(false)
                .setPositiveButton("确定", { dialogInterface: DialogInterface, i: Int -> Toast.makeText(this,"即将开始登录",Toast.LENGTH_SHORT).show()})
                      .setNegativeButton("取消",{dialogInterface: DialogInterface, i: Int -> Toast.makeText(this,"取消中",Toast.LENGTH_SHORT).show()})
                      .create().show()*/
                


            }
            R.id.reset->{
                Toast.makeText(this,"重置处理中",Toast.LENGTH_SHORT).show()

            }
            R.id.logo->{

                if(count%2==0)
                    logo.setImageResource(R.drawable.moneybook1)
                else
                    logo.setImageResource(R.drawable.moneybook)
                count++

            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login.setOnClickListener(this)
        reset.setOnClickListener(this)
        logo.setOnClickListener(this)
        loading.setOnClickListener(this);
    }
}
