package cn.xdf.shudu;

/**
 * author:fumm
 * Date : 2021/ 06/ 18 2:38 PM
 * Dec : 数独试题bean
 **/
public class ShuduBean {
    // 列
    int column;
    // 行
    int row;

    // 是否被选中
    boolean isSelect =false;
    // 是否被关联 选中的行 列
    boolean isAttach = false;
    int value = 0;
}
