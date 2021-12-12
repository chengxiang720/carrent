package test.carrent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import test.carrent.service.RentService;

import java.util.Map;

@Controller
public class CarRentController {

    @Autowired
    public RentService rentService;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    /**
     * 租车
     *
     * @param carModel
     * @return
     */
    @PostMapping("rentCar")
    @ResponseBody
    public String rentCar(String carModel) {
        String result;
        boolean isLegalModel = rentService.isLegalModel(carModel);
        if (isLegalModel) {
            if (rentService.rentCar(carModel)) {
                result = "租车成功，赶快提车吧！";
            } else {
                result = "当前租车太火爆，已经租完了哦！";
            }
        } else {
            result = "此类车型不存在";
        }
        return result;
    }

    /**
     * 还车
     *
     * @param carModel
     * @return
     */
    @PostMapping("restoreCar")
    @ResponseBody
    public String restoreCar(String carModel) {
        String result;
        boolean isLegalModel = rentService.isLegalModel(carModel);
        if (isLegalModel) {
            if (rentService.restoreCar(carModel)) {
                result = "还车成功，欢迎下次再来哦！";
            } else {
                result = "还车失败，请稍后再试，或联系工作人员！";
            }
        } else {
            result = "此类车型不存在";
        }
        return result;
    }

    /**
     * 查询剩余可用车辆信息
     *
     * @return
     */
    @PostMapping("queryRemainCarInfo")
    @ResponseBody
    public Map<String, Integer> queryRemainCarInfo() {
        return rentService.queryRemainCarInfo();
    }

}
