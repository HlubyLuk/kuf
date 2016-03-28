package cz.hlubyluk.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by HlubyLuk on 28.03.16.
 */
public class DetailActivity extends AppCompatActivity implements ICancel {
    public static final String FRAGMENT = "fragment";
    public static final int CREATE = 0;
    public static final int LIST = 1;
    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        Fragment fragment;
        switch (extras.getInt(FRAGMENT)) {
            case CREATE:
                fragment = FragmentCreate.newInstance();
                break;

            case LIST:
                fragment = FragmentList.newInstance();
                break;

            default:
                throw new RuntimeException("Not implemented");
        }

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.detail_root, fragment, TAG);
        fragmentTransaction.commit();
    }

    @Override
    public void onCancel() {
        finish();
    }
}
