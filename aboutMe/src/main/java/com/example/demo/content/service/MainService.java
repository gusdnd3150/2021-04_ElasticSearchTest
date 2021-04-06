package com.example.demo.content.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.content.dao.MainDAO;

@Service
public class MainService {

	@Autowired
	MainDAO dao;
}
