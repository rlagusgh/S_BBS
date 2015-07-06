package com.bbs.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.Dao.BbsDaoImpl;
import com.bbs.Domain.BbsVo;

@Service(value="bbsService")
public class BbsService {
	@Resource(name="bbsDaoImpl")
	BbsDaoImpl bbsDao;
	
	public Map<String,Object> RowPrintService(String SEARCH_TYPE,String KEYWORD,int PAGENUM){
		int page_count = 0;
		int start_pageNum = 0;
		int end_pageNum = 0;
		int max_page = 0;
		
		List<BbsVo> bbs = null;
		List<BbsVo> search_list = null;
		Map<String,Object> map = new HashMap<String, Object>();
		
		if(SEARCH_TYPE == null){
			page_count = bbsDao.countAllBbs();
			
			//검색 안했을경우
			search_list = bbsDao.getAllBbs();
			//게시물 없을때
			if(search_list.size() == 0){
				bbs = new ArrayList<BbsVo>();
			}else{
				//게시물 있을때.
				if(search_list.subList(((PAGENUM-1)*10), search_list.size()).size()<10){
					//row가 5개 미만일경우
					bbs = search_list.subList(((PAGENUM-1)*10), search_list.size());
				}else{
					//row가 5개일경우
					bbs = search_list.subList(((PAGENUM-1)*10), PAGENUM*10);
				}
			}
		}else{
			page_count = bbsDao.countAllSearchBbs(SEARCH_TYPE, KEYWORD);
			//검색 했을때
			search_list = bbsDao.getSearchBbs(SEARCH_TYPE, KEYWORD);
			//5개 씩 끊어서
			if(search_list.size() == 0){
				//검색 결과 없을떄
				bbs = new ArrayList<BbsVo>();
			}else{
				//검색 결과 있을때
				if(search_list.subList(((PAGENUM-1)*10), search_list.size()).size()<5){
					//row가 5개 미만일경우
					bbs = search_list.subList(((PAGENUM-1)*10), search_list.size());
				}else{
					//row가 5개일경우
					bbs = search_list.subList(((PAGENUM-1)*10), PAGENUM*10);
				}
			}
		}//
		
		if(page_count%10 == 0)
			max_page = (page_count/10);
		else
			max_page = (page_count/10)+1;
		
		start_pageNum = (((PAGENUM-1)/10)*10) + 1;
		end_pageNum = (((PAGENUM-1)/10)+1)*10;
		
		if(max_page<end_pageNum)
			end_pageNum = max_page;
		
		map.put("BBS", bbs);
		map.put("START_PAGENUM", start_pageNum);
		map.put("END_PAGENUM", end_pageNum);
		map.put("MAX_PAGE", max_page);
		map.put("SEARCH_TYPE", SEARCH_TYPE);
		map.put("KEYWORD", KEYWORD);
		
		return map;
	}
	
	public void addBbs(BbsVo bbs){
		this.bbsDao.addBbs(bbs);
	}
	
	public BbsVo Read_Bbs(int BBS_NUM){
		this.bbsDao.incre_Readcount(BBS_NUM);
		
		return bbsDao.getBbs(BBS_NUM);
	}
	
	public boolean Check_Pass(int BBS_NUM,String password){
		String get_pass = bbsDao.getBbs(BBS_NUM).getPASSWORD();
		
		if(get_pass.equals(password)){
			return true;
		}else{
			return false;
		}
	}
	
	public void Delete(int BBS_NUM){
		this.bbsDao.deleteBbs(BBS_NUM);
	}
	
	public void Update(BbsVo bbs){
		this.bbsDao.updateBbs(bbs);
	}
	
	public void Reply(BbsVo bbs){
		this.bbsDao.AddReply(bbs);
	}
}
