package com.gc.xml;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多层级map和xml字符串的互相转换关系
 * @author gaochao
 * @create 2020-09-18 14:44
 */
@Slf4j
public class XmlUtil {
  static Map<String, String> xmlMap = new HashMap<String, String>();

  public static void main(String[] args) {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <SDOROOT package_type=\"xml\"> \t<SYS_HEAD> \t\t<ORG_SYS_ID>010208</ORG_SYS_ID> \t\t<ESB_SEQ_NO>C1-20200918104524-015601</ESB_SEQ_NO> \t\t<SERVICE_SCENE>01</SERVICE_SCENE> \t\t<TRAN_TIMESTAMP>104531718</TRAN_TIMESTAMP> \t\t<RET_STATUS>S</RET_STATUS> \t\t<SERVICE_CODE>11002000181</SERVICE_CODE> \t\t<CONSUMER_ID>010208</CONSUMER_ID> \t\t<RET> \t\t\t<SDO> \t\t\t\t<RET_MSG>交易成功完成</RET_MSG> \t\t\t\t<RET_CODE>I010209000000</RET_CODE> \t\t\t</SDO> \t\t</RET> \t\t<TRAN_DATE>20200918</TRAN_DATE> \t\t<CONSUMER_SEQ_NO>0102082032111268954053</CONSUMER_SEQ_NO> \t</SYS_HEAD> \t<APP_HEAD> \t\t<USER_ID>W62001</USER_ID> \t</APP_HEAD> \t<LOCAL_HEAD> \t\t<RURAL_BRANCH_ID>0000</RURAL_BRANCH_ID> \t</LOCAL_HEAD> \t<BODY> \t\t<MSG_FLOW>00000000000102082032111235721146</MSG_FLOW> \t\t<TRAN_LIST_ARRAY> \t\t\t<SDO> \t\t\t\t<ID>511523199412176453</ID> \t\t\t\t<PHOTO></PHOTO> \t\t\t\t<NAME>刘刚</NAME> \t\t\t\t<ISSUE_OFFICE>辽宁0</ISSUE_OFFICE> \t\t\t\t<CHECK_RESULT>00</CHECK_RESULT> \t\t\t</SDO> \t\t</TRAN_LIST_ARRAY> \t\t<ENTRUST_DATE>20321112104520</ENTRUST_DATE> \t\t<VER>1.0</VER> \t\t<STS>0000</STS> \t\t<MSG_TYPE>picp.250.002.01</MSG_TYPE> \t\t<RESERVE>String</RESERVE> \t</BODY> </SDOROOT>";
    Map<String, Object> map = multilayerXmlToMap(xml);
    IdentifySingleCheck identifySingleCheck1 = resolveMapToBean(map, IdentifySingleCheck.class);
    System.out.println(identifySingleCheck1.toString());
  }

  public static <T> T resolveMapToBean(Map<String,Object> map,Class<T> clz){

//    Set<Map.Entry<String, Object>> entries = map.entrySet();
//    Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
//    while (iterator.hasNext()){
//      Map.Entry<String, Object> next = iterator.next();
//      String key = next.getKey();
//      Object value = next.getValue();
//      if ("SYS_HEAD".equals(key)){
//        System.out.println("SYS_HEAD="+value.toString());
//      }else if ("BODY".equals(key)){
//        System.out.println("BODY="+value.toString());
//      }else if ("RET_MSG".equals(key)){
//        System.out.println("RET_MSG="+value.toString());
//      }else if ("RET_CODE".equals(key)){
//        System.out.println("RET_CODE="+value.toString());
//      }
//    }

    Map<String, Object> headMap = new HashMap<>();
    Map<String, Object> bodyMap = new HashMap<>();
    map = (Map<String, Object>) map.get("SDOROOT");
    bodyMap = (Map<String, Object>) map.get("BODY");
    headMap = (Map<String, Object>)((Map<String, Object>) ((Map<String, Object>) map.get("SYS_HEAD")).get("RET")).get("SDO");
    String RET_MSG = headMap.get("RET_MSG").toString();
    String RET_CODE = headMap.get("RET_CODE").toString();


    String jsonString = JSONObject.toJSONString(bodyMap);
    T t = JSONObject.parseObject(jsonString, clz);
    try {
//      Field field = t.getClass().getDeclaredField("retCd");
//      field.set(t,RET_MSG);

      Method M1 = t.getClass().getDeclaredMethod("setRet",String.class,String.class);
      M1.setAccessible(true) ;
      M1.invoke(t,RET_MSG,RET_CODE);
//      Method M2 = t.getClass().getDeclaredMethod("setRetMsg",String.class);
//      M2.setAccessible(true) ;
//      M2.invoke(t,RET_CODE);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return t;
  }


  /**
   * (多层)xml格式字符串转换为map
   *
   * @param xml xml字符串
   * @return 第一个为Root节点，Root节点之后为Root的元素，如果为多层，可以通过key获取下一层Map
   */
  public static Map<String, Object> multilayerXmlToMap(String xml) {
    Document doc = null;
    try {
      doc = DocumentHelper.parseText(xml);
    } catch (DocumentException e) {
      log.error("xml字符串解析，失败 --> {}", e);
    }
    Map<String, Object> map = new HashMap<>();
    if (null == doc) {
      return map;
    }
    // 获取根元素
    Element rootElement = doc.getRootElement();
    recursionXmlToMap(rootElement,map);
    return map;
  }

  /**
   * multilayerXmlToMap核心方法，递归调用
   *
   * @param element 节点元素
   * @param outmap 用于存储xml数据的map
   */
  @SuppressWarnings("unchecked")
  private static void recursionXmlToMap(Element element, Map<String, Object> outmap) {
    // 得到根元素下的子元素列表
    List<Element> list = element.elements();
    int size = list.size();
    if (size == 0) {
      // 如果没有子元素,则将其存储进map中
      outmap.put(element.getName(), element.getTextTrim());
    } else {
      // innermap用于存储子元素的属性名和属性值
      Map<String, Object> innermap = new HashMap<>();
      // 遍历子元素
      list.forEach(childElement -> recursionXmlToMap(childElement, innermap));
      outmap.put(element.getName(), innermap);
    }
  }

}
