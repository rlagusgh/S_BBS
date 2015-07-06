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
				new BbsVo("�̸�1","1234","����1","����1"),
				new BbsVo("�̸�2","1234","����2","����2"),
				new BbsVo("�̸�3","1234","����3","����3"),
				new BbsVo("�̸�4","1234","����4","����4")
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
			System.out.println("��ȣ:"+bbs.getBBS_NUM()+" �̸�:"+bbs.getNAME()+" ����:"+bbs.getTITLE()+" ����:"+bbs.getCONTENTS());
	}
	
	@Test
	public void SearchTest(){
		bbsDao.deleteAllBbs();
		
		for(BbsVo bbs : boards)
			bbsDao.addBbs(bbs);
		
		List<BbsVo> getBoards = bbsDao.getSearchBbs("NAME", "�̸�4");
		
		for(BbsVo bbs:getBoards)
			System.out.println("��ȣ:"+bbs.getBBS_NUM()+" �̸�:"+bbs.getNAME()+" ����:"+bbs.getTITLE()+" ����:"+bbs.getCONTENTS());
	}*/
	
	@Test
	public void MockTest(){
		String first[] = {"��","��","��","��","��","��","��","��","��","��","��","��","��","��"};
		String last[] = {"��ȣ","����","����","����","�뼺","����","�μ�","����","����","�ο�"};
		BbsVo bbs;
		
		for(int i=0;i<14;i++)
			for(int j=0;j<10;j++){
				bbs = new BbsVo(first[i]+last[j],"1234",first[i]+last[j]+"�� �Խù�","Test@test.com",
						"���� �����ϴ�.");
				this.bbsDao.addBbs(bbs);
			}
	}
	
}
