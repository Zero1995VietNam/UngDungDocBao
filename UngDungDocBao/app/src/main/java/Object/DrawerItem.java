package Object;

/**
 * Created by namnguyenthanhnam on 9/1/2016.
 */
public class DrawerItem {
    private String mName;
    private int image;

    public DrawerItem(String mName, int image) {
        this.mName = mName;
        this.image = image;
    }

    public String getmName() {
        return mName;
    }

    public int getImage() {
        return image;
    }
}
