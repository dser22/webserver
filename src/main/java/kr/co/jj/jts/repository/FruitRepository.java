package kr.co.jj.jts.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import kr.co.jj.jts.model.Fruit;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

}
