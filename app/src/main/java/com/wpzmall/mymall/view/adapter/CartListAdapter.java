package com.wpzmall.mymall.view.adapter;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
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
    private TextView text;
    private String piece;
    private Float money;

    public CartListAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<CartBean.DatasBean.CartListBean.GoodsBean> list) {
        this.list = list;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setText(TextView text){
        this.text = text;
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
            viewHolder.cartLvAdd = (TextView) convertView.findViewById(R.id.cart_lv_add);
            viewHolder.cartlvupper = (CheckBox) convertView.findViewById(R.id.cart_lv_upper);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //选中的商品
        viewHolder.cartlvupper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < list.size(); i++) {
                    if (position == i) {
                        if (list.get(position).getCart_check()) {
                            list.get(position).setCart_check(false);
                        }
                        list.get(position).setCart_check(true);
                    }
                    if (list.get(i).getCart_check()) {
                        String goods_num = list.get(i).getGoods_num();
                        String goods_price = list.get(i).getGoods_price();
                        piece = piece + Integer.parseInt(goods_num);
                        money = money + Float.parseFloat(goods_price) * Integer.parseInt(goods_num);
                    }
                }
                text(piece,money);
            }
        });

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
                if (i == 1) {
                    Toast.makeText(context, "已经是一件了，不想买就删除吧", Toast.LENGTH_SHORT).show();
                } else {
                    viewHolder.cartLvNum2.setText(i - 1 + "");
                    viewHolder.cartLvBuyNum.setText(i - 1 + "");
                    float price = Float.parseFloat(viewHolder.cartLvPrice.getText().toString());
                    float price2 = Float.parseFloat(viewHolder.cartLvPrice2.getText().toString());
                    float price3 = price2 - price;
                    viewHolder.cartLvPrice2.setText(price3 + "");
                }
            }
        });
        //添加数量的点击事件
        viewHolder.cartLvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.parseInt(viewHolder.cartLvNum2.getText().toString());
                viewHolder.cartLvNum2.setText(i + 1 + "");
                viewHolder.cartLvBuyNum.setText(i + 1 + "");
                String s1 = Integer.toString(i + 1);
                list.get(position).setGoods_num(s1);
                float price = Float.parseFloat(viewHolder.cartLvPrice.getText().toString());
                float price2 = Float.parseFloat(viewHolder.cartLvPrice2.getText().toString());
                float price3 = price2 + price;
                String s = Float.toString(price3);
                list.get(position).setGoods_total(s);
                viewHolder.cartLvPrice2.setText(price3 + "");

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

        return convertView;    }

    class ViewHolder {
        public ImageView cartLvImage;  //商品图片的展示
        public TextView cartLvName;     //商品名称
        public TextView cartLvPrice;    //商品单价
        public TextView cartLvNum2;     //单个商品数量
        public TextView cartLvPrice2;
        public TextView cartLvDelete;   //删除商品按钮
        public TextView cartLvSubtract;   //减少数值的按钮
        public TextView cartLvBuyNum;   //可选择的数值
        public TextView cartLvAdd;   //增加数值的按钮
        public CheckBox cartlvupper;   //选中的Check
    }

    public void text(String piece,Float money){
        String str = "共<font color='#FF5001'>" + piece + "</font>件商品,共<font color='#FF5001'>" + money + "</font>元";
        text.setTextSize(18);
        text.setText(Html.fromHtml(str));
    }




}
