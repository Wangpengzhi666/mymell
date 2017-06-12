package com.wpzmall.mymall.model.Bean.login;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/6/12  16:48
 * <p>
 * 思路：
 */


public class LoginBean {

    /**
     * code : 400
     * datas : {"error":"登录失败"}
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
         * error : 登录失败
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
