package cz.hlubyluk.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ClickHandler clickHandler = new ClickHandler(this);

        Button create = (Button) findViewById(R.id.home_create);
        if (create != null) {
            create.setOnClickListener(clickHandler);
        }

        Button list = (Button) findViewById(R.id.home_list);
        if (list != null) {
            list.setOnClickListener(clickHandler);
        }
    }

    private class ClickHandler implements View.OnClickListener {

        private final Activity activity;

        public ClickHandler(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick() called with: " + "v.getId = [" + v.getId() + "]");

        }
    }
}
