package com.zdqk.laobing.dao.impl;


import org.springframework.stereotype.Component;

import com.zdqk.laobing.dao.PhotosDAO;
import com.zdqk.laobing.po.Photos;

@Component("photosDAO")
public class PhotosDAOImpl extends BasicDaoImpl<Photos> implements PhotosDAO<Photos>{

}