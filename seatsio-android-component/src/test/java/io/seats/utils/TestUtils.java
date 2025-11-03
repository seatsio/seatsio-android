package io.seats.utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class TestUtils {

    private TestUtils() {
    }

    public static String resource(String path) {
        try {
            return IOUtils.resourceToString(path, Charset.defaultCharset(), TestUtils.class.getClassLoader());
        } catch (IOException e) {
            throw new RuntimeException("Error loading " + path, e);
        }
    }
}
