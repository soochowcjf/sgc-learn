package com.cjf.fastjson;


//下面是FastJson的简介：常用的方法！
//  Fastjson API入口类是com.alibaba.fastjson.JSON，常用的序列化操作都可以在JSON类上的静态方法直接完成。
//  public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray
//  public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject
//  public static final <T> T parseObject(String text, Class<T> clazz); // 把JSON文本parse为JavaBean
//  public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray
//  public static final <T> List<T> parseArray(String text, Class<T> clazz); //把JSON文本parse成JavaBean集合
//  public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本
//  public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本
//  public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray（和上面方法的区别是返回值是不一样的）

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author:chenjinfeng
 * Date:2018/5/28
 * Time:21:57
 */
public class JsonDemo {
    public static void main(String[] args) {
//        json2JsonObjectM1();//将Json文本数据信息转换为JsonObject对象，然后利用键值对的方式获取信息
//        json2BeanM2();//将Json文本数据转换为JavaBean数据！
//        json2JSONArrayM3();//将json数据转化为JSONArray:
//        json2JavaBeanM4();//将JSON文本转换为JavaBean的集合；转换为单纯的1个Object：parseObject(String text, Class<T> clazz);
//        bean2JsonM5();//将JavaBean转换为Json格式的数据/Json文本 用户数据的传递：例如上传服务器
//        bean2JSONObjectM6();//将JavaBean转换为JSON对象
//        complexExampleM7();//一个相对复杂的例子：
//        complex2JsonM8();//一个复杂的Object到Json的Demo
//        complexMap2JsonM9();//将Map数据转换为JsonString的Demo；这个对RedBoy服务端不就直接破了嘛！
    }

    /**
     * 将json文本数据转换成jsonObject对象，然后利用键值对的方式来取值
     */
    @Test
    public  void json2JsonObjectM1() {
        //json串
        String s = "{\"name\":\"chenjinfeng\"}";
        //将json串转换成jsonObject对象
        JSONObject object = JSONObject.parseObject(s);
        System.out.println(object.get("name"));
        /**
         * 输出： chenjinfeng
         */
    }

    /**
     * 将json串转换成javabean
     * 需要注意的是：这时候的Json文本信息中的键的名称必须和JavaBean中的字段名称一样！
     * 键中没有的在这个JavaBean中就显示为null！
     */
    @Test
    public void json2BeanM2() {
        //json串
        String s = "{\"id\":\"0375\",\"city\":\"平顶山\"}";
        //转换成javabean
        Weibo weibo = JSONObject.parseObject(s, Weibo.class);
        System.out.println(weibo);
        /**
         * 输出： Weibo{id='0375', city='平顶山'}
         */
    }
    /**
     * 将json数据转化为JSONArray:
     * 注意：获取到JSONArray之后（我们这里只是获取到JSONArray而不是JavaBean的List集合）
     * 获取JSONArray中的数据转换为String类型需要在外边加"";
     */
    @Test
    public void json2JSONArrayM3() {
        String s = "[{\"id\":\"0375\",\"city\":\"平顶山\"},{\"id\":\"0377\",\"city\":\"南阳\"}]";
        //转换成jsonArray
        JSONArray jsonArray = JSONObject.parseArray(s);
        //得到第二个json对象的json串
        String s1 = jsonArray.get(1).toString();
        System.out.println(s1);
        //{"city":"南阳","id":"0377"}
        Weibo weibo = JSONObject.parseObject(s1, Weibo.class);
        System.out.println(weibo);
        //Weibo{id='0377', city='南阳'}
        Object o = jsonArray.get(0);
        System.out.println(o);
        //{"city":"平顶山","id":"0375"}
    }

    /**
     * 将JSON文本转换为JavaBean的集合；
     * 内部实现肯定是：首先转换为JSONArray，然后再转换为List集合
     */
    @Test
    public void json2JavaBeanM4() {
        String s = "[{\"id\":\"0375\",\"city\":\"平顶山\"},{\"id\":\"0377\",\"city\":\"南阳\"}]";
        List<Weibo> list = JSONObject.parseArray(s, Weibo.class);
        for (Weibo weibo : list) {
            System.out.println(weibo);
        }
        /**
         * 输出：Weibo{id='0375', city='平顶山'}
         *      Weibo{id='0377', city='南阳'}
         */
    }

