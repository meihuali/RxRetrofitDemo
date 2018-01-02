package com.example.wsl.rxretrofitdemo.bean;

import java.util.List;

/**
 * Created by wsl on 2018/1/2.
 */

public class WeatherBean {


    /**
     * shidu : 87%
     * pm25 : 101.0
     * pm10 : 144.0
     * quality : 轻度污染
     * wendu : 14
     * ganmao : 儿童、老年人及心脏、呼吸系统疾病患者人群应减少长时间或高强度户外锻炼
     * yesterday : {"date":"01日星期一","sunrise":"07:08","high":"高温 21.0℃","low":"低温 12.0℃","sunset":"17:52","aqi":98,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"悠悠的云里有淡淡的诗"}
     * forecast : [{"date":"02日星期二","sunrise":"07:08","high":"高温 21.0℃","low":"低温 13.0℃","sunset":"17:53","aqi":116,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"},{"date":"03日星期三","sunrise":"07:09","high":"高温 22.0℃","low":"低温 13.0℃","sunset":"17:54","aqi":122,"fx":"无持续风向","fl":"<3级","type":"多云","notice":"今日多云，骑上单车去看看世界吧"},{"date":"04日星期四","sunrise":"07:09","high":"高温 20.0℃","low":"低温 13.0℃","sunset":"17:54","aqi":105,"fx":"无持续风向","fl":"<3级","type":"阴","notice":"阴天没有晴天的明朗，却依然明亮"},{"date":"05日星期五","sunrise":"07:09","high":"高温 17.0℃","low":"低温 13.0℃","sunset":"17:55","aqi":102,"fx":"北风","fl":"3-4级","type":"小雨","notice":"雾蒙蒙的雨天，最喜欢一个人听音乐"},{"date":"06日星期六","sunrise":"07:09","high":"高温 15.0℃","low":"低温 12.0℃","sunset":"17:56","aqi":81,"fx":"无持续风向","fl":"<3级","type":"小雨","notice":"下雨了不要紧，撑伞挡挡就行"}]
     */

    private String shidu;
    private double pm25;
    private double pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private YesterdayBean yesterday;
    private List<ForecastBean> forecast;

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public double getPm25() {
        return pm25;
    }

    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public YesterdayBean getYesterday() {
        return yesterday;
    }

    public void setYesterday(YesterdayBean yesterday) {
        this.yesterday = yesterday;
    }

    public List<ForecastBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<ForecastBean> forecast) {
        this.forecast = forecast;
    }

    public static class YesterdayBean {
        /**
         * date : 01日星期一
         * sunrise : 07:08
         * high : 高温 21.0℃
         * low : 低温 12.0℃
         * sunset : 17:52
         * aqi : 98.0
         * fx : 无持续风向
         * fl : <3级
         * type : 多云
         * notice : 悠悠的云里有淡淡的诗
         */

        private String date;
        private String sunrise;
        private String high;
        private String low;
        private String sunset;
        private double aqi;
        private String fx;
        private String fl;
        private String type;
        private String notice;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public double getAqi() {
            return aqi;
        }

        public void setAqi(double aqi) {
            this.aqi = aqi;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }

    public static class ForecastBean {
        /**
         * date : 02日星期二
         * sunrise : 07:08
         * high : 高温 21.0℃
         * low : 低温 13.0℃
         * sunset : 17:53
         * aqi : 116.0
         * fx : 无持续风向
         * fl : <3级
         * type : 多云
         * notice : 今日多云，骑上单车去看看世界吧
         */

        private String date;
        private String sunrise;
        private String high;
        private String low;
        private String sunset;
        private double aqi;
        private String fx;
        private String fl;
        private String type;
        private String notice;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getHigh() {
            return high;
        }

        public void setHigh(String high) {
            this.high = high;
        }

        public String getLow() {
            return low;
        }

        public void setLow(String low) {
            this.low = low;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public double getAqi() {
            return aqi;
        }

        public void setAqi(double aqi) {
            this.aqi = aqi;
        }

        public String getFx() {
            return fx;
        }

        public void setFx(String fx) {
            this.fx = fx;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }
    }
}

