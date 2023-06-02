package edu.spring.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.board.domain.HeartVO;
import edu.spring.board.service.HeartService;

@RestController
@RequestMapping(value = "board/heart")
public class HeartRESTController {
	private static final Logger logger = LoggerFactory.getLogger(HeartRESTController.class);

	@Autowired
	private HeartService heartService;
	
	@GetMapping("/{boardId}")
	public ResponseEntity<Integer> selectHeart(@PathVariable("boardId") int boardId, @RequestParam String memberId) {
		logger.info("selectHeart() 호출");
		logger.info("boardId = " + boardId);
		logger.info("memberId = "  + memberId);
		int result = 0;
		try {
			result = heartService.read(boardId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end selectHeart
	
	@PostMapping
	public ResponseEntity<Integer> createHeart(@RequestBody HeartVO vo) {
		logger.info("createHeart() 호출");
		
		int result = 0;
		try {
			result = heartService.create(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end createHeart
	

	@DeleteMapping("/{boardId}")
	public ResponseEntity<Integer> deleteHeart(@PathVariable("boardId") int boardId, @RequestBody String memberId) {
		logger.info("deleteHeart() 호출");
		int result = 0;
		try {
			result = heartService.delete(boardId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end deleteHeart
	
} // end HeartRESTController
