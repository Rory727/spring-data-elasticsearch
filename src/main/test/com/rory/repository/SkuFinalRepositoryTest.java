package com.rory.repository;

import com.ebay.constants.EsConstant;
import com.ebay.model.SkuFinal;
import com.ebay.model.User;
import com.ebay.repository.SkuFinalRepository;
import com.ebay.repository.UserRepository;
import com.ebay.util.ReadFileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SkuFinalRepositoryTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private SkuFinalRepository repository;



    @Test
    public void bulkIndexTest() throws Exception {
        String filePath = "E:/ElasticSearch/csv/sku_final_feed.csv" ;
        List<SkuFinal> skuFinals = ReadFileUtils.readFeedDataTest(filePath);

        bulkIndex(skuFinals);
    }



    public void bulkIndex(List<SkuFinal> SkuFinalList) {
        int counter = 0;
        try {
            if (!elasticsearchTemplate.indexExists(EsConstant.PRODUCT_INDEX_NAME)) {
                elasticsearchTemplate.createIndex(SkuFinal.class);
            }
            List<IndexQuery> queries = new ArrayList<>();
            for (SkuFinal skuFinal : SkuFinalList) {

                IndexQuery index = new IndexQueryBuilder().withId(skuFinal.getId() + "").withObject(skuFinal).build();

                //the same method to builder IndexQuery
//                IndexQuery indexQuery = new IndexQuery();
//                indexQuery.setId(skuFinal.getId() + "");
//                indexQuery.setObject(skuFinal);
//                indexQuery.setIndexName(EsConstant.PRODUCT_INDEX_NAME);
//                indexQuery.setType(EsConstant.PRODUCT_INDEX_TYPE);


                queries.add(index);
                if (counter % 20 == 0) {
                    elasticsearchTemplate.bulkIndex(queries);
                    queries.clear();
                    System.out.println("bulkIndex counter : " + counter);
                }
                counter++;
            }
            if (queries.size() > 0) {
                elasticsearchTemplate.bulkIndex(queries);
            }
            System.out.println("bulkIndex completed.");
        } catch (Exception e) {
            System.out.println("IndexerService.bulkIndex e;" + e.getMessage());
            throw e;
        }
    }
}
