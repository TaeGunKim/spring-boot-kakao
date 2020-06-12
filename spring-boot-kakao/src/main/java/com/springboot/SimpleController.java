package com.springboot;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



/**
 * Copyright 2020 by kimtg ALL right reserved.

 * <pre>
 * @author kimtg
 * @date 2020. 6. 11. 오전 10:41:49
 * @description
 * </pre>
 */
@RestController
public class SimpleController {


	@RequestMapping("/test")
    private String jspTest(){
        System.out.println("Hello world~");
        return "hello world~";
    }

	// 버튼 키보드
    @RequestMapping(value = "/keyboard", method = RequestMethod.GET)
    public String keyboard() {

        System.out.println("/keyboard");

        JSONObject jobjBtn = new JSONObject();
        ArrayList<String> btns = new ArrayList<>();
        btns.add("신청");
        btns.add("나의 신청 내역 (고객센터)");

        jobjBtn.put("type", "buttons");
        jobjBtn.put("buttons",btns);

        return jobjBtn.toJSONString();
    }

    // 단순 키보드
    @RequestMapping(value = "/keyboard2", method = RequestMethod.GET)
    public String keyboard2() {

        System.out.println("/keyboard");

        JSONObject jobjBtn = new JSONObject();
        jobjBtn.put("type", "text");

        return jobjBtn.toJSONString();
    }


    //버튼메세지
    @RequestMapping(value = "/message", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String message(@RequestBody JSONObject resObj) {

        System.out.println("/message");
        System.out.println(resObj.toJSONString());

        String content;
        content = (String) resObj.get("content");
        JSONObject jobjRes = new JSONObject();
        JSONObject jobjText = new JSONObject();
        JSONObject jobjmesBtn = new JSONObject();
        JSONObject jobjBtn = new JSONObject();

        ArrayList<String> btns = new ArrayList<>();
        btns.add("신청");
        btns.add("나의 신청 내역 (고객센터)");
        jobjBtn.put("type", "buttons");
        jobjBtn.put("buttons", btns);

        if(content.contains("신청")){
            System.out.println("click A");
            jobjText.put("text","안녕하세요 고객님! 신청해주셔서 감사합니다. 아래의 URL을 클릭하여 작성해주세요.");
            jobjmesBtn.put("label","신청서 작성");
            jobjmesBtn.put("url"," http://www.abc.com");
            jobjText.put("message_button",jobjmesBtn);

        } else if(content.contains("나의 신청 내역")){
            System.out.println("click B");
            jobjText.put("text","안녕하세요 고객님! 신청하신 내역은 아래의 URL에서 확인하실 수 있습니다");
            jobjmesBtn.put("label","고객센터 문의");
            jobjmesBtn.put("url"," http://www.abc.com");
            jobjText.put("message_button",jobjmesBtn);

        }

        jobjRes.put("message", jobjText);
        jobjRes.put("keyboard", jobjBtn);
        System.out.println(jobjRes.toJSONString());

        return  jobjRes.toJSONString();
    }

    //단순 메세지
    @RequestMapping(value = "/message2", method = RequestMethod.POST, headers = "Accept=application/json")
    @ResponseBody
    public String message2(@RequestBody JSONObject resObj) {

        System.out.println("/message");
        System.out.println(resObj.toJSONString());

        String content;
        content = (String) resObj.get("content");
        JSONObject jobjRes = new JSONObject();
        JSONObject jobjText = new JSONObject();

        // 사용자 구현
        if(content.contains("안녕")){
            jobjText.put("text","안녕 하세요");
        } else if(content.contains("사랑")){
            jobjText.put("text","나도 너무너무 사랑해");
        } else if(content.contains("잘자")){
            jobjText.put("text","꿈 속에서도 너를 볼꺼야");
        } else if(content.contains("졸려")){
            jobjText.put("text","졸리면 언능 세수하러 가용!");
        } else if(content.contains("시간")||content.contains("몇 시")){
            jobjText.put("text","섹시");
        } else {
            jobjText.put("text","흠... 아직 지정해 두지 않은 말인걸.");
        }

        jobjRes.put("message", jobjText);
        System.out.println(jobjRes.toJSONString());

        return  jobjRes.toJSONString();
    }




}
