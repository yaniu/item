package com.example.administrator.yn_yuzhilai.bean;

/**
 * 作者：仝晓雅 on 2017/6/7 10:48
 * 类的注释：收藏Bean
 */

public class ShouBean {


    /**
     * data : {"status":1,"msg":"收藏成功","type":1,"object_id":"10000036","title":"视频CESHI"}
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
         * status : 1
         * msg : 收藏成功
         * type : 1
         * object_id : 10000036
         * title : 视频CESHI
         */

        private int status;
        private String msg;
        private int type;
        private String object_id;
        private String title;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getObject_id() {
            return object_id;
        }

        public void setObject_id(String object_id) {
            this.object_id = object_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
