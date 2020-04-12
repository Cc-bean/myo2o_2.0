package com.yyc.o2o.web.shopadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther:Cc
 * @Date: 2020/02/02/22:04
 */
@Controller
@RequestMapping(value = "/shopadmin",method = {RequestMethod.GET})
public class ShopAdminController {
    @RequestMapping(value = "/shopoperation")
    public String shopOperation(){
        return "shop/shopoperation";
    }
    //店铺列表页面
    @RequestMapping(value = "/shoplist")
    public String shopList(){
        return "shop/shoplist";
    }
    //店铺管理页面
    @RequestMapping(value = "/shopmanagement")
    public String shopManagement(){
        return "shop/shopmanagement";
    }
    //商品类别管理页面
    @RequestMapping(value = "/productcategorymanagement")
    public String productCategoryManage(){
        return "shop/productcategorymanagement";
    }
    //商品添加/编辑页面
    @RequestMapping(value = "/productoperation")
    public String productOperation(){
        return "shop/productoperation";
    }
    //商品管理页面
    @RequestMapping(value = "/productmanagement")
    public String productManagement(){
        return "shop/productmanagement";
    }

    //店铺授权页面
    @RequestMapping(value = "/shopauthmanagement")
    public String shopAuthManagement(){
        return "shop/shopauthmanagement";
    }
    //授权信息修改页面
    @RequestMapping(value = "/shopauthedit")
    public String shopAuthEdit(){
        return "shop/shopauthedit";
    }
    @RequestMapping(value = "/operationsuccess",method = RequestMethod.GET)
    public String operationSuccess(){
        return "shop/operationsuccess";
    }
    @RequestMapping(value = "/operationfail",method = RequestMethod.GET)
    public String operationFail(){
        return "shop/operationfail";
    }
    // 转发至店铺的消费记录的页面
    @RequestMapping(value = "/productbuycheck", method = RequestMethod.GET)
    private String productBuyCheck() {
        return "shop/productbuycheck";
    }
    // 奖品管理页路由
    @RequestMapping(value = "/awardmanagement", method = RequestMethod.GET)
    private String awardManagement() {
        return "shop/awardmanagement";
    }
    // 奖品编辑页路由
    @RequestMapping(value = "/awardoperation", method = RequestMethod.GET)
    private String awardEdit() {
        return "shop/awardoperation";
    }
    // 店铺用户积分统计路由
    @RequestMapping(value = "/usershopcheck", method = RequestMethod.GET)
    private String userShopCheck() {
        return "shop/usershopcheck";
    }
    // 店铺用户积分兑换路由
    @RequestMapping(value = "/awarddelivercheck", method = RequestMethod.GET)
    private String awardDeliverCheck() {
        return "shop/awarddelivercheck";
    }

}







