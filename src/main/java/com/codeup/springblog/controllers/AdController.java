package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import com.codeup.springblog.repos.AdRepository;
import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//
@Controller
public class AdController {
//
    private final AdRepository adDao;

    private final UserRepository userDao;

    public AdController(AdRepository adDao, UserRepository userDao) {
       this.adDao = adDao;
       this.userDao = userDao;
    }


     @GetMapping(path = "/ads")
     public String showAds(Model model){

        List<Ad> adsToShow = adDao.findAll();

        model.addAttribute("ads", adsToShow);

        return "ad/index";
    }

//    @GetMapping("/posts/{id}")
//    @ResponseBody
//    public String userIdPosts(@PathVariable int id){
//       return "View individual post " + id+" !";
//    }

//    @GetMapping("/ads/{id}")
//    public String showOnePost(@PathVariable int id, Model model){
//        Post post = new Post("Fun title", "Fun body");
//        model.addAttribute("postId", id);//emulates going to a diff post by id
//        model.addAttribute("post", post);
//        return "ad/show";
//    }

    @GetMapping("/ads/{id}")
    public String showOneAd(@PathVariable Long id, Model model){
        Ad adToShow = adDao.getById(id);
        model.addAttribute("ad",adToShow);
        return "ad/show";
    }

    @PostMapping("/ads/create")
    public String createAd(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "description") String description
    ){
        User hardCodedUser = userDao.getById(1L);
//        Ad adToSubmitToDB = new Ad(title, description);
//        Ad adToSubmitToDB = new Ad(title, description, hardCodedUser);

        Ad adToSubmitToDB = new Ad();
        adToSubmitToDB.setTitle(title);
        adToSubmitToDB.setDescription(description);
        adToSubmitToDB.setOwner(hardCodedUser);

        adDao.save(adToSubmitToDB);
        return "redirect:/ads";
    }

    @GetMapping("/ads/create")
    //showCreatedForm prev method name
    public String showCreatedAdForm(){
//       return "View form for creating a post";
        return "ad/create";
    }

//    //todo my version
//    @RequestMapping(path = "/ads/create", method = RequestMethod.GET)
//    @ResponseBody
//    public String createAPost(){
//        return "Create new Post";
//    }
//
//    @PostMapping("/posting/create")
//    @ResponseBody
//    public String createPost(){
//        return "create a new post";
//    }


}
