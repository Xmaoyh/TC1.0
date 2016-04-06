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
    private OnItemListener mOnItemListener;

    public void setmOnItemListener(OnItemListener mOnItemListener) {
        this.mOnItemListener = mOnItemListener;
    }

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
        holder.initDate.setText(mOrderdata.get(position).getDateList().get(position).getInitDate());
        holder.sendingUnit.setText(mOrderdata.get(position).getDateList().get(position).getSendingUnit());
        holder.sendingAddr.setText(mOrderdata.get(position).getDateList().get(position).getSendingAddr());
        holder.orderNo.setText(mOrderdata.get(position).getDateList().get(position).getOrderNo());
    }

    @Override
    public int getItemCount() {
        return mOrderdata == null ? 0 : mOrderdata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView initDate;
        TextView sendingUnit;
        TextView sendingAddr;
        TextView orderNo;

        public ViewHolder(final View itemView) {
            super(itemView);
            initDate = (TextView) itemView.findViewById(R.id.initDate);
            sendingUnit = (TextView) itemView.findViewById(R.id.sendingUnit);
            sendingAddr = (TextView) itemView.findViewById(R.id.sendingAddr);
            orderNo = (TextView) itemView.findViewById(R.id.orderNo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemListener.onItemClick(itemView,getLayoutPosition());
                }
            });
        }
    }

    public  interface OnItemListener{
        void onItemClick(View view, int position);
    }
}
