package com.delivery.web.controller.front;

import com.delivery.domain.DeliveryCard;
import com.delivery.framework.web.domain.Server;
import com.delivery.service.IDeliveryCardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @author jcohy
 */
@Controller
@RequestMapping("/front")
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    private String prefix = "/front";

    @Autowired
    private IDeliveryCardService deliveryCardService;

    @GetMapping()
    public String index(@RequestParam String t, ModelMap mmap){
        logger.info("cardNo = {}",t);
        mmap.put("t", t);
        return prefix + "/index";
    }

    /**
     * 校验参数键名
     */
    @PostMapping("/checkPassword")
    @ResponseBody
    public boolean checkConfigKeyUnique(DeliveryCard deliveryCard) {
//        logger.info("checkPassword | deliveryCard = {}",deliveryCard.toString());
//        DeliveryCard deliveryCard1 = deliveryCardService.selectDeliveryCardByCardNo(deliveryCard.getCardNo());
//        logger.info("checkPassword | deliveryCard1 = {}",deliveryCard1.toString());
        return true;
    }
}
