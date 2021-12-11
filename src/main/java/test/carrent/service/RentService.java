package test.carrent.service;

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

}
