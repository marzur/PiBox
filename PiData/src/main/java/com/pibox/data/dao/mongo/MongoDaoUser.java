package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoUser;
import com.pibox.data.dto.ToUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Marcin Żuralski on 12.10.2016.
 */
@Component("daoUser")
public interface MongoDaoUser extends IDaoUser, MongoRepository<ToUser, String> {
}
