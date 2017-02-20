package com.pibox.core.spring;

import com.pibox.core.repository.IRepositoryManager;
import com.pibox.core.repository.linux.LinuxRepositoryManager;
import com.pibox.core.repository.macos.MacOsRepositoryManager;
import com.pibox.core.repository.windows.WindowsRepositoryManager;
import com.picode.pitool.messages.MessagesTool;
import com.picode.pitool.yaml.YamlTool;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;
import java.util.PropertyResourceBundle;

/**
 * Created by Marcin Żuralski on 16.09.2016.
 * <p>
 * Spring configuration for the development environment
 */
@Configuration
@Profile("dev")
@ComponentScan(basePackages = "com.pibox.core")
public class PiCoreConfigDev implements PiCoreConfig {

    /**
     * Path to PiBoxLeaf main directory
     *
     * @return
     */
    @Bean
    public File PiBoxLeafDirectory() {
        File file = new File(System.getenv(SYSTEM_PROPERTY_PiBoxLeaf));
        if (!file.exists()) {
            throw new IllegalStateException("Cann't find the system proeprty : %s"); // TODO add error
        }
        return file;
    }

    /**
     * Map contains all value from PiCore yaml config file
     *
     * @return
     * @throws IOException
     */
    @Bean
    public Map<String, Object> PiCoreYamlConfigMap() throws IOException {
        try (FileInputStream is = new FileInputStream(new File(PiBoxLeafDirectory(), CONFIG_FILE))) {
            return YamlTool.load(is);
        }
    }

    /**
     * Messages tool to manage massages in the module
     *
     * @return
     * @throws IOException
     */
    @Bean
    public MessagesTool MessagesTool() throws IOException {
        File defaultMessagesProperties = new File(PiCoreConfig.PICORE_MESSAGES_PROPERTIES);
        String messagesDirStr = (String) YamlTool.getValue(PiCoreYamlConfigMap(), PiCoreConfig.YAML_MESSAGES_DIR);
        if (messagesDirStr != null) {
            Locale locale = Locale.getDefault();
            File localeFileProperties = new File(FilenameUtils.getBaseName(defaultMessagesProperties.getName()) + "_" + locale.getCountry() + ".properties");
            if (localeFileProperties != null) {
                return new MessagesTool(new PropertyResourceBundle(new FileInputStream(localeFileProperties)));
            }
        }
        return new MessagesTool(new PropertyResourceBundle(PiCoreConfigDev.class.getResourceAsStream(PiCoreConfig.PICORE_MESSAGES_PROPERTIES)));
    }

}