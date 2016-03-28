package cz.hlubyluk.myapplication.entity;

/**
 * Created by HlubyLuk on 28.03.16.
 */
public class DBEvent {
    private static final String TAG = "DBEvent";
    private Kind kind;
    private Place from;
    private Place to;
    private String id;
    private long timeStamp;

    public DBEvent(int kind, int from, int to, String id, long timeStamp) {
        this.kind = Kind.find(kind);
        this.from = Place.find(from);
        this.to = Place.find(to);
        this.id = id;
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public String getKindName() {
        return kind.getName();
    }

    public String getId() {
        return id;
    }

    public String getFromName() {
        return from.getName();
    }

    public String getToName() {
        return to.getName();
    }
}
