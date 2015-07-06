package com.bbs.Domain;

public class BbsVo {
	int BBS_NUM;
	String NAME;
	String PASSWORD;
	String TITLE;
	String EMAIL;
	String CONTENTS;
	String CRE_DATE;
	int READCOUNT;
	
	public BbsVo() {
		super();
	}

	public BbsVo(String nAME, String pASSWORD, String tITLE, String eMAIL,
			String cONTENTS) {
		super();
		NAME = nAME;
		PASSWORD = pASSWORD;
		TITLE = tITLE;
		EMAIL = eMAIL;
		CONTENTS = cONTENTS;
	}

	public BbsVo(int bBS_NUM, String nAME, String pASSWORD, String tITLE,
			String eMAIL, String cONTENTS, String cRE_DATE, int rEADCOUNT) {
		super();
		BBS_NUM = bBS_NUM;
		NAME = nAME;
		PASSWORD = pASSWORD;
		TITLE = tITLE;
		EMAIL = eMAIL;
		CONTENTS = cONTENTS;
		CRE_DATE = cRE_DATE;
		READCOUNT = rEADCOUNT;
	}

	public int getBBS_NUM() {
		return BBS_NUM;
	}

	public BbsVo setBBS_NUM(int bBS_NUM) {
		BBS_NUM = bBS_NUM;
		return this;
	}

	public String getNAME() {
		return NAME;
	}

	public BbsVo setNAME(String nAME) {
		NAME = nAME;
		return this;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public BbsVo setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
		return this;
	}

	public String getTITLE() {
		return TITLE;
	}

	public BbsVo setTITLE(String tITLE) {
		TITLE = tITLE;
		return this;
	}

	public String getCONTENTS() {
		return CONTENTS;
	}

	public BbsVo setCONTENTS(String cONTENTS) {
		CONTENTS = cONTENTS;
		return this;
	}

	public String getCRE_DATE() {
		return CRE_DATE;
	}

	public BbsVo setCRE_DATE(String cRE_DATE) {
		CRE_DATE = cRE_DATE;
		return this;
	}

	public int getREADCOUNT() {
		return READCOUNT;
	}

	public BbsVo setREADCOUNT(int rEADCOUNT) {
		READCOUNT = rEADCOUNT;
		return this;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
}
