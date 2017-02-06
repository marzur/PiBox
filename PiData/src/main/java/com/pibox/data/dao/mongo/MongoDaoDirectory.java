package com.pibox.data.dao.mongo;

import com.pibox.data.dao.IDaoDirectory;
import com.pibox.data.dao.IDaoFile;
import com.pibox.data.dto.ToDirectory;
import com.pibox.data.dto.ToFile;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Marcin Żuralski on 04.02.2017.
 */
public interface MongoDaoDirectory extends IDaoDirectory, MongoRepository<ToDirectory, String> {
}
