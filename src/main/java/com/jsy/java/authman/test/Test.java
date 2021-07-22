package com.jsy.java.authman.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInput;
import java.lang.reflect.Array;
import java.util.*;

public class Test {

    public static void main(String[] args) {
        List<Object[]> datas = new ArrayList<Object[]>();
        datas.add(new Object[]{"Q", 100, "2021-06-02 10:00:00"});
        datas.add(new Object[]{"W", 90, "2021-06-02 10:00:00"});
        datas.add(new Object[]{"E", 100, "2021-06-02 09:00:00"});
        datas.add(new Object[]{"R", 90, "2021-06-02 09:00:00"});
        datas.add(new Object[]{"T", 100, "2021-06-02 11:00:00"});
        datas.add(new Object[]{"Y", 90, "2021-06-02 11:00:00"});
        datas.add(new Object[]{"U", 100, "2021-06-02 08:00:00"});
        datas.add(new Object[]{"I", 100, "2021-06-02 09:00:00"});
        datas.add(new Object[]{"O", 100, "2021-06-02 07:00:00"});

        Map<String, List<String>> map = new HashMap<>();

        map = s3(datas);
        sortMapByValuecount(map);
    }

    //数据源解析并存储到map
    public static Map<String, List<String>> s3(List<Object[]> list) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            List<String> listinfo = new ArrayList<>();

            Object[] o1 = list.get(i);
            listinfo.add(o1[1] + "," + o1[2]);
            map.put(o1[0].toString(), listinfo);
        }
        return map;
    }


    //排序积分
    public static void sortMapByValuecount(Map<String, List<String>> oriMap) {
        String info="";
        Map<String, List<String>> sortedMap = new LinkedHashMap<String, List<String>>();
        List<Map.Entry<String, List<String>>> entryList = new ArrayList<Map.Entry<String, List<String>>>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, List<String>>> iter = entryList.iterator();
        Map.Entry<String, List<String>> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        //key
        for(String key : sortedMap.keySet()){
            List<String> listinfo =sortedMap.get(key);
            info+=key+"\t"+listinfo.get(0).toString()+"\n";
           // System.out.println(key);
        }
        System.out.println(info);


    }
    static class MapValueComparator implements Comparator<Map.Entry<String, List<String>>> {

        @Override
        public int compare(Map.Entry<String, List<String>> me1, Map.Entry<String, List<String>> me2) {
            if(me1.getValue().get(0).split(",")[0].equals(me2.getValue().get(0).split(",")[0])){
                return me1.getValue().get(0).split(",")[1].compareTo(me2.getValue().get(0).split(",")[1]);
            }else{
                return me1.getValue().get(0).split(",")[0].compareTo(me2.getValue().get(0).split(",")[0]);
            }
        }
    }
}
