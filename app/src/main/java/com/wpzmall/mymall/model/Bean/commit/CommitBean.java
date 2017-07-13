package com.wpzmall.mymall.model.Bean.commit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @类作用:
 * @author: 王鹏智
 * @Date: 2017/7/12  20:09
 * <p>
 * 思路：
 */


public class CommitBean {

    /**
     * code : 200
     * datas : {"store_cart_list":{"1":{"goods_list":[{"cart_id":"26","buyer_id":"3","store_id":"1","store_name":"好商城V5","goods_id":"100009","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_price":"52800.00","goods_num":"5","goods_image":"1_04752627958339099.jpg","bl_id":"0","state":true,"storage_state":true,"goods_commonid":"100009","gc_id":"587","transport_id":"0","goods_freight":"0.00","goods_vat":"0","goods_storage":"100","goods_storage_alarm":"0","is_fcode":"0","have_gift":"0","groupbuy_info":null,"xianshi_info":null,"is_book":"0","book_down_payment":"0.00","book_final_payment":"0.00","book_down_time":"0","is_chain":"0","sole_info":[],"contractlist":[],"goods_total":"264000.00","goods_image_url":"http://169.254.191.113/data/upload/shop/store/goods/1/1_04752627958339099_240.jpg"}],"store_goods_total":"264000.00","store_mansong_rule_list":null,"store_voucher_info":[],"store_voucher_list":[],"freight":"1","store_name":"好商城V5"}},"freight_hash":"YjcTZg8WqfuTb3dp1gMKYfGFOpxZKvjLso2J94QEmnVsNe0d6vvHQm3Bese06pUWtplxgW3fuOsGd65NoZnm9Uhglm6B-GPjINZ6Bg4fG1fYzwS4_7qjpx7zQ4RZGlyeg1u8yfGnmBS8PvCnW59phAX0hzMrWd-9d02gjAX","address_info":[],"ifshow_offpay":null,"vat_hash":"s4AuGDCVXCFto-EfKEV5l5n6IuEVa5KFVyW","inv_info":{"content":"不需要发票"},"available_predeposit":null,"available_rc_balance":null,"rpt_list":[],"zk_list":[],"order_amount":"264000.00","rpt_info":[],"address_api":"","store_final_total_list":{"1":"264000.00"}}
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
         * store_cart_list : {"1":{"goods_list":[{"cart_id":"26","buyer_id":"3","store_id":"1","store_name":"好商城V5","goods_id":"100009","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_price":"52800.00","goods_num":"5","goods_image":"1_04752627958339099.jpg","bl_id":"0","state":true,"storage_state":true,"goods_commonid":"100009","gc_id":"587","transport_id":"0","goods_freight":"0.00","goods_vat":"0","goods_storage":"100","goods_storage_alarm":"0","is_fcode":"0","have_gift":"0","groupbuy_info":null,"xianshi_info":null,"is_book":"0","book_down_payment":"0.00","book_final_payment":"0.00","book_down_time":"0","is_chain":"0","sole_info":[],"contractlist":[],"goods_total":"264000.00","goods_image_url":"http://169.254.191.113/data/upload/shop/store/goods/1/1_04752627958339099_240.jpg"}],"store_goods_total":"264000.00","store_mansong_rule_list":null,"store_voucher_info":[],"store_voucher_list":[],"freight":"1","store_name":"好商城V5"}}
         * freight_hash : YjcTZg8WqfuTb3dp1gMKYfGFOpxZKvjLso2J94QEmnVsNe0d6vvHQm3Bese06pUWtplxgW3fuOsGd65NoZnm9Uhglm6B-GPjINZ6Bg4fG1fYzwS4_7qjpx7zQ4RZGlyeg1u8yfGnmBS8PvCnW59phAX0hzMrWd-9d02gjAX
         * address_info : []
         * ifshow_offpay : null
         * vat_hash : s4AuGDCVXCFto-EfKEV5l5n6IuEVa5KFVyW
         * inv_info : {"content":"不需要发票"}
         * available_predeposit : null
         * available_rc_balance : null
         * rpt_list : []
         * zk_list : []
         * order_amount : 264000.00
         * rpt_info : []
         * address_api :
         * store_final_total_list : {"1":"264000.00"}
         */

        private StoreCartListBean store_cart_list;
        private String freight_hash;
        private Object ifshow_offpay;
        private String vat_hash;
        private InvInfoBean inv_info;
        private Object available_predeposit;
        private Object available_rc_balance;
        private String order_amount;
        private String address_api;
        private StoreFinalTotalListBean store_final_total_list;
        private List<?> address_info;
        private List<?> rpt_list;
        private List<?> zk_list;
        private List<?> rpt_info;

        public StoreCartListBean getStore_cart_list() {
            return store_cart_list;
        }

