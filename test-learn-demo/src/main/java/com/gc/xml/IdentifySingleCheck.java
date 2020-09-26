package com.gc.xml;

import lombok.Data;

import java.util.List;

@Data
public class IdentifySingleCheck extends IdentifyBase {

  private List<TranListArray> tranListArray;

  public void setRet(String code,String msg){
    super.retCd=code;
    super.retMsg=msg;
  }

}
