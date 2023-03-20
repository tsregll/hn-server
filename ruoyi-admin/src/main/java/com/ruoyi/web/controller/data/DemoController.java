package com.ruoyi.web.controller.data;

import cn.com.skdb.api.*;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/test")
public class DemoController extends BaseController {

    //@PreAuthorize("@ss.hasPermi('monitor:logininfor:list')")
    @PostMapping("/list")
    public TableDataInfo list()
    {

        List<SkNowval> skNowvals=null;
        ISkApi connect = null;
        try {
            connect = SkFactory.CreateApi("172.22.192.216", 9090, "root", "123456", 6000);
            List<SkHisval> values = new ArrayList<SkHisval> ();
            List<String> vCpids = new ArrayList<String> ();
            //添加有功测点
            vCpids.add("HNHN.GD.2_YM_410NQ");
            vCpids.add("HNHN.GD.2_YM_410NP");
            vCpids.add("HNHN.GD.2_YM_410PQ");
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

            skNowvals = connect.GetNowValue (vCpids);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        connect.Close();
        return  getDataTable(skNowvals);
    }
}
