package com.neuedu.ruidaoexam.entity;

public class AbilityType {
    private Integer abilityTypeId;

    private String abilityType;

    public Integer getAbilityTypeId() {
        return abilityTypeId;
    }

    public void setAbilityTypeId(Integer abilityTypeId) {
        this.abilityTypeId = abilityTypeId;
    }

    public String getAbilityType() {
        return abilityType;
    }

    public void setAbilityType(String abilityType) {
        this.abilityType = abilityType == null ? null : abilityType.trim();
    }
}