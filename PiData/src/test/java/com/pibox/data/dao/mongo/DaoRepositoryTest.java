package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoRepository;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Created by Marcin Żuralski on 02.09.2016.
 */
public class DaoRepositoryTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * Test for creating a repository
     */
    public void testCreateToRepository() {


        IDaoRepository daoRepository = new DaoRepository();
    }
}