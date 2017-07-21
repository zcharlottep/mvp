package com.example.mvp_mvp.bean;

/**
 * Created by teresa on 2017/7/21.
 *
 * {
     "weatherinfo": {
         "Radar": "",
         "SD": "69%",
         "WD": "东风",
         "WS": "1级",
         "WSE": 1,
         "city": "北京",
         "cityid": "101010100",
         "isRadar": 1,
         "njd": "",
         "qy": "0",
         "temp": "26",
         "time": "2017-07-21T15:46:01.223"
    }
 }
 天气bean
 */
public class WeatherBean {

    public WeatherInfo weatherinfo;
    public class WeatherInfo{
        public String Radar;
        public String SD;
        public String WD;
        public String WS;
        public long WSE;
        public String city;
        public String cityid;
        public long isRadar;
        public String njd;
        public String qy;
        public String temp;
        public String time;
    }
}
