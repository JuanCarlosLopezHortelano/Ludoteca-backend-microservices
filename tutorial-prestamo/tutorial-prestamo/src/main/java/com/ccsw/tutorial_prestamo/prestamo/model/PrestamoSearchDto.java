package com.ccsw.tutorial_prestamo.prestamo.model;

import com.ccsw.tutorial_prestamo.common.pagination.PageableRequest;

public class PrestamoSearchDto {

    private PageableRequest pageable;

    public PageableRequest getPageable() {
        return pageable;
    }

    public void setPageable(PageableRequest pageable) {
        this.pageable = pageable;
    }
}
