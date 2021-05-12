package com.example.controller;

import java.net.http.HttpClient.Redirect;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.entity.PaperTable;
import com.example.entity.PullDownCategory;
import com.example.entity.cityEntity;
import com.example.entity.prefectureEntity;
import com.example.repository.PullDownPrefectureRepository;
import com.example.repository.categoryEntityRepository;
import com.example.repository.cityEntityRepository;
import com.example.repository.paperRepository;
import com.example.repository.peperSearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class searchController {


    @Autowired
	categoryEntityRepository categoryRepository;
	
	@Autowired 
	PullDownPrefectureRepository prefRepository;

    @Autowired
    peperSearchRepository pRepository;


    @RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView referenceGet(
		@ModelAttribute PullDownCategory DownCategory,
		@ModelAttribute prefectureEntity prefEntity,
	 	ModelAndView mv) {

		List<prefectureEntity> pref =  prefRepository.findAll();
		mv.addObject("pref", pref);

		// カテゴリープルダウン(keyは0始まり。)
		List<PullDownCategory> cate =  categoryRepository.findAll();
		mv.addObject("cate", cate);
		
		mv.setViewName("search"); 
		return mv;
	}

     
    @RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView search(
        ModelAndView mv,
        @RequestParam(name="paperName") String paperName,
		@RequestParam(name="prefectures") String prefectures,
		@RequestParam(name="category") String categoryName){
		 	mv.setViewName("search"); 
			 List<PaperTable> list = new ArrayList<PaperTable>();
			

			// if (prefectures != null) { //都道府県
			// 	// list = pRepository.findByPrefectures(prefectures);
				
			// 	if (category != null) {//都道府県とカテゴリー
			// 		list = pRepository.findByPaperNameAndCategory(prefectures,category);
			// 		mv.addObject("size",list.size());
			// 		mv.addObject("prefectures",prefectures);
			// 		mv.addObject("category",category);
			// 	}else 
				// if(paperName != null) { //名前入力・曖昧検索
				// 	list  = pRepository.findByPaperName(paperName);
				// 	mv.addObject("size",list.size());
				// 	mv.addObject("prefectures",prefectures);
				// 	mv.addObject("paperName",paperName);
				// }

				if(prefectures != null) {
					if(categoryName != null){//都道府県とカテゴリー/一致
						list  = pRepository.findByPrefecturesAndCategory(prefectures, categoryName);
						mv.addObject("size",list.size());
						mv.addObject("prefectures",prefectures);
						mv.addObject("category",categoryName);
					}else if(paperName != null){//都道府県とペーパー名/一致・曖昧検索
						list  = pRepository.findByPrefecturesAndPaperName(prefectures, paperName);
						mv.addObject("size",list.size());
						mv.addObject("prefectures",prefectures);
						mv.addObject("paperName",paperName);
					}
				// }else{//都道府県のみ/一致
				// 	list  = pRepository.findByPrefectures(prefectures);
				// 	mv.addObject("size",list.size());
				// 	mv.addObject("prefectures",prefectures);
				// 	mv.addObject("PaperName",PaperName);
				}

				// if(categoryName != null) { //カテゴリ・一致
				// 	list  = pRepository.findByCategory(categoryName);
				// 	mv.addObject("size",list.size());
				// 	mv.addObject("category",categoryName);
				// 	mv.addObject("PaperName",PaperName);
				// }
			// 	else {		// エリアだけ入力
			// 		list = pRepository.findByPrefectures(prefectures);
			// 		mv.addObject("size",list.size());
			// 		mv.addObject("prefectures",prefectures);
			// 	}

			// }else if(PaperName != null && category == null) {
			// 		list = pRepository.findByPaperName(PaperName);
			// 		mv.addObject("size",list.size());
			// 		mv.addObject("PaperName",PaperName);
			// }else if(category != null) {
			// 		list = pRepository.findByCategory(category);	
			// 		mv.addObject("size",list.size());		
			// 		mv.addObject("category",category);	
			// }else{
			// 		list = pRepository.findAll();
			// 		mv.addObject("size",list.size());
			// }
			// if(list.size() == 0) {
			// 	// mv.addObject("msg","該当データがありません。");
			// }
			mv.addObject("list", list);
			// return new ModelAndView("redirect:/search");
				return mv;
        /**
         * 画像データはbase64にエンコードしてhtmlに渡す
         * th:src="${base64data}"
         * th:src="${base64data-profImg}"
         */
			
	}
}
