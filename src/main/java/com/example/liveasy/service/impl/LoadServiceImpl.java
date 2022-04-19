package com.example.liveasy.service.impl;

import com.example.liveasy.dto.LoadDto;
import com.example.liveasy.entity.Load;
import com.example.liveasy.repository.LoadRepository;
import com.example.liveasy.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    public LoadRepository loadRepository;

    //save load details
    @Override
    public String saveLoad(LoadDto loadDto) {

        final Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(loadDto.getDate());
        } catch (Exception exception) {
            throw new IllegalArgumentException("Date format error");
        }

        final Load load = new Load();
        load.setLoadingPoint(loadDto.getLoadingPoint());
        load.setUnloadingPoint(loadDto.getUnloadingPoint());
        load.setProductType(loadDto.getProductType());
        load.setTruckType(loadDto.getTruckType());
        load.setNoOfTrucks(loadDto.getNoOfTrucks());
        load.setWeight(loadDto.getWeight());
        load.setComment(loadDto.getComment());
        load.setShipperId(loadDto.getShipperId());
        load.setDate(date);
        loadRepository.save(load);
        return "Load details successfully added.";

    }

    //get a list of all loads of a specific shipper
    @Override
    public List<Load> getListOfLoad(String shipperId) {
        List<Load> loadList = this.loadRepository.findByShipperId(shipperId);
        if(loadList.size() == 0) {
            throw new IllegalArgumentException("Load list for the provided ShipperId is empty.");
        }
        return loadList;
    }

    //get load details from a loadId
    @Override
    public Load getLoad(Long loadId) {
        final Optional<Load> optionalLoad = this.loadRepository.findByLoadId(loadId);
        if(!optionalLoad.isPresent()) {
            throw new IllegalArgumentException("Load for the given LoadId not found.");
        }
        return optionalLoad.get();
    }

    //update load details
    @Override
    public String updateLoad(Long loadId, LoadDto loadDto) {
        final Optional<Load> optionalLoad = this.loadRepository.findByLoadId(loadId);
        if(!optionalLoad.isPresent()) {
            throw new IllegalArgumentException("Load for the given LoadId not found.");
        }

        final Date date;
        try {
            date = new SimpleDateFormat("dd-MM-yyyy").parse(loadDto.getDate());
        } catch (Exception exception) {
            throw new IllegalArgumentException("Date format error");
        }

        final Load load = optionalLoad.get();
        load.setLoadingPoint(loadDto.getLoadingPoint());
        load.setUnloadingPoint(loadDto.getUnloadingPoint());
        load.setProductType(loadDto.getProductType());
        load.setTruckType(loadDto.getTruckType());
        load.setNoOfTrucks(loadDto.getNoOfTrucks());
        load.setWeight(loadDto.getWeight());
        load.setComment(loadDto.getComment());
        load.setDate(date);
        loadRepository.save(load);
        return "Load details successfully updated.";
    }

    //delete load details
    @Override
    public String deleteLoad(Long loadId) {
        final Optional<Load> optionalLoad = this.loadRepository.findByLoadId(loadId);
        if(!optionalLoad.isPresent()) {
            throw new IllegalArgumentException("Load for the given LoadId not found.");
        }

        final Load load = optionalLoad.get();
        loadRepository.delete(load);

        return "Load details successfully deleted.";
    }

}
