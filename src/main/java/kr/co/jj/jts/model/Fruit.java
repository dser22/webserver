package kr.co.jj.jts.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="fruit")
@AllArgsConstructor // 자바클래스에서 선언한 모든 속성값을 파라미터로 받는 생성자 자동 생성
@NoArgsConstructor // 자바클래스에서 어떤 파라미터도 받지 않는 생성자 자동 생성
@Data		// 자바클래스 속성에 대한 setter와 getter 메소드 자동 생성
public class Fruit implements Serializable{
	// Serializable(직렬화) : 자바의 객체 또는 데이터 등을 외부 시스템에서도 사용할 수 있도록 바이트 형식으로 변환하는 메커니즘
	private static final long serialVersionUID = 1L;
	@Id		// table의 Primary key와 매핑하는 자바 속성에 선언
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer idx;
	public String fname;
	public String fengname;
	public Integer fkcal;
	public String fcontents;
	public LocalDateTime regdate= LocalDateTime.now();

	public void setIdx(Integer idx) {this.idx = idx;}	
	public Integer getIdx() { return idx;}	
	public void setFname(String fname) {this.fname = fname;}	
	public String getFname() { return fname;}	
	public void setFengname(String fengname) {this.fengname = fengname;}	
	public String getFengname() { return fengname;}	
	public void setFkcal(Integer fkcal) {this.fkcal = fkcal;}	
	public Integer getFkcal() { return fkcal;}	
	public void setFcontents(String fcontents) {this.fcontents = fcontents;}	
	public String getFcontents() { return fcontents;}
	public void setRegdate(LocalDateTime regdate) { this.regdate = regdate;}
	public LocalDateTime getRegdate() { return regdate;}
}