package com.kangtong.nalingweather.model;

import java.util.List;

/**
 * Created by kangt on 2017/4/4.
 */

public class HeWeather5 {
  private List<HeWeather5Bean> HeWeather5;

  public List<HeWeather5Bean> getHeWeather5() {
    return HeWeather5;
  }

  public void setHeWeather5(List<HeWeather5Bean> HeWeather5) {
    this.HeWeather5 = HeWeather5;
  }

  public static class HeWeather5Bean {
    /**
     * aqi : {"city":{"aqi":"242","co":"2","no2":"85","o3":"64","pm10":"207","pm25":"192","qlty":"重度污染","so2":"34"}}
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904989","lon":"116.405285","update":{"loc":"2017-04-04
     * 13:51","utc":"2017-04-04 05:51"}} daily_forecast : [{"astro":{"mr":"11:42","ms":"01:29","sr":"05:54","ss":"18:41"},"cond":{"code_d":"104","code_n":"305","txt_d":"阴","txt_n":"小雨"},"date":"2017-04-04","hum":"55","pcpn":"0.0","pop":"1","pres":"1015","tmp":{"max":"21","min":"12"},"uv":"4","vis":"20","wind":{"deg":"175","dir":"南风","sc":"微风","spd":"6"}},{"astro":{"mr":"12:43","ms":"02:20","sr":"05:52","ss":"18:42"},"cond":{"code_d":"104","code_n":"101","txt_d":"阴","txt_n":"多云"},"date":"2017-04-05","hum":"68","pcpn":"0.1","pop":"40","pres":"1014","tmp":{"max":"18","min":"9"},"uv":"5","vis":"19","wind":{"deg":"158","dir":"东风","sc":"微风","spd":"1"}},{"astro":{"mr":"13:46","ms":"03:05","sr":"05:51","ss":"18:43"},"cond":{"code_d":"101","code_n":"104","txt_d":"多云","txt_n":"阴"},"date":"2017-04-06","hum":"61","pcpn":"0.0","pop":"20","pres":"1012","tmp":{"max":"23","min":"10"},"uv":"6","vis":"20","wind":{"deg":"144","dir":"南风","sc":"微风","spd":"0"}}]
     * hourly_forecast : [{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-04-04
     * 16:00","hum":"44","pop":"0","pres":"1013","tmp":"19","wind":{"deg":"196","dir":"西南风","sc":"3-4","spd":"18"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-04-04
     * 19:00","hum":"55","pop":"0","pres":"1014","tmp":"16","wind":{"deg":"198","dir":"西南风","sc":"微风","spd":"16"}},{"cond":{"code":"103","txt":"晴间多云"},"date":"2017-04-04
     * 22:00","hum":"60","pop":"1","pres":"1015","tmp":"14","wind":{"deg":"211","dir":"西南风","sc":"微风","spd":"12"}}]
     * now : {"cond":{"code":"104","txt":"阴"},"fl":"19","hum":"45","pcpn":"0","pres":"1015","tmp":"19","vis":"2","wind":{"deg":"147","dir":"南风","sc":"微风","spd":"9"}}
     * status : ok suggestion : {"air":{"brf":"很差","txt":"气象条件不利于空气污染物稀释、扩散和清除，请尽量避免在室外长时间活动。"},"comf":{"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},"cw":{"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"drsg":{"brf":"较舒适","txt":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"},"flu":{"brf":"易发","txt":"相对于今天将会出现大幅度降温，空气湿度较大，易发生感冒，请注意适当增加衣服。"},"sport":{"brf":"较适宜","txt":"阴天，较适宜进行各种户内外运动。"},"trav":{"brf":"适宜","txt":"天气较好，风稍大，但温度适宜，总体来说还是好天气。这样的天气适宜旅游，您可以尽情享受大自然的风光。"},"uv":{"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}}
     */

    private AqiBean aqi;
    private BasicBean basic;
    private NowBean now;
    private String status;
    private SuggestionBean suggestion;
    private List<DailyForecastBean> daily_forecast;
    private List<HourlyForecastBean> hourly_forecast;

    public AqiBean getAqi() {
      return aqi;
    }

    public void setAqi(AqiBean aqi) {
      this.aqi = aqi;
    }

    public BasicBean getBasic() {
      return basic;
    }

    public void setBasic(BasicBean basic) {
      this.basic = basic;
    }

    public NowBean getNow() {
      return now;
    }

