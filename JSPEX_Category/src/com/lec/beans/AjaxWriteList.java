package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxWriteList extends AjaxWriteResult {
   @JsonProperty("data")
   private List<CategoryDTO> list;  // 데이터 목록
   
//   @JsonProperty("depth")
//   private int ca_depth;
//   
//   @JsonProperty("parent")
//   private int ca_parent;
//   
//   @JsonProperty("order")
//   private int ca_order;   
//
   public List<CategoryDTO> getList() {
      return list;
   }

   public void setList(List<CategoryDTO> list) {
      this.list = list;
   }
//
//public int getCa_depth() {
//	return ca_depth;
//}
//
//public void setCa_depth(int ca_depth) {
//	this.ca_depth = ca_depth;
//}
//
//public int getCa_parent() {
//	return ca_parent;
//}
//
//public void setCa_parent(int ca_parent) {
//	this.ca_parent = ca_parent;
//}
//
//public int getCa_order() {
//	return ca_order;
//}
//
//public void setCa_order(int ca_order) {
//	this.ca_order = ca_order;
//}

   
   
   
   
   
}












