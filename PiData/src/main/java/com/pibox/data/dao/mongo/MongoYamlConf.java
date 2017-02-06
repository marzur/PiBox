package com.pibox.data.dao.mongo;

/**
 * A class represents a structure of the config file from mongo installation
 * Created by Marcin Żuralski on 15.12.2016.
 */
public class MongoYamlConf {
    /**
     * Default netport
     */
    private static final int DEFAULT_NETPORT = 12345;

    private String netBindIp;
    private int netPort;

    public MongoYamlConf(String netBindIp, Integer netPort) {
        this.netBindIp = netBindIp;
        this.netPort = netPort;
        if (netPort == null) {
            this.netPort = DEFAULT_NETPORT;
        }
    }

    public String getNetBindIp() {
        return netBindIp;
    }

    public int getNetPort() {
        return netPort;
    }
}