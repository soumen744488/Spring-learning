package com.man.hospitalManagement.dto;

import com.man.hospitalManagement.entity.type.BloodGroupType;
import lombok.Data;

@Data
public class BloodGroupStats {
    private final BloodGroupType blooadGroupType;
    private final Long count;
}
