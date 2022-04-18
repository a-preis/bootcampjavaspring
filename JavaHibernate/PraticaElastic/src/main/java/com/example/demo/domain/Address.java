package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "address")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private String id;
    private String city;
    private String state;
}
