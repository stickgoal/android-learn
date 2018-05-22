package maiz.me.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HelloActivity extends AppCompatActivity {


    private static final String TAG = "HelloActivity";

    public static final String EXTRA_MSG="maiz.me.helloworld.HelloActivity.MSG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //指定页面
        setContentView(R.layout.activity_hello);
        //Log的使用
        Log.i(TAG, "onCreate: 创建完成");
    }


    public void sendMeesage(View view){
        //使用Intent启动另一个Activity
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText et = findViewById(R.id.editText);
        String message = et.getText().toString();
        intent.putExtra(EXTRA_MSG,message);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"您点击了添加菜单项",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rm_item:
                Toast.makeText(this,"您点击了删除菜单项",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}
