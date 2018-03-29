package com.ebay.model;

import com.ebay.constants.EsConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
@Data@AllArgsConstructor
@Document(indexName = EsConstant.USER_INDEX_NAME,type=EsConstant.USER_INDEX_TYPE)
public class User {
    @Id
    @Field(type= FieldType.Long)
    private Long id;
    @Field(type=FieldType.text)
    private String userName;
    @Field(type=FieldType.text)
    private String passWord;
}
