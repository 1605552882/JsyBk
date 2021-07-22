package com.jsy.java.authman.test;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class CollectTests {

    public static void main(String[] args) {
        List<Object[]> datas = new ArrayList<Object[]>();
        datas.add(new Object[] {"Q", 100, "2021-06-02 10:00:00"});
        datas.add(new Object[] {"W", 90, "2021-06-02 10:00:00"});
        datas.add(new Object[] {"E", 100, "2021-06-02 09:00:00"});
        datas.add(new Object[] {"R", 90, "2021-06-02 09:00:00"});
        datas.add(new Object[] {"T", 100, "2021-06-02 11:00:00"});
        datas.add(new Object[] {"Y", 90, "2021-06-02 11:00:00"});
        datas.add(new Object[] {"U", 100, "2021-06-02 08:00:00"});
        datas.add(new Object[] {"I", 100, "2021-06-02 09:00:00"});
        datas.add(new Object[] {"O", 100, "2021-06-02 07:00:00"});
        /**
         * 排序
         * */
        sort(datas);
        /**
         * 结果打印
         * */
        println(datas, CollectTests::printObject);
    }


    /**
     * 按照积分、时间排序
     * */
    public static List<Object[]> sort(List<Object[]> dataList){
        dataList.sort((Object[] a1, Object[] a2) -> {
            if((int)a1[1] == (int)a2[1]) {
                /**
                 * 积分相同
                 * 按照时间排序
                 * */
                if (a1[2] == null) {
                    return 1;
                } if (a2[2] == null) {
                    return -1;
                } else if (Timestamp.valueOf((String) a1[2]).getTime() - Timestamp.valueOf((String) a2[2]).getTime() > 0L) {
                    return 1;
                } else if (Timestamp.valueOf((String) a1[2]).getTime() - Timestamp.valueOf((String) a2[2]).getTime() < 0L){
                    return -1;
                }else {
                    return 0;

                }

            }
            /**
             * 积分不同按照积分倒排序
             * */
            return (int)a2[1] - (int)a1[1];
        });
        return dataList;
    }

    /**
     * 打印list
     * */
    public static <T> void println(List<T> dataList, Function<T,Object> function) {
        if (dataList == null || dataList.size() == 0) {
            return;
        }
        for (T data : dataList) {
            function.apply(data);
        }
    }

    /**
     * 自定义对象格式打印
     * */
    public static <T> Object printObject(T data) {
        if (data == null) {
            System.out.println(data);;
        } else if (data.getClass().isArray()) {
            for (Object dataProperty : (Object[]) data){
                System.out.print(dataProperty + " ");
            }
            System.out.println();
        } else {

            System.out.println(data);
        }

        return data;
    }


}
