package kr.co.jj.jts.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jj.jts.model.Fruit;
import kr.co.jj.jts.repository.FruitRepository;

@Service // 현재 클래스가 비즈니스 로직을 담당하는 것을 표기
public class FruitServiceImpl implements FruitService{
	@Autowired
	private FruitRepository fruitRepository;
	
	@Override
	public List<Fruit> findAll(){
		List<Fruit> fs = new ArrayList<>();
		// Repository를 통해서 데이터 가져오기
		fruitRepository.findAll().forEach(e -> fs.add(e));
		return fs;
	}
	
	@Override
	public Fruit save(Fruit fru) {
		// 실제로 Repository를 이용하여 데이터 저장
		fruitRepository.save(fru);
		return fru;
	}
	
	@Override
	public Fruit findById(int idx) {
		Fruit fru = new Fruit();
		return fruitRepository.findById(idx).orElse(null);
	}
	
	@Override
	public void delete(int idx) {
		fruitRepository.deleteById(idx);
	}
}
