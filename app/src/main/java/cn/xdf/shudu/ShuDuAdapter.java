package cn.xdf.shudu;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fumm
 * Date : 2021/ 06/ 18 2:19 PM
 * Dec : 数独UI 适配器
 **/
public class ShuDuAdapter extends RecyclerView.Adapter<ShuDuAdapter.MyHolder> {

    private List<ShuduBean> mShuduBeanList = new ArrayList<>();

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_shudu_item, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        ShuduBean shuduBean = mShuduBeanList.get(position);
        setTopLine(holder.topView, shuduBean);
        setBottomLine(holder.bottomView, shuduBean);
        setRightLine(holder.rightView, shuduBean);
        setLeftLine(holder.liftView, shuduBean);
        holder.mTvValue.setText("" + shuduBean.value);
        holder.mTvValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemSelect(shuduBean);
            }
        });
    }


    private void onItemSelect(ShuduBean shuduBean){

        // 1、选中当前

        // 2、关联选中

        // 3、显示可能出现的值

    }

    private void setTopLine(View lineView, ShuduBean shuduBean) {
        // 第 1 行粗线
        lineView.setVisibility(shuduBean.row == 0 ? View.VISIBLE : View.GONE);
    }

    private void setBottomLine(View lineView, ShuduBean shuduBean) {
        // 第3 6 9 行粗线
        if((shuduBean.row + 1) % 3 == 0){
            lineView.setVisibility( View.VISIBLE);
            Log.d("显示：",shuduBean.row + " "+shuduBean.column+" 值："+shuduBean.value);
        }else{
            lineView.setVisibility(View.GONE);
            Log.d("隐藏：",shuduBean.row + " "+shuduBean.column+" 值："+shuduBean.value);
        }
    }


    private void setLeftLine(View lineView, ShuduBean shuduBean) {
        lineView.setVisibility(shuduBean.column == 0 ? View.VISIBLE : View.GONE);
    }

    private void setRightLine(View lineView, ShuduBean shuduBean) {
        // 第3 6 9 行粗线
        lineView.setVisibility((shuduBean.column + 1) % 3 == 0 ? View.VISIBLE : View.GONE);
    }


    @Override
    public int getItemCount() {
        return mShuduBeanList.size();
    }

    /**
     * 设置数据
     *
     * @param list
     */
    public void setData(List<ShuduBean> list) {
        mShuduBeanList = list;
        notifyDataSetChanged();
    }

    /**
     * 获取数据
     *
     * @return
     */
    public List<ShuduBean> getData() {
        return mShuduBeanList;
    }

    static class MyHolder extends RecyclerView.ViewHolder {
        private TextView mTvValue;
        private View liftView, rightView, topView, bottomView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mTvValue = itemView.findViewById(R.id.tv_value);
            liftView = itemView.findViewById(R.id.view_left_line);
            rightView = itemView.findViewById(R.id.view_right_line);
            topView = itemView.findViewById(R.id.view_top_line);
            bottomView = itemView.findViewById(R.id.view_bottom_line);
        }
    }
}
