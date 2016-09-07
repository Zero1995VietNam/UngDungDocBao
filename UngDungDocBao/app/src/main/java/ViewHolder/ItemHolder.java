package ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import demomap.nguyenthanhnam.com.ungdungdocbao.R;

/**
 * Created by namnguyenthanhnam on 9/1/2016.
 */
public class ItemHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView txtViewTitle,txtViewDate;
    public RelativeLayout linearLayout;
    public ItemHolder(View itemView) {
        super(itemView);
        imageView= (ImageView) itemView.findViewById(R.id.imageView);
        txtViewTitle= (TextView) itemView.findViewById(R.id.txtTitle);
        txtViewDate= (TextView) itemView.findViewById(R.id.txt_date);
        linearLayout= (RelativeLayout) itemView.findViewById(R.id.linearlayout);
    }
}
