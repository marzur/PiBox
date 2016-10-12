package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoRepository;
import com.pibox.data.dto.ToRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Marcin Żuralski on 02.09.2016.
 */
@Component("daoRepository")
public interface MongoDaoRepository extends IDaoRepository<ToRepository, String>, MongoRepository<ToRepository, String> {

}