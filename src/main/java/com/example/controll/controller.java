package com.example.controll;
 
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

// 投稿詳細ぺーじの表示
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView datailsGet(ModelAndView mv) {
		mv.setViewName("details"); 
		return mv;
	}

// マイページの表示
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public ModelAndView mypageGet(ModelAndView mv) {
		mv.setViewName("mypage"); 
		return mv;
	}

// 検索結果一覧表示
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public ModelAndView searchResultGet(ModelAndView mv) {
		mv.setViewName("searchResult"); 
		return mv;
	}

// 投稿一覧の表示
	@RequestMapping(value="/post", method=RequestMethod.GET)
	public ModelAndView postListGet(ModelAndView mv) {
		mv.setViewName("postList"); 
		return mv;
	}

// お気に入り一覧の表示
	@RequestMapping(value="/favorite", method=RequestMethod.GET)
	public ModelAndView favoriteListGet(ModelAndView mv) {
		mv.setViewName("favoriteList"); 
		return mv;
	}

// 退会ページの表示
	@RequestMapping(value="/withd", method=RequestMethod.GET)
	public ModelAndView withdrawalGet(ModelAndView mv) {
	mv.setViewName("withdrawal"); 
	return mv;
	}

// プロフ変更ページ表示
	@RequestMapping(value="/change", method=RequestMethod.GET)
	public ModelAndView profilleChangeGet(ModelAndView mv) {
	mv.setViewName("profilleChange"); 
	return mv;
	}
}