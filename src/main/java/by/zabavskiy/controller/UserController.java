package by.zabavskiy.controller;

import by.zabavskiy.controller.request.SearchCriteria;
import by.zabavskiy.controller.request.UserCreateRequest;
import by.zabavskiy.domain.User;
import by.zabavskiy.service.UserService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users") //all methods mapping will start with /users
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;

    public static final String USER_PAGE = "users";
    public static final String USERS_LIST_ATTRIBUTE = "users";

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }

    // /users
    @GetMapping
    public ModelAndView getAllUsers() {
        ModelAndView result = new ModelAndView();

        result.setViewName(USER_PAGE);
        result.addObject(USERS_LIST_ATTRIBUTE, userService.findAll());

        return result;
    }

    @GetMapping("/create")
    public ModelAndView getUserCreateRequest() {
        ModelAndView result = new ModelAndView();

        result.setViewName("createuser");
        result.addObject("userCreateRequest", new UserCreateRequest());

        return result;
    }

    //  /users/search
    // Query params handling
    // 1)RequestParam
    // 2)ModelAttribute
    // 3)ModelMap and get query param by key from map

/*    @GetMapping(value = "/search")
    public ModelAndView search(ModelMap modelMap) {
        ModelAndView result = new ModelAndView();
        String resultQuery = StringUtils.isNotBlank((String)modelMap.get("query")) ? (String)modelMap.get("query") : "Viachaslau";
        Long resultLimit = (Long)modelMap.get("limit") != null ? (Long)modelMap.get("limit") : 100;
        result.setViewName(USER_PAGE);
        result.addObject(USERS_LIST_ATTRIBUTE, userService.search(resultQuery).stream().limit(resultLimit).collect(Collectors.toList()));
        return result;
    }*/

    @GetMapping(value = "/search")
    public ModelAndView search(@ModelAttribute SearchCriteria criteria) {

        ModelAndView result = new ModelAndView();

        result.setViewName(USER_PAGE);
        result.addObject(USERS_LIST_ATTRIBUTE, userService.search(criteria.getQuery()).stream().limit(criteria.getLimit()).collect(Collectors.toList()));

        return result;
    }

    //   /users/1
    @GetMapping(value = "/{id}")
    public ModelAndView search(@PathVariable("id") Long userId) {
        ModelAndView result = new ModelAndView();

        result.setViewName(USER_PAGE);
        result.addObject(USERS_LIST_ATTRIBUTE, Collections.singletonList(userService.findById(userId)));

        return result;
    }

    @PostMapping
    public ModelAndView createUser(
            @ModelAttribute UserCreateRequest userCreateRequest
    ) {
/*
        String name = userCreateRequest.getName();
        String surname = userCreateRequest.getSurname();
        Date birth = userCreateRequest.getBirthDate();
        Gender gender = userCreateRequest.getGender();*/

        // converters
        User user = new User();
        user.setGender(userCreateRequest.getGender());
        user.setName(userCreateRequest.getName());
        user.setSurname(userCreateRequest.getSurname());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setWeight(userCreateRequest.getWeight());
        userService.save(user);

        ModelAndView result = new ModelAndView();

        result.setViewName(USER_PAGE);
        result.addObject(USERS_LIST_ATTRIBUTE, userService.findAll());

        return result;
    }

//    @GetMapping("/info")
//    public List<String> findAllGoogleUsers() {
//        GoogleConfig googleConfig = new GoogleConfig();
//
//        List<String> fields = new ArrayList<>();
//        fields.add(googleConfig.getName());
//        fields.add(googleConfig.getSurname());
//
//        return fields;
//    }

}