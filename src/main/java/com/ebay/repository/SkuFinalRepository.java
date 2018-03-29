package com.ebay.repository;

import com.ebay.model.SkuFinal;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by ruirli on 2018/3/29.
 */
public interface SkuFinalRepository extends ElasticsearchRepository<SkuFinal, Long> {
}
