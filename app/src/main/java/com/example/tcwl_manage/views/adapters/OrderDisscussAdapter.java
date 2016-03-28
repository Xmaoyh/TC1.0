package com.example.tcwl_manage.views.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tcwl_manage.R;
import com.example.tcwl_manage.models.enties.Order;

import java.util.List;

/**
 * Created by suanzi on 2016/3/25.
 * 订单列表适配器
 */
public class OrderDisscussAdapter extends RecyclerView.Adapter<OrderDisscussAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private List<Order> mOrderdata;
    private Activity activity;

    public OrderDisscussAdapter(List<Order> mOrderdata, Activity activity) {
        this.mOrderdata = mOrderdata;
        this.activity = activity;
        mLayoutInflater = LayoutInflater.from(activity);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.order_disscuss_item1, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(activity).load(R.mipmap.date).into(holder.item1_image1);
        holder.initDate.setText(mOrderdata.get(position).getInitDate());
        Glide.with(activity).load(R.mipmap.arrvingaddrs).into(holder.item1_image2);
        holder.sendingUnit.setText(mOrderdata.get(position).getSendingUnit());
        holder.sendingAddr.setText(mOrderdata.get(position).getSendingAddr());
        Glide.with(activity).load(R.mipmap.orderbnumber).into(holder.item1_image3);
        holder.orderNo.setText(mOrderdata.get(position).getOrderNo());

    }

    @Override
    public int getItemCount() {

        return mOrderdata == null ? 0 : mOrderdata.size();
    }

    //item1 的ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item1_image1;
        TextView initDate;
        ImageView item1_image2;
        TextView sendingUnit;
        TextView sendingAddr;
        ImageView item1_image3;
        TextView orderNo;

        public ViewHolder(View itemView) {
            super(itemView);
            item1_image1 = (ImageView) itemView.findViewById(R.id.item1_image1);
            initDate = (TextView) itemView.findViewById(R.id.initDate);
            item1_image2 = (ImageView) itemView.findViewById(R.id.item1_image2);
            sendingUnit = (TextView) itemView.findViewById(R.id.sendingUnit);
            sendingAddr = (TextView) itemView.findViewById(R.id.sendingAddr);
            item1_image3 = (ImageView) itemView.findViewById(R.id.item1_image3);
            orderNo = (TextView) itemView.findViewById(R.id.orderNo);
        }
    }

}
