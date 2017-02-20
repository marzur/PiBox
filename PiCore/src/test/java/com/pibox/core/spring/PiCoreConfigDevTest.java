package com.pibox.core.spring;

import com.picode.pitool.messages.MessagesTool;
import com.picode.pitool.yaml.YamlTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Map;

import static com.pibox.core.messages.MessagesKeys.MSG_SYSTEM_PROPERTY_NOT_FOUND;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Marcin Żuralski on 05.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = {PiCoreConfigDev.class})
@ActiveProfiles("dev")
public class PiCoreConfigDevTest {

    @Autowired
    MessagesTool MessagesTool;


    @Value("#{PiCoreYamlConfigMap}")
    Map<String, Object> coreYamlConfigMap;

    @Test
    public void getRepositoryManager() throws Exception {

    }

    @Test
    public void messagesTool() throws Exception {
        assertNotNull(MessagesTool);
        assertEquals("Can't find system property - 1", MessagesTool.formatMessage(MSG_SYSTEM_PROPERTY_NOT_FOUND, "1"));
    }

    @Test
    public void getPiBoxLeafDir() throws Exception {
    }

    @Test
    public void configYaml() throws Exception {
        assertNotNull(coreYamlConfigMap);
        assertEquals(1, coreYamlConfigMap.size());
        assertNotNull(YamlTool.getValue(coreYamlConfigMap, "PiCore"));
    }

    @Test
    public void piBoxRepositoryMainDir() throws Exception {

    }

}