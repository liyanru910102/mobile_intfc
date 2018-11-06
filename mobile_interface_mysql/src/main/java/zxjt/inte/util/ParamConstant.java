package zxjt.inte.util;

/**
 * 常量
 * 
 * @author Administrator
 *
 */
public interface ParamConstant {

	/**
	 * ************************************************************
	 * ***********************正反例标识 **************************
	 **********************************************************/
	public static final String ZL = "zl";
	public static final String FL = "fl";

	/**
	 * ************************************************************
	 * ***********************大业务分类 **************************
	 **********************************************************/
	public static final String PTYW = "PTYW";
	public static final String RZRQ = "RZRQ";
	public static final String WW = "WW";

	/**
	 * ************************************************************
	 * ****************json schema文件的名称 **************************
	 **********************************************************/
	public static final String SCHEMA_ZL = "_schema";
	public static final String SCHEMA_FL = "fail_schema";
	public static final String A00_SCHEMA = "普通交易_普通业务_客户校验";
	public static final String A01_SCHEMA = "普通交易_普通业务_委托下单";
	public static final String A01_1_SCHEMA = "普通交易_普通业务_可买卖数量查询";
	public static final String A01_2_SCHEMA = "普通交易_普通业务_市价可买卖数量查询";
	public static final String W06_SCHEMA = "代码云查询";
	public static final String W00_SCHEMA = "自选股行情查询";
	public static final String W01_SCHEMA = "代码链查询";
	public static final String W02_SCHEMA = "板块排行";
	public static final String W03_SCHEMA = "股票排行";
	public static final String W04_SCHEMA = "板块排行索引";
	public static final String W05_SCHEMA = "个股综合";
	public static final String B00_SCHEMA = "沪深港股通_普通业务_持仓查询";
	public static final String B01_SCHEMA = "沪深港股通_普通业务_交易状态信息查询";
	public static final String B02_SCHEMA = "沪深港股通_普通业务_可买卖数量查询";
	public static final String B03_SCHEMA = "沪深港股通_普通业务_资金查询";
	public static final String B04_SCHEMA = "沪深港股通_普通业务_当日委托查询";
	public static final String B05_SCHEMA = "沪深港股通_普通业务_当日成交查询";
	public static final String B06_SCHEMA = "沪深港股通_普通业务_历史委托查询";
	public static final String B07_SCHEMA = "沪深港股通_普通业务_历史成交查询";
	public static final String B08_SCHEMA = "沪深港股通_普通业务_委托下单";
	public static final String B09_SCHEMA = "沪深港股通_普通业务_委托撤单";

	/**
	 * ************************************************************
	 * ***********************url对应的ID号 **************************
	 **********************************************************/
//	public static final int GPMM_ID = 4885;
	public static final int GPMM_ID = 965;
	public static final int KMMXXCX_ID = 986;
//	public static final int KMMXXCX_ID = 4906;
	public static final int SJKMMXXCX_ID = 1007;
//	public static final int SJKMMXXCX_ID = 5102;
//	public static final int PTJYLOGIN_ID = 4899;
	public static final int PTJYLOGIN_ID = 979;
	
	public static final int HQZXGHQ_ID = 5487;
	public static final int DML_ID = 5488;
	public static final int BKPH_ID = 5489;
	public static final int GPPH_ID = 5490;
	public static final int BKPHINDEX_ID = 5491;
	public static final int GGZH_ID = 5492;
	public static final int YCX_ID = 5493;	
	
	public static final int HSGGT_CCCX_ID = 4715;
	public static final int HSGGT_JYZTXXCX_ID = 4753;
	public static final int HSGGT_KMMSLCX_ID = 4716;
	public static final int HSGGT_ZJCX_ID = 4723;
	public static final int HSGGT_DRWTCX_ID = 4726;
	public static final int HSGGT_DRCJCX_ID = 4730;
	public static final int HSGGT_LSWTCX_ID = 4728;
	public static final int HSGGT_LSCJCX_ID = 4736;
	public static final int HSGGT_WTXD_ID = 4713;
	public static final int HSGGT_WTCD_ID = 4721;

