package cz.hlubyluk.myapplication.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import cz.hlubyluk.myapplication.entity.Item;

/**
 * Created by HlubyLuk on 28.03.16.
 */
public class DropDownAdapter implements SpinnerAdapter {
    private final Context context;
    private final Item[] values;

    public DropDownAdapter(Context context, Item[] values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return createView(position);
    }

    private View createView(int position) {
        Item value = values[position];
        String name = value.getName();

        TextView textView = new TextView(context);
        textView.setText(name);
        textView.setTextColor(Color.BLACK);

        return textView;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Item getItem(int position) {
        return values[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return createView(position);
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return values.length == 0;
    }
}