    public void setNow(NowBean now) {
      this.now = now;
    }

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }

    public SuggestionBean getSuggestion() {
      return suggestion;
    }

    public void setSuggestion(SuggestionBean suggestion) {
      this.suggestion = suggestion;
    }

    public List<DailyForecastBean> getDaily_forecast() {
      return daily_forecast;
    }

    public void setDaily_forecast(List<DailyForecastBean> daily_forecast) {
      this.daily_forecast = daily_forecast;
    }

    public List<HourlyForecastBean> getHourly_forecast() {
      return hourly_forecast;
    }

    public void setHourly_forecast(List<HourlyForecastBean> hourly_forecast) {
      this.hourly_forecast = hourly_forecast;
    }

    public static class AqiBean {
      /**
       * city : {"aqi":"242","co":"2","no2":"85","o3":"64","pm10":"207","pm25":"192","qlty":"重度污染","so2":"34"}
       */

      private CityBean city;

      public CityBean getCity() {
        return city;
      }

      public void setCity(CityBean city) {
        this.city = city;
      }

      public static class CityBean {
        /**
         * aqi : 242
         * co : 2
         * no2 : 85
         * o3 : 64
         * pm10 : 207
         * pm25 : 192
         * qlty : 重度污染
         * so2 : 34
         */

        private String aqi;
        private String co;
        private String no2;
        private String o3;
        private String pm10;
        private String pm25;
        private String qlty;
        private String so2;

        public String getAqi() {
          return aqi;
        }

        public void setAqi(String aqi) {
          this.aqi = aqi;
        }

        public String getCo() {
          return co;
        }

        public void setCo(String co) {
          this.co = co;
        }

        public String getNo2() {
          return no2;
        }

        public void setNo2(String no2) {
          this.no2 = no2;
        }

        public String getO3() {
          return o3;
        }

        public void setO3(String o3) {
          this.o3 = o3;
        }

        public String getPm10() {
          return pm10;
        }

        public void setPm10(String pm10) {
          this.pm10 = pm10;
        }

        public String getPm25() {
          return pm25;
        }

        public void setPm25(String pm25) {
          this.pm25 = pm25;
        }

        public String getQlty() {
          return qlty;
        }

        public void setQlty(String qlty) {
          this.qlty = qlty;
        }

        public String getSo2() {
          return so2;
        }

        public void setSo2(String so2) {
          this.so2 = so2;
        }
      }
    }

    public static class BasicBean {
      /**
       * city : 北京
       * cnty : 中国
       * id : CN101010100
       * lat : 39.904989
       * lon : 116.405285
       * update : {"loc":"2017-04-04 13:51","utc":"2017-04-04 05:51"}
       */

      private String city;
      private String cnty;
      private String id;
      private String lat;
      private String lon;
      private UpdateBean update;

      public String getCity() {
        return city;
      }

      public void setCity(String city) {
        this.city = city;
      }

      public String getCnty() {
        return cnty;
      }

      public void setCnty(String cnty) {
        this.cnty = cnty;
      }

      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
      }

      public String getLat() {
        return lat;
      }

      public void setLat(String lat) {
        this.lat = lat;
      }

      public String getLon() {
        return lon;
      }

      public void setLon(String lon) {
        this.lon = lon;
      }

      public UpdateBean getUpdate() {
        return update;
      }

      public void setUpdate(UpdateBean update) {
        this.update = update;
      }

      public static class UpdateBean {
        /**
         * loc : 2017-04-04 13:51
         * utc : 2017-04-04 05:51
         */

        private String loc;
        private String utc;

        public String getLoc() {
          return loc;
        }

        public void setLoc(String loc) {
          this.loc = loc;
        }

        public String getUtc() {
          return utc;
        }

