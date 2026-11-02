package kr.co.jj.jts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.jj.jts.model.Fruit;
import kr.co.jj.jts.service.FruitService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// 스프링 프레임워크에서 컨트롤러 역할을 하는 클래스를 설정
@Controller
public class FruitController {
	// Service 의존성 주입
	@Autowired
	private FruitService fruitService;
	
	// @GetMapping: Spring MVC에서 URL에 대한 Get 방식의 요청을 선언된 메소드와 연결하는 어노테이션
	@GetMapping
	// @ResponseBody: Spring에서 연결된 반환값을 HTTP 응답의 Body(본문)직접 전달하는 어노테이션
	@ResponseBody
	public String index() {
		return "안녕하세요. Java 기반의 웹서버 첫 페이지입니다.<br/><a href='index.html'>index페이지</a>";
	}
	
	@GetMapping("main")
	@ResponseBody
	public String index2() {
		return "두번째 페이지 입니다.";
	}
	
	@GetMapping("/index.html")
    public String index3() {
        return "index"; // templates/layout/index.html 일 경우 이름만 적으면 됨
    }
	
	@GetMapping("/aboutme")
	public String callAboutMe() {
		return "aboutme";
	}
	
	@GetMapping("/fruitlist")
	public String getFruitLists(Model model) {
		List<Fruit> ff = fruitService.findAll();
		model.addAttribute("fruits", ff);
		return "fruit_list";
	}
	
	@GetMapping("/fruit_reg")
	public String getFruitReg() {
		return "fruit_regform";
	}
	
	@PostMapping("/fruit_reg")
	public String fruitRegOk(@ModelAttribute Fruit fru) {
		fruitService.save(fru);
		return "redirect:/fruitlist";
	}
	
	@GetMapping("/fruit_info/{idx}")
	public String editFruitInfo(@PathVariable int idx, Model model) {
		Fruit fru = fruitService.findById(idx);
		model.addAttribute("fruit", fru);
		return "fruit_editform";
	}
	
	@PostMapping("/fruit_editok")
	public String editOkFruit(@ModelAttribute Fruit fru) {
		fruitService.save(fru);
		return "redirect:/fruitlist";
	}
	
	@GetMapping("/fruit_del/{idx}")
	public String  fruitDel(@PathVariable int idx) {
		fruitService.delete(idx);
		return "redirect:/fruitlist";
	}
}
