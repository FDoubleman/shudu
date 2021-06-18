package cn.xdf.shudu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnDiscern, mBtnSetData;
    private ShuDuAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rlvRoot = findViewById(R.id.rlv_root);
        GridLayoutManager glm = new GridLayoutManager(this, 9);
        mAdapter = new ShuDuAdapter();
        rlvRoot.setLayoutManager(glm);
        rlvRoot.setAdapter(mAdapter);
        mBtnDiscern = findViewById(R.id.btn_discern);
        mBtnSetData = findViewById(R.id.btn_set_data);
        mBtnDiscern.setOnClickListener(this);
        mBtnSetData.setOnClickListener(this);
    }

    private char[][] chars = new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

    private void setData() {
        List<ShuduBean> list = ShuDuBeanUtils.arr2ShuduBeanList(chars);
        mAdapter.setData(list);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_discern) {

            List<ShuduBean> list = mAdapter.getData();
            char[][] chars = ShuDuBeanUtils.shuDuBeanList2Arr(list);

            ShuDuSolveUtils.solveSudoku(chars);

            List<ShuduBean> newList = ShuDuBeanUtils.arr2ShuduBeanList(chars);
            mAdapter.setData(newList);
        } else if (id == R.id.btn_set_data) {
            setData();
        }
    }


}