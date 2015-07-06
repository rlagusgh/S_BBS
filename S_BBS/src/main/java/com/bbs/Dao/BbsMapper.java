package com.bbs.Dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.bbs.Domain.BbsVo;

@Repository(value="bbsMapper")
public interface BbsMapper {
	List<BbsVo> getAllBbs();
	List<BbsVo> getRowBbs(@Param("START_ROW")int START_ROW,@Param("END_ROW")int END_ROW);
	List<BbsVo> getSearchBbs(@Param("SEARCH_TYPE")String SEARCH_TYPE,@Param("KEYWORD")String KEYWORD);
	void addBbs(BbsVo bbs);
	void addReply(BbsVo bbs);
	void deleteBbs(int BBS_NUM);
	void deleteAllBbs();
	int countAllBbs();
	int countAllSearchBbs(@Param("SEARCH_TYPE")String SEARCH_TYPE,@Param("KEYWORD")String KEYWORD);
	BbsVo getBbs(int BBS_NUM);
	void incre_Readcount(int BBS_NUM);
	void updateBbs(BbsVo bbs);
	void ReplyUpdate(int BBS_NUM);
}
