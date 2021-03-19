package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.ISBN;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
@Entity
public class Book{
//	private int id;
//	private String last_name;
//	private String first_name;
//	private String gender;
//	private String hobby;
//	private LocalDateTime insert_time;
//	private Map<String, Long> countMap;
//
//	public void setCountMap(Map<String, Long> countMap){
//        this.countMap = countMap;
//    }
//	public Map<String, Long> getCountMap(){
//        return countMap;
//    }
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message="ISBNコードは必ず入力してください。")
    @ISBN(message="ISBNコードは17桁（ハイフン込み）で入力してください。")
    @Column(name = "isbn", nullable = false)
    private String isbn;

    @NotBlank
    @Size(max=100)
    @Column(name = "title", nullable = true)
    private String title;

    @Min(0)
    //@IsHigher
    @Column(name = "price", nullable = false)
    private int price;

    //@Include(list= {"翔泳社", "技術評論社", "SBクリエイティブ"})
    @Column(name = "publisher", nullable = false)
    private String publisher;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "published", nullable = false)
    private LocalDate published;

    @Column(name = "attach", nullable = true)
    public String attach;

}
