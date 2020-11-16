package com.common.ash.controller;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.common.ash.model.LibraryModel;

@RestController
@RequestMapping("/book")
public class LibraryController {
	
	Map<Integer, LibraryModel> book = new HashMap<Integer,LibraryModel>();
	public LibraryController(){
		book.put(1,new LibraryModel(1,"C",1999));
		book.put(2,new LibraryModel(2,"C++",2000));
		book.put(3,new LibraryModel(3,"Java",2020));
		book.put(4,new LibraryModel(4,"Python",2000));
		book.put(5,new LibraryModel(5,"Spring",2016));
		book.put(6,new LibraryModel(6,"Git",2021));
	
	}
	
	@RequestMapping("")
	public String getBookDetails() {
		String b = "";
		for (Map.Entry<Integer, LibraryModel> e : book.entrySet()) 
            b+=e.getValue().toString()+"\n";
		return b;
	}
	
	@RequestMapping("/{id}")
	public String getBookDetails(@PathVariable int id) {
		LibraryModel bk = book.get(id);
		return bk.toString();
	}
	
}
