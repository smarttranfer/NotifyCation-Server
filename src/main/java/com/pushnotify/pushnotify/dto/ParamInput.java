package com.pushnotify.pushnotify.dto;

import java.util.List;

public class ParamInput {
    private List<NotificationRequestDto> listParam;

    public List<NotificationRequestDto> getListParam() {
        return this.listParam;
    }

    public void setListParam(List<NotificationRequestDto> listParam) {
        this.listParam = listParam;
    }
}