        public void setStore_cart_list(StoreCartListBean store_cart_list) {
            this.store_cart_list = store_cart_list;
        }

        public String getFreight_hash() {
            return freight_hash;
        }

        public void setFreight_hash(String freight_hash) {
            this.freight_hash = freight_hash;
        }

        public Object getIfshow_offpay() {
            return ifshow_offpay;
        }

        public void setIfshow_offpay(Object ifshow_offpay) {
            this.ifshow_offpay = ifshow_offpay;
        }

        public String getVat_hash() {
            return vat_hash;
        }

        public void setVat_hash(String vat_hash) {
            this.vat_hash = vat_hash;
        }

        public InvInfoBean getInv_info() {
            return inv_info;
        }

        public void setInv_info(InvInfoBean inv_info) {
            this.inv_info = inv_info;
        }

        public Object getAvailable_predeposit() {
            return available_predeposit;
        }

        public void setAvailable_predeposit(Object available_predeposit) {
            this.available_predeposit = available_predeposit;
        }

        public Object getAvailable_rc_balance() {
            return available_rc_balance;
        }

        public void setAvailable_rc_balance(Object available_rc_balance) {
            this.available_rc_balance = available_rc_balance;
        }

        public String getOrder_amount() {
            return order_amount;
        }

        public void setOrder_amount(String order_amount) {
            this.order_amount = order_amount;
        }

        public String getAddress_api() {
            return address_api;
        }

        public void setAddress_api(String address_api) {
            this.address_api = address_api;
        }

        public StoreFinalTotalListBean getStore_final_total_list() {
            return store_final_total_list;
        }

        public void setStore_final_total_list(StoreFinalTotalListBean store_final_total_list) {
            this.store_final_total_list = store_final_total_list;
        }

        public List<?> getAddress_info() {
            return address_info;
        }

        public void setAddress_info(List<?> address_info) {
            this.address_info = address_info;
        }

        public List<?> getRpt_list() {
            return rpt_list;
        }

        public void setRpt_list(List<?> rpt_list) {
            this.rpt_list = rpt_list;
        }

        public List<?> getZk_list() {
            return zk_list;
        }

        public void setZk_list(List<?> zk_list) {
            this.zk_list = zk_list;
        }

        public List<?> getRpt_info() {
            return rpt_info;
        }

        public void setRpt_info(List<?> rpt_info) {
            this.rpt_info = rpt_info;
        }

        public static class StoreCartListBean {
            /**
             * 1 : {"goods_list":[{"cart_id":"26","buyer_id":"3","store_id":"1","store_name":"好商城V5","goods_id":"100009","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_price":"52800.00","goods_num":"5","goods_image":"1_04752627958339099.jpg","bl_id":"0","state":true,"storage_state":true,"goods_commonid":"100009","gc_id":"587","transport_id":"0","goods_freight":"0.00","goods_vat":"0","goods_storage":"100","goods_storage_alarm":"0","is_fcode":"0","have_gift":"0","groupbuy_info":null,"xianshi_info":null,"is_book":"0","book_down_payment":"0.00","book_final_payment":"0.00","book_down_time":"0","is_chain":"0","sole_info":[],"contractlist":[],"goods_total":"264000.00","goods_image_url":"http://169.254.191.113/data/upload/shop/store/goods/1/1_04752627958339099_240.jpg"}],"store_goods_total":"264000.00","store_mansong_rule_list":null,"store_voucher_info":[],"store_voucher_list":[],"freight":"1","store_name":"好商城V5"}
             */

            @SerializedName("1")
            private _$1Bean _$1;

            public _$1Bean get_$1() {
                return _$1;
            }

            public void set_$1(_$1Bean _$1) {
                this._$1 = _$1;
            }

            public static class _$1Bean {
                /**
                 * goods_list : [{"cart_id":"26","buyer_id":"3","store_id":"1","store_name":"好商城V5","goods_id":"100009","goods_name":"劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品","goods_price":"52800.00","goods_num":"5","goods_image":"1_04752627958339099.jpg","bl_id":"0","state":true,"storage_state":true,"goods_commonid":"100009","gc_id":"587","transport_id":"0","goods_freight":"0.00","goods_vat":"0","goods_storage":"100","goods_storage_alarm":"0","is_fcode":"0","have_gift":"0","groupbuy_info":null,"xianshi_info":null,"is_book":"0","book_down_payment":"0.00","book_final_payment":"0.00","book_down_time":"0","is_chain":"0","sole_info":[],"contractlist":[],"goods_total":"264000.00","goods_image_url":"http://169.254.191.113/data/upload/shop/store/goods/1/1_04752627958339099_240.jpg"}]
                 * store_goods_total : 264000.00
                 * store_mansong_rule_list : null
                 * store_voucher_info : []
                 * store_voucher_list : []
                 * freight : 1
                 * store_name : 好商城V5
                 */

