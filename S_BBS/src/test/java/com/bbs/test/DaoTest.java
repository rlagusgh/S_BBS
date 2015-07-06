package com.bbs.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bbs.Dao.BbsDaoImpl;
import com.bbs.Domain.BbsVo;
import com.bbs.Service.BbsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class DaoTest {
	@Resource(name="bbsDaoImpl")
	BbsDaoImpl bbsDao;
	
	@Resource(name="bbsService")
	BbsService service;
	
	/*List<BbsVo> boards;
	
	@Before
	public void setUp(){
		boards = Arrays.asList(
				new BbsVo("이름1","1234","제목1","내용1"),
				new BbsVo("이름2","1234","제목2","내용2"),
				new BbsVo("이름3","1234","제목3","내용3"),
				new BbsVo("이름4","1234","제목4","내용4")
				);
	}
	
	@Test
	public void AddBbsTest(){
		bbsDao.deleteAllBbs();
		
		for(BbsVo bbs : boards)
			bbsDao.addBbs(bbs);
	}
	
	@Test
	public void getAllBbs(){
		bbsDao.deleteAllBbs();
		
		for(BbsVo bbs : boards)
			bbsDao.addBbs(bbs);
		
		List<BbsVo> getBoards = bbsDao.getAllBbs();
		
		for(BbsVo bbs:getBoards)
			System.out.println("번호:"+bbs.getBBS_NUM()+" 이름:"+bbs.getNAME()+" 제목:"+bbs.getTITLE()+" 내용:"+bbs.getCONTENTS());
	}
	
	@Test
	public void SearchTest(){
		bbsDao.deleteAllBbs();
		
		for(BbsVo bbs : boards)
			bbsDao.addBbs(bbs);
		
		List<BbsVo> getBoards = bbsDao.getSearchBbs("NAME", "이름4");
		
		for(BbsVo bbs:getBoards)
			System.out.println("번호:"+bbs.getBBS_NUM()+" 이름:"+bbs.getNAME()+" 제목:"+bbs.getTITLE()+" 내용:"+bbs.getCONTENTS());
	}*/
	
	@Test
	public void MockTest(){
		String first[] = {"김","이","박","최","정","강","조","윤","장","임","오","한","신","서"};
		String last[] = {"현호","지섭","지성","찬성","대성","석준","민석","현석","대준","민우"};
		BbsVo bbs;
		
		for(int i=0;i<14;i++)
			for(int j=0;j<10;j++){
				bbs = new BbsVo(first[i]+last[j],"1234",first[i]+last[j]+"의 게시물","Test@test.com",
						"내용 없습니다.");
				this.bbsDao.addBbs(bbs);
			}
	}
	
}
