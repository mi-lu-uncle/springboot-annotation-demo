package com.gc.ioc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author gaochao
 * @create 2020-04-15 15:12
 */
@Component
@Slf4j
public class Pig  {

  public Pig(){
    log.info("Pig 构造方法...");
  }

  @PreDestroy
  public void destroy() throws Exception {
    log.info("Pig destroy @PreDestroy...");
  }

  @PostConstruct
  public void afterPropertiesSet() throws Exception {
    log.info("Pig init @PostConstruct...");
  }
}