    /**
     * 将JavaBean转换为Json格式的数据/Json文本
     * 用户数据的传递：例如上传服务器
     */
    @Test
    public void bean2JsonM5() {
        Weibo weibo = new Weibo("123456", "上海");
        String json = JSONObject.toJSONString(weibo);
        System.out.println(json);
        //{"city":"上海","id":"123456"}
    }

    /**
     * 将JavaBean转换为JSON对象
     */
    @Test
    public void bean2JSONObjectM6() {
        Weibo weibo = new Weibo("0373", "洛阳");
        //转换成json对象
        JSONObject json = (JSONObject) JSONObject.toJSON(weibo);
        System.out.println(json.get("id"));
        //0373
    }

    /**
     * 一个相对复杂的例子：
     * JSON文本数据：
     *  首先是JSONObject，转换为JSONArray；
     *  然后将JSONArray转换为JavaBean
     */
    @Test
    public void complexExampleM7() {
        String s = "{js:[{id:\"110000\",\"city\":\"北#001京市\"},{id:\"110000\",\"city\":\"北#002京市\"}"
                + ",{id:\"110000\",\"city\":\"北#002京市\"},{id:\"110000\",\"city\":\"北#002京市\"},"
                + "{id:\"110000\",\"city\":\"#006北#005京市\"},"
                + "{id:\"110000\",\"city\":\"北#002京市\"},"
                + "{id:\"110000\",\"city\":\"北#002京市\"},{id:\"120000\",\"city\":\"天#009津市\"}]}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        Object jsonArray = jsonObject.get("js");
        //将其转换成list集合
        List<Weibo> list = JSONObject.parseArray(jsonArray.toString(), Weibo.class);
        for (Weibo weibo : list) {
            System.out.println(weibo);
        }
        /**
         * JSONArray js = jsonObject.getJSONArray("js");
         * List<Weibo> list1 = JSONObject.parseArray(js.toJSONString(), Weibo.class);
         * for (Weibo weibo : list1) {
         *    System.out.println(weibo);
         * }
         */

        /**
         * 输出：Weibo{id='110000', city='北#001京市'}
         *      Weibo{id='110000', city='北#002京市'}
         *      Weibo{id='110000', city='北#002京市'}
         *      Weibo{id='110000', city='北#002京市'}
         *      Weibo{id='110000', city='#006北#005京市'}
         *      Weibo{id='110000', city='北#002京市'}
         *      Weibo{id='110000', city='北#002京市'}
         *      Weibo{id='120000', city='天#009津市'}
         */
    }

    /**
     * 由一个复杂的Object到Json的Demo
     */
    @Test
    public void complex2JsonM8() {
        Group group = new Group();
        group.setId(1);
        group.setName("group");

        User user1 = new User();
        user1.setId(2);
        user1.setName("user1");

        User user2 = new User();
        user2.setId(3);
        user2.setName("user2");
        group.getList().add(user1);
        group.getList().add(user2);
        String jsonString = JSONObject.toJSONString(group);
        System.out.println(jsonString);
        /**
         * 输出：  {"id":1,"list":[{"id":2,"name":"user1"},{"id":3,"name":"user2"}],"name":"group"}
         */
    }
    /**
     * 将Map类型的数据转换为JsonString
     */
    @Test
    public void complexMap2JsonM9() {
        Group group = new Group();
        group.setId(1);
        group.setName("group");

        User user1 = new User();
        user1.setId(2);
        user1.setName("user1");

        User user2 = new User();
        user2.setId(3);
        user2.setName("user2");
        group.getList().add(user1);
        group.getList().add(user2);

        Map<Integer, Object> map = new HashMap<Integer,Object>();
        map.put(1, "No.1");
        map.put(2, "No.2");
        map.put(3, group.getList());

        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        /**
         * 输出： {1:"No.1",2:"No.2",3:[{"id":2,"name":"user1"},{"id":3,"name":"user2"}]}
         */
    }

