package com.example.administrator.yn_yuzhilai.bean;

/**
 * 类的用途：
 * Created by ${仝晓雅}
 * on 2017/6/8 17:21
 */

public class QQLogin {

    /**
     * data : {"user_role":0,"user_new":true,"alert":false,"if_bind":false,"session":"66f455250f73da0e9e8eaf24cbef5bd7515c245f","bound_tel":"","message":""}
     * ret : 0
     */

    private DataBean data;
    private int ret;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
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

    @Override
    public String toString() {
        return "QQLogin{" +
                "data=" + data +
                ", ret=" + ret +
                '}';
    }

    public static class DataBean {
        /**
         * user_role : 0
         * user_new : true
         * alert : false
         * if_bind : false
         * session : 66f455250f73da0e9e8eaf24cbef5bd7515c245f
         * bound_tel :
         * message :
         */

        private int user_role;
        private boolean user_new;
        private boolean alert;
        private boolean if_bind;
        private String session;
        private String bound_tel;
        private String message;

        public int getUser_role() {
            return user_role;
        }

        public void setUser_role(int user_role) {
            this.user_role = user_role;
        }

        public boolean isUser_new() {
            return user_new;
        }

        public void setUser_new(boolean user_new) {
            this.user_new = user_new;
        }

        public boolean isAlert() {
            return alert;
        }

        public void setAlert(boolean alert) {
            this.alert = alert;
        }

        public boolean isIf_bind() {
            return if_bind;
        }

        public void setIf_bind(boolean if_bind) {
            this.if_bind = if_bind;
        }

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public String getBound_tel() {
            return bound_tel;
        }

        public void setBound_tel(String bound_tel) {
            this.bound_tel = bound_tel;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "user_role=" + user_role +
                    ", user_new=" + user_new +
                    ", alert=" + alert +
                    ", if_bind=" + if_bind +
                    ", session='" + session + '\'' +
                    ", bound_tel='" + bound_tel + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
