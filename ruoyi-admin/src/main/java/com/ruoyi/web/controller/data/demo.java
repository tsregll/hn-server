package com.ruoyi.web.controller.data;

import cn.com.skdb.api.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class demo {
    //private static int[] vol = new int[]{350,350,350,350,320,320,600,600,330,330,350,350,50,50};
    private static void getnowval(){
        ISkApi connect = null;
        try {
            connect = SkFactory.CreateApi("172.22.192.216", 9090, "root", "123456", 6000);
            List<SkHisval> values = new ArrayList<SkHisval> ();
            List<String> vCpids = new ArrayList<String> ();
            //添加有功测点
            //3#机组  机组负荷率  （实时指标）
            vCpids.add ("HNHN.YYDC.FSUM.RFDMH.SKCAL");

            Calendar cal = Calendar.getInstance();
            Date date1 = new Date(cal.get(Calendar.YEAR)-1900, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
            //火电日发电量计算原始点
            values = connect.GetHistoryValue(vCpids, date1, cal.getTime(), 5000);
            double firevalue = 0;
            if(values != null && values.size() > 0) {
                for(SkHisval item : values) {
                    for (SkValue val : item.values){
                        if (val.Status == 1) {
                            firevalue += val.Value;
                        }
                    }
                }
            }

            List<SkNowval> skNowvals = connect.GetNowValue (vCpids);
            //System.out.println (skNowvals.size ());
            for(SkNowval s:skNowvals){
                System.out.println (s.value);
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        connect.Close();
    }
    public static void main(String[] args) {
        while(true) {
            try {
                getnowval();
                Thread.sleep(60000l);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
