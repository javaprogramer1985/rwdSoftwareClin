package com.softwareatumedida.rwdsoftwareclin.controlador;

import com.softwareatumedida.rwdsoftwareclin.entity.Car;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CarPool implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Car> currentlySelectedCars = new ArrayList<>();

    public List<Car> getCurrentlySelectedCars() {
        return currentlySelectedCars;
    }

    private List<Car> carPool;

    @PostConstruct
    public void init() {
        carPool = new ArrayList<>();
        Car car;
        for(int i=0 ;i<50 ; i++){
            car = new Car();
            car.setBrand("Fiat " + i);
            car.setType("Punto " + i);
            car.setColor("Blue " + i);
            car.setYear("Blue " + i);
            car.setEnginePower("64 " + i);
            carPool.add(car);
        }
    }
    
    public List<Car> getCarPool() {
        return carPool;
    }

    public void setCurrentlySelectedCars(List<Car> currentlySelectedCars) {
        this.currentlySelectedCars = currentlySelectedCars;
    }

    public void onSelect(Car car, String typeOfSelection, String indexes) {
        System.out.println("OnSelect:" + car + " typeOfSelection: " + typeOfSelection + " indexes: " + indexes);
        if (null != car) {
            getCurrentlySelectedCars().add(car);
        } else if (null != indexes) {
            String[] indexArray = indexes.split(",");
            for (String index : indexArray) {
                int i = Integer.valueOf(index);
                Car newCar = carPool.get(i);
                if (!currentlySelectedCars.contains(newCar)) {
                    getCurrentlySelectedCars().add(newCar);
                }
            }
        }
    }

    public void onDeselect(Car car, String typeOfSelection, String indexes) {
        System.out.println("OnDeselect:" + car + " typeOfSelection: " + typeOfSelection + " indexes: " + indexes);
        if (null != car) {
            getCurrentlySelectedCars().remove(car);
        } else if (null != indexes) {
            String[] indexArray = indexes.split(",");
            for (String index : indexArray) {
                int i = Integer.valueOf(index);
                getCurrentlySelectedCars().remove(carPool.get(i));
            }
        }
    }
}
