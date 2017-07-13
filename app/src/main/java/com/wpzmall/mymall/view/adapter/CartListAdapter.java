package com.wpzmall.mymall.view.adapter;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wpzmall.mymall.R;
import com.wpzmall.mymall.model.Bean.cart.CartBean;
import com.wpzmall.mymall.view.Event.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/7  21:37
 * <p>
 * 思路：
 */


public class CartListAdapter extends BaseAdapter {

    private Context context;
    private List<CartBean.DatasBean.CartListBean.GoodsBean> list = new ArrayList<>();
    private int code;

    public CartListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<CartBean.DatasBean.CartListBean.GoodsBean> list) {
        this.list = list;
    }

    public void setCode(int code){
        this.code = code;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = convertView.inflate(context, R.layout.item_cart_list, null);
            viewHolder.cartLvImage = (ImageView) convertView.findViewById(R.id.cart_lv_image);
            viewHolder.cartLvName = (TextView) convertView.findViewById(R.id.cart_lv_name);
            viewHolder.cartLvPrice = (TextView) convertView.findViewById(R.id.cart_lv_price);
            viewHolder.cartLvNum2 = (TextView) convertView.findViewById(R.id.cart_lv_num2);
            viewHolder.cartLvPrice2 = (TextView) convertView.findViewById(R.id.cart_lv_price2);
            viewHolder.cartLvDelete = (TextView) convertView.findViewById(R.id.cart_lv_delete);
            viewHolder.cartLvBuyNum = (TextView) convertView.findViewById(R.id.cart_lv_buyNum);
            viewHolder.cartLvSubtract = (TextView) convertView.findViewById(R.id.cart_lv_subtract);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.cartLvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cart_id = list.get(position).getCart_id();
                //EventBus传值
                EventBus.getDefault().post(new MessageEvent(cart_id));
            }
        });
        viewHolder.cartLvSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(viewHolder.cartLvNum2.getText().toString());
                if (i == 1){
                    Toast.makeText(context,"已经是一件了，不想买就删除吧", Toast.LENGTH_SHORT).show();
                }else {
                    viewHolder.cartLvNum2.setText(i - 1 + "");
                    viewHolder.cartLvBuyNum.setText(i - 1 + "");
                    int price = Integer.parseInt(viewHolder.cartLvPrice.getText().toString());
                    int price2 = Integer.parseInt(viewHolder.cartLvPrice2.getText().toString());
                    int price3 = price2 - price;
                    viewHolder.cartLvPrice2.setText(price3 + "");
                }
            }
        });

        viewHolder.cartLvName.setText(list.get(position).getGoods_name());
        viewHolder.cartLvPrice.setText(list.get(position).getGoods_price());
        viewHolder.cartLvPrice2.setText(list.get(position).getGoods_total());
        viewHolder.cartLvNum2.setText(list.get(position).getGoods_num());
        viewHolder.cartLvBuyNum.setText(list.get(position).getGoods_num());
        Glide.with(context)
                .load(list.get(position).getGoods_image_url())
                .placeholder(R.mipmap.ic_action_add)
                .into(viewHolder.cartLvImage);

        return convertView;
    }

    class ViewHolder {
        public ImageView cartLvImage;  //商品图片的展示
        public TextView cartLvName;     //商品名称
        public TextView cartLvPrice;    //商品单价
        public TextView cartLvNum2;     //单个商品数量
        public TextView cartLvPrice2;
        public TextView cartLvDelete;   //删除商品按钮
        public TextView cartLvSubtract;   //减少数值的按钮
        public TextView cartLvBuyNum;   //可选择的数值
        public TextView cartLvAdd;
    }
}
