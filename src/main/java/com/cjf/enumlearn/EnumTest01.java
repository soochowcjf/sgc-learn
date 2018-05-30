package com.cjf.enumlearn;

/**
 * @author:chenjinfeng
 * @Date:2018/5/30
 * @Time:23:05
 */
public enum EnumTest01 {

    UPDATE(1,"更新"),QUERY(2,"查询"),DELETE(3,"删除");
    private Integer enumValue;
    private String enumDesc;

    private EnumTest01(Integer enumValue, String enumDesc) {
        this.enumValue = enumValue;
        this.enumDesc = enumDesc;
    }

    public int getEnumValue(){
        return this.enumValue;
    }

    public void setEnumValue(Integer enumValue) {
        this.enumValue = enumValue;
    }

    public void setEnumDesc(String enumDesc) {
        this.enumDesc = enumDesc;
    }

    public String getEnumDesc(){
        return this.enumDesc;
    }

    @Override
    public String toString() {
        return "EnumTest01{" +
                "enumValue=" + enumValue +
                ", enumDesc='" + enumDesc + '\'' +
                '}';
    }
}

