package com.cskaoyan.controller.wxAddress;

import com.cskaoyan.bean.vo.ResponseVO;
import com.cskaoyan.bean.wxBean.WxAddress;
import com.cskaoyan.bean.wxBean.WxAddress2;
import com.cskaoyan.service.wxAddress.WxAddressService;
import com.cskaoyan.tokenManager.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class WxAddressController {

    @Autowired
    WxAddressService addressService;

    /*收货地址列表*/
    @RequestMapping("wx/address/list")
    @ResponseBody
    public ResponseVO<List> queryAddressList(HttpServletRequest request) {

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        ResponseVO<List> responseVO = new ResponseVO<>();
        List<WxAddress> addressList = addressService.queryAddressListByUserId(userId);

        responseVO.setData(addressList);
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    /*收货地址详情*/
    @RequestMapping("wx/address/detail")
    @ResponseBody
    public ResponseVO<WxAddress2> addressDetail(int id) {
        ResponseVO<WxAddress2> responseVO = new ResponseVO<>();
        responseVO.setData(addressService.queryAddressById(id));
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }

    /*保存地址信息*/
    @RequestMapping("wx/address/save")
    @ResponseBody
    public ResponseVO<Integer> save(@RequestBody WxAddress2 address, HttpServletRequest request) {
        ResponseVO<Integer> responseVO = new ResponseVO<>();

        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);

        int ret = addressService.updateAddress(address, userId);

        responseVO.setData(address.getId());
        responseVO.setErrmsg("成功");
        responseVO.setErrno(0);
        return responseVO;
    }
}
