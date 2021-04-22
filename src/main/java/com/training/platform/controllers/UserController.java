package com.training.platform.controllers;
import com.training.platform.entities.User;
import com.training.platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public List<User> index() {
        return userService.findAllByJpqlParamsQuery(0, "bangkok");
    }

    @GetMapping(value = "/f1")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/f2")
    public Optional<User> findById(@RequestParam String id) {
        return userService.findById(Integer.parseInt(id));
    }

    @GetMapping(value = "/f3")
    public Page<User> findAllByLimit(@RequestParam String start, @RequestParam String limit, @RequestParam String field) {
        return userService.findAllByLimit(Integer.parseInt(start), Integer.parseInt(limit), field);
    }

    @GetMapping(value = "/f4")
    public List<User> findByCityAndActiveAndAge(@RequestParam String city, @RequestParam String active, @RequestParam String age) {
        return userService.findByCityAndActiveAndAge(city, Integer.parseInt(active), Integer.parseInt(age));

    }

    @GetMapping(value = "/f5")
    public List<User> findByAgeIn(@RequestParam(name = "age") List<Integer> ages) {
        return userService.findByAgeIn(ages);
    }
    @GetMapping(value = "/f5.2")
    public List<User> findByAgeIn2(@RequestBody Map<String, Object> dataInput) {
        return userService.findByAgeIn((List<Integer>) dataInput.get("age"));
    }

    @GetMapping(value = "/f6")
    public List<User> findAllByQuery(){
        return userService.findAllByQuery();
    }

    @GetMapping(value = "/f7")
    public List<User> findAllByParamsQuery(@RequestParam  String active, @RequestParam String city){
        return userService.findAllByParamsQuery(Integer.parseInt(active), city);
    }

    @GetMapping (value = "/f8")
    public List<User> findAllByJpqlQuery(){
        return userService.findAllByJpqlQuery();
    }

    @GetMapping(value = "/f9")
    public List<User> findByFirstnameAndLastname(@RequestParam String name, @RequestParam String surname){
        return userService.findByNameAndSurname(name, surname);
    }

    @GetMapping(value = "/f10")
    public List<User> findAllByCity(@RequestParam String city){
        return  userService.findByCity(city);
    }

}