package com.neuedu.ruidaoexam.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.neuedu.ruidaoexam.config.PaypalPaymentIntent;
import com.neuedu.ruidaoexam.config.PaypalPaymentMethod;
import com.neuedu.ruidaoexam.service.StudentService;
import com.neuedu.ruidaoexam.service.TeacherService;
import com.neuedu.ruidaoexam.service.impl.PaypalService;
import com.neuedu.ruidaoexam.Util.URLUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "paypal")
public class PaypalController {
    @Resource
    private PaypalService paypalService;
    public static final String PAYPAL_SUCCESS_URL = "paypal/pay/success";
    public static final String PAYPAL_CANCEL_URL = "paypal/pay/cancel";
    public static final String paypal_to_Success = "paypal/pay/tosuccess";

    private Logger log = LoggerFactory.getLogger(PaypalController.class);

    @Autowired TeacherService teacherservice;
    @Autowired StudentService studentservice;
    
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "pay";
    }

    @RequestMapping(method = RequestMethod.POST, value = "pay")
    public String pay(HttpServletRequest request,@RequestParam(value="a")Integer a){
    	
        String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
        String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
        /*
         * 以下8行代码为后添加，若出错请注释掉by王重阳
         */
        HttpSession session = request.getSession();
        int uid = Integer.parseInt(String.valueOf(session.getAttribute("uid")).trim());
        if(session.getAttribute("role").equals("teacher")) {
        	teacherservice.addPoint(uid, a);
        }else {
        	studentservice.addPoint(uid, a);
        }
        
        try {
            Payment payment = paypalService.createPayment(
                    Double.valueOf(a),
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "payment description",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
            	System.out.println("进入了循环");
                if(links.getRel().equals("approval_url")){
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        System.out.println("a的值是多少"+a);
        System.out.println("进入了pay");
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "pay/cancel")
    public String cancelPay(){
        log.info("cancle");
        return "cancel";
    }

    @RequestMapping(method = RequestMethod.GET, value = "pay/success")
    public String successPay(HttpServletRequest request,@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        System.out.println("lallalalalalalalalal");
//        String Url = URLUtils.getBaseURl(request) + "/"+paypal_to_Success;
    	log.info("successpay");
        try {
        	log.info("try starts");
        	System.out.println("try starts");
            Payment payment = paypalService.executePayment(paymentId, payerId);
            log.info(payment.getState()+"lyt");
            System.out.println(payment.getState()+"lyt");
            if(payment.getState().equals("approved")){
                return "redirect:/toindexteacher";
            }
        } catch (PayPalRESTException e) {
        	log.error("111");
            log.error(e.getMessage());
        }
        log.info("lyt");
        System.out.println("furunfengdashabi");
        return "redirect:/";
    }

    @RequestMapping(value = "pay/tosuccess")
	public String tot() {
		 System.out.println("f-----------------");
		return "toindex";
	}
}
