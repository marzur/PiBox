package com.picode.pitool.yaml;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Marcin Żuralski on 05.02.2017.
 */
public class YamlToolTest {

    public static final Path testFilePath = Paths.get("src/test/resources/yaml/test.conf.yaml");

    @Test
    public void createYamlMapFromStream() throws IOException {
        System.out.println(testFilePath.toAbsolutePath().toFile());
        try (FileInputStream is = new FileInputStream(testFilePath.toAbsolutePath().toFile())) {
            Map<String, Object> yaml = YamlTool.load(is);
            assertNotNull(yaml);
        }
    }

    @Test
    public void YamlGetSimpleValue() throws IOException {
        try (FileInputStream is = new FileInputStream(testFilePath.toFile())) {
            Map<String, Object> yaml = YamlTool.load(is);

            Object value = YamlTool.getValue(yaml, "PiTool.simplenode.simpleStringValue");
            assertEquals(String.class, value.getClass());
            assertEquals("StringValue", value);

            Object intValue = YamlTool.getValue(yaml, "PiTool.simplenode.simpleIntValue");
            assertEquals(Integer.class, intValue.getClass());
            assertEquals(3, intValue);

            Object doubleValue = YamlTool.getValue(yaml, "PiTool.simplenode.simpleDoubleValue");
            assertEquals(Double.class, doubleValue.getClass());
            assertEquals(2.1, doubleValue);

            Object booleanValue = YamlTool.getValue(yaml, "PiTool.simplenode.simpleBooleanValue");
            assertEquals(Boolean.class, booleanValue.getClass());
            assertEquals(false, booleanValue);

            Object indexedValue = YamlTool.getValue(yaml, "PiTool.sequence[1]");
            assertEquals(String.class, indexedValue.getClass());
            assertEquals("element2", indexedValue);

            Object mapValue = YamlTool.getValue(yaml, "PiTool.mapNode[key1]");
            assertEquals(String.class, mapValue.getClass());
            assertEquals("element2", indexedValue);

        }
    }
}
