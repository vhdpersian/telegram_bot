/*     */ package io.github.nixtabyte.telegram.jtelebot.response.json;
/*     */ 
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
/*     */ @JsonIgnoreProperties(ignoreUnknown=true)
/*     */ public class User
/*     */   extends Chat
/*     */ {
/*     */   @JsonProperty("first_name")
/*     */   private String firstName;
/*     */   @JsonProperty("last_name")
/*     */   private String lastName;
/*     */   @JsonProperty("username")
/*     */   private String username;
/*     */   @JsonProperty("type")
/*     */   private String type;
/*     */   
/*     */   public String getType()
/*     */   {
/*  45 */     return type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  49 */     this.type = type;
/*     */   }
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
/*     */   public String getFirstName()
/*     */   {
/*  71 */     return firstName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setFirstName(String firstName)
/*     */   {
/*  79 */     this.firstName = firstName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getLastName()
/*     */   {
/*  87 */     return lastName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLastName(String lastName)
/*     */   {
/*  95 */     this.lastName = lastName;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getUsername()
/*     */   {
/* 103 */     return username;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setUsername(String username)
/*     */   {
/* 111 */     this.username = username;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 119 */     int prime = 31;
/* 120 */     int result = super.hashCode();
/* 121 */     result = 31 * result + (firstName == null ? 0 : firstName.hashCode());
/*     */     
/* 123 */     result = 31 * result + (lastName == null ? 0 : lastName.hashCode());
/*     */     
/* 125 */     result = 31 * result + (username == null ? 0 : username.hashCode());
/*     */     
/* 127 */     result = 31 * result + (type == null ? 0 : type.hashCode());
/*     */     
/* 129 */     return result;
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/* 134 */     if (this == obj)
/* 135 */       return true;
/* 136 */     if (!super.equals(obj))
/* 137 */       return false;
/* 138 */     if (getClass() != obj.getClass())
/* 139 */       return false;
/* 140 */     User other = (User)obj;
/* 141 */     if (firstName == null) {
/* 142 */       if (firstName != null)
/* 143 */         return false;
/* 144 */     } else if (!firstName.equals(firstName))
/* 145 */       return false;
/* 146 */     if (lastName == null) {
/* 147 */       if (lastName != null)
/* 148 */         return false;
/* 149 */     } else if (!lastName.equals(lastName))
/* 150 */       return false;
/* 151 */     if (username == null) {
/* 152 */       if (username != null)
/* 153 */         return false;
/* 154 */     } else if (!username.equals(username))
/* 155 */       return false;
/* 156 */     if (type == null) {
/* 157 */       if (type != null)
/* 158 */         return false;
/* 159 */     } else if (!type.equals(type))
/* 160 */       return false;
/* 161 */     return true;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 166 */     return "User [id=" + getId() + " firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + "]";
/*     */   }
/*     */ }

/* Location:           D:\eclipse luna\workspace\telebot10\lib\jtelebot-core-0.1.0.jar
 * Qualified Name:     io.github.nixtabyte.telegram.jtelebot.response.json.User
 * Java Class Version: 7 (51.0)
 * JD-Core Version:    0.7.1
 */