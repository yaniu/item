package com.example.administrator.yn_itme_x.bean;

/**
 * 作者：仝晓雅 on 2017/5/28 11:16
 * 类的注释：登录bean
 */

public class MaBean {


    /**
     * data : {"uname":"11111111111","login":true,"session":"08cd5bbb7330bac5836342dad3a538ce7b040df5","message":"测试弹窗","alert":true}
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
         * uname : 11111111111
         * login : true
         * session : 08cd5bbb7330bac5836342dad3a538ce7b040df5
         * message : 测试弹窗
         * alert : true
         */

        private String uname;
        private boolean login;
        private String session;
        private String message;
        private boolean alert;

        public String getUname() {
            return uname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            this.alert = alert;
        }
    }
}
