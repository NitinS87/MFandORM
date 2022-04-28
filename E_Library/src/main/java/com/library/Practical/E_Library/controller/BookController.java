package com.library.Practical.E_Library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.library.Practical.E_Library.entity.Books;
import com.library.Practical.E_Library.service.BookService;

@Controller
public class BookController {

	/* Controller will talk to service layer */
	// Spring has already created the bean/object of StudentServiceImpl using
	// @Service
	// so, we can inject the service object directly using @Autowired

	@Autowired
	private BookService bookService;

	/* Creating domain object/bean for data binding */
	@ModelAttribute("book")
	public Books getBook() {

		return new Books();
	}

	/* Controller mapping for showing the student input form */
	@GetMapping("/showBookForm")
	public String showStudentForm() {
		return "book-form";
	}

	/* Controller mapping for processing the create/insert operation */
	@PostMapping("/processForm")
	public String showProcessForm(@ModelAttribute("book") Books book) {

		bookService.saveBook(book);

		return "confirmation";
	}

	/* Controller mapping for showing the student list dashboard */
	@RequestMapping(value = "/showBook", method = RequestMethod.GET)
	public String showStudentsList(Model model) {
		List<Books> bookList = bookService.fetchBooks();
		model.addAttribute("books", bookList);
		return "book-list";
	}

	/* Controller mapping for update form */
	@GetMapping("/updateForm")
	public String showUpdateForm(@RequestParam("id") int bookId, @ModelAttribute("book") Books book, Model model) {

		System.out.println("Getting the book data for id: " + bookId);
		book = bookService.getOneBook(bookId);
		/* send the student object to view */
		model.addAttribute(book);
		return "book-update-form";
	}

	/* Controller mapping for processing the update operation */
	@PostMapping("/processUpdate")
	public String processUpdateForm(@ModelAttribute("book") Books book) {
		bookService.editBook(book);
		return "confirmation";
	}

	/* Controller mapping for processing the delete operation */
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") int id) {
		bookService.deleteOneBook(id);
		return "redirect:/showBook";
	}

}
