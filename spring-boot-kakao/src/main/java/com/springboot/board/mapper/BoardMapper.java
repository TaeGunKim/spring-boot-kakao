package com.springboot.board.mapper;

import java.io.Serializable;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 6. 11. 오전 11:48:19
 * @description
 * </pre>
 */
@Repository("com.springboot.board.mapper.BoardMapper")
@Mapper
public interface BoardMapper extends Serializable {

	public int getBoardCount();
}
