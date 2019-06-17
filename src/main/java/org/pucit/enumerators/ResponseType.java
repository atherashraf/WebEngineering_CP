package org.pucit.org.pucit.enumerators;

public enum ResponseType {
   SUCCESS("alert-success"),
   ERROR("alert-danger"),
   WARNING("alert-warning");

   public String getResponseType() {
      return responseType;
   }

   //   @Override
//   public String toString() {
//      return "alert-"+this.toString().toLowerCase();
//   }
   private String responseType;
   ResponseType(String s) {
      this.responseType = s;
   }
}
