package cz.hlubyluk.myapplication.entity;

/**
 * Created by HlubyLuk on 28.03.16.
 */
public enum Kind implements Item {
    P0(0, "P0P0"),
    P1(1, "P1P1"),
    P2(2, "P2P2"),
    P3(3, "P3P3"),
    P4(4, "P4P4"),
    P5(5, "P5P5"),
    P6(6, "P6P6"),
    P7(7, "P7P7"),
    P8(8, "P8P8"),
    P9(9, "P9P9");

    private final int id;
    private final String name;

    Kind(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
