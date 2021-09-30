package com.nier.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @Description
 * @create 2018-06-28 14:18
 **/

public class IntrospectorUtils {
    /**
     *
     * @param obj 该Bean对象的实例,以便获取字节码;  也可改造该方法直接获取字节码
     * @return
     */
    public static Map<String,Object> transBeanToMap(Object obj) {
        if(obj == null){
            return null;
        }

        HashMap<String, Object> map = new HashMap<>();
        try {
            //获取内省对象
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            //获取属性数组
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            //遍历每一个成员属性(会包含class字节码属性,需过滤)
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String propertyName = propertyDescriptor.getName();
                //过滤class属性
                if(!"class".equals(propertyName)){
                    //获取property对应的getter方法(getWriteMethod()是setter方法)
                    Method getter = propertyDescriptor.getReadMethod();
                    //调用getter方法,获取传入对象的属性值
                    Object value = getter.invoke(obj);
                    //是否需要设置值value为null的进入map,根据业务需求
                    map.put(propertyName,value);
                    /*
                    //如果是导出为excel下载,容易出现该结果原本没值,使得列结果错乱
                    //可以使用一个VO对应多个数据库查询结果(但是需要保证需要返回的结果都存在,不为null 可以为"" 0)
                    if(value != null){
                        map.put(propertyName,value);
                    }*/
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    /**
     *
     * @param obj 该Bean对象的实例,以便获取字节码;  也可改造该方法直接获取字节码
     * @return
     */
    public static void transMapToBean(Map<String, Object> map, Object obj) {
        if(obj == null){
            return;
        }

        try {
            //获取内省对象
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            //获取属性数组
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            //遍历每一个成员属性(会包含class字节码属性,需过滤)
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                String key = propertyDescriptor.getName();
                //过滤class属性
                if(!"class".equals(key)){
                    if(map.containsKey(key)){
                        //获取property对应的setter方法
                        Method setter = propertyDescriptor.getWriteMethod();
                        //在数据类型要求严格情况下,可先转value为对应类型 setter.getParameterTypes()[0].getName() 判断是Long Integer long int BigDecimal等等;
                        Object value = map.get(key);
                        setter.invoke(obj,value);
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
