package com.common.ash.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.common.ash.model.ElectricModel;

@RestController
@RequestMapping("/totalbill")
public class ElectricController {
	@RequestMapping(value="/{initialReading}/{MonthReading}", method=RequestMethod.GET)
	public String validateUser(@PathVariable double initialReading, @PathVariable double MonthReading) {
		ElectricModel electricity = new ElectricModel(initialReading, MonthReading);
		electricity.setTotalBill((electricity.getMonthReading()-electricity.getInitialReading())*ElectricModel.COST_PER_UNIT);
		return "Total Bill : "+electricity.getTotalBill();
	}
}
