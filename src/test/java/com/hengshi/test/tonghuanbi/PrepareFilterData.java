package com.hengshi.test.tonghuanbi;

import com.csvreader.CsvWriter;
import com.hengshi.utils.DateUtils;

import java.nio.charset.Charset;
import java.util.Date;

public class PrepareFilterData {
    public static long day = 24 * 60 * 60 * 1000;
    public static long halfhour = 30 * 60 * 1000;

    public static void main(String[] args) throws Exception {
        String filePath = "calculation.csv";
        CsvWriter csvWriter = new CsvWriter(filePath, ',', Charset.forName("utf8"));
        String[] headers = {"personid","birthdate","location","isvip","dinnertime","money"};
        csvWriter.writeRecord(headers);

        String[] years = {"2017/01/01 00:00:00","2018/01/01 00:00:00","2019/01/01 00:00:00"};
        String format = "yyyy/MM/dd HH:mm:ss";
        for(int i = 0; i < 3; i++) {
            long start = DateUtils.getTimeStamp(years[i], format);
            for (int j = 0; j < 365; j++) {
                for (int k = 0; k < 48; k++) {
                    Date date = new Date(start + day * j + k * halfhour);
                    int day = DateUtils.getDay(date);
                    String dinnertime = DateUtils.getDateString(date, format);
                    String money = "";
                    if(k<10) {
                        money = String.valueOf(day) + ".0" + String.valueOf(k);
                    }
                    else {
                        money = String.valueOf(day) + "." + String.valueOf(k);
                    }
                    String[] data1 = {"张三", "1990-12-25","北京", "true", dinnertime, money};
                    String[] data2 = {"李四", "1982-11-11","上海", "true", dinnertime, "-" + money};
                    String[] data3 = {null, null, "天津", "false", dinnertime, money};
                    csvWriter.writeRecord(data1);
                    csvWriter.writeRecord(data2);
                    csvWriter.writeRecord(data3);
                }
            }
        }
        String[] data4 = {"unknown", null, null, null, null, null};
        csvWriter.writeRecord(data4);
        csvWriter.close();
    }
}



