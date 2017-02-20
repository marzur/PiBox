package com.pibox.core.spring;

/**
 * Interface contains KEYS used in a YAML config file
 *
 * Created by Marcin Żuralski on 05.02.2017.
 */
public interface PiCoreConfig {

    /**
     * Main directory of PiBoxLeaf application
     */
    String SYSTEM_PROPERTY_PiBoxLeaf = "PiBoxLeaf";

    /**
     * PiCore config file
     */
    String CONFIG_FILE = "conf/com.picode.piboxleaf.core.yaml";

    /**
     * PiCore config file
     */
    String PICORE_MESSAGES_PROPERTIES = "/messages/picore_messages.properties";


    /**
     * YAML path to directory contained messages.properties for various languages
     */
    String YAML_MESSAGES_DIR = "/PiCore/messages/dir";
}
