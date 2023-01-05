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
// Controller�� ����� ���� ������̼�
@Controller
@RequiredArgsConstructor
public class HomeController {
	
	// �α׸� ����ϱ� ���� ��ü
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// GET ��û�� / �� ���� �� ó���ϴ� �޼���
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		// �α׸� ����ϴ� �κ�
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		// �����͸� ����� View���� �����͸� ���� �ϴ� �κ�
		model.addAttribute("serverTime", formattedDate );
		
		// ��ȯ�ϴ� ���ڿ��� View�� �̸��̴�. �̺κ��� /src/main/resource/WEB-INF/spring/appServlet�� servlet-context.xml �� ���޵Ǿ�
		// View Resolver ���� �κп��� ��ȯ�� �� �̸��� ������ �������� /WEB-INF/views/home.jsp �� ��ϵǰ� �ȴ�
		// /WEB-INF/views/home.jsp ��ġ���� Ȯ�� �� �� �ִ�.
		return "home";
	}
	
	// Hello ��û�� GET ������� �������� �� ó��
	@RequestMapping(value = "Hello", method=RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("message", "�信�� �����ϴ� ������");
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
		// �������� Java Web ���α׷��� ��Ŀ����� �Ķ���� �д� ���
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		System.out.println("�������� Java Web ���α׷��� ��Ŀ����� �Ķ���� �д� ���");
		System.out.println("name: " +name);
		System.out.println("password: " + password);
		
		return "";
	}
	
	@RequestMapping(value="param2", method=RequestMethod.POST)
	public String param2 (Model model, @RequestParam("name") String name, @RequestParam String password) {
		System.out.println("@RequestParam�� �̿��ؼ� �Ķ���� �б�");
		System.out.println("name: " +name);
		System.out.println("password: " + password);
		
		return "";
	}
	
	@RequestMapping(value="param3", method=RequestMethod.POST)
	public String param3 (Model model, Command command) {
		System.out.println("@Commad Ŭ������  �̿��ؼ� �Ķ���� �б�");
		System.out.println(command);
		
		return "";
	}
	
	@RequestMapping(value = "redirect", method = RequestMethod.GET)
	public String redirect(Model model, HttpSession session, RedirectAttributes rettr) {
		// ������ �����ϱ�
		// request.setAttribute("msg", "Hello Redirect!")�� �����ϰ� �����Ѵ�.
		// redirect�� �̵��ϰԵǸ� request���� ���� �����Ǳ⿡ request�� �����ʹ� ���޵��� �ʴ´�.
		// �� ��, session�̳� RedirectAttributes�� �̿��ؾ� �Ѵ�.
		model.addAttribute("msg", "Hello Redirect!");

		// �������� �����ϰų� ���� �ʱ�ȭ�� �����ʴ´ٸ� ��� �����ȴ�..
		// session.setAttribute("msg", "Hello Session To Data!");
		
		// RedirectAttributes�� ���� �ѹ��� ���� ������ �����͸� ������ �� �ִ�.
		rettr.addFlashAttribute("msg", "��ȸ�� ������ ����");
		
		// �����̷�Ʈ �� ���� redirect:��û��� �������� �����Ѵ�.
		return "redirect:display";
	}	
	
	@RequestMapping(value = "display", method = RequestMethod.GET)
	public String display(Model model) {
		
		return "redirect";
	}
	
}
