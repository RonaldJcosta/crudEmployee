package br.com.ronald.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-06-07T13:47:40.434991-03:00[America/Sao_Paulo]")
@Entity
@Table(name="employees")
public class Employee   {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private @Valid int employee_id;	
  private @Valid String first_name;
  private @Valid String last_name;
  private @Valid String department;
  private @Valid String job_title;
  private @Valid String employee_type;
  private @Valid String start_date;
  private @Valid String status;
  private @Valid String email;
  /**
   **/
  
  public Employee employee_id(int employee_id) {
	  this.employee_id = employee_id;
	  return this;
  }
  
  @ApiModelProperty(value = "")
  @JsonProperty("employee_id")
 @Size(max=25)  public int getEmployee_id() {
    return employee_id;
  }

  public void setEmployee_id(int employee_id) {
	  this.employee_id = employee_id;
  }

  /**
   **/
  
  
  
  public Employee first_name(String first_name) {
    this.first_name = first_name;
    return this;
  }

  

  
  @ApiModelProperty(value = "")
  @JsonProperty("first_name")
 @Size(max=25)  public String getfirst_name() {
    return first_name;
  }

  public void setfirst_name(String first_name) {
    this.first_name = first_name;
  }

/**
   **/
  public Employee last_name(String last_name) {
    this.last_name = last_name;
    return this;
  }

  

  
  @ApiModelProperty(value = "")
  @JsonProperty("last_name")
 @Size(max=25)  public String getlast_name() {
    return last_name;
  }

  public void setlast_name(String last_name) {
    this.last_name = last_name;
  }

/**
   **/
  public Employee department(String department) {
    this.department = department;
    return this;
  }

  

  
  @ApiModelProperty(value = "")
  @JsonProperty("department")
 @Size(max=30)  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

/**
   **/
  public Employee job_title(String job_title) {
    this.job_title = job_title;
    return this;
  }

  

  
  @ApiModelProperty(value = "")
  @JsonProperty("job_title")
 @Size(max=30)  public String getjob_title() {
    return job_title;
  }

  public void setjob_title(String job_title) {
    this.job_title = job_title;
  }

/**
   **/
  public Employee employee_type(String employee_type) {
    this.employee_type = employee_type;
    return this;
  }

  

  
  @ApiModelProperty(value = "")
  @JsonProperty("employee_type")
 @Size(max=20)  public String getemployee_type() {
    return employee_type;
  }

  public void setemployee_type(String employee_type) {
    this.employee_type = employee_type;
  }

/**
   **/
  public Employee start_date(String start_date) {
    this.start_date = start_date;
    return this;
  }

  

  
  @ApiModelProperty(value = "")
  @JsonProperty("start_date")
 @Size(max=8)  public String getstart_date() {
    return start_date;
  }

  public void setstart_date(String start_date) {
    this.start_date = start_date;
  }

/**
   **/
  public Employee status(String status) {
    this.status = status;
    return this;
  }

  

  
  @ApiModelProperty(value = "")
  @JsonProperty("status")
 @Size(max=20)  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

/**
   **/
  public Employee email(String email) {
    this.email = email;
    return this;
  }

  

  
  @ApiModelProperty(value = "")
  @JsonProperty("email")
 @Size(max=20)  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Employee employee = (Employee) o;
    return Objects.equals(this.first_name, employee.first_name) &&
        Objects.equals(this.last_name, employee.last_name) &&
        Objects.equals(this.department, employee.department) &&
        Objects.equals(this.job_title, employee.job_title) &&
        Objects.equals(this.employee_type, employee.employee_type) &&
        Objects.equals(this.start_date, employee.start_date) &&
        Objects.equals(this.status, employee.status) &&
        Objects.equals(this.email, employee.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(first_name, last_name, department, job_title, employee_type, start_date, status, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Employee {\n");
    
    sb.append("    first_name: ").append(toIndentedString(first_name)).append("\n");
    sb.append("    last_name: ").append(toIndentedString(last_name)).append("\n");
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
    sb.append("    job_title: ").append(toIndentedString(job_title)).append("\n");
    sb.append("    employee_type: ").append(toIndentedString(employee_type)).append("\n");
    sb.append("    start_date: ").append(toIndentedString(start_date)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

