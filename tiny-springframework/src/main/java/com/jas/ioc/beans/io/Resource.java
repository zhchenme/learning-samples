package com.jas.ioc.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource
 *
 * @author lanxiang
 * @since 2019-07-19
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
