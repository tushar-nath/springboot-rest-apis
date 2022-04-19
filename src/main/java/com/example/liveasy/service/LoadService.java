package com.example.liveasy.service;

import com.example.liveasy.dto.LoadDto;
import com.example.liveasy.entity.Load;

import java.util.List;

public interface LoadService {

    String saveLoad (final LoadDto loadDto);

    List<Load> getListOfLoad (final String shipperId);

    Load getLoad (final Long loadId);

    String updateLoad (final Long loadId, final LoadDto loadDto);

    String deleteLoad (final Long loadId);
}
