package com.bookstore.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bookstore.model.BookStoreModel;
import com.bookstore.repository.StoreRepository;



@Controller
public class BookStoreController {
	
	@Autowired
	public StoreRepository storeRepo;
	
	
	@GetMapping("/")
	public String addBookPage(BookStoreModel store) {
		return "addbookinfo";
	}
	
	
	@PostMapping("/addnewbook")
	public String addBook (BookStoreModel book, BindingResult result, Model model) {
		storeRepo.save(book);
		return "redirect:/showallbooks";
		
	}
	
	@GetMapping("/showallbooks")
	public String showAllBooks(Model model) {
		model.addAttribute ("bookStoreModel",storeRepo.findAll());
		return "displaylibrarydetails";
	}
	
    
	  @GetMapping("/delete/{id}")
	  public String deleteUser(@PathVariable("id") long id, Model model) {
		  
		  BookStoreModel book = storeRepo.findById(id).get();
		  storeRepo.delete(book);
		  
	      return "redirect:/showallbooks";
	  }
  
  
  
	  @GetMapping("/edit/{id}")
	  public String showUpdateBook(@PathVariable("id") long id, Model model) {
		  BookStoreModel book = storeRepo.findById(id).get();
	      model.addAttribute("book", book);
	      return "edit-book";
	  }
	  
	  @GetMapping("/view-single-book/{id}")
	  public String showSingleBook(@PathVariable("id") long id, Model model) {
		  BookStoreModel book = storeRepo.findById(id).get();
	      model.addAttribute("book", book);
	      return "single-book";
	  }
  
	  @PostMapping("/update/{id}")
	  public String updateBook(@PathVariable("id") long id, @Valid BookStoreModel book, 
	    BindingResult result, Model model) {
	          
	      storeRepo.save(book);
	      return "redirect:/showallbooks";
	  }
  
	

}
