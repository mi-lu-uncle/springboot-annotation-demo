package com.gc.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gaochao
 * @create 2020-08-05 11:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private int id;
  private String name;
  private int age;

}
