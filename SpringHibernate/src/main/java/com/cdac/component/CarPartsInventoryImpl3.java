package com.cdac.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("CarParts3")
public class CarPartsInventoryImpl3 implements CarPartsInventory {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void addNewPart(CarPart carPart) {
		em.persist(carPart);
	}
	
	public List<CarPart> getAvailableParts() {
		// TODO Auto-generated method stub
		return em
				.createQuery("select c from CarPart c", CarPart.class)
				.getResultList();
	}

}
