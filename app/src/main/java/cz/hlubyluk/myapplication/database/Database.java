package cz.hlubyluk.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;

import java.util.ArrayList;
import java.util.List;

import cz.hlubyluk.myapplication.entity.DBEvent;
import cz.hlubyluk.myapplication.entity.Kind;
import cz.hlubyluk.myapplication.entity.Place;

/**
 * Created by HlubyLuk on 28.03.16.
 */
public class Database extends SQLiteOpenHelper {
    private static final String TAG = "Database";
    private static final int VERSION = 1;
    private static final String DATABASE = "my_application.db";
    private static final String TABLE = "events";
    private static final String KIND = "kind";
    private static final String FROM = "fromPlace";
    private static final String TO = "toPlace";
    private static final String KIND_ID = "kind_id";
    private static final String DATE = "date_event";

    private static final String[] COLUMNS = {KIND, FROM, TO, KIND_ID, DATE};
    private static final String DATABASE_CREATE =
            String.format(
                    "CREATE TABLE %s (id INTEGER PRIMARY KEY AUTOINCREMENT, %s INTEGER, %s INTEGER, %s INTEGER, %s TEXT NOT NULL, %s INTEGER);",
                    TABLE,
                    KIND,
                    FROM,
                    TO,
                    KIND_ID,
                    DATE
            );

    private static final String DATABASE_DROP =
            String.format(
                    "DROP TABLE IF EXISTS %s ;",
                    TABLE
            );

    public Database(Context context) {
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DATABASE_DROP);
        onCreate(db);
    }

    public void insert(Kind kind, Place from, Place to, Editable kindId) {
        ContentValues values = new ContentValues();
        values.put(KIND, kind.getId());
        values.put(FROM, from.getId());
        values.put(TO, to.getId());
        values.put(DATE, System.currentTimeMillis());
        values.put(KIND_ID, kindId.toString());

        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(TABLE, null, values);
        database.close();
    }

    public List<DBEvent> getAll() {
        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.query(TABLE, COLUMNS, null, null, null, null, null);
        cursor.moveToFirst();

        ArrayList<DBEvent> ret = new ArrayList<>();
        while (cursor.moveToNext()) {
            int kind = cursor.getInt(0);
            int from = cursor.getInt(1);
            int to = cursor.getInt(2);
            String id = cursor.getString(3);
            long timeStamp = cursor.getLong(4);

            DBEvent dbEvent = new DBEvent(kind, from, to, id, timeStamp);
            ret.add(dbEvent);
        }

        cursor.close();

        return ret;
    }

}
