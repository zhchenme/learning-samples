package com.jas.staticfactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Services
 *
 * @author lanxiang
 * @since 2019-08-28
 */
public class Services {

    private static final Map<String, Provider> providersMap = new ConcurrentHashMap<String, Provider>();

    private static final String DEFAULT_PROVIDER_NAME = "def";

    private Services() {}

    /**
     * 服务注册
     *
     * @param p provoder
     */
    public static void registerDefaultProvider(Provider p) {
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p) {
        providersMap.put(name, p);
    }

    /**
     * 服务访问
     *
     * @return service
     */
    public static Service defaultNewInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    private static Service newInstance(String name) {
        Provider p = providersMap.get(name);
        if (null == p) {
            throw new IllegalArgumentException("No provider registered with name:" + name);
        }
        return p.newService();
    }

}
