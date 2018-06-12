package maiz.me.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);


        Intent intent = getIntent();
        TextView tv = findViewById(R.id.messageTV);
        tv.setText(intent.getStringExtra(HelloActivity.EXTRA_MSG));

        Toast.makeText(this,"A new Toast is ready,新吐司烤好了。",Toast.LENGTH_SHORT).show();

    }
}
