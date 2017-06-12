package com.wpzmall.mymall.model.Bean.Registered;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/12  16:53
 * <p>
 * 思路：
 */


public class RegisteredBean {


    /**
     * code : 400
     * datas : {"error":"请填写用户名"}
     */

    private int code;
    private DatasBean datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DatasBean getDatas() {
        return datas;
    }

    public void setDatas(DatasBean datas) {
        this.datas = datas;
    }

    public static class DatasBean {
        /**
         * error : 请填写用户名
         */

        private String error;

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
