package com.jas.ioc.beans.io;

import java.net.URL;

/**
 * ResourceLoader
 *
 * @author lanxiang
 * @since 2019-07-19
 */
public class ResourceLoader {

    public Resource getResource(String resourceLocation) {
        URL resource = this.getClass().getClassLoader().getResource(resourceLocation);
        return new UrlResource(resource);
    }
}
