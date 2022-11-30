package com.kindsonthegenius.fleetmvsv2.fleet.models;

import com.kindsonthegenius.fleetmvsv2.parameters.models.CommonObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class VehicleModel extends CommonObject {

}