package com.care.root.testboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class BoardTest {
	@GetMapping("/board")
	public String testBoard() {
		return "test/board";
	}
	
	@GetMapping("/write")
	public String testWrite() {
		return "test/board";
	}
	
}
