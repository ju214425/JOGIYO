package com.example.JOGIYO.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping()
public class DataController {
    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping(value = "/data")
    public ResponseEntity<List<DataDomain>> selectAll() {
        List<DataDomain> dataDomainList = this.dataService.getDataDomains();
        return new ResponseEntity<>(dataDomainList, HttpStatus.OK);
    }

    @GetMapping(value = "/data/{id}")
    public ResponseEntity<DataDomain> select(@PathVariable(name = "id") Long id) {
        DataDomain dataDomain = this.dataService.getDataDomain(id);
        return new ResponseEntity<>(dataDomain, HttpStatus.OK);
    }

    @PostMapping(value = "/data")
    @ResponseBody
    public ResponseEntity<DataDomain> create(@RequestBody DataDomain form) {
        DataDomain dataDomain1 = new DataDomain();
        dataDomain1.setTitle(form.getTitle());
        dataDomain1.setPrice(form.getPrice());
        dataDomain1.setDate(LocalDateTime.now());

        dataService.saveDataDomain(dataDomain1);

        return new ResponseEntity<>(dataDomain1, HttpStatus.OK);
    }

    @PutMapping(value = "/data/{id}")
    public ResponseEntity<DataDomain> update(@PathVariable(name = "id") Long id, @RequestBody DataDomain form) {
        DataDomain dataDomain1 = new DataDomain();
        dataDomain1.setId(id);
        dataDomain1.setTitle(form.getTitle());
        dataDomain1.setPrice(form.getPrice());
        dataDomain1.setDate(LocalDateTime.now());

        DataDomain updatedMember = dataService.updateDataDomain(dataDomain1);

        return new ResponseEntity<>(updatedMember, HttpStatus.OK);
    }

    @DeleteMapping(value = "/data/{id}")
    public ResponseEntity<Long> delete(@PathVariable(name = "id") Long id) {
        dataService.deleteDataDomain(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
