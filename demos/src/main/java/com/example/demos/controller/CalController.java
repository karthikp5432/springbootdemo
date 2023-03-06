package com.example.demos.controller;
import com.example.demos.CalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/calculator")
public class CalController {

	@Autowired
	CalService calService;

	@GetMapping("/greet")
	public String sayHello(){
		return "Welcome to this project";
	}
	@GetMapping("/add/{first}/{second}")
	public double addition(@PathVariable("first") double firstnum,
						   @PathVariable("second") double secondnum){
		double res =  calService.add(firstnum,secondnum);
		return res;
	}
	@GetMapping("/subtract/{first}/{second}")
	public double sub(@PathVariable("first") double firstnum,
							  @PathVariable("second") double secondnum){
		double res = calService.sub(firstnum, secondnum);
		return res;
	}
	@GetMapping("/Multiplication")
    public HttpEntity<?> Multiply(@RequestParam("first") double firstnum, @RequestParam("second") double secondnum){
		if(firstnum == 0 || secondnum == 0){
			return new ResponseEntity<>("INVALID INPUT", HttpStatus.BAD_REQUEST);
		}
		double res = calService.multiply(firstnum, secondnum);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	@GetMapping("/divide")
	public HttpEntity<?> div(@RequestParam("first") double first,
							 @RequestParam("second") double second){
		if(second == 0){
			return new ResponseEntity<>("Division by Zero is undefined",HttpStatus.BAD_REQUEST);
		}
		double res = calService.div(first,second);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}

}





