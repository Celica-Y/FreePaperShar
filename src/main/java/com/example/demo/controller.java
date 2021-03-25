package com.example.demo;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {

	// indexページの表示
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView indexGet(ModelAndView mv) {
		mv.setViewName("index"); 
		return mv;
	}

	// entryページの表示
	@RequestMapping(value="/entry", method=RequestMethod.GET)
	public ModelAndView entryGet(ModelAndView mv) {
		mv.setViewName("entry"); 
		return mv;
	}

	// ログインページの表示
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginGet(ModelAndView mv) {
		mv.setViewName("login"); 
		return mv;
	}

	// 検索ページの表示
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView referenceGet(ModelAndView mv) {
		mv.setViewName("search"); 
		return mv;
	}

	// 投稿ページの表示(urlはログイン機能追加後に変更)
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public ModelAndView registerGet(ModelAndView mv) {
		mv.setViewName("register"); 
		return mv;
	}
}