package com.douzone.mysite.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.BoardRepository;
import com.douzone.mysite.vo.BoardVo;

@Service
public class BoardService {
	private static final int LIST_SIZE=5; //리스팅되는 게시물의 수
	private static final int PAGE_SIZE=5; //페이지 리스트의 게시물의 수
	
	
	private BoardRepository boardRepository;
	
	public void addContents(BoardVo vo) {
		
	}
	
	public BoardVo getContents(Long no) {
		// view
		return null;
	}

	public BoardVo getContents(Long no, Long userNo) {
		//수정
		return null;
	}
	
	public void updateContents(BoardVo vo) {
		
	}
	
	public void deleteContents(Long no, Long userNo) {
		
	}
	
	
	public List<BoardVo> getContentsList(int pageNo, String keyword) {
		int totalCount = boardRepository.getTotalCount(keyword);
		
		
		// 계산 여기서 다 하기
		// 1. view에서 게시판 리스트를 렌더링 하기 위한 데이터 값 계산	
		int beginPage=0;
		int prePage = 0;
		int nextPage=0;
		int endPage=0;
		
		//2. 리스트 가져오기
		List<BoardVo> list = boardRepository.findAllByPageAndKeyword(pageNo, keyword, PAGE_SIZE);
		
		//3. 리스트 정보를 맵에 저장
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("beginPage", beginPage);
		//...
		//...
		
		return list;
	}
	
}
