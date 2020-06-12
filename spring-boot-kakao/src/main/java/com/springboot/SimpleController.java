package com.springboot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.board.service.BoardService;
import com.springboot.board.mapper.BoardMapper;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 6. 11. 오전 10:41:49
 * @description
 * </pre>
 */
@Controller
public class SimpleController {

	@Resource
	private BoardService boardService;


	@RequestMapping("/test")
	public ModelAndView test() throws Exception{
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("name", "태건아 안녕?");
		List<String> testList = new ArrayList<String>();
		testList.add("a");
		testList.add("b");
		testList.add("c");
		mav.addObject("list", testList);
		return mav;
	}

    @RequestMapping("/test2")
    private String jspTest() throws Exception{

    	int boardCount = boardService.getBoardCount();
        System.out.println(boardCount);

        return "test";
    }






}
