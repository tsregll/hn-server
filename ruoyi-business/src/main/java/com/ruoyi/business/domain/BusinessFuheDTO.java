package com.ruoyi.business.domain;

import lombok.*;


import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class BusinessFuheDTO {

//    上传时间
    private String uploadDate;
//    场站名称
    private String uploadType;
    private List<BusinessfuheDataDTO> data;
    private int type;
}
