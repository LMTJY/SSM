package action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import service.UserService;

@Controller
@RequestMapping("user")
public class UserAction {
	@Resource
	private UserService userService;
	
	
	@RequestMapping("all")
	public String queryAll(Model model){
		List<User> list = userService.queryAll();
		model.addAttribute("list",list);
		return "index";
	}
	
}
