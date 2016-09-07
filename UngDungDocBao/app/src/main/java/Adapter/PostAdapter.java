package Adapter;

import Config.ConfigApp;
import ViewHolder.ItemHolder;
import Object.Post;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.nguyenthanhnam.ungdungdocbao.ReadActivity;
import com.squareup.picasso.Picasso;
import demomap.nguyenthanhnam.com.ungdungdocbao.R;

import java.util.ArrayList;

/**
 * Created by namnguyenthanhnam on 9/1/2016.
 */
public class PostAdapter extends RecyclerView.Adapter<ItemHolder> {

    private Context mContext;
    private ArrayList<Post> listPost;

    public PostAdapter(Context mContext, ArrayList<Post> listPost) {
        this.mContext = mContext;
        this.listPost = listPost;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent,false);
        ItemHolder holder = new ItemHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, final int position) {
        Post post = listPost.get(position);
        Log.i("URL23",listPost.get(position).getUrl() +"");
        Picasso.with(mContext).load(post.getUrl()).into(holder.imageView);

        holder.txtViewTitle.setText(post.getTitle());
        holder.txtViewDate.setText("Ngay đăng:"+post.getPubDate());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mContext, ReadActivity.class);
                intent.putExtra(ConfigApp.KEY_POSITION_LINK,listPost.get(position).getLink());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listPost.size();
    }


}
