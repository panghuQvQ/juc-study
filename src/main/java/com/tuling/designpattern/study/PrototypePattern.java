package com.tuling.designpattern.study;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PrototypePattern.java
 * @Description TODO 原型模式
 * @createTime 2023年02月16日 09:17:00
 */
public class PrototypePattern {
    public static void main(String[] args) throws CloneNotSupportedException {
        BaseInfo baseInfo = new BaseInfo("XXX");
        Product product = new Product("part1", "part2", "part3", "part4", "part5",baseInfo);

        Product clone = product.clone();

        System.out.println("old...." + product);
        System.out.println("new...." + clone);

        product.getBaseInfo().setCompanyName("YYY");
        System.out.println("old...." + product);
        System.out.println("new...." + clone);
    }

}

@Data
@AllArgsConstructor
class BaseInfo implements Cloneable {
    private String companyName;

    @Override
    protected BaseInfo clone() throws CloneNotSupportedException {
        return (BaseInfo) super.clone();
    }

    @Override
    public String toString() {
        return super.hashCode() + "]BaseInfo{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Product implements Cloneable {
    private String part1;
    private String part2;
    private String part3;
    private String part4;
    private String part5;
    private BaseInfo baseInfo;


    @Override
    protected Product clone() throws CloneNotSupportedException {
        Product clone = (Product) super.clone();
        BaseInfo clone1 = this.baseInfo.clone();
        clone.setBaseInfo(clone1);
        return clone;
    }


    @Override
    public String toString() {
        return super.hashCode() + " ]Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", part3='" + part3 + '\'' +
                ", part4='" + part4 + '\'' +
                ", part5='" + part5 + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }
}
