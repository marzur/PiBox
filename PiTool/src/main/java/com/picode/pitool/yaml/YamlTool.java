package com.picode.pitool.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Marcin Żuralski on 05.02.2017.
 */
public class YamlTool {

    /**
     * Load yaml structure from the following input stream to Map
     *
     * @param is
     * @return
     */
    public static Map<String, Object> load(InputStream is) {
        Yaml yaml = new Yaml();
        return (Map<String, Object>) yaml.load(is);
    }


    /**
     * @param yamlMap
     * @param path
     * @return
     */
    public static Object getValue(Map<String, Object> yamlMap, String path) {
        Map<String, Object> currentMap = yamlMap;
        Object currentValue = null;
        String[] split = path.split("[.]");
        for (int i = 0; i < split.length; i++) {
            String key = split[i];

            /**
             * If current path contains index e.q. something[7]
             */
            Integer isIndexed = isIndexed(key);
            if (isIndexed != null) {
                key = key.substring(0, key.lastIndexOf("["));
                currentValue = getItem(currentMap, key, isIndexed);
            } else {
                currentValue = currentMap.get(key);
            }

            if (i == (split.length - 1)) {
                return currentValue;
            } else if (currentValue instanceof Map) {
                currentMap = (Map<String, Object>) currentValue;
            } else {
                return currentValue;
            }
        }

        return null;
    }

    public static Object getItem(Map<String, Object> yamlMap, String key, int index) {
        Object o = yamlMap.get(key);
        if (o instanceof Collection) {
            Collection collection = (Collection) o;
            Iterator iterator = collection.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                Object obj = iterator.next();
                if (i++ == index) {
                    return obj;
                }
            }
            throw new IndexOutOfBoundsException(
                    String.format(
                            "Bad index %s in %s",
                            index,
                            collection.stream().reduce((i1, i2) -> "" + i1 + ", " + i2).get()));
        }
        return null;
    }

    private static Integer isIndexed(String path) {
        if (path != null && path.matches("(.)*[\\[][1-9]*[\\]]")) {
            return Integer.parseInt(path.substring(path.lastIndexOf("[") + 1, path.lastIndexOf("]")));
        } else {
            return null;
        }
    }
}