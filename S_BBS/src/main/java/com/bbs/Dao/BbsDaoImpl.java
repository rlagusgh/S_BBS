package com.bbs.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.bbs.Domain.BbsVo;

@Repository(value="bbsDaoImpl")
public class BbsDaoImpl implements BbsDao{
	@Resource(name="bbsMapper")
	private BbsMapper bbsMapper;

	@Override
	public List<BbsVo> getAllBbs() {
		return this.bbsMapper.getAllBbs();
	}

	@Override
	public List<BbsVo> getRowBbs(int pageNum) {
		int START_ROW = (pageNum * 5) - 4;
		int END_ROW = pageNum * 5;
		
		return this.bbsMapper.getRowBbs(START_ROW, END_ROW);
	}

	@Override
	public List<BbsVo> getSearchBbs(String SEARCH_TYPE,String KEYWORD) {
		return this.bbsMapper.getSearchBbs(SEARCH_TYPE, KEYWORD);
	}

	@Override
	public void addBbs(BbsVo bbs) {
		this.bbsMapper.addBbs(bbs);
	}

	@Override
	public void deleteBbs(int BBS_NUM) {
		this.bbsMapper.deleteBbs(BBS_NUM);
	}

	@Override
	public void deleteAllBbs() {
		this.bbsMapper.deleteAllBbs();
	}
	
	@Override
	public int countAllBbs() {
		return bbsMapper.countAllBbs();
	}

	@Override
	public int countAllSearchBbs(String SEARCH_TYPE,String KEYWORD) {
		return this.bbsMapper.countAllSearchBbs(SEARCH_TYPE, KEYWORD);
	}

	@Override
	public BbsVo getBbs(int BBS_NUM) {
		return this.bbsMapper.getBbs(BBS_NUM);
	}

	@Override
	public void incre_Readcount(int BBS_NUM) {
		this.bbsMapper.incre_Readcount(BBS_NUM);
	}

	@Override
	public void updateBbs(BbsVo bbs) {
		this.bbsMapper.updateBbs(bbs);
	}

	@Override
	public void AddReply(BbsVo bbs) {
		this.bbsMapper.ReplyUpdate(bbs.getBBS_NUM());
		this.bbsMapper.addReply(bbs);
	}
}
