package com.ruoyi.business.domain;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BusinessfuheDataDTO {
    private String time;
    private double load;
}
