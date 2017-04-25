package com.example.ahmed.training_system_app.admin;

/**
 * Created by ahmed on 4/25/2017.
 */

public class DataModelStudentList {

    private int id;
    private String user_name;
    private String password;
    private String email;
    private String phone;
    private String supervisor_name;
    private String unique_num;
    private String year_study;
    private String department;
    private String student_grade;
    private String site_company;

    public int getId() {
        return id;
    }

    public DataModelStudentList(int id, String user_name, String password, String email, String phone, String supervisor_name, String unique_num
                                , String year_study, String department, String student_grade){
        this.id=id;
        this.user_name=user_name;
        this.password=password;
        this.email=email;
        this.phone=phone;
        this.supervisor_name=supervisor_name;
        this.unique_num=unique_num;
        this.year_study=year_study;
        this.department=department;
        this.student_grade=student_grade;
    }

    public DataModelStudentList(String user_name,String phone){
        this.user_name=user_name;
        this.phone=phone;
    }

    public String getSite_company() {
        return site_company;
    }

    public DataModelStudentList(int id, String user_name, String password, String unique_num, String phone, String email,
                                String department, String site_company){

        this.id=id;
        this.user_name=user_name;
        this.password=password;
        this.unique_num=unique_num;
        this.phone=phone;
        this.email=email;
        this.department=department;
        this.site_company=site_company;

    }
    public DataModelStudentList(int id, String user_name, String password, String unique_num, String phone, String email,
                                String department){

        this.id=id;
        this.user_name=user_name;
        this.password=password;
        this.unique_num=unique_num;
        this.phone=phone;
        this.email=email;
        this.department=department;

    }

    public String getUser_name() {
        return user_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getSupervisor_name() {
        return supervisor_name;
    }

    public String getUnique_num() {
        return unique_num;
    }

    public String getYear_study() {
        return year_study;
    }

    public String getDepartment() {
        return department;
    }

    public String getStudent_grade() {
        return student_grade;
    }
}
