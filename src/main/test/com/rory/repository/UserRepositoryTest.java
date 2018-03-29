package com.rory.repository;

import com.ebay.constants.EsConstant;
import com.ebay.model.SkuFinal;
import com.ebay.model.User;
import com.ebay.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserRepositoryTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private UserRepository repository;

    @Test
    public void createIndex() {
        elasticsearchTemplate.createIndex(User.class);
        elasticsearchTemplate.putMapping(User.class);
    }

    @Test
    public void addUserTest() {
        User u1 = new User(22L, "king", "123");
        repository.save(u1);
    }

    @Test
    public void deleteUserTest() {
        User u1 = new User(11L, "query", "123");
        repository.delete(u1);
    }

    @Test
    public void updateUserTest() {
        User u1 = new User(11L, "update", "123");
        repository.save(u1);
    }

    @Test
    public void findUserTest() {
//        User u = new User(1L, "rory", "123");
//        repository.save(u);
        Iterable<User> all = repository.findAll();
        for (User user : all) {
            System.out.println(user.toString());
        }
    }


    @Test
    public void bulkIndexTest() {
        User u1 = new User(1L, "ery", "123");
        User u2 = new User(2L, "wer", "456");
        User u3 = new User(3L, "wer", "456");
        User u4 = new User(4L, "ewe", "456");
        User u5 = new User(5L, "ert", "456");
        User u6 = new User(6L, "dfg", "456");
        User u7 = new User(7L, "sdf", "456");
        User u8 = new User(8L, "asd", "456");
        User u9 = new User(9L, "gfg", "456");
        User u10 = new User(10L, "fgh", "456");
        List<User> users = Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10);
        bulkIndex(users);

    }


    public void bulkIndex(List<User> userList) {
        int counter = 0;
        try {
            if (!elasticsearchTemplate.indexExists(EsConstant.USER_INDEX_NAME)) {
                elasticsearchTemplate.createIndex(User.class);
                System.out.println("create new index or type !");
            }
            List<IndexQuery> queries = new ArrayList<>();
            for (User user : userList) {

                IndexQuery index = new IndexQueryBuilder().withId(user.getId() + "").withObject(user).build();

                //the same method to builder IndexQuery
//                IndexQuery indexQuery = new IndexQuery();
//                indexQuery.setId(User.getId() + "");
//                indexQuery.setObject(User);
//                indexQuery.setIndexName(EsConstant.PRODUCT_INDEX_NAME);
//                indexQuery.setType(EsConstant.PRODUCT_INDEX_TYPE);

                queries.add(index);

                if (counter % 30 == 0) {
                    elasticsearchTemplate.bulkIndex(queries);
                    System.out.println("bulkIndex counter : " + counter);
                    queries.clear();
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
