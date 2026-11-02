package kr.co.jj.jts.service;
import java.util.List;
import kr.co.jj.jts.model.Fruit;

public interface FruitService{
	List<Fruit> findAll();
	
	Fruit save(Fruit fru);
	
	Fruit findById(int idx);
	
	void delete(int idx);
}
