package Adapter;

import Object.DrawerItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import demomap.nguyenthanhnam.com.ungdungdocbao.R;

import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 9/1/2016.
 */
public class CustomDrawerAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<DrawerItem> listItem;

    public CustomDrawerAdapter(Context mContext, ArrayList<DrawerItem> listItem) {
        this.mContext = mContext;
        this.listItem = listItem;
    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.itemdrawerlayout, parent, false);
            viewHolder.name = (TextView) convertView.findViewById(R.id.txt_category);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.image_drawer);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        DrawerItem drawerItem = listItem.get(position);
        viewHolder.imageView.setImageResource(drawerItem.getImage());
        viewHolder.name.setText(drawerItem.getmName());
        return convertView;
    }

    private class ViewHolder {
        TextView name;
        ImageView imageView;
    }
}
