package com.hengshi.test.tonghuanbi;

import com.csvreader.CsvWriter;
import com.hengshi.utils.DateUtils;

import java.nio.charset.Charset;
import java.util.Date;

public class PrepareTestData {
    public static long day = 24 * 60 * 60 * 1000;

    public static void main(String[] args) throws Exception {
        String filePath = "tonghuanbi.csv";
        CsvWriter csvWriter = new CsvWriter(filePath, ',', Charset.forName("utf8"));
        String[] headers = {"dinnertime","personid","location","money"};
        csvWriter.writeRecord(headers);

        String[] years = {"2016/01/01","2017/01/01","2018/01/01"};
        String format = "yyyy/MM/dd";
        for(int i = 0; i < 3; i++) {
            long start = DateUtils.getTimeStamp(years[i], format);
            for (int j = 0; j < 365; j++) {
                Date date = new Date(start + day * j);
                int day = DateUtils.getDay(date);
                String dinnertime = DateUtils.getDateString(date, format);
                String[] data1 = {dinnertime, "张三", "北京", String.valueOf(day)};
                String[] data2 = {dinnertime, "李四", "上海", "-" + day};
                String[] data3 = {dinnertime, null, "天津", String.valueOf(day)};
                String[] data4 = {null,"李四","北京",String.valueOf(day)};
                csvWriter.writeRecord(data1);
                csvWriter.writeRecord(data2);
                csvWriter.writeRecord(data3);
                csvWriter.writeRecord(data4);
            }
        }
        csvWriter.close();
    }
}


