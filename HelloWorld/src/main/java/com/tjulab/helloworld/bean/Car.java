package com.tjulab.helloworld.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 只有在容器中的组件才能使用SpringBoot提供的功能
 */
@EqualsAndHashCode
@NoArgsConstructor // 无参构造器
@AllArgsConstructor // 有参（全参）构造器
@ToString // toString方法
@Data // getter、setter方法
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private String brand;
    private Integer price;

//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "brand='" + brand + '\'' +
//                ", price=" + price +
//                '}';
//    }

}
