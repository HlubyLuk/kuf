package cz.hlubyluk.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import cz.hlubyluk.myapplication.adapter.DropDownAdapter;
import cz.hlubyluk.myapplication.database.Database;
import cz.hlubyluk.myapplication.entity.Kind;
import cz.hlubyluk.myapplication.entity.Place;

/**
 * Created by HlubyLuk on 28.03.16.
 */
public class FragmentCreate extends Fragment {
    private static final String TAG = "FragmentCreate";
    private DropDownAdapter kindAdapter;
    private DropDownAdapter placeAdapter;
    private Spinner kind;
    private Spinner from;
    private Spinner to;
    private EditText id;
    private Database database;
    private ICancel callBack;

    public static Fragment newInstance() {
        return new FragmentCreate();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        setUpFragment(activity);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        setUpFragment(context);
    }

    private void setUpFragment(Context context) {
        this.callBack = ((ICancel) context);
        this.database = new Database(context);
        this.kindAdapter = new DropDownAdapter(context, Kind.values());
        this.placeAdapter = new DropDownAdapter(context, Place.values());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        return inflater.inflate(R.layout.fragment_create, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        kind = (Spinner) view.findViewById(R.id.create_kind);
        from = (Spinner) view.findViewById(R.id.create_from);
        to = (Spinner) view.findViewById(R.id.create_to);
        id = (EditText) view.findViewById(R.id.create_id);
        Button apply = (Button) view.findViewById(R.id.create_apply);
        apply.setOnClickListener(new ClickHandler());

        kind.setAdapter(kindAdapter);
        from.setAdapter(placeAdapter);
        to.setAdapter(placeAdapter);
    }

    private class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Kind kindSelected = (Kind) kind.getSelectedItem();
            Place fromSelected = (Place) from.getSelectedItem();
            Place toSelected = (Place) to.getSelectedItem();
            Editable text = id.getText();

            database.insert(kindSelected, fromSelected, toSelected, text);

            callBack.onCancel();
        }
    }
}
