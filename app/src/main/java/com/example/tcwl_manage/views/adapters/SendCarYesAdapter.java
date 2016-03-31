package com.example.tcwl_manage.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.models.enties.OrderList;

import java.util.List;

/**
 * Created by MAOYH on 2016/3/29.
 */
public class SendCarYesAdapter extends RecyclerView.Adapter<SendCarYesAdapter.MyViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<OrderList> mOrderLists;

    public SendCarYesAdapter(Context context, List<OrderList> orderLists) {
        this.mContext = context;
        this.mOrderLists = orderLists;
        mLayoutInflater = LayoutInflater.from(context);


    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_sendcar_yes,parent, false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.order_no.setText(mOrderLists.get(position).getDateList().get(position).getOrderNo());
            holder.order_no_manual.setText(mOrderLists.get(position).getDateList().get(position).getOrderNoManual());
            holder.sending_addr.setText(mOrderLists.get(position).getDateList().get(position).getSendingAddr());
            holder.sending_unit.setText(mOrderLists.get(position).getDateList().get(position).getSendingUnit());
            holder.total_volume.setText(String.valueOf(mOrderLists.get(position).getDateList().get(position).getTotalVolume()));
            holder.total_wight.setText(String.valueOf(mOrderLists.get(position).getDateList().get(position).getTotalWight()));
    }

    @Override
    public int getItemCount() {
        return mOrderLists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView order_no;
        TextView order_no_manual;
        TextView sending_unit;
        TextView sending_addr;
        TextView total_volume;
        TextView total_wight;

        public MyViewHolder(View view) {
            super(view);
            order_no = (TextView) view.findViewById(R.id.tv_order_no);
            order_no_manual = (TextView) view.findViewById(R.id.tv_order_no_manual);
            sending_unit = (TextView) view.findViewById(R.id.tv_sending_unit);
            sending_addr = (TextView) view.findViewById(R.id.tv_sending_addr);
            total_volume = (TextView) view.findViewById(R.id.tv_total_volume);
            total_wight = (TextView) view.findViewById(R.id.tv_total_wight);
        }

    }
}