package cz.hlubyluk.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by HlubyLuk on 28.03.16.
 */
public class FragmentList extends Fragment{
    private static final String TAG = "FragmentList";

    public static Fragment newInstance() {
        return new FragmentList();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        setUp(context);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        setUp(activity);
    }

    private void setUp(Context context) {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView list = (ListView) view.findViewById(R.id.list_list);
    }
}
