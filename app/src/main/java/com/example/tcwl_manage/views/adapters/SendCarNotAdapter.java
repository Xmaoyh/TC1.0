package com.example.tcwl_manage.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.tcwl_manage.R;
import com.example.tcwl_manage.models.enties.OrderList;

import java.util.List;

/**
 * Created by MAOYH on 2016/3/29.
 */
public class SendCarNotAdapter extends RecyclerView.Adapter<SendCarNotAdapter.MyViewHolder> {
    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<OrderList> mOrderLists;

    /**
     * recyclerView点击事件
     */
    public interface OnItemClickListener {
        /*item点击事件*/
        void onDataClick(int position);

        /*checkBox勾选事件*/
        void onCheckBoxClick(double volume, double wight);

        /*checkBox未勾选事件*/
        void onCheckBoxUnClick(double volume, double wight);
    }

    private OnItemClickListener mOnItemClickListener;

    public SendCarNotAdapter(Context context, List<OrderList> orderLists) {
        this.mContext = context;
        this.mOrderLists = orderLists;
        mLayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_sendcar_not, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.order_no.setText(mOrderLists.get(position).getDateList().get(position).getOrderNo());
        holder.order_no_manual.setText(mOrderLists.get(position).getDateList().get(position).getOrderNoManual());
        holder.sending_addr.setText(mOrderLists.get(position).getDateList().get(position).getSendingAddr());
        holder.sending_unit.setText(mOrderLists.get(position).getDateList().get(position).getSendingUnit());
        holder.total_volume.setText(String.valueOf(mOrderLists.get(position).getDateList().get(position).getTotalVolume()));
        holder.total_wight.setText(String.valueOf(mOrderLists.get(position).getDateList().get(position).getTotalWight()));
        //设置点击事件
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onDataClick(position);
                }
            });
            //checkBox点击事件
            holder.mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                    if (checked) {
                        mOnItemClickListener.onCheckBoxClick(mOrderLists.get(position).getDateList().get(position).getTotalVolume(), mOrderLists.get(position).getDateList().get(position).getTotalWight());
                    } else {
                        mOnItemClickListener.onCheckBoxUnClick(mOrderLists.get(position).getDateList().get(position).getTotalVolume(), mOrderLists.get(position).getDateList().get(position).getTotalWight());
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        //由于是网络加载的数据，要先判断是否为空
        return mOrderLists == null ? 0 : mOrderLists.size();
    }

    //设置Recyclerview 点击事件监听
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView order_no;
        TextView order_no_manual;
        TextView sending_unit;
        TextView sending_addr;
        TextView total_volume;
        TextView total_wight;
        CheckBox mCheckBox;

        public MyViewHolder(View view) {
            super(view);
            order_no = (TextView) view.findViewById(R.id.tv_order_no);
            order_no_manual = (TextView) view.findViewById(R.id.tv_order_no_manual);
            sending_unit = (TextView) view.findViewById(R.id.tv_sending_unit);
            sending_addr = (TextView) view.findViewById(R.id.tv_sending_addr);
            total_volume = (TextView) view.findViewById(R.id.tv_total_volume);
            total_wight = (TextView) view.findViewById(R.id.tv_total_wight);
            mCheckBox = (CheckBox) view.findViewById(R.id.checkbox);

        }

    }
}
