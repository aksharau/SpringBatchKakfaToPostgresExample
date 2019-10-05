package com.example.sprbatch.step;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.batch.item.ItemWriter;

import com.example.sprbatch.dao.CycleInstanceDao;
import com.example.sprbatch.model.CycleInstance;

public class Writer implements ItemWriter<CycleInstance>{
	
	private final CycleInstanceDao cycleInstanceDao;

	public Writer(CycleInstanceDao cycleInstanceDao) {
		// TODO Auto-generated constructor stub
		this.cycleInstanceDao = cycleInstanceDao;
	}
	
	

	
	public void write(List<? extends CycleInstance> cycleinstances) throws Exception {
		try {
		//remove the cycleinstances that have default values, due to parse errors
			final List<CycleInstance> cycleinstancesNew = new ArrayList<CycleInstance>();
			cycleinstances.forEach(new Consumer<CycleInstance>() {
				public void accept(CycleInstance item) {
					if(item.getCycleCodeTc()>0)
						cycleinstancesNew.add(item);
				}
			}
					);
			if(!cycleinstancesNew.isEmpty())
				cycleInstanceDao.insert(cycleinstances);
		}
		catch(org.springframework.dao.DuplicateKeyException ex)
		{
			System.out.println("Ignore dupliate key" + ex.getMessage());
		}
		catch(Exception other)
		{
			System.out.println("Other exception caught " + other.getMessage());
			throw other;
		}
	}

}
