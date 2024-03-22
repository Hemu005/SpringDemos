package com.insuranceapp.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.insuranceapp.model.AppUser;
@Mapper
public interface IAppUserRepository {
	
    @Insert("insert into appuser values(#{userId},#{userName},#{password},#{email})")
	void addUser(AppUser appUser);
	@Select("select * from appuser where username=#{userName}")
	AppUser findByUsername(String username);
}
