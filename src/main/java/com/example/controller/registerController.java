package com.example.controller;

import com.example.entity.PaperTable;
import com.example.ripository.PaperTableRipository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class registerController{

    @Autowired
    PaperTableRipository PaperRipositry;
    
    @RequestMapping(value="/regist", method=RequestMethod.POST)
	public ModelAndView registerPost(@ModelAttribute("PaperForm") PaperTable paper, ModelAndView mv)  {
// MultipartFile uploadfile,throws Exception


/**
 * テストデータ
 * 取り置きによる、タウン情報誌でせう。
    置き場所はおっきーパン屋にありました。
    URL→http://*******
 */
        // String img = paper.getUploadImg();
        // String delims="[,]";
        // String[] parts = img.split(delims);
        // String imageString = parts[1];

        // paper.setUploadImg(imageString);
        PaperRipositry.saveAndFlush(paper);
        return new ModelAndView("redirect:/post");
    }

}