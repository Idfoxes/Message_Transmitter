package com.Idfoxes.Service.A.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MsgA {
    private String msg;
    private String lng;
    private Coordinates coordinates;

    @Data
    @AllArgsConstructor
    public static class Coordinates {
        private String latitude;
        private String longitude;
    }
}