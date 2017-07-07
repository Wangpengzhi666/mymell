package com.wpzmall.mymall.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.list.ListBean;
import com.wpzmall.mymall.view.activity.DetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  09:08
 * <p>
 * 思路：
 */


public class ListRecyclerAdapter extends RecyclerView.Adapter<ListRecyclerAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<ListBean.DatasBean.GoodsListBean> list = new ArrayList<>();

    public ListRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<ListBean.DatasBean.GoodsListBean> l) {
        if (l != null) {
            list.addAll(l);
        }
        notifyDataSetChanged();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        final View view = View.inflate(context, R.layout.item_list_list, null);
        final MyViewHolder viewHodler = new MyViewHolder(view);

        return viewHodler;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.listRecycleName.setText(list.get(position).getGoods_name());
        holder.listRecyclePrice.setText(list.get(position).getGoods_price());
        holder.listRecycleNum.setText(list.get(position).getGoods_salenum());
        Glide.with(context)
                .load(list.get(position).getGoods_image_url())
                .placeholder(R.mipmap.ic_action_add)
                .into(holder.listRecycleImage);    // 如果设置了回调，则设置点击事件
        if (monClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    monClickListener.onItemClickListener(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int poss = holder.getLayoutPosition();
                    monClickListener.onLongItemClickListener(holder.itemView,poss);
                    return false;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView listRecycleImage;
        public TextView listRecycleName;
        public TextView listRecyclePrice;
        public TextView listRecycleNum;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.listRecycleImage = (ImageView) itemView.findViewById(R.id.list_recycle_image);
            this.listRecycleName = (TextView) itemView.findViewById(R.id.list_recycle_name);
            this.listRecyclePrice = (TextView) itemView.findViewById(R.id.list_recycle_price);
            this.listRecycleNum = (TextView) itemView.findViewById(R.id.list_recycle_num);
        }
    }
    //定义接口  条目点击事件  跟  长按条目点击事件
    public interface OnClickListenerr{
        void onItemClickListener(View view, int position);
        void onLongItemClickListener(View view, int position);
    }

    private OnClickListenerr monClickListener;

    public void setOnItemClinckListener(OnClickListenerr onClickListener){
        this.monClickListener = onClickListener;
    }
}