    /**
     * 构造post请求，请求体是json
     *   {
     * 	    "name" : "notify",
     *      "tels" : [ "13112341234", "13212341234" ]
     *   }
     */
    @Test
    public void fun() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("15850061614");
        jsonArray.add("15850061411");
        jsonObject.put("name","notify");
        jsonObject.put("tels",jsonArray);
        System.out.println(jsonObject.toJSONString());
        /**
         * 输出：{"name":"notify","tels":["15850061614","15850061411"]}
         */
    }
    @Test
    public void fun2() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0,"15850061614");
        jsonArray.add(1,"15850061411");
        jsonObject.put("tels",jsonArray.toJSONString());
        System.out.println(jsonObject.toString());
        /**
         * 输出：  {"tels":"[\"15850061614\",\"15850061411\"]"}
         */
    }
    @Test
    public void fun3() {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("15850061614");
        jsonArray.add("15850061411");
        jsonArray.add("15850068888");
        Object[] objects = jsonArray.toArray();
        for (Object object : objects) {
            System.out.println(object.toString());
        }
        /**
         * 15850061614
         * 15850061411
         * 15850068888
         */
    }

    /**
     * [
     *   {
     *     "provinceName": "江苏省",
     *     "cities": [
     *       {
     *         "cityName": "苏州市",
     *         "district": [
     *           {
     *             "name": "苏州市一号店"
     *           },
     *           {
     *             "name": "苏州市二号店"
     *           }
     *         ]
     *       },
     *       {
     *         "cityName": "南京市",
     *         "district": [
     *           {
     *             "name": "南京市一号店"
     *           },
     *           {
     *             "name": "南京市二号店"
     *           }
     *         ]
     *       }
     *     ]
     *   },
     *   {
     *     "provinceName": "北京市",
     *     "cities": [
     *       {
     *         "cityName": "北京市",
     *         "district": [
     *           {
     *             "name": "北京市一号店"
     *           },
     *           {
     *             "name": "北京市二号店"
     *           }
     *         ]
     *       }
     *     ]
     *   }
     * ]
     */
    @Test
    public void fun4() {
        ArrayList<Store> stores = new ArrayList<Store>(){{
            add(new Store("北京市一号店"));
            add(new Store("北京市二号店"));
        }};
        //创建City对象
        City city = new City();
        city.setCityName("北京市");
        city.setDistrict(stores);

        //city集合
        ArrayList<City> cities = new ArrayList<City>(){{
            add(city);
        }};

        //创建Province对象
        Province province = new Province();
        province.setProvinceName("北京市");
        province.setCities(cities);

        //jsonArray
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(province);

        String s = JSONObject.toJSONString(jsonArray);
        System.out.println(s);

//        HashMap<String,Object> cityMap = new HashMap<>();
//        cityMap.put("cityName","北京市");
//        //添加市下面的经销商
//        ArrayList<Store> stores = new ArrayList<Store>(){{
//            add(new Store("北京市一号店"));
//            add(new Store("北京市二号店"));
//        }};
//        cityMap.put("district",stores);
//
//        HashMap<String,Object> provinceMap = new HashMap<>();
//        provinceMap.put("provinceName","北京市");
        //添加省下面的市
//        ArrayList<HashMap<String,Object>> citiesMap = new ArrayList<HashMap<String, Object>>() {{
//           add(cityMap);
//        }};
//        provinceMap.put("cities",provinceMap);
//
//        String s = JSONObject.toJSONString(provinceMap);
//        System.out.println(s);

    }

    public static class Province {
        private String provinceName;
        private List<City> cities;

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public List<City> getCities() {
            return cities;
        }

        public void setCities(List<City> cities) {
            this.cities = cities;
        }
    }

    public static class City {
        private String cityName;
        private List<Store> district;

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public List<Store> getDistrict() {
            return district;
        }

        public void setDistrict(List<Store> district) {
            this.district = district;
        }
    }

    public static class Store {
        private String name;

        public Store(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
