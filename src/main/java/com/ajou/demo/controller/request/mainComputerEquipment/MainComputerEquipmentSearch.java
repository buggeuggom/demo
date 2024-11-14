package com.ajou.demo.controller.request.mainComputerEquipment;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static java.lang.Math.min;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MainComputerEquipmentSearch {

    private static final int MAX_PAGE = 999;
    private static final int MAX_SIZE = 2000;

    private String use; //용도
    private String equipmentName;//장비명
//    private String modelName;//모델명
//    private String os; //os
//    private String introductionDate; //도입일자


    @Min(value = 1, message = "Write page. 1 ~")
    private Integer page;
    @Min(value = 10, message = "Write size. 1 ~")
    private Integer size;


    public void setPage(Integer page) {
        this.page = page <= 0 ? 1 : min(page, MAX_PAGE);
    }

    public long getOffset() {
        return (long) (page - 1) * min(size, MAX_SIZE);
    }

    public Pageable getPageable() {
        return PageRequest.of(page - 1, size);
    }
}
