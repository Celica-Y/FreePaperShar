package com.example.controller;
 
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.entity.PullDownCategory;
import com.example.entity.prefectureEntity;
import com.example.entity.userData;
import com.example.repository.PullDownPrefectureRepository;
import com.example.repository.UserDataRipository;
import com.example.repository.categoryEntityRepository;
import com.example.repository.cityEntity;
import com.example.repository.cityEntityRepository;
import com.example.service.AccountService;
import com.example.service.AccountUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {
	@Autowired
	categoryEntityRepository categoryRepository;
	
	@Autowired 
	PullDownPrefectureRepository prefRepository;
	
	@Autowired
	cityEntityRepository cityRepository;

	@Autowired
	UserDataRipository repository;

	@Autowired
	AccountService service;
	
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

// 検索ページの表示はサーチコントローラーへ

// 投稿ページの表示(urlはログイン機能追加後に変更)
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public ModelAndView registerGet(
				@ModelAttribute PullDownCategory DownCategory,
				@ModelAttribute prefectureEntity prefEntity,
				@ModelAttribute cityEntity cityEntity, 
	 			ModelAndView mv) {
		List<prefectureEntity> pref =  prefRepository.findAll();
		mv.addObject("pref", pref);
		// 市区町村プルダウン
		List<cityEntity> city = cityRepository.findAll();
		mv.addObject("city", city);
		// System.out.println(city);

		// カテゴリープルダウン(keyは0始まり。)
		List<PullDownCategory> DC =  categoryRepository.findAll();
		mv.addObject("category", DC);
		/**
		 * 発行年プルダウン。
		 * カレンダーから今年を取得し、１０年分繰り返えしてマップにする。
		 * (keyは0始まり。)
		 */
		Calendar cl = Calendar.getInstance();

		Map<String, String> Year = new LinkedHashMap<String, String>();

		int yearData = cl.get(Calendar.YEAR);
		for (int i = 0 ; i <= 10 ; i++){
			int YearData = yearData-i ;
			Year.put(String.valueOf(i), String.valueOf(YearData));
			// System.out.println(i);
			// System.out.println(YearData);
		  }
		mv.addObject("Year", Year);

		//発行月プルダウン(keyは１始まり。)
		Map<String, String> month = new LinkedHashMap<String, String>();
		for (int i = 1; i <= 12; i++){
			month.put(String.valueOf(i), String.valueOf(i));
		}
		mv.addObject("month", month);


		mv.setViewName("mypage"); 
		return mv;
	}

// 投稿詳細ぺーじの表示
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView datailsGet(ModelAndView mv) {
		mv.setViewName("details"); 
		return mv;
	}


// 投稿一覧の表示
	@RequestMapping(value="/post", method=RequestMethod.GET)
	public ModelAndView postListGet(ModelAndView mv) {
		mv.setViewName("postList"); 
		return mv;
	}


// 退会ページの表示
	@RequestMapping(value="/deleteUser", method=RequestMethod.GET)
	public ModelAndView withdrawalPOST(@AuthenticationPrincipal AccountUserDetails userDetails,ModelAndView mv) {
		
		String name = userDetails.getUsername();
		service.deleteByEmail(name);

		mv.setViewName("withdrawal"); 
		return new ModelAndView("redirect:/");
	}

// プロフ変更ページ表示
	@RequestMapping(value="/mypage/change/{id}", method=RequestMethod.GET)
	public ModelAndView profilleChangeGet(@ModelAttribute userData userData, @PathVariable long id,ModelAndView mv) {
		Optional <userData> user = repository.findById(id);
		mv.addObject("userData", user.get());
		mv.setViewName("profilleChange"); 
		return mv;
	}
}