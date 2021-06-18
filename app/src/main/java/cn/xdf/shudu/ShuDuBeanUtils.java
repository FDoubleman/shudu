package cn.xdf.shudu;

import java.util.ArrayList;
import java.util.List;

/**
 * author:fumm
 * Date : 2021/ 06/ 18 3:10 PM
 * Dec : 数独 实体类 和 二维数组相互转化
 **/
public class ShuDuBeanUtils {


    /**
     * 数独实体list 转化为 二维数组
     *
     * @param list 数独实体list
     * @return 二维数组
     */
    public static char[][] shuDuBeanList2Arr(List<ShuduBean> list) {
        char[][] arr = new char[9][9];
        for (ShuduBean shuduBean : list) {
            if (shuduBean.value == 0) {
                arr[shuduBean.row][shuduBean.column] = '.';
            } else {
                arr[shuduBean.row][shuduBean.column] = (char) (shuduBean.value+'0');
            }
        }
        return arr;
    }

    /**
     * 二维数组 转化数独实体list
     *
     * @param arr 二维数组
     * @return 数独实体list
     */
    public static List<ShuduBean> arr2ShuduBeanList(char[][] arr) {
        List<ShuduBean> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                ShuduBean shuduBean = new ShuduBean();
                shuduBean.row = i;
                shuduBean.column = j;

                if (arr[i][j] == '.') {
                    shuduBean.value = 0;
                } else {
                    shuduBean.value = (arr[i][j]-'0');
                }
                list.add(shuduBean);
            }
        }
        return list;
    }


}
