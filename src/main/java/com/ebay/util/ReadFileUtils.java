package com.ebay.util;

import com.ebay.model.SkuFinal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class ReadFileUtils {


    public static List<SkuFinal> readFeedDataTest(String filePath) throws Exception {
        //获取读取流
        FileReader reader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader);

        String firstLine = br.readLine();
        System.out.println("Feed Title: " + firstLine);

        List<SkuFinal> dataList = new ArrayList<>();
        String lineData;
        Long count = 0L;
        while ((lineData = br.readLine()) != null) {

            String[] fileds = lineData.split(",", 102);

            int i = fileds.length;

            SkuFinal skuFinal = null;
            try {
                skuFinal = ConvertorUtils.parseArgs2SkuFinalFeed(fileds);
            } catch (Exception e) {
                System.out.println("lineCount :" + fileds.length + " : lineData: " + lineData);
            }

            dataList.add(skuFinal);
            skuFinal.setId(count);
        }
        count++;

        System.out.println("total line :" + count);
        //关闭读取流
        br.close();
        reader.close();
        return dataList;
    }
}
