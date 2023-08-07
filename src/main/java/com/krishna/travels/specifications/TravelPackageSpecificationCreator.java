package com.krishna.travels.specifications;

import com.krishna.travels.entity.TravelPackage;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@Data
public class TravelPackageSpecificationCreator {

    public Specification<TravelPackage> createSpecification(Filter filter){

        if (filter.getOperator() == null) {
            return null;
        }
        switch (filter.getOperator()) {

            case "equals":
                return ((root, query, criteriaBuilder) -> {
                    return criteriaBuilder.equal(root.get(filter.getField()), SpecificationUtils.castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue()));
                });

            case "notequals":
                return ((root, query, criteriaBuilder) -> {
                    return criteriaBuilder.notEqual(root.get(filter.getField()), SpecificationUtils.castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue()));
                });

            case "gt":
                return ((root, query, criteriaBuilder) -> {
                    return criteriaBuilder.gt(root.get(filter.getField()), (Number) SpecificationUtils.castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue()));
                });

            case "lt":
                return ((root, query, criteriaBuilder) -> {
                    return criteriaBuilder.lt(root.get(filter.getField()), (Number) SpecificationUtils.castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue()));
                });

            case "like":
                return ((root, query, criteriaBuilder) -> {
                    return criteriaBuilder.like(root.get(filter.getField()), "%" + SpecificationUtils.castToRequiredType(root.get(filter.getField()).getJavaType(), filter.getValue()) + "%");
                });

            default:
                return null;
        }


    }


}
