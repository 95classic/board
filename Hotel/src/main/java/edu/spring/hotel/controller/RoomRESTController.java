package edu.spring.hotel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.hotel.domain.RoomVO;
import edu.spring.hotel.service.RoomService;

// 방 이름을 클릭했을 시 그 방에 대한 상세정보 ajax형식으로 바로 출력하기
@RestController
@RequestMapping(value="room")
public class RoomRESTController {
	private static final Logger logger =
			LoggerFactory.getLogger(RoomRESTController.class);
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("/{roomId}")
	public RoomVO selectRoom(@PathVariable("roomId") int roomId) {
		logger.info("selectRoom() 호출 : roomId = " + roomId);
		RoomVO vo = roomService.selectRead(roomId);
		
		return vo;	
	} // end selectRoom()
	
	
} // end RoomRESTController
