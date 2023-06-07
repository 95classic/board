package edu.spring.hotel.controller;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.spring.hotel.domain.HeartVO;
import edu.spring.hotel.service.HeartService;

@RestController
@RequestMapping(value = "heart")
public class HeartRESTController {
	private static final Logger logger = LoggerFactory.getLogger(HeartRESTController.class);

	@Autowired
	private HeartService heartService;

	@GetMapping("/all/{hotelId}")
	public ResponseEntity<Integer> selectHeart(@PathVariable("hotelId") int hotelId, @RequestParam String memberId) {
		logger.info("selectHeart() 호출");
		logger.info("hotelId = " + hotelId);
		logger.info("memberId = " + memberId);
		int result = 0;
		try {
			result = heartService.read(hotelId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end selectHeart()

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

	} // end createHeart()

	@DeleteMapping("/{hotelId}")
	public ResponseEntity<Integer> deleteHeart(@PathVariable("hotelId") int hotelId, @RequestBody String memberId) {
		logger.info("deleteHeart() 호출");
		int result = 0;
		try {
			result = heartService.delete(hotelId, memberId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	} // end deleteHeart()

} // end HeartRESTController
