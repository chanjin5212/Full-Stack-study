package com.test.spring;

import java.util.List;

import lombok.Data;

@Data
public class BoardDTO {
	
	private String seq;
	private String title;
	private String regdate;
	private List<FileDTO> files;
	
}







