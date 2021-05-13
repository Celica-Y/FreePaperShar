package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.PaperTable;
import com.example.entity.PullDownCategory;
import com.example.entity.prefectureEntity;
import com.example.repository.PullDownPrefectureRepository;
import com.example.repository.categoryEntityRepository;
import com.example.repository.peperSearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		@RequestParam(name = "prefectures", required = false) String prefectures,
		@RequestParam(name ="category", required = false) String categoryName,
		@RequestParam(name ="paperName", required = false) String paperName
		){
			
			mv.setViewName("search"); 
			List<PaperTable> list = new ArrayList<PaperTable>();

			if(prefectures!=""){
				if(categoryName!=""){//都道府県とカテゴリ
					list = pRepository.findByPrefecturesAndCategory(prefectures, categoryName);
					mv.addObject("size", list.size());
					mv.addObject("prefectures", prefectures);
					mv.addObject("categoryName", categoryName);
					mv.addObject("picture", categoryName);
					System.out.println("都道府県とカテゴリ");

				}else if(paperName!=""){//都道府県とフリペ名
					list = pRepository.findByPrefecturesAndPaperNameContaining(prefectures, paperName);
					mv.addObject("size", list.size());
					mv.addObject("prefectures", prefectures);
					mv.addObject("paperName", paperName);
					System.out.println("都道府県とフリペ名");

				}else{//都道府県のみ
					list = pRepository.findByPrefectures(prefectures);
					mv.addObject("size", list.size());
					mv.addObject("prefectures", prefectures);
					System.out.println("都道府県");
				}
			}else if(categoryName!=""){//カテゴリのみ
				if(paperName!=""){
					list = pRepository.findByCategoryAndPaperNameContaining(categoryName, paperName);
					mv.addObject("size", list.size());
					mv.addObject("categoryName", categoryName);
					mv.addObject("paperName", paperName);
					System.out.println("カテゴリとフリペ");
				}else{
					list = pRepository.findByCategory(categoryName);
					mv.addObject("size", list.size());
					mv.addObject("categoryName", categoryName);
					System.out.println("カテゴリのみ");
				}
			}else if(paperName!=""){//フリペ名のみ
					list = pRepository.findByPaperNameContaining(paperName);
					mv.addObject("size", list.size());
					mv.addObject("paperName", paperName);
					System.out.println("フリペのみ");
			}else{//未入力
				list = pRepository.findAll();
				mv.addObject("size", list.size());
				mv.addObject("list", list);
				System.out.println("未入力");
			}

			if(prefectures!="" && categoryName!="" && paperName!=""){
				list = pRepository.findByPrefecturesAndCategoryAndPaperName(prefectures, categoryName, paperName);
				mv.addObject("size", list.size());
				mv.addObject("prefectures", prefectures);
				mv.addObject("categoryName", categoryName);
				mv.addObject("paperName", paperName);
				System.out.println("全一致");
			}

			if(list.size()==0){
				mv.addObject("msg", "該当データがありません。");
			}


			mv.addObject("list", list);
			return mv;
        /**
         * 画像データはbase64にエンコードしてhtmlに渡す
         * th:src="${base64data}"
         * th:src="${base64data-profImg}"
         */
			
	}
}
