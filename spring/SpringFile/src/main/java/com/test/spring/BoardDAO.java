package com.test.spring;

import java.util.List;

public interface BoardDAO {

	int add(String title);

	int getSeq();

	void addFile(FileDTO fdto);

	List<BoardDTO> list();

	List<FileDTO> flist(String seq);

}