                private String store_goods_total;
                private Object store_mansong_rule_list;
                private String freight;
                private String store_name;
                private List<GoodsListBean> goods_list;
                private List<?> store_voucher_info;
                private List<?> store_voucher_list;

                public String getStore_goods_total() {
                    return store_goods_total;
                }

                public void setStore_goods_total(String store_goods_total) {
                    this.store_goods_total = store_goods_total;
                }

                public Object getStore_mansong_rule_list() {
                    return store_mansong_rule_list;
                }

                public void setStore_mansong_rule_list(Object store_mansong_rule_list) {
                    this.store_mansong_rule_list = store_mansong_rule_list;
                }

                public String getFreight() {
                    return freight;
                }

                public void setFreight(String freight) {
                    this.freight = freight;
                }

                public String getStore_name() {
                    return store_name;
                }

                public void setStore_name(String store_name) {
                    this.store_name = store_name;
                }

                public List<GoodsListBean> getGoods_list() {
                    return goods_list;
                }

                public void setGoods_list(List<GoodsListBean> goods_list) {
                    this.goods_list = goods_list;
                }

                public List<?> getStore_voucher_info() {
                    return store_voucher_info;
                }

                public void setStore_voucher_info(List<?> store_voucher_info) {
                    this.store_voucher_info = store_voucher_info;
                }

                public List<?> getStore_voucher_list() {
                    return store_voucher_list;
                }

                public void setStore_voucher_list(List<?> store_voucher_list) {
                    this.store_voucher_list = store_voucher_list;
                }

                public static class GoodsListBean {
                    /**
                     * cart_id : 26
                     * buyer_id : 3
                     * store_id : 1
                     * store_name : 好商城V5
                     * goods_id : 100009
                     * goods_name : 劳力士Rolex 日志型系列 116200 63200 自动机械钢带男表联保正品
                     * goods_price : 52800.00
                     * goods_num : 5
                     * goods_image : 1_04752627958339099.jpg
                     * bl_id : 0
                     * state : true
                     * storage_state : true
                     * goods_commonid : 100009
                     * gc_id : 587
                     * transport_id : 0
                     * goods_freight : 0.00
                     * goods_vat : 0
                     * goods_storage : 100
                     * goods_storage_alarm : 0
                     * is_fcode : 0
                     * have_gift : 0
                     * groupbuy_info : null
                     * xianshi_info : null
                     * is_book : 0
                     * book_down_payment : 0.00
                     * book_final_payment : 0.00
                     * book_down_time : 0
                     * is_chain : 0
                     * sole_info : []
                     * contractlist : []
                     * goods_total : 264000.00
                     * goods_image_url : http://169.254.191.113/data/upload/shop/store/goods/1/1_04752627958339099_240.jpg
                     */

                    private String cart_id;
                    private String buyer_id;
                    private String store_id;
                    private String store_name;
                    private String goods_id;
                    private String goods_name;
                    private String goods_price;
                    private String goods_num;
                    private String goods_image;
                    private String bl_id;
                    private boolean state;
                    private boolean storage_state;
                    private String goods_commonid;
                    private String gc_id;
                    private String transport_id;
                    private String goods_freight;
                    private String goods_vat;
                    private String goods_storage;
                    private String goods_storage_alarm;
                    private String is_fcode;
                    private String have_gift;
                    private Object groupbuy_info;
                    private Object xianshi_info;
                    private String is_book;
                    private String book_down_payment;
                    private String book_final_payment;
                    private String book_down_time;
                    private String is_chain;
                    private String goods_total;
                    private String goods_image_url;
                    private List<?> sole_info;
                    private List<?> contractlist;

                    public String getCart_id() {
                        return cart_id;
                    }

                    public void setCart_id(String cart_id) {
                        this.cart_id = cart_id;
                    }

                    public String getBuyer_id() {
                        return buyer_id;
                    }

                    public void setBuyer_id(String buyer_id) {
                        this.buyer_id = buyer_id;
                    }

                    public String getStore_id() {
                        return store_id;
                    }

                    public void setStore_id(String store_id) {
                        this.store_id = store_id;
                    }

                    public String getStore_name() {
                        return store_name;
                    }

                    public void setStore_name(String store_name) {
                        this.store_name = store_name;
                    }

                    public String getGoods_id() {
                        return goods_id;
                    }

                    public void setGoods_id(String goods_id) {
                        this.goods_id = goods_id;
                    }

                    public String getGoods_name() {
                        return goods_name;
                    }

                    public void setGoods_name(String goods_name) {
                        this.goods_name = goods_name;
                    }

                    public String getGoods_price() {
                        return goods_price;
                    }

                    public void setGoods_price(String goods_price) {
                        this.goods_price = goods_price;
                    }

