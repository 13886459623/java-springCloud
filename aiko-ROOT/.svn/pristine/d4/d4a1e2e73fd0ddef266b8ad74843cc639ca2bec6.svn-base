package com.ycb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import chinapay.util.CommonUtil;
import com.ycb.domain.config_b;
import com.ycb.mapper.config_bMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ycb.domain.config_a;
import com.ycb.mapper.config_aMapper;

@Service
@Transactional
public class ConfigService {
	@Autowired
	private config_aMapper configADao;

	@Autowired
	private config_bMapper configBDao;

	/**
	 *	分页
	 * @param params      查询条件
	 * @param currentPage 当前页码
	 * @param pageSize    每页记录数
	 * @return            
	 */
	public List<config_a> getConfigAList(Map<String,Object> params,int cPage,int pSize){
		params.put("cPage", cPage);
		params.put("pSize", pSize);
		return configADao.getConfigAList(params);
	}

	/**
	 *	分页
	 * @param params      查询条件
	 * @param currentPage 当前页码
	 * @param pageSize    每页记录数
	 * @return
	 */
	public List<config_b> getConfigBList(Map<String,Object> params, int cPage, int pSize){
		params.put("cPage", cPage);
		params.put("pSize", pSize);
		return configBDao.getConfigBList(params);
	}

	public int getConfigACount(){
		return configADao.getConfigACount();
	}

	public int getConfigBCount(){
		return configBDao.getConfigBCount();
	}

	public void updateCondigA(Map<String,Object> map){
		configADao.updateByPrimaryKeySelective(map);
	}

	public void updateCondigB(Map<String,Object> map){
		configBDao.updateByPrimaryKeySelective(map);
	}

	public String restartA() throws Exception {
		String result = null;
		List<config_a> variables = configADao.getAvariables();
		String predictpath;
		String elwatchpath = null;
		String predictname = null;
		String elwatchname = null;
		for (config_a config : variables) {
			switch(config.getVariables()){
				case "predictpath":
					predictpath = config.getParameters();
					break;
				case "elwatchpath":
					elwatchpath = config.getParameters();
					break;
				case "predictname":
					predictname = config.getParameters();
					break;
				default:
					elwatchname = config.getParameters();
					break;
			}
		}
		CommonUtil.killExe(predictname);
		if(!CommonUtil.getExeState(elwatchname)){
			result = CommonUtil.openExe(elwatchname,elwatchpath + ".exe");
		}
		return result;
	}

	public String restartB() throws Exception {
		String result = null;
		List<config_b> variables = configBDao.getBvariables();
		String predictpath;
		String elwatchpath = null;
		String predictname = null;
		String elwatchname = null;
		for (config_b config : variables) {
			switch(config.getVariables()){
				case "predictpath":
					predictpath = config.getParameters();
					break;
				case "elwatchpath":
					elwatchpath = config.getParameters();
					break;
				case "predictname":
					predictname = config.getParameters();
					break;
				default:
					elwatchname = config.getParameters();
					break;
			}
		}
		CommonUtil.killExe(predictname);
		if(!CommonUtil.getExeState(elwatchname)){
			result = CommonUtil.openExe(elwatchname,elwatchpath + ".exe");
		}
		return result;
	}

    public List<config_a> getConfigAproduct(){
        return configADao.getConfigAproduct();
    }

    public String updateAProductSwitch(Map<String,Object> map){
		String result = null;
        configADao.updateProductSwitch(map);
		List<config_a> variables = configADao.getAvariables();
		String elwatchpath = null;
		String predictname = null;
		String elwatchname = null;
		for (config_a config : variables) {
			switch(config.getVariables()){
				case "elwatchpath":
					elwatchpath = config.getParameters();
					break;
				case "predictname":
					predictname = config.getParameters();
					break;
				case "elwatchname":
					elwatchname = config.getParameters();
					break;
			}
		}
		result = CommonUtil.killExe(predictname);
		try {
			if(!CommonUtil.getExeState(elwatchname)){
				result = CommonUtil.openExeByDos(elwatchname,elwatchpath + ".exe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	public String updateBProductSwitch(Map<String,Object> map){
		String result = null;
		configBDao.updateProductSwitch(map);
		List<config_b> variables = configBDao.getBvariables();
		String elwatchpath = null;
		String predictname = null;
		String elwatchname = null;
		for (config_b config : variables) {
			switch(config.getVariables()){
				case "elwatchpath":
					elwatchpath = config.getParameters();
					break;
				case "predictname":
					predictname = config.getParameters();
					break;
				case "elwatchname":
					elwatchname = config.getParameters();
					break;
			}
		}
		result = CommonUtil.killExe(predictname);
		try {
			if(!CommonUtil.getExeState(elwatchname)){
				result = CommonUtil.openExeByDos(elwatchname,elwatchpath + ".exe");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<config_b> getConfigBproduct(){
		return configBDao.getConfigBproduct();
	}
}
