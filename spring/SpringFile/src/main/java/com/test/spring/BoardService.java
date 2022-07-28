package com.test.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface BoardService {

	int write(HttpServletRequest req, String title);

	List<BoardDTO> list();

}
