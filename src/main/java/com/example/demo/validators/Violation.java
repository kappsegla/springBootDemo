package com.example.demo.validators;

public class Violation {

    private final String fieldName;
  
    private final String message;

    public String getFieldName() {
      return fieldName;
    }

    public String getMessage() {
      return message;
    }

    public Violation(String fieldName, String message) {
      this.fieldName = fieldName;
      this.message = message;
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
      result = prime * result + ((message == null) ? 0 : message.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Violation other = (Violation) obj;
      if (fieldName == null) {
        if (other.fieldName != null)
          return false;
      } else if (!fieldName.equals(other.fieldName))
        return false;
      if (message == null) {
        if (other.message != null)
          return false;
      } else if (!message.equals(other.message))
        return false;
      return true;
    }
  
    

  

  }
