package cz.hlubyluk.myapplication.entity;

/**
 * Created by HlubyLuk on 28.03.16.
 */
public enum Place implements Item {
    K0(0, "K0K0"),
    K1(1, "K1K1"),
    K2(2, "K2K2"),
    K3(3, "K3K3"),
    K4(4, "K4K4"),
    K5(5, "K5K5"),
    K6(6, "K6K6"),
    K7(7, "K7K7"),
    K8(8, "K8K8"),
    K9(9, "K9K9");

    private final int id;
    private final String name;

    Place(int id, String name) {
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
