package com.pibox.data.dao;

import com.pibox.data.dto.ToRepository;
import org.springframework.stereotype.Component;

/**
 * Created by Marcin Żuralski on 02.09.2016.
 */
public interface IDaoRepository<T extends ToRepository, String> extends IDaoCRUD<T, String> {

}