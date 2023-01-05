package com.kakao.hb9397;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kakao.hb9397.domain.Command;
import com.kakao.hb9397.service.ItemService;

import lombok.RequiredArgsConstructor;

/**
 * Handles requests for the application home page.
 */
// Controller를 만들기 위한 어노테이션
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	// 로그를 기록하기 위한 객체
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// GET 요청이 / 로 왔을 때 처리하는 메서드
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// 로그를 기록하는 부분
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		// 데이터를 만들고 View에게 데이터를 전달 하는 부분
		model.addAttribute("serverTime", formattedDate );
		
		// 반환하는 문자열이 View의 이름이다. 이부분이 /src/main/resource/WEB-INF/spring/appServlet의 servlet-context.xml 로 전달되어
		// View Resolver 설정 부분에서 반환한 뷰 이름과 설정이 합쳐저서 /WEB-INF/views/home.jsp 로 등록되게 된다
		// /WEB-INF/views/home.jsp 위치에서 확인 할 수 있다.
		return "home";
	}
	
	// Hello 요청을 GET 방식으로 전송했을 때 처리
	@RequestMapping(value = "Hello", method=RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("message", "뷰에게 전달하는 데이터");
		return "hello";
	}
	@RequestMapping(value="message/detail/{num}", method=RequestMethod.GET)
	public String detail (Model model, @PathVariable("num") Integer num) {
		System.out.println("num : " + num);
		model.addAttribute("num", num);
		return "detail";
	}
	
	@RequestMapping(value="param1", method=RequestMethod.GET)
	public String param1 (Model model, HttpServletRequest request) {
		// 전통적인 Java Web 프로그래밍 방식에서의 파라미터 읽는 방법
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		System.out.println("전통적인 Java Web 프로그래밍 방식에서의 파라미터 읽는 방법");
		System.out.println("name: " +name);
		System.out.println("password: " + password);
		
		return "";
	}
	
	@RequestMapping(value="param2", method=RequestMethod.POST)
	public String param2 (Model model, @RequestParam("name") String name, @RequestParam String password) {
		System.out.println("@RequestParam을 이용해서 파라미터 읽기");
		System.out.println("name: " +name);
		System.out.println("password: " + password);
		
		return "";
	}
	
	@RequestMapping(value="param3", method=RequestMethod.POST)
	public String param3 (Model model, Command command) {
		System.out.println("@Commad 클래스를  이용해서 파라미터 읽기");
		System.out.println(command);
		
		return "";
	}
	
	@RequestMapping(value = "redirect", method = RequestMethod.GET)
	public String redirect(Model model, HttpSession session, RedirectAttributes rettr) {
		// 데이터 생성하기
		// request.setAttribute("msg", "Hello Redirect!")와 동일하게 동작한다.
		// redirect로 이동하게되면 requestㅇ가 새로 생성되기에 request의 데이터는 전달되지 않는다.
		// 이 때, session이나 RedirectAttributes를 이용해야 한다.
		model.addAttribute("msg", "Hello Redirect!");

		// 브라우저를 종료하거나 세션 초기화를 하지않는다면 계속 유지된다..
		// session.setAttribute("msg", "Hello Session To Data!");
		
		// RedirectAttributes를 통해 한번만 쓰고 버려질 데이터를 전달할 수 있다.
		rettr.addFlashAttribute("msg", "일회용 데이터 전달");
		
		// 리다이렉트 할 때는 redirect:요청경로 형식으로 설정한다.
		return "redirect:display";
	}	
	
	@RequestMapping(value = "display", method = RequestMethod.GET)
	public String display(Model model) {
		
		return "redirect";
	}
	
}
