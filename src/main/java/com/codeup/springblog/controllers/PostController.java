//package com.codeup.springblog.controllers;
//
//import com.codeup.polarisspringblog.com.codeup.springblog.models.Post;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Controller
//public class PostController {
//
////    @GetMapping(path = "/posts")
////    @ResponseBody
////    public String allPosts(){
////        return "Posts index page";
////    }
//    @GetMapping(path = "/posts")
//    public String showPosts(Model model){
//
//        List<Post> allPosts = new ArrayList<>();
//        allPosts.add(new Post("post!", "post1 body"));
//        allPosts.add(new Post("post@", "post2 body"));
//
//        model.addAttribute("posts", allPosts);
//
//        return "post/index";
//    }
//
////    @GetMapping("/posts/{id}")
////    @ResponseBody
////    public String userIdPosts(@PathVariable int id){
////        return "View individual post " + id+" !";
////    }
//
//    @GetMapping("/posts/{id}")
//    public String showOnePost(@PathVariable int id, Model model){
//        Post post = new Post("Fun title", "Fun body");
//        model.addAttribute("postId", id);//emulates going to a diff post by id
//        model.addAttribute("post", post);
//        return "post/show";
//    }
//
//
//    @GetMapping("/post/create")
//    @ResponseBody
//    public String viewAPost(){
//        return "View form for creating a post";
//    }
//
//    //todo my version
//    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
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

//TODO OLD STUFF ABOVE COMMENTING OUT BC GIVING ISSUES

//package com.codeup.polarisspringblog.controllers;
package com.codeup.springblog.controllers;

import com.codeup.springblog.models.User;
import org.springframework.stereotype.Controller;
import com.codeup.springblog.models.Post;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.codeup.springblog.repos.PostRepository;
//import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
//
//    @Controller
//    public class PostController {
//
//        @GetMapping("/posts")
//        public String showPosts(Model model) {
//            List<Post> allPosts = new ArrayList<>();
//
//            allPosts.add(new Post("post!", "post1 body"));
//            allPosts.add(new Post("post@", "post2 body"));
//
//            model.addAttribute("posts", allPosts);
//            return "post/index";
//        }
//
//        @GetMapping("/posts/{id}")
//        public String showOnePost(@PathVariable int id, Model model) {
//
//            Post post = new Post("Fun title", "Fun body");
//            model.addAttribute("postId", id);
//            model.addAttribute("post", post);
//
//            return "post/show";
//        }
//
//        @GetMapping("/posts/create")
//        @ResponseBody
//        public String showCreatePostForm() {
//            return "view form for creating a new post";
//        }
//
//        @PostMapping("/posts/create")
//        @ResponseBody
//        public String createPost() {
//            return "create a new post";
//        }
//
//    }

// TODO Personally redoing exercise for practice
//Create a PostController class.
// This controller should return strings for the following routes
// that describe what will ultimately be there.

@Controller
public class PostController {

    private final PostRepository postDao;
    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String showPosts(Model model){
        List<Post> allPosts = new ArrayList<>();


        allPosts.add(new Post("post!", "post1 body"));
        allPosts.add(new Post("post@", "post2 body"));

        model.addAttribute("posts", allPosts);
        return "post/index";
    }

//    @GetMapping("/posts")
//    public String showPost(Model model){
//        List<Post> allPosts = postDao.findAll();
//        model.addAttribute("posts", allPosts);
//        return "post/index";
//    }

    @GetMapping("/posts/{id}")
    public String showOnePost(@PathVariable int id, Model model){
//        Post post = postDao.getById(id);
        Post post = new Post("Fun title", "Fun body");
        model.addAttribute("postId", id);
        model.addAttribute("post", post);

        return "post/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showCreatePostForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost(){
        return "create a new post";
    }


    @GetMapping("/posts/edit/{id}")
    public String showEditPostForm(@PathVariable long id, Model model){
        Post postToEdit = postDao.getById(id);
        model.addAttribute("id", postToEdit.getId());
        return"post/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body

    ){
        Post editedPost = new Post(id, title, body);
        postDao.save(editedPost);

        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        Post postToDelete = postDao.getById(id);
        postDao.delete(postToDelete);

        return "redirect:/posts";
    }

}



