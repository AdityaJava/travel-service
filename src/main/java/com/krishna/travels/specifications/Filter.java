package com.krishna.travels.specifications;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class Filter {
    private String field;
    private String operator;
    private String value;
    private List<String> values;
}
