package com.vo;

import com.utils.JSONField;

public class InBDScorVo {
	
	@JSONField(key = "trns_clss", length =  2 , TrnsClssYN = true , pkYN = true )
	private String TRNS_CLSS;
	@JSONField(key = "appl_dt",   length =  8 , pkYN = true )
	private String APPL_DT;
	@JSONField(key = "cust_no",   length =  6 , pkYN = true )
	private String CUST_NO;
	@JSONField(key = "loan_amt",  length = 13 )
	private long   LOAN_AMT;

	// ----------------------------------------------------------------------
	// Getter
	// ----------------------------------------------------------------------
	public String getTRNS_CLSS() {
		return TRNS_CLSS;
	}
	public String getAPPL_DT()   {
		return APPL_DT;
	}
	public String getCUST_NO()   {
		return CUST_NO;
	}
	public long   getLOAN_AMT()  {
		return LOAN_AMT;
	}
	
	// ----------------------------------------------------------------------
	// Setter
	// ----------------------------------------------------------------------
	public void setTRNS_CLSS(String trns_clss) {
		this.TRNS_CLSS = trns_clss;
	}
	public void setAPPL_DT(String appl_dt)     {
		this.APPL_DT = appl_dt;
	}
	public void setCUST_NO(String cust_no)     {
		this.CUST_NO = cust_no;
	}
	public void setLOAN_AMT(long loan_amt)     {
		this.LOAN_AMT = loan_amt;
	}
}
