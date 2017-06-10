package com.example.administrator.yn_yuzhilai.bean;

import java.util.List;

/**
 * 作者：仝晓雅 on 2017/6/4 09:21
 * 类的注释：课程分类
 */

public class CateGroyBean {


    /**
     * data : {"category":[{"key":"c0000020","title":"分类2"},{"key":"c0000015","title":"test"}]}
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
        private List<CategoryBean> category;

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public static class CategoryBean {
            /**
             * key : c0000020
             * title : 分类2
             */

            private String key;
            private String title;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
