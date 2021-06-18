package cn.xdf.shudu;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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
        holder.mEtEdit.setText("" + shuduBean.value);
        holder.mEtEdit.setSelection(("" + shuduBean.value).length());
        holder.mEtEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String num = s.toString();
                if (TextUtils.isEmpty(num)) {
                    shuduBean.value = 0;
                } else {
                    shuduBean.value = Integer.parseInt(num);
                }
            }
        });
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
        private EditText mEtEdit;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            mEtEdit = itemView.findViewById(R.id.et_edit);
        }
    }
}
