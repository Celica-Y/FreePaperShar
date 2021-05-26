package com.example.controller;

import com.example.entity.PaperTable;
import com.example.repository.UserDataRipository;
import com.example.repository.paperRepository;
import com.example.service.AccountUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class registerController{

    @Autowired
    paperRepository PaperRipositry;
    @Autowired
    UserDataRipository reposi;

    @RequestMapping(value="/mypage", method=RequestMethod.POST)
	public ModelAndView registerPost(
        @ModelAttribute("PaperForm") PaperTable paper,
        MultipartFile uploadfile,
        ModelAndView mv,
        BindingResult bindingResult,
        @RequestParam(name = "image", required = false) String image,
        @AuthenticationPrincipal AccountUserDetails datailaccount
        ){


/**
 * テストデータ1
 * ペーパー名：  とりおっきー
 * 場所：　　　　北海道　札幌市中央区
 * カテゴリー：　　タウン情報誌
 * 発行年月：　　2021/1
 * コメント：　　　取り置きさんによる、タウン情報誌です。
 *            置き場所はおっきーパン屋にありました。
 *            http://*******
 * 
 * テストデータ2
 * ペーパー名：  寝蔵酒
 * 場所：　　　　青森県　弘前市
 * カテゴリー：　　飲食
 * 発行年月：　　2020/3
 * コメント：　　　寝蔵氏が青森県の地酒を紹介するフリーペーパーです。
 *            ２件の場所で発見！以下がその場所です。
 *            ①弘前市＊＊町**番　酒屋キクラゲ
 *            ②弘前市＊町***番*-*  酒店oske
 */

        // ユーザーIdのセット
        // Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // Long userId = principal.getId();

        // datailaccount.getUser().getId();
        System.out.println("ユーザーのidは:"+datailaccount.getUser().getId()+"さん："+datailaccount.getUser().getUserName());

        long id = datailaccount.getUser().getId();
        paper.setUserId(id);

        if(image==""){
            System.out.println("no data");

        }else if(image!=""){
            
            String imag = paper.getImage();
            // System.out.println(image);
            String delims=",";
            String[] parts = imag.split(delims);

            String imageString = parts[1];
            paper.setImage(imageString);
            System.out.println(imageString);
        }

        PaperRipositry.saveAndFlush(paper);

      
        return new ModelAndView("redirect:/mypage");
    }

}