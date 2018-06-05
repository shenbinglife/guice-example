package org.shenb.example.guice.service;

import java.lang.annotation.*;

/**
 * 类名
 *
 * @author shenbing
 * @version 2018/6/5
 * @since since
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Log {
}
