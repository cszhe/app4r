package nz.ac.auckland.zhe203.lifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LifeCycle", "++++onCreate");

        final TextView et = (TextView)findViewById(R.id.textView);

        et.setText("This is old data");
        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("The data has been changed");
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("LifeCycle", "++++onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("LifeCycle", "++++onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d("LifeCycle", "++++onPause");
    }



    @Override
    protected void onStop() {
        super.onStop();

        Log.d("LifeCycle", "++++onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d("LifeCycle", "++++onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.d("LifeCycle", "++++onDestroy");
    }
    
}
