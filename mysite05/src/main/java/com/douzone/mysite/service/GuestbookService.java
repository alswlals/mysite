package com.douzone.mysite.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.mysite.repository.GuestbookRepository;
import com.douzone.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	public GuestbookRepository guestbookRepository;
	
	public List<GuestbookVo> getMessageList() {
		
		List<GuestbookVo> list = new ArrayList<>();
		list = guestbookRepository.findAll();
		return list;
				
	}
	
	public void deleteMessage(Long no, String password) {
		guestbookRepository.deleteByNoAndPassword(no, password);
	}
	
	public void addMessage(GuestbookVo vo) {
		guestbookRepository.insert(vo);
	}
}
