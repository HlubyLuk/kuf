package cz.hlubyluk.myapplication;

import android.app.Activity;
import android.content.Intent;
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
            Intent intent = new Intent();
            intent.setClass(activity, DetailActivity.class);

            switch (v.getId()) {
                case R.id.home_create:
                    intent.putExtra(DetailActivity.FRAGMENT, DetailActivity.CREATE);
                    break;

                case R.id.home_list:
                    intent.putExtra(DetailActivity.FRAGMENT, DetailActivity.LIST);
                    break;

                default:
                    String format = String.format("%s", "Not implemented");
                    Log.e(TAG, format);
            }

            startActivity(intent);
        }
    }
}
