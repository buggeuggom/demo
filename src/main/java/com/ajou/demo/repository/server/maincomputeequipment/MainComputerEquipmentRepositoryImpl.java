package com.ajou.demo.repository.server.maincomputeequipment;

import com.ajou.demo.controller.request.maincomputerequipment.MainComputerEquipmentSearch;
import com.ajou.demo.domain.server.MainComputerEquipment;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

import static com.ajou.demo.domain.server.QMainComputerEquipment.mainComputerEquipment;


@RequiredArgsConstructor
public class MainComputerEquipmentRepositoryImpl implements MainComputerEquipmentRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<MainComputerEquipment> getList(MainComputerEquipmentSearch search) {
        long totalCount = jpaQueryFactory
                .select(mainComputerEquipment.count())
                .where(getUserLike(search.getUse()),
                        getEquipmentNameLike(search.getEquipmentName()))
                .from(mainComputerEquipment)
                .fetchFirst();


        List<MainComputerEquipment> items = jpaQueryFactory.selectFrom(mainComputerEquipment)
                .where(getUserLike(search.getUse()),
                        getEquipmentNameLike(search.getEquipmentName()))
                .limit(search.getSize())
                .offset(search.getOffset())
                .orderBy(mainComputerEquipment.id.asc())
                .fetch();

        return new PageImpl<>(items, search.getPageable(), totalCount);
    }

    private static BooleanExpression getUserLike(String use) {

        if (use == null || use.isBlank()) return null;
        return mainComputerEquipment.use.lower().like("%" + use.toLowerCase() + "%");
    }

    private static BooleanExpression getEquipmentNameLike(String equipmentName) {

        if (equipmentName == null || equipmentName.isBlank()) return null;
        return mainComputerEquipment.equipmentName.lower().like("%" + equipmentName + "%");
    }
}
