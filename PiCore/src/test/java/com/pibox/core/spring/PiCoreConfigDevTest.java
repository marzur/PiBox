package com.pibox.core.spring;

import com.pibox.core.repository.IRepositoryFactory;
import com.pibox.core.repository.linux.LinuxRepositoryFactory;
import com.pibox.core.repository.macos.MacOsRepositoryFactory;
import com.pibox.core.repository.windows.WindowsRepositoryFactory;
import com.picode.pitool.messages.MessagesTool;
import com.picode.pitool.messages.OsCheckTool;
import com.picode.pitool.yaml.YamlTool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.io.File;
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
    File PiBoxLeafDirectory;

    @Value("#{PiCoreYamlConfigMap}")
    Map<String, Object> coreYamlConfigMap;

    @Autowired
    MessagesTool MessagesTool;

    @Autowired
    IRepositoryFactory RepositoryFactory;

    @Test
    public void PiBoxLeafDirectoryTest() throws Exception {
        assertNotNull(PiBoxLeafDirectory);
    }

    @Test
    public void PiCoreYamlConfigMapTest() throws Exception {
        assertNotNull(coreYamlConfigMap);
        assertEquals(1, coreYamlConfigMap.size());
        assertNotNull(YamlTool.getValue(coreYamlConfigMap, "PiCore"));
    }

    @Test
    public void MessagesToolTest() throws Exception {
        assertNotNull(MessagesTool);
        assertEquals("Can't find system property - 1", MessagesTool.formatMessage(MSG_SYSTEM_PROPERTY_NOT_FOUND, "1"));
    }

    @Test
    public void RepositoryFactory() {
        assertNotNull(RepositoryFactory);
        switch (OsCheckTool.getOperatingSystemType()) {
            case MacOS:
                assertEquals(MacOsRepositoryFactory.class, RepositoryFactory.getClass());
                break;
            case Windows:
                assertEquals(WindowsRepositoryFactory.class, RepositoryFactory.getClass());
                break;
            case Linux:
                assertEquals(LinuxRepositoryFactory.class, RepositoryFactory.getClass());
                break;
        }
    }
}