	/**
	 * ************************************************************
	 * ***********************其他用到的自定义参数 **************************
	 **********************************************************/
	public static final String MESSAGE = "message";
	public static final String VALIDATEPARAM = "validateParam";
	public static final String MEHTOD = "method";
	public static final String LOGGER = "zxjtInterface";
	public static final String URL = "url";
	public static final String ONEMONTH = "一个月内";
	public static final String THREEMONTH = "三个月内";
	
	

	/**
	 * ************************************************************
	 * ***********************自选股查询/股票排行的参数**************************
	 **********************************************************/
	public static final String PSZCODES = "pszCodes";
	public static final String MARKETLIST = "marketList";
	public static final String WTYPE = "wType";
	public static final String BSORT = "bSort";
	public static final String BDIRECT = "bDirect";
	public static final String WFROM = "wFrom";
	public static final String WCOUNT = "wCount";
	public static final String FIELDSBITMAP = "fieldsBitMap";
	public static final String WTOTALCOUNT = "wTotalCount";
	public static final String BLOCKCLASSNAME = "blockClassName";

	public static final String MARKETID = "marketID";
	public static final String STOCK_CODE = "stock_code";
	public static final String STOCK_NAME = "stock_name";
	public static final String NZRSP = "nZrsp";
	public static final String NJRKP = "nJrkp";
	public static final String NZJCJ = "nZjcj";
	public static final String NZD = "nZd";
	public static final String NZDF = "nZdf";
	public static final String BSUSPENDED = "bSuspended";
	public static final String NRQSJ = "nRqSj";
	public static final String NLIMUP = "nLimUp";
	public static final String NLIMDOWN = "nLimDown";
	public static final String BLOCKID = "blockID";
	public static final String BLOCKNAME = "blockName";
	public static final String IS_GGT_OBJECT = "is_ggt_object";

	 public static final String NZGCJ ="nZgcj";
	 public static final String NZDCJ ="nZdcj";
	 public static final String NCJSS ="nCjss";
	 public static final String NZF ="nZf";
	 public static final String NCJJE ="nCjje";
	 public static final String NLB ="nLb";
	 public static final String N5MIN ="n5Min";
	 public static final String NHSL ="nHsl";
	 public static final String NSYL ="nSyl";
	 public static final String DATAARR_WTYPE ="dataArr_wType";
	 
	 
	// public static final int nBjg1 =nBjg1;
	// public static final int nSjg1 =nSjg1;
	// public static final int nBsl1 =nBsl1;
	// public static final int nSsl1 =nSsl1;
	//
	
	
	//
	
	
	// public static final String new_name =new_name;
	// public static final int wStockStatus =wStockStatus;
	// public static final int wZjs =wZjs;
	// public static final int wDjs =wDjs;
	// public static final int wPjs =wPjs;
	// public static final int nLTP =nLTP;
	// public static final int nZSZ =nZSZ;
	//
	// public static final int ExercisePrice =ExercisePrice;
	// public static final int TotalLongPosition =TotalLongPosition;
	// public static final int cangCha =cangCha;
	// public static final int ContractMultiplierUn=;
	// public static final int SurplusDays =;
	// public static final String option_flag =;

	// public static final int wCYDZS =;

	// public static final int blockZDF =;
	// public static final int week_num =;
	// public static final String repurchase_name =;
	// public static final int APY =;
	// public static final int earnings =;

	/**
	 * ************************************************************
	 * ***********************不同业务的urlkey值**************************
	 **********************************************************/
	public static final String SAFEURL = "httpsurl";
	public static final String UNSAFEURL = "httpurl";

	/**
	 * ************************************************************
	 * ***********************代码链/全市场代码表查询用到的入参**************************
	 **********************************************************/
	public static final String VERSION = "version";
	public static final String UUIDVERSION = "uuidVersion";
	public static final String MARKET_ID = "market_id";
	public static final String CODE_TYPE = "code_type";
	public static final String CODELIST_ADD_REPEATED_CODE = "codeList_add_repeated_code";
	public static final String PINYIN = "pinyin";
	public static final String PSZMARK = "pszMark";
	public static final String NAME = "name";
	public static final String CODELIST_DEL_REPEATED_CODE = "codeList_del_repeated_code";

