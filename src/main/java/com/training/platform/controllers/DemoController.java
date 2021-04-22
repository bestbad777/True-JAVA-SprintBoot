package com.training.platform.controllers;
import com.training.platform.entities.User;
import com.training.platform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired //สามารถใช้ความสามารถในการทำ dependency injection (DI) เพื่อทำการ Inject object ขึ้นมาใช้งานได้ โดย object ดังกล่าวจะต้องถูกประกาศไว้ก่อนหน้า และเป็น object ที่ register อยู่ใน Spring Bean หรือพูดง่ายๆคือ class ที่สร้างมาแล้ว Spring รู้จัก Class นั้น นั่นเอง
    private UserRepository userRepository; //สามารถใช้ Object class ที่เรา Autowired นั้นๆ ได้ทุก method

    /*@GetMapping(value = "")
    public String index() {
        List<User> users = userRepository.findAll();
        System.out.println("############### Find All User (In Console) ###############");
        System.out.println(users);
        return "Method GET, Function : index => SHOW data list on page";
    }*/

    /*@GetMapping(value = "")
    public List<User> index() {
        List<User> users = userRepository.findByCityAndActiveAndAge("nakornpathom", 1, 20);
        return users;
    }*/


    @GetMapping(value = "")
    public List<User> index() {
        List<Integer> ages = new ArrayList<>(Arrays.asList(18, 19, 22) );
        List<User> users = userRepository.findByAgeIn(ages);
        return users;
    }

    // Example for findAllByQuery
    @GetMapping(value = "/test1")
    public List<User> test1() {
        return userRepository.findAllByQuery();
    }
    // Example for findAllByParamsQuery
    @GetMapping(value = "/test2")
    public List<User> test2() {
        return userRepository.findAllByParamsQuery(0, "nakornpathom");
    }

    /*@GetMapping(value = "")
    public String index() {
        return "Method GET, Function : index => SHOW data list on page";
    }*/

    /*@GetMapping(value = "")
    public String showWithParam(@RequestParam String id) {
        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with query string";
    }*/

    @PostMapping(value = "")
    public String create(@RequestBody Map<String,Object> inputs) {
        System.out.println("########### POST Param ###########");
        System.out.println(inputs);

        return "Method POST, Function : create => INSERT data to DB";
    }

    @GetMapping(value = "/{id}")
    public String showWithPath(@PathVariable String id) { //
        Optional<User> user = userRepository.findById(Integer.parseInt(id));
        System.out.println("############### Find User By ID (In Console) ###############");
        System.out.println(user);
        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with path";
    }


    /*@GetMapping(value = "/{id}")
    public String showWithPath(@PathVariable String id) {
        return "Method Get, Function : show, ID : "+ id +" => SHOW data by id on page with path";
    }*/

    @PatchMapping(value = "/{id}")
    public String update(@PathVariable String id, @RequestParam Map<String,String> inputs) {
        System.out.println("########### PATCH Param ###########");
        System.out.println(inputs);

        return "Method PATCH, Function : update => ID : " + id + " UPDATE data to DB";
    }

    @DeleteMapping(value = "/{id}")
    public String destroy(@PathVariable String id)  {
        return "Method DELETE, Function : delete, ID : " + id + " => DELETE data to DB";
    }


    @RequestMapping(value = "/healthcheck")
    @ResponseStatus(code = HttpStatus.CREATED) //ต้องพิมพ์เอง copy แล้วจะ Error
    public String healthCheck() {
        return "Hello Created 201";
    }

}
