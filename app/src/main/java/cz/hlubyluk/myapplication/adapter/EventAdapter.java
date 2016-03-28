package cz.hlubyluk.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.sql.Date;
import java.util.List;

import cz.hlubyluk.myapplication.R;
import cz.hlubyluk.myapplication.entity.DBEvent;

/**
 * Created by HlubyLuk on 28.03.16.
 */
public class EventAdapter extends BaseAdapter {
    private final List<DBEvent> data;

    public EventAdapter(Context context, List<DBEvent> data) {
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public DBEvent getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.db_event, null);
        }

        TextView date = (TextView) convertView.findViewById(R.id.db_time);
        TextView kind = (TextView) convertView.findViewById(R.id.db_kind);
        TextView id = (TextView) convertView.findViewById(R.id.db_id);
        TextView from = (TextView) convertView.findViewById(R.id.db_from);
        TextView to = (TextView) convertView.findViewById(R.id.db_to);

        DBEvent dbEvent = data.get(position);
        Date time = new Date(dbEvent.getTimeStamp());

        setTextViewText(date, time.toString());
        setTextViewText(kind, dbEvent.getKindName());
        setTextViewText(id, dbEvent.getId());
        setTextViewText(from, dbEvent.getFromName());
        setTextViewText(to, dbEvent.getToName());

        return convertView;
    }

    private void setTextViewText(TextView textView, String text) {
        textView.setText(text);
    }
}
