package test.bwie.com.qiuhaitao_20170410.bean;

import java.util.List;

/**
 * Created by ${仇海涛} on 2017/4/10.
 * 类的用途 ：
 */

public class Bean {

    /**
     * code : 200
     * msg : success
     * newslist : [{"ctime":"2017-04-10 07:56","title":"河南社旗回应体罚学生：涉事老师被调离教学岗位","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487428117_ss.jpeg","url":"http://news.sohu.com/20170410/n487447914.shtml"},{"ctime":"2017-04-10 08:13","title":"PX项目困局：经济损失巨大 政府公信力雪上加霜","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487444190_ss.jpeg","url":"http://news.sohu.com/20170410/n487448949.shtml"},{"ctime":"2017-04-10 08:30","title":"多地限制网约车车籍户籍 涉嫌违反行政许可法","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487444190_ss.jpeg","url":"http://news.sohu.com/20170410/n487450373.shtml"},{"ctime":"2017-04-10 08:31","title":"青岛700米樱花大道变花海 赏花游人爆棚(组图)","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487450374_ss.jpeg","url":"http://news.sohu.com/20170410/n487452770.shtml"},{"ctime":"2017-04-10 08:31","title":"叫板衡水模式恐怕底气不足","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487452771_ss.jpg","url":"http://news.sohu.com/20170410/n487450453.shtml"},{"ctime":"2017-04-10 08:37","title":"警方回应\u201c成都女子小区抢娃视频\u201d 系精神病发作","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487451378_ss.jpeg","url":"http://news.sohu.com/20170410/n487451377.shtml"},{"ctime":"2017-04-10 07:06","title":"北京一女子戏弄乞丐并伙同3人殴打致死 均获刑","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487426801_ss.jpeg","url":"http://news.sohu.com/20170410/n487442753.shtml"},{"ctime":"2017-04-10 07:14","title":"太原一医院聘女主播网上直播揽客 当地卫计委调查","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487428117_ss.jpeg","url":"http://news.sohu.com/20170410/n487443168.shtml"},{"ctime":"2017-04-10 07:24","title":"衡水中学浙江分校涉嫌违规招生 教育厅责令调查","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487444190_ss.jpeg","url":"http://news.sohu.com/20170410/n487444189.shtml"},{"ctime":"2017-04-10 07:28","title":"常德原副市长受贿被审 曾告诉女儿\u201c钱是最脏的\u201d","description":"搜狐社会","picUrl":"http://photocdn.sohu.com/20170410/Img487444190_ss.jpeg","url":"http://news.sohu.com/20170410/n487444742.shtml"}]
     */

    private int code;
    private String msg;
    private List<NewslistBean> newslist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<NewslistBean> getNewslist() {
        return newslist;
    }

    public void setNewslist(List<NewslistBean> newslist) {
        this.newslist = newslist;
    }

    public static class NewslistBean {
        /**
         * ctime : 2017-04-10 07:56
         * title : 河南社旗回应体罚学生：涉事老师被调离教学岗位
         * description : 搜狐社会
         * picUrl : http://photocdn.sohu.com/20170410/Img487428117_ss.jpeg
         * url : http://news.sohu.com/20170410/n487447914.shtml
         */

        private String ctime;
        private String title;
        private String description;
        private String picUrl;
        private String url;

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
