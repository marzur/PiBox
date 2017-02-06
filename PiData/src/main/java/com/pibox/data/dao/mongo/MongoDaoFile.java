package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoFile;
import com.pibox.data.dao.IDaoUser;
import com.pibox.data.dto.ToFile;
import com.pibox.data.dto.ToUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Marcin Żuralski on 04.02.2017.
 */
public interface MongoDaoFile extends IDaoFile, MongoRepository<ToFile, String> {
}
