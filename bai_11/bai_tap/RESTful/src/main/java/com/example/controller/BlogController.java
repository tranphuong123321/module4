package com.example.controller;

import com.example.dto.BlogDto;
import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping(value = "/blog/list")
    public ResponseEntity<Page<Blog>> getPageBlog(@PageableDefault(value = 2)Pageable pageable){

           Page<Blog> blogPage = iBlogService.findAllPaging(pageable);
           if(!blogPage.hasContent()){
               return new ResponseEntity<>(HttpStatus.NOT_FOUND);
           }
           return new ResponseEntity<>(blogPage,HttpStatus.OK);

    }
    @PostMapping(value = "/blog/create")
    public ResponseEntity<List<FieldError>> createBlog(@Validated @RequestBody BlogDto blogDto , BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto,blog);
        this.iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping    (value = "/blog/edit{id}")
    public ResponseEntity<Blog> edit(@PathVariable int id, @RequestBody Blog blog){
        Optional<Blog> blogOptional=iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(blogOptional.get().getId());
        iBlogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/blog/delete{id}")
    public ResponseEntity<Blog> deleteBlog(@PathVariable Integer id) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iBlogService.deleteById(id);
        return new ResponseEntity<>(blogOptional.get(), HttpStatus.NO_CONTENT);
    }
}
