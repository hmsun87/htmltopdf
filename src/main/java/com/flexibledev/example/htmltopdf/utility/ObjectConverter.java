package com.flexibledev.example.htmltopdf.utility;

import lombok.extern.slf4j.Slf4j;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by seonhyeonmin on 2020/05/08 6:44 오후
 */
@Slf4j
public class ObjectConverter {
    public Map<String, String> toMap(Object object) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        return convertToMap(new HashMap<>(), object, null);
    }

    private Map<String, String> convertToMap(Map<String, String> map, Object object, String template) throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        for (PropertyDescriptor pd : Introspector.getBeanInfo(object.getClass()).getPropertyDescriptors()) {
            if (!pd.getName().equals("class")) {
                Class<?> cls = pd.getPropertyType();

                if (cls.getName().equals(String.class.getName())) {
                    String name = (template == null ? "" : template + ".") + pd.getName();
                    Object value = pd.getReadMethod().invoke(object);
                    map.put(name, value != null ? value.toString() : "");
                } else if (!cls.isPrimitive() && !cls.isEnum()) {
                    String name = (template == null ? "" : template + ".") + pd.getName();
                    map = convertToMap(map, pd.getReadMethod().invoke(object), name);
                }
            }
        }

        return map;
    }
}
