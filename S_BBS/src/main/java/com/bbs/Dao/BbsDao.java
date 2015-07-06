package com.bbs.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bbs.Domain.BbsVo;

public interface BbsDao {
	List<BbsVo> getAllBbs();
	List<BbsVo> getRowBbs(int pageNum);
	List<BbsVo> getSearchBbs(String SEARCH_TYPE,String KEYWORD);
	void addBbs(BbsVo bbs);
	void deleteBbs(int BBS_NUM);
	void deleteAllBbs();
	int countAllBbs();
	int countAllSearchBbs(String SEARCH_TYPE,String KEYWORD);
	BbsVo getBbs(int BBS_NUM);
	void incre_Readcount(int BBS_NUM);
	void updateBbs(BbsVo bbs);
	void AddReply(BbsVo bbs);
}

