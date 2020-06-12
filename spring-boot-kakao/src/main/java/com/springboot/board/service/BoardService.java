package com.springboot.board.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springboot.board.mapper.BoardMapper;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 6. 11. 오후 3:34:09
 * @description
 * </pre>
 */
@Service
public class BoardService {

	@Resource
	private BoardMapper boardMapper;

	public int getBoardCount() {
		int cnt = boardMapper.getBoardCount();
		return cnt;
	}


}
