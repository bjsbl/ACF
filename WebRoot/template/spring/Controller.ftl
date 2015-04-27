/**
 * ACF
 * Create By ${author}
 * ${createDate}
 * 
 */
package ${packageName}.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/${className}")
@Controller
public class ${className}Controller {

	@Autowired
	private ${className}Service ${className}Service;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView toList(ModelMap model) {
		model.addAttribute("${className}s", ${className}Service.findAll());
		return new ModelAndView("${className}/list", "${className}s", ${className}s);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String toAdd(ModelMap model) {
		model.addAttribute("users", userService.findAll());
		return "${className}/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(${className}Entity account, String userId) {
		account.setUser(userService.find(userId));
		accountService.save(account);
		return "redirect:list";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String toEdit(ModelMap model, String id) {
		model.addAttribute("account", accountService.find(id));
		return "${className}/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String edit(AccountEntity account) {
		accountService.update(account);
		return "redirect:list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String toDelete(String id) {
		accountService.delete(id);
		return "redirect:list";
	}

}
