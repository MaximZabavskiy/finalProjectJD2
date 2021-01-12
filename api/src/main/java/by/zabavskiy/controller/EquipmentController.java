package by.zabavskiy.controller;

import by.zabavskiy.controller.request.EquipmentCreateRequest;
import by.zabavskiy.controller.request.EquipmentEditRequest;
import by.zabavskiy.domain.CurrentStatus;
import by.zabavskiy.domain.Equipment;
import by.zabavskiy.service.EquipmentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    private final CacheManager cacheManager;


    @ApiOperation(value = "Endpoint \"All equipment's search\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Auth-Token", defaultValue = "token", required = true, paramType = "header", dataType = "string"),
    })
    @GetMapping
    public ResponseEntity<List<Equipment>> findAllEquipment() {

        return new ResponseEntity<>(equipmentService.findAll(), HttpStatus.OK);
    }


    @ApiOperation(value = "Endpoint \"Equipment's search by id\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @GetMapping("/{id}")
    public ResponseEntity<Equipment> findEquipmentById(@PathVariable Long id) {

        return new ResponseEntity<>(equipmentService.findById(id), HttpStatus.OK);
    }


    @ApiOperation(value = "Endpoint \"Equipment's creation\"")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipment createEquipment(@RequestBody EquipmentCreateRequest equipmentCreateRequest) {

        Equipment equipment = new Equipment();
        equipment.setClothes(equipmentCreateRequest.getClothes());
        equipment.setShoes(equipmentCreateRequest.getShoes());
        equipment.setBeverage(equipmentCreateRequest.getBeverage());
        equipment.setCleanser(equipmentCreateRequest.getCleanser());
        equipment.setCreated(new java.sql.Timestamp(new Date().getTime()));
        equipment.setChanged(new java.sql.Timestamp(new Date().getTime()));

        CurrentStatus currentStatus = new CurrentStatus();
        currentStatus.setBlocked(false);
        equipment.setCurrentStatus(currentStatus);

        return equipmentService.save(equipment);
    }


    @ApiOperation(value = "Endpoint \"Equipment's update\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipment updateEquipmnet(@RequestBody EquipmentEditRequest equipmentEditRequest) {

        Equipment equipment = equipmentService.findById(equipmentEditRequest.getId());
        equipment.setClothes(equipmentEditRequest.getClothes());
        equipment.setShoes(equipmentEditRequest.getShoes());
        equipment.setBeverage(equipmentEditRequest.getBeverage());
        equipment.setCleanser(equipmentEditRequest.getCleanser());
        equipment.setChanged(new java.sql.Timestamp(new Date().getTime()));

        return equipmentService.save(equipment);
    }


    @ApiOperation(value = "Endpoint \"Equipment's deletion\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @PutMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEquipmentById(@PathVariable Long id) {

        equipmentService.deleteById(id);
    }


    @ApiOperation(value = "Endpoint \"Equipment's caches info\"",
            authorizations = {@Authorization(value = "jwtToken")})
    @GetMapping("/caches")
    public ResponseEntity<Object> getCachesInfo() {

        return new ResponseEntity<>(String.join(",", cacheManager.getCacheNames()), HttpStatus.OK);
    }
}