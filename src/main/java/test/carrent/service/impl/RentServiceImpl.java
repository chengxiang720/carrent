package test.carrent.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import test.carrent.dao.CarRentDao;
import test.carrent.service.RentService;

@Service
public class RentServiceImpl implements RentService {

    @Override
    public boolean isLegalModel(String carModel) {
        if (StringUtils.isEmpty(carModel)) {
            return false;
        }

        return CarRentDao.inStockMap.containsKey(carModel);
    }

    @Override
    public synchronized boolean rentCar(String carModel) {
        if (StringUtils.isEmpty(carModel)) {
            return false;
        }

        int num = CarRentDao.inStockMap.get(carModel);
        if (num < 1) {
            return false;
        } else {
            CarRentDao.inStockMap.put(carModel, --num);;
        }
        return true;
    }

    @Override
    public synchronized boolean restoreCar(String carModel) {
        if (StringUtils.isEmpty(carModel)) {
            return false;
        }

        int num = CarRentDao.inStockMap.get(carModel);
        if (num > Integer.MAX_VALUE) {
            return false;
        } else {
            CarRentDao.inStockMap.put(carModel, ++num);
        }
        return true;
    }

}
