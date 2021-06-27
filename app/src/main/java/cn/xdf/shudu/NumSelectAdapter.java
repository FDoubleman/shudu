package cn.xdf.shudu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class NumSelectAdapter extends RecyclerView.Adapter<NumSelectAdapter.MyHolder> {
     private List<NumSelectBean> sList = new ArrayList<>();

     public NumSelectAdapter(){
         for (int i = 1; i < 10; i++) {
             NumSelectBean numSelectBean = new NumSelectBean();
             numSelectBean.num = i;
             sList.add(numSelectBean);
         }
     }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_num_select,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  NumSelectAdapter.MyHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        public MyHolder(View itemView) {
            super(itemView);

        }
    }
}
