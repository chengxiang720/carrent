package test.carrent.service;

import java.util.Map;

public interface RentService {

    /**
     * 车型是否合法
     *
     * @param carModel
     * @return
     */
    boolean isLegalModel(String carModel);

    /**
     * 租车
     *
     * @param carModel
     * @return
     */
    boolean rentCar(String carModel);

    /**
     * 还车
     *
     * @param carModel
     * @return
     */
    boolean restoreCar(String carModel);

    /**
     * 剩余可租用车辆信息
     *
     * @return
     */
    Map<String, Integer> queryRemainCarInfo();

}
