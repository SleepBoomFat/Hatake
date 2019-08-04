package boot.spring.controller;

import boot.spring.pagemodel.PersonGrid;
import boot.spring.po.Person;
import boot.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @program: SSM
 * @description:
 * @author: Simida
 * @create: 2019-08-04 12:16
 **/
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value="/person",method= RequestMethod.GET)
    @ResponseBody
    public PersonGrid selectAll(@RequestParam(value="current")int current,@RequestParam("rowCount") int rowCount){
        PersonGrid personGrid = new PersonGrid ();
        List<Person> ls = personService.selectAll ();
        personGrid.setRows (ls);
        personGrid.setCurrent (1);
        personGrid.setRowCount (100);
        personGrid.setTotal (100);
        return personGrid;
    }
@RequestMapping(value="/showperson",method=RequestMethod.GET)
    public String showperson(){
        return "person";
}
}
