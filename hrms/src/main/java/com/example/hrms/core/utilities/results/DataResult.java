package com.example.hrms.core.utilities.results;

public class DataResult<T> extends Result { 
	
	//birden fazla veri tipiyle çalışıyor olabiliriz (ürün,işçi) o yüzden genric çalışıyoruz <T>
	
	private T data;
	public DataResult(T data,boolean success, String message) {
		super(success, message); 
		this.data =data;
		}
	
	public DataResult(T data,boolean success) {
		super(success);
		this.data =data;
		}
	public T getData() {
		return this.data;
	}
	
}
