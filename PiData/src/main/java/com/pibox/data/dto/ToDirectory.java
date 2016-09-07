package com.pibox.data.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin Żuralski on 31.08.2016.
 */
public class ToDirectory extends ToFile {

    /**
     * Files stored in the directory
     */
    private List<ToFile> files = new ArrayList();

    public List<ToFile> getFiles() {
        return files;
    }
}
