package com.example.CarShop.specification;

import com.example.CarShop.entity.Car;
import com.example.CarShop.form.CarFilterForm;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarSpecification {

    public static Specification<Car> buildSpec(CarFilterForm form){

        return form == null ? null : new Specification<Car>() {
            @Override
            public Predicate toPredicate(
                    Root<Car> root,
                    CriteriaQuery<?> query,
                    CriteriaBuilder builder
            ) {
                List<Predicate> predicates = new ArrayList<>();

                String carMaker = form.getCarMaker();
                if (StringUtils.hasText(carMaker)) {

                    String pattern = "%" + carMaker.trim() + "%";
                    Predicate predicate1 = builder.like(root.get("carMaker"), pattern);
                    predicates.add(predicate1);
                }


                //select name as ten from car where id = 1
                //      Expression                 Predicate
                LocalDate repairDate = form.getRepairDate();
                Expression<LocalDateTime> local = root.get("pk").get("repairDate").as(LocalDateTime.class);
                if (repairDate != null) {
                    LocalDateTime datetime1 = LocalDateTime.of(repairDate, LocalTime.now());
                    Predicate predicate2 = builder.lessThanOrEqualTo(
                            root.get("pk").get("repairDate").as(LocalDateTime.class),
                            datetime1);
//                    Predicate predicate3 = builder.greaterThan(root.get("carMaker"), "haha");
                    predicates.add(predicate2);
                }

                return builder.and(predicates.toArray(new Predicate[0]));
            }
        };

    }
}
