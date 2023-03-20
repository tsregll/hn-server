package com.ruoyi.business.vo;

import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BusinessFuheVo {
    private String realTime;
    private String uploadType;
    private double loadActual;
    private double loadPredict;
    private double difference;
}
