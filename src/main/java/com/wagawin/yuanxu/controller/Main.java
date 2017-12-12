package com.wagawin.yuanxu.controller;

import com.wagawin.yuanxu.model.*;
import com.wagawin.yuanxu.service.ChildEntityService;
import com.wagawin.yuanxu.service.HouseEntityService;
import com.wagawin.yuanxu.service.MealEntityService;
import com.wagawin.yuanxu.service.PersonEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Main {

    @Autowired
    PersonEntityService personEntityService;

    @Autowired
    ChildEntityService childEntityService;

    @Autowired
    HouseEntityService houseEntityService;

    @Autowired
    MealEntityService mealEntityService;

    @RequestMapping(value = "/house/{person_name}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public HouseEntity getHouseEntityByPerson(@PathVariable("person_name") String name) {
        PersonEntity personEntity = personEntityService.getPersonByName(name);
        int personId = personEntity.getId();
        HouseEntity houseEntity = houseEntityService.getHouseByPersonId(personId);
        return houseEntity;
    }

    @RequestMapping(value = "/child/info/{child_name}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public Info getInfoByChild(@PathVariable("child_name")  String name) {
        PersonEntity personEntity = personEntityService.getPersonByChildName(name);
        MealEntity favouriteMeal = mealEntityService.getFavouriteMealByChild(name);
        Info info = new Info(personEntity, favouriteMeal);
        return info;
    }

    @RequestMapping(value = "/color/{child_name}", method = RequestMethod.GET,
            headers = "Accept=application/json")
    public String getColorBySex(@PathVariable("child_name") String name){
        ChildEntity childEntity = childEntityService.getChildByName(name);
        if(childEntity.getSex() == "daughter")
            return childEntity.getHairColor();
        else return childEntity.getBicycleColor();
    }
}
