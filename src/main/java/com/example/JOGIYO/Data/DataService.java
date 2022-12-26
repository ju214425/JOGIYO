package com.example.JOGIYO.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@Service
public class DataService {
    private final DataRepository dataRepository;

    @Autowired
    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public List<DataDomain> getDataDomains() {
        return dataRepository.findAll();
    }

    public DataDomain getDataDomain(Long id) {
        return dataRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("No such Data!"));
    }

    public DataDomain saveDataDomain(DataDomain dataDomain) {
        return dataRepository.save(dataDomain);
    }

    public DataDomain updateDataDomain(DataDomain dataDomain) {
        DataDomain updatedDataDomain = null;
        try {
            DataDomain existedDataDomain = getDataDomain(dataDomain.getId());
            if(!ObjectUtils.isEmpty(existedDataDomain)) {
                updatedDataDomain = dataRepository.save(dataDomain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return updatedDataDomain;
        }
    }
    public void deleteDataDomain(Long id){
        dataRepository.deleteById(id);
    }
}
