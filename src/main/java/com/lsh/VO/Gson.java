package com.lsh.VO;

import java.util.List;

/**
 * @ClassName Gson
 * @Description: TODO
 * @Author lsh
 * @Date 2018/10/7 21:15
 * @Version
 */
public class Gson {

    /**
     * code : 0
     * msg : 成功
     * data : [{"name":"热榜","type":1,"foods":[{"id":"123456","name":"皮蛋粥","price":1.2,"description":"好吃的皮蛋粥","icon":"http://xxx.com"}]},{"name":"好吃的","type":2,"foods":[{"id":"123457","name":"慕斯蛋糕","price":10.9,"description":"美味爽口","icon":"http://xxx.com"}]}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 热榜
         * type : 1
         * foods : [{"id":"123456","name":"皮蛋粥","price":1.2,"description":"好吃的皮蛋粥","icon":"http://xxx.com"}]
         */

        private String name;
        private int type;
        private List<FoodsBean> foods;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<FoodsBean> getFoods() {
            return foods;
        }

        public void setFoods(List<FoodsBean> foods) {
            this.foods = foods;
        }

        public static class FoodsBean {
            /**
             * id : 123456
             * name : 皮蛋粥
             * price : 1.2
             * description : 好吃的皮蛋粥
             * icon : http://xxx.com
             */

            private String id;
            private String name;
            private double price;
            private String description;
            private String icon;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }
        }
    }
}
