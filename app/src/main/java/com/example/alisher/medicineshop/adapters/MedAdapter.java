package com.example.alisher.medicineshop.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.alisher.medicineshop.R;
import com.example.alisher.medicineshop.entities.Medicine;

import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MedAdapter extends RecyclerView.Adapter<MedAdapter.ItemHolder> {

    private List<Medicine> iList;
    private Context context;
    private CallBack callBack;

    public MedAdapter(List<Medicine> iList, Context context) {
        this.iList = iList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_row, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        holder.bind(iList.get(position));
    }

    public void setCallback(CallBack callback) {
        this.callBack = callback;
    }

    @Override
    public int getItemCount() {
        return iList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_name)
        TextView tv_name;

        @BindView(R.id.tv_description)
        TextView tv_description;

        @BindView(R.id.tv_cost)
        TextView tv_cost;
        Medicine bindItem;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Medicine it) {
            bindItem = it;
            tv_name.setText(it.getName());
            tv_description.setText(it.getDescription());
            tv_cost.setText(it.getPrice());
        }
/*
        @OnClick(R.id.checkBox)
        public void checked() {
            callBack.selectedItem(bindItem);
        }
        */
    }

    public interface CallBack {
        void selectedItem(Medicine iList);
    }
}