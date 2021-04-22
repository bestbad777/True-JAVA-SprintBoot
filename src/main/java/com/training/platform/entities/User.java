package com.training.platform.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data; // annotation ที่เป็นของ lombok library ที่เราแอดเพิ่มขึ้นมา เพื่อมาช่วยลด Code ในส่วนของการ getter/setter method ทำให้ code สั้นลง ถ้าเราไม่ใช้ lombok เราจะต้องเขียน getter/setter method
import javax.persistence.*; //เป็นการเข้าถึง entity ให้อัติโนมัติ
import java.io.Serializable; //คือตัวที่ทำการเก็บ object ลงไฟล์และคืนรูปจากไฟล์ ใช้โดยการใส่ implements Serializable ในคลาสที่เก็บข้อมูล
import java.util.Date;

@Data
@Entity // annotation ที่บอกว่า Java Class นี้คือ Entity Class ที่จะทำการ map ระหว่าง java class กับ table ใน db ที่ต้องการ
@Table(name = "users") //คือ annotation ที่ระบุว่า class นี้จะ map กับ table ที่ชื่อว่าอะไร
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User implements Serializable {

    @Id //annotation ที่ระบุว่า ตัวแปรที่ map กับ field นี้เป็น Primary key ของ table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //nnotation ที่บอกว่า ตัวแปรที่ map กับ field นี้ เป็น auto increment
    @Column(name = "id") //map กับ field ชื่ออะไรใน Table
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")

    private String email;

    @Column(name = "password")
    private String password;

    @Transient //ตัวแปรนี้ไม่ต้อง map กับ field ใน table เช่น ในกรณีของ confirm_password ถูกสร้างมาเพื่อใช้ในการใส่ password ซ้ำเพื่อความถูกต้องของการค่า password เท่านั้น แต่ไม่ได้เก็บค่าใน confirm_password ลง table
    private String confirm_password;
    @Column(name = "age")
    private Integer age;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "active")
    private Integer active;

    @Column(name = "api_token")
    private String api_token;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Shop shop;


}
