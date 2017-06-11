package com.example.administrator.yn_yuzhilai.bean;

/**
 * 作者：仝晓雅 on 2017/6/10 11:09
 * 类的注释：
 */

public class FenBean {


    /**
     * data : {"share_img":"https://pretty.f8cam.com/static/image/product/vf/vfgtztampl.jpg","share_content":"描述描述（试看26秒）","type":1,"share_title":"行动教育","object_id":"10000006"}
     * ret : 0
     */

    private DataBean data;
    private int ret;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public static class DataBean {
        /**
         * share_img : https://pretty.f8cam.com/static/image/product/vf/vfgtztampl.jpg
         * share_content : 描述描述（试看26秒）
         * type : 1
         * share_title : 行动教育
         * object_id : 10000006
         */

        private String share_img;
        private String share_content;
        private int type;
        private String share_title;
        private String object_id;

        public String getShare_img() {
            return share_img;
        }

        public void setShare_img(String share_img) {
            this.share_img = share_img;
        }

        public String getShare_content() {
            return share_content;
        }

        public void setShare_content(String share_content) {
            this.share_content = share_content;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getShare_title() {
            return share_title;
        }

        public void setShare_title(String share_title) {
            this.share_title = share_title;
        }

        public String getObject_id() {
            return object_id;
        }

        public void setObject_id(String object_id) {
            this.object_id = object_id;
        }
    }
}
