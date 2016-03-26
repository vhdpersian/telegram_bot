/*     */ package io.github.nixtabyte.telegram.jtelebot.response.json;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.codehaus.jackson.annotate.JsonIgnoreProperties;
/*     */ import org.codehaus.jackson.annotate.JsonProperty;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @JsonIgnoreProperties(ignoreUnknown=true)
/*     */ public class TelegramResponse<T>
/*     */ {
/*     */   @JsonProperty("ok")
/*     */   private Boolean successful;
/*     */   @JsonProperty("description")
/*     */   private String description;
/*     */   @JsonProperty("error_code")
/*     */   private Integer errorCode;
/*     */   @JsonProperty("result")
/*     */   private List<T> result;
/*     */   
/*     */   public Boolean isSuccessful()
/*     */   {
/*  54 */     return successful;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setSuccessful(Boolean successful)
/*     */   {
/*  63 */     this.successful = successful;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getDescription()
/*     */   {
/*  72 */     return description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setDescription(String description)
/*     */   {
/*  81 */     this.description = description;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Integer getErrorCode()
/*     */   {
/*  90 */     return errorCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setErrorCode(Integer errorCode)
/*     */   {
/*  99 */     this.errorCode = errorCode;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<T> getResult()
/*     */   {
/* 109 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setResult(List<T> result)
/*     */   {
/* 118 */     this.result = result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 125 */     int prime = 31;
/* 126 */     int result = 1;
/* 127 */     result = 31 * result + (description == null ? 0 : description.hashCode());
/*     */     
/* 129 */     result = 31 * result + (errorCode == null ? 0 : errorCode.hashCode());
/*     */     
/* 131 */     result = 31 * result + (this.result == null ? 0 : this.result.hashCode());
/*     */     
/* 133 */     result = 31 * result + (successful == null ? 0 : successful.hashCode());
/*     */     
/* 135 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 141 */     if (this == obj)
/* 142 */       return true;
/* 143 */     if (obj == null)
/* 144 */       return false;
/* 145 */     if (getClass() != obj.getClass())
/* 146 */       return false;
/* 147 */     TelegramResponse other = (TelegramResponse)obj;
/* 148 */     if (description == null) {
/* 149 */       if (description != null)
/* 150 */         return false;
/* 151 */     } else if (!description.equals(description))
/* 152 */       return false;
/* 153 */     if (errorCode == null) {
/* 154 */       if (errorCode != null)
/* 155 */         return false;
/* 156 */     } else if (!errorCode.equals(errorCode))
/* 157 */       return false;
/* 158 */     if (result == null) {
/* 159 */       if (result != null)
/* 160 */         return false;
/* 161 */     } else if (!result.equals(result))
/* 162 */       return false;
/* 163 */     if (successful == null) {
/* 164 */       if (successful != null)
/* 165 */         return false;
/* 166 */     } else if (!successful.equals(successful))
/* 167 */       return false;
/* 168 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 174 */     return "TelegramResponse [successful=" + successful + ", description=" + description + ", errorCode=" + errorCode + ", result=" + result + "]";
/*     */   }
/*     */ }

/* Location:           D:\eclipse luna\workspace\telebot10\lib\jtelebot-core-0.1.0.jar
 * Qualified Name:     io.github.nixtabyte.telegram.jtelebot.response.json.TelegramResponse
 * Java Class Version: 7 (51.0)
 * JD-Core Version:    0.7.1
 */