        public void setUtc(String utc) {
          this.utc = utc;
        }
      }
    }

    public static class NowBean {
      /**
       * cond : {"code":"104","txt":"阴"}
       * fl : 19
       * hum : 45
       * pcpn : 0
       * pres : 1015
       * tmp : 19
       * vis : 2
       * wind : {"deg":"147","dir":"南风","sc":"微风","spd":"9"}
       */

      private CondBean cond;
      private String fl;
      private String hum;
      private String pcpn;
      private String pres;
      private String tmp;
      private String vis;
      private WindBean wind;

      public CondBean getCond() {
        return cond;
      }

      public void setCond(CondBean cond) {
        this.cond = cond;
      }

      public String getFl() {
        return fl;
      }

      public void setFl(String fl) {
        this.fl = fl;
      }

      public String getHum() {
        return hum;
      }

      public void setHum(String hum) {
        this.hum = hum;
      }

      public String getPcpn() {
        return pcpn;
      }

      public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
      }

      public String getPres() {
        return pres;
      }

      public void setPres(String pres) {
        this.pres = pres;
      }

      public String getTmp() {
        return tmp;
      }

      public void setTmp(String tmp) {
        this.tmp = tmp;
      }

      public String getVis() {
        return vis;
      }

      public void setVis(String vis) {
        this.vis = vis;
      }

      public WindBean getWind() {
        return wind;
      }

      public void setWind(WindBean wind) {
        this.wind = wind;
      }

      public static class CondBean {
        /**
         * code : 104
         * txt : 阴
         */

        private String code;
        private String txt;

        public String getCode() {
          return code;
        }

        public void setCode(String code) {
          this.code = code;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }

      public static class WindBean {
        /**
         * deg : 147
         * dir : 南风
         * sc : 微风
         * spd : 9
         */

        private String deg;
        private String dir;
        private String sc;
        private String spd;

        public String getDeg() {
          return deg;
        }

        public void setDeg(String deg) {
          this.deg = deg;
        }

        public String getDir() {
          return dir;
        }

        public void setDir(String dir) {
          this.dir = dir;
        }

        public String getSc() {
          return sc;
        }

        public void setSc(String sc) {
          this.sc = sc;
        }

        public String getSpd() {
          return spd;
        }

        public void setSpd(String spd) {
          this.spd = spd;
        }
      }
    }

    public static class SuggestionBean {
      /**
       * air : {"brf":"很差","txt":"气象条件不利于空气污染物稀释、扩散和清除，请尽量避免在室外长时间活动。"}
       * comf : {"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"}
       * cw : {"brf":"不宜","txt":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"}
       * drsg : {"brf":"较舒适","txt":"建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。"}
       * flu : {"brf":"易发","txt":"相对于今天将会出现大幅度降温，空气湿度较大，易发生感冒，请注意适当增加衣服。"}
       * sport : {"brf":"较适宜","txt":"阴天，较适宜进行各种户内外运动。"}
       * trav : {"brf":"适宜","txt":"天气较好，风稍大，但温度适宜，总体来说还是好天气。这样的天气适宜旅游，您可以尽情享受大自然的风光。"}
       * uv : {"brf":"最弱","txt":"属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。"}
       */

      private AirBean air;
      private ComfBean comf;
      private CwBean cw;
      private DrsgBean drsg;
      private FluBean flu;
      private SportBean sport;
      private TravBean trav;
      private UvBean uv;

      public AirBean getAir() {
        return air;
      }

      public void setAir(AirBean air) {
        this.air = air;
      }

      public ComfBean getComf() {
        return comf;
      }

      public void setComf(ComfBean comf) {
        this.comf = comf;
      }

      public CwBean getCw() {
        return cw;
      }

      public void setCw(CwBean cw) {
        this.cw = cw;
      }

      public DrsgBean getDrsg() {
        return drsg;
      }

      public void setDrsg(DrsgBean drsg) {
        this.drsg = drsg;
      }

      public FluBean getFlu() {
        return flu;
      }

      public void setFlu(FluBean flu) {
        this.flu = flu;
      }

      public SportBean getSport() {
        return sport;
      }

      public void setSport(SportBean sport) {
        this.sport = sport;
      }

      public TravBean getTrav() {
        return trav;
      }

      public void setTrav(TravBean trav) {
        this.trav = trav;
      }

      public UvBean getUv() {
        return uv;
      }

      public void setUv(UvBean uv) {
        this.uv = uv;
      }

      public static class AirBean {
        /**
         * brf : 很差
         * txt : 气象条件不利于空气污染物稀释、扩散和清除，请尽量避免在室外长时间活动。
         */

        private String brf;
        private String txt;

        public String getBrf() {
          return brf;
        }

        public void setBrf(String brf) {
          this.brf = brf;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }

      public static class ComfBean {
        /**
         * brf : 舒适
         * txt : 白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。
         */

        private String brf;
        private String txt;

        public String getBrf() {
          return brf;
        }

        public void setBrf(String brf) {
          this.brf = brf;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }

      public static class CwBean {
        /**
         * brf : 不宜
         * txt : 不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。
         */

        private String brf;
        private String txt;

        public String getBrf() {
          return brf;
        }

        public void setBrf(String brf) {
          this.brf = brf;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }

      public static class DrsgBean {
        /**
         * brf : 较舒适
         * txt : 建议着薄外套、开衫牛仔衫裤等服装。年老体弱者应适当添加衣物，宜着夹克衫、薄毛衣等。
         */

        private String brf;
        private String txt;

        public String getBrf() {
          return brf;
        }

        public void setBrf(String brf) {
          this.brf = brf;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }

      public static class FluBean {
        /**
         * brf : 易发
         * txt : 相对于今天将会出现大幅度降温，空气湿度较大，易发生感冒，请注意适当增加衣服。
         */

        private String brf;
        private String txt;

        public String getBrf() {
          return brf;
        }

        public void setBrf(String brf) {
          this.brf = brf;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }

      public static class SportBean {
        /**
         * brf : 较适宜
         * txt : 阴天，较适宜进行各种户内外运动。
         */

        private String brf;
        private String txt;

        public String getBrf() {
          return brf;
        }

        public void setBrf(String brf) {
          this.brf = brf;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }

      public static class TravBean {
        /**
         * brf : 适宜
         * txt : 天气较好，风稍大，但温度适宜，总体来说还是好天气。这样的天气适宜旅游，您可以尽情享受大自然的风光。
         */

        private String brf;
        private String txt;

        public String getBrf() {
          return brf;
        }

        public void setBrf(String brf) {
          this.brf = brf;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }

      public static class UvBean {
        /**
         * brf : 最弱
         * txt : 属弱紫外线辐射天气，无需特别防护。若长期在户外，建议涂擦SPF在8-12之间的防晒护肤品。
         */

        private String brf;
        private String txt;

        public String getBrf() {
          return brf;
        }

        public void setBrf(String brf) {
          this.brf = brf;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }
    }

    public static class DailyForecastBean {
      /**
       * astro : {"mr":"11:42","ms":"01:29","sr":"05:54","ss":"18:41"}
       * cond : {"code_d":"104","code_n":"305","txt_d":"阴","txt_n":"小雨"}
       * date : 2017-04-04
       * hum : 55
       * pcpn : 0.0
       * pop : 1
       * pres : 1015
       * tmp : {"max":"21","min":"12"}
       * uv : 4
       * vis : 20
       * wind : {"deg":"175","dir":"南风","sc":"微风","spd":"6"}
       */

      private AstroBean astro;
      private CondBeanX cond;
      private String date;
      private String hum;
      private String pcpn;
      private String pop;
      private String pres;
      private TmpBean tmp;
      private String uv;
      private String vis;
      private WindBeanX wind;

      public AstroBean getAstro() {
        return astro;
      }

      public void setAstro(AstroBean astro) {
        this.astro = astro;
      }

      public CondBeanX getCond() {
        return cond;
      }

      public void setCond(CondBeanX cond) {
        this.cond = cond;
      }

      public String getDate() {
        return date;
      }

      public void setDate(String date) {
        this.date = date;
      }

      public String getHum() {
        return hum;
      }

      public void setHum(String hum) {
        this.hum = hum;
      }

      public String getPcpn() {
        return pcpn;
      }

      public void setPcpn(String pcpn) {
        this.pcpn = pcpn;
      }

      public String getPop() {
        return pop;
      }

      public void setPop(String pop) {
        this.pop = pop;
      }

      public String getPres() {
        return pres;
      }

      public void setPres(String pres) {
        this.pres = pres;
      }

      public TmpBean getTmp() {
        return tmp;
      }

      public void setTmp(TmpBean tmp) {
        this.tmp = tmp;
      }

      public String getUv() {
        return uv;
      }

      public void setUv(String uv) {
        this.uv = uv;
      }

      public String getVis() {
        return vis;
      }

      public void setVis(String vis) {
        this.vis = vis;
      }

      public WindBeanX getWind() {
        return wind;
      }

      public void setWind(WindBeanX wind) {
        this.wind = wind;
      }

      public static class AstroBean {
        /**
         * mr : 11:42
         * ms : 01:29
         * sr : 05:54
         * ss : 18:41
         */

        private String mr;
        private String ms;
        private String sr;
        private String ss;

        public String getMr() {
          return mr;
        }

        public void setMr(String mr) {
          this.mr = mr;
        }

        public String getMs() {
          return ms;
        }

        public void setMs(String ms) {
          this.ms = ms;
        }

        public String getSr() {
          return sr;
        }

        public void setSr(String sr) {
          this.sr = sr;
        }

        public String getSs() {
          return ss;
        }

        public void setSs(String ss) {
          this.ss = ss;
        }
      }

      public static class CondBeanX {
        /**
         * code_d : 104
         * code_n : 305
         * txt_d : 阴
         * txt_n : 小雨
         */

        private String code_d;
        private String code_n;
        private String txt_d;
        private String txt_n;

        public String getCode_d() {
          return code_d;
        }

        public void setCode_d(String code_d) {
          this.code_d = code_d;
        }

        public String getCode_n() {
          return code_n;
        }

        public void setCode_n(String code_n) {
          this.code_n = code_n;
        }

        public String getTxt_d() {
          return txt_d;
        }

        public void setTxt_d(String txt_d) {
          this.txt_d = txt_d;
        }

        public String getTxt_n() {
          return txt_n;
        }

        public void setTxt_n(String txt_n) {
          this.txt_n = txt_n;
        }
      }

      public static class TmpBean {
        /**
         * max : 21
         * min : 12
         */

        private String max;
        private String min;

        public String getMax() {
          return max;
        }

        public void setMax(String max) {
          this.max = max;
        }

        public String getMin() {
          return min;
        }

        public void setMin(String min) {
          this.min = min;
        }
      }

      public static class WindBeanX {
        /**
         * deg : 175
         * dir : 南风
         * sc : 微风
         * spd : 6
         */

        private String deg;
        private String dir;
        private String sc;
        private String spd;

        public String getDeg() {
          return deg;
        }

        public void setDeg(String deg) {
          this.deg = deg;
        }

        public String getDir() {
          return dir;
        }

        public void setDir(String dir) {
          this.dir = dir;
        }

        public String getSc() {
          return sc;
        }

        public void setSc(String sc) {
          this.sc = sc;
        }

        public String getSpd() {
          return spd;
        }

        public void setSpd(String spd) {
          this.spd = spd;
        }
      }
    }

    public static class HourlyForecastBean {
      /**
       * cond : {"code":"103","txt":"晴间多云"}
       * date : 2017-04-04 16:00
       * hum : 44
       * pop : 0
       * pres : 1013
       * tmp : 19
       * wind : {"deg":"196","dir":"西南风","sc":"3-4","spd":"18"}
       */

      private CondBeanXX cond;
      private String date;
      private String hum;
      private String pop;
      private String pres;
      private String tmp;
      private WindBeanXX wind;

      public CondBeanXX getCond() {
        return cond;
      }

      public void setCond(CondBeanXX cond) {
        this.cond = cond;
      }

      public String getDate() {
        return date;
      }

      public void setDate(String date) {
        this.date = date;
      }

      public String getHum() {
        return hum;
      }

      public void setHum(String hum) {
        this.hum = hum;
      }

      public String getPop() {
        return pop;
      }

      public void setPop(String pop) {
        this.pop = pop;
      }

      public String getPres() {
        return pres;
      }

      public void setPres(String pres) {
        this.pres = pres;
      }

      public String getTmp() {
        return tmp;
      }

      public void setTmp(String tmp) {
        this.tmp = tmp;
      }

      public WindBeanXX getWind() {
        return wind;
      }

      public void setWind(WindBeanXX wind) {
        this.wind = wind;
      }

      public static class CondBeanXX {
        /**
         * code : 103
         * txt : 晴间多云
         */

        private String code;
        private String txt;

        public String getCode() {
          return code;
        }

        public void setCode(String code) {
          this.code = code;
        }

        public String getTxt() {
          return txt;
        }

        public void setTxt(String txt) {
          this.txt = txt;
        }
      }

      public static class WindBeanXX {
        /**
         * deg : 196
         * dir : 西南风
         * sc : 3-4
         * spd : 18
         */

        private String deg;
        private String dir;
        private String sc;
        private String spd;

        public String getDeg() {
          return deg;
        }

        public void setDeg(String deg) {
          this.deg = deg;
        }

        public String getDir() {
          return dir;
        }

        public void setDir(String dir) {
          this.dir = dir;
        }

        public String getSc() {
          return sc;
        }

        public void setSc(String sc) {
          this.sc = sc;
        }

        public String getSpd() {
          return spd;
        }

        public void setSpd(String spd) {
          this.spd = spd;
        }
      }
    }
  }
}
