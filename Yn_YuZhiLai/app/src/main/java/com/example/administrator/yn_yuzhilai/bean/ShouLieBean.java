package com.example.administrator.yn_yuzhilai.bean;

import java.util.List;

/**
 * 作者：仝晓雅 on 2017/6/7 11:09
 * 类的注释：
 */

public class ShouLieBean {


    /**
     * data : {"heart":[{"title":"视频CESHI","image":"https://pretty.f8cam.com/static/image/product/tu/tuauimijnc.jpg","object_type":1,"object_id":"10000036","length":1242,"progress":0,"type":1}]}
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
        private List<HeartBean> heart;

        public List<HeartBean> getHeart() {
            return heart;
        }

        public void setHeart(List<HeartBean> heart) {
            this.heart = heart;
        }

        public static class HeartBean {
            /**
             * title : 视频CESHI
             * image : https://pretty.f8cam.com/static/image/product/tu/tuauimijnc.jpg
             * object_type : 1
             * object_id : 10000036
             * length : 1242
             * progress : 0
             * type : 1
             */

            private String title;
            private String image;
            private int object_type;
            private String object_id;
            private int length;
            private int progress;
            private int type;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getObject_type() {
                return object_type;
            }

            public void setObject_type(int object_type) {
                this.object_type = object_type;
            }

            public String getObject_id() {
                return object_id;
            }

            public void setObject_id(String object_id) {
                this.object_id = object_id;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public int getProgress() {
                return progress;
            }

            public void setProgress(int progress) {
                this.progress = progress;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }
    }
}