                    public String getGoods_num() {
                        return goods_num;
                    }

                    public void setGoods_num(String goods_num) {
                        this.goods_num = goods_num;
                    }

                    public String getGoods_image() {
                        return goods_image;
                    }

                    public void setGoods_image(String goods_image) {
                        this.goods_image = goods_image;
                    }

                    public String getBl_id() {
                        return bl_id;
                    }

                    public void setBl_id(String bl_id) {
                        this.bl_id = bl_id;
                    }

                    public boolean isState() {
                        return state;
                    }

                    public void setState(boolean state) {
                        this.state = state;
                    }

                    public boolean isStorage_state() {
                        return storage_state;
                    }

                    public void setStorage_state(boolean storage_state) {
                        this.storage_state = storage_state;
                    }

                    public String getGoods_commonid() {
                        return goods_commonid;
                    }

                    public void setGoods_commonid(String goods_commonid) {
                        this.goods_commonid = goods_commonid;
                    }

                    public String getGc_id() {
                        return gc_id;
                    }

                    public void setGc_id(String gc_id) {
                        this.gc_id = gc_id;
                    }

                    public String getTransport_id() {
                        return transport_id;
                    }

                    public void setTransport_id(String transport_id) {
                        this.transport_id = transport_id;
                    }

                    public String getGoods_freight() {
                        return goods_freight;
                    }

                    public void setGoods_freight(String goods_freight) {
                        this.goods_freight = goods_freight;
                    }

                    public String getGoods_vat() {
                        return goods_vat;
                    }

                    public void setGoods_vat(String goods_vat) {
                        this.goods_vat = goods_vat;
                    }

                    public String getGoods_storage() {
                        return goods_storage;
                    }

                    public void setGoods_storage(String goods_storage) {
                        this.goods_storage = goods_storage;
                    }

                    public String getGoods_storage_alarm() {
                        return goods_storage_alarm;
                    }

                    public void setGoods_storage_alarm(String goods_storage_alarm) {
                        this.goods_storage_alarm = goods_storage_alarm;
                    }

                    public String getIs_fcode() {
                        return is_fcode;
                    }

                    public void setIs_fcode(String is_fcode) {
                        this.is_fcode = is_fcode;
                    }

                    public String getHave_gift() {
                        return have_gift;
                    }

                    public void setHave_gift(String have_gift) {
                        this.have_gift = have_gift;
                    }

                    public Object getGroupbuy_info() {
                        return groupbuy_info;
                    }

                    public void setGroupbuy_info(Object groupbuy_info) {
                        this.groupbuy_info = groupbuy_info;
                    }

                    public Object getXianshi_info() {
                        return xianshi_info;
                    }

                    public void setXianshi_info(Object xianshi_info) {
                        this.xianshi_info = xianshi_info;
                    }

                    public String getIs_book() {
                        return is_book;
                    }

                    public void setIs_book(String is_book) {
                        this.is_book = is_book;
                    }

                    public String getBook_down_payment() {
                        return book_down_payment;
                    }

                    public void setBook_down_payment(String book_down_payment) {
                        this.book_down_payment = book_down_payment;
                    }

                    public String getBook_final_payment() {
                        return book_final_payment;
                    }

                    public void setBook_final_payment(String book_final_payment) {
                        this.book_final_payment = book_final_payment;
                    }

                    public String getBook_down_time() {
                        return book_down_time;
                    }

                    public void setBook_down_time(String book_down_time) {
                        this.book_down_time = book_down_time;
                    }

                    public String getIs_chain() {
                        return is_chain;
                    }

                    public void setIs_chain(String is_chain) {
                        this.is_chain = is_chain;
                    }

                    public String getGoods_total() {
                        return goods_total;
                    }

                    public void setGoods_total(String goods_total) {
                        this.goods_total = goods_total;
                    }

                    public String getGoods_image_url() {
                        return goods_image_url;
                    }

                    public void setGoods_image_url(String goods_image_url) {
                        this.goods_image_url = goods_image_url;
                    }

                    public List<?> getSole_info() {
                        return sole_info;
                    }

                    public void setSole_info(List<?> sole_info) {
                        this.sole_info = sole_info;
                    }

                    public List<?> getContractlist() {
                        return contractlist;
                    }

                    public void setContractlist(List<?> contractlist) {
                        this.contractlist = contractlist;
                    }
                }
            }
        }

        public static class InvInfoBean {
            /**
             * content : 不需要发票
             */

            private String content;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class StoreFinalTotalListBean {
            /**
             * 1 : 264000.00
             */

            @SerializedName("1")
            private String _$1;

            public String get_$1() {
                return _$1;
            }

            public void set_$1(String _$1) {
                this._$1 = _$1;
            }
        }
    }
}
