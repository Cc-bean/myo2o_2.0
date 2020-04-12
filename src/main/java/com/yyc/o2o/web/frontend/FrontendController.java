package com.yyc.o2o.web.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther:Cc
 * @Date: 2020/02/15/14:10
 */
@Controller
@RequestMapping("/frontend")
public class FrontendController {
    //首页
    @RequestMapping(value = "/index")
    public String shopOperation(){
        return "frontend/index";
    }
    //列表页
    @RequestMapping(value = "/shoplist")
    public String ShowShopList(){
        return "frontend/shoplist";
    }
    //店铺详情页
    @RequestMapping(value = "/shopdetail")
    public String showShopDetail(){
        return "frontend/shopdetail";
    }
    //商品详情页
    @RequestMapping(value = "/productdetail")
    public String showProductDetail(){
        return "frontend/productdetail";
    }
    /**
     * 店铺的奖品列表页路由
     *
     * @return
     */
    @RequestMapping(value = "/awardlist", method = RequestMethod.GET)
    private String showAwardList() {
        return "frontend/awardlist";
    }

    /**
     * 奖品兑换列表页路由
     *
     * @return
     */
    @RequestMapping(value = "/pointrecord", method = RequestMethod.GET)
    private String showPointRecord() {
        return "frontend/pointrecord";
    }

    /**
     * 奖品详情页路由
     *
     * @return
     */
    @RequestMapping(value = "/myawarddetail", method = RequestMethod.GET)
    private String showMyAwardDetail() {
        return "frontend/myawarddetail";
    }

    /**
     * 消费记录列表页路由
     *
     * @return
     */
    @RequestMapping(value = "/myrecord", method = RequestMethod.GET)
    private String showMyRecord() {
        return "frontend/myrecord";
    }

    /**
     * 用户各店铺积分信息页路由
     *
     * @return
     */
    @RequestMapping(value = "/mypoint", method = RequestMethod.GET)
    private String showMyPoint() {
        return "frontend/mypoint";
    }

}
