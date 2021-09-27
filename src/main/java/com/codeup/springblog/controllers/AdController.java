//package com.codeup.springblog.controllers;
//
//import com.codeup.springblog.repos.AdRepository;
//import com.codeup.springblog.models.Ad;
//import com.codeup.springblog.models.Post;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
////
//@Controller
//public class AdController {
////
//    private final AdRepository adDao;
//
//    public AdController(AdRepository adDao) {
//       this.adDao = adDao;
//    }
//
//
//     @GetMapping(path = "/ads")
//     public String showAds(Model model){
//
//        List<Ad> adsToshow = adDao.findAll();
//
//        model.addAttribute("ads", adsToshow);
//
//        return "ad/index";
//    }
//
////    @GetMapping("/posts/{id}")
////    @ResponseBody
////    public String userIdPosts(@PathVariable int id){
////       return "View individual post " + id+" !";
////    }
//
////    @GetMapping("/ads/{id}")
////    public String showOnePost(@PathVariable int id, Model model){
////        Post post = new Post("Fun title", "Fun body");
////        model.addAttribute("postId", id);//emulates going to a diff post by id
////        model.addAttribute("post", post);
////        return "ad/show";
////    }
//
//
//    @PostMapping("/ads/create")
//    public String createAd(
//            @RequestParam(name = "title") String title,
//            @RequestParam(name = "description") String description
//    ){
//        Ad adToSubmitToDB = new Ad(title, description);
//        adDao.save(adToSubmitToDB);
//        return "redirect:/ads";
//    }
//
////    @GetMapping("/ad/create")
////    @ResponseBody
////    public String viewAPost(){
////       return "View form for creating a post";
////    }
//
////    //todo my version
////    @RequestMapping(path = "/ads/create", method = RequestMethod.GET)
////    @ResponseBody
////    public String createAPost(){
////        return "Create new Post";
////    }
////
////    @PostMapping("/posting/create")
////    @ResponseBody
////    public String createPost(){
////        return "create a new post";
////    }
//
//
//}