	/**
	 * ************************************************************
	 * ***********************板块排行查询用到的入参**************************
	 **********************************************************/
	public static final String FZDF = "fZdf";
	public static final String SCODE = "sCode";
	public static final String PSZBKNAME = "pszBkName";
	public static final String SSTOCKCODE = "sStockCode";
	public static final String PSZSTOCKNAME = "pszStockName";
	public static final String FIRST_ZDF = "first_zdf";
	public static final String FIRST_PRICE = "first_price";
	
	
	/**
	 * ************************************************************
	 * ***********************股票排行查询用到的入参**************************
	 **********************************************************/
	public static final String WMARKETID = "wMarketID";
	public static final String SBKCODE = "sBKCode";

	/**
	 * ************************************************************
	 * ***********************个股综合用到的入参**************************
	 **********************************************************/
	// public static final String WMARKETID= "wMarketID";(与股票排行参数一致)
	public static final String SPSZCODE = "sPszCode";
	// public static final String WTYPE= "wType";(与rankoption参数一致)
	// public static final String FIELDSBITMAP= "fieldsBitMap";(与rankoption参数一致)
	public static final String WKXTYPE = "wKXType";
	public static final String DWKXDATE = "dwKXDate";
	public static final String DWKXTIME = "dwKXTime";
	public static final String WKXCOUNT = "wKXCount";
	public static final String WFQTYPE = "wFQType";
	public static final String REQNEWKLINES = "reqNewKlines";
	public static final String DWFSDATE = "dwFSDate";
	public static final String DWFSTIME = "dwFSTime";
	public static final String COUNT = "count";
	
	 public static final String BLOCKZDF ="blockZDF";
	 public static final String MA_PRICE ="ma_price";
	 public static final String WB ="wb";
	 public static final String WC ="wc";
	 public static final String JZC ="jzc";
	 public static final String SJL ="sjl";
	 public static final String SY ="sy";
	 public static final String QUARTER ="quarter";
	 public static final String LTG ="ltg";
	 public static final String SYLJ ="sylj";
	 public static final String ZGB ="zgb";
	 public static final String NMAXVOL ="nMaxVol";
	 public static final String NTIME ="nTime";
	 public static final String TIMEDIVISION_NZJCJ ="timeDivision_nZjcj";
	 public static final String TIMEDIVISION_NZDF ="timeDivision_nZdf";
	 public static final String NCJJJ ="nCjjj";
	 public static final String NDATE ="nDate";
	 public static final String NBUYP ="nBuyp";
	 public static final String NSELP ="nSelp";
	 public static final String DWTIME ="dwTime";
	 public static final String BCJLB ="bCjlb";
	 public static final String TRADEDETAIL_NZJCJ ="tradeDetail_nZjcj";
	 public static final String TRADEDETAIL_NCJSS ="tradeDetail_nCjss";

	/**
	 * ************************************************************
	 * ***********************正则表达式的参数**************************
	 **********************************************************/
	public static final String REGEXBEGIN = "^";
	public static final String REGEXEND = "$";
	
	/**
	 * ************************************************************
	 * ***********************沪深港股通的参数**************************
	 **********************************************************/
	public static final String SGT = "9";
	public static final String HGT = "6";
	public static final String B = "B";
	public static final String S = "S";
	
	public static final String JYSDM = "jysdm";
	public static final String ZQDM = "zqdm";
	public static final String WTLX = "wtlx";
	public static final String YYBDM = "yybdm";
	public static final String QSRQ = "qsrq";
	public static final String ZZRQ = "zzrq";
	public static final String WTRQ = "wtrq";
	public static final String CJRQ = "cjrq";
	public static final String GDDM = "gddm";
	public static final String WTJG = "wtjg";
	public static final String MMLB = "mmlb";
	public static final String WTSX = "wtsx";
	public static final String WTSL = "wtsl";
	public static final String EXPECTMSG = "expectMsg";
	public static final String WTXH = "wtxh";
	public static final String TYPE = "type";
	public static final String GGTMM_KEY = "港股通买卖";
	
	
	public static final String KMMXX_JYSDM = "kmmxx_jysdm";
	public static final String KMMXX_ZQDM = "kmmxx_zqdm";
	public static final String KMMXX_KMSL = "kmmxx_kmsl";
	public static final String CXLB_GXRQ = "cxlb_gxrq";
	public static final String ZJLB_YYBDM = "zjlb_yybdm";
	public static final String CXLB_WTRQ = "cxlb_wtrq";
	
	public static final String KMSL_S = "^$|^[0-9]+$";
	public static final String KMSL_H = "^[0-9]+$";

}
