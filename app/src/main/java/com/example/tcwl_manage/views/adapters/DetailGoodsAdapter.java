package com.example.tcwl_manage.views.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.models.enties.OrderInfo;

import java.util.List;

/**
 * Created by suanzi on 2016/3/29.
 */
public class DetailGoodsAdapter extends RecyclerView.Adapter<DetailGoodsAdapter.ViewHolder> {

    private List<OrderInfo> orderInfos;
    private Activity activity;
    private LayoutInflater inflater;

    public DetailGoodsAdapter(Activity activity, List<OrderInfo> orderInfos) {
        this.activity = activity;
        this.orderInfos = orderInfos;
        inflater = LayoutInflater.from(activity);
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.detail_goods_item1, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OrderInfo info = orderInfos.get(position);
        holder.name.setText(info.getGoods().get(position).getName());
        holder.number.setText(String.valueOf(info.getGoods().get(position).getQuantity()));
        holder.weight.setText(String.valueOf(info.getGoods().get(position).getWeight()));

    }

    @Override
    public int getItemCount() {
        return orderInfos == null ? 0 : orderInfos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView number;
        TextView weight;

        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.detail_goods_name);
            number = (TextView) itemView.findViewById(R.id.detail_goods_number);
            weight = (TextView) itemView.findViewById(R.id.detail_goods_weight);
        }
    }


}
