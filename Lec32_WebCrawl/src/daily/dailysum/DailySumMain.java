package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/53576c67506a736135346359696467/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/53576c67506a736135346359696467/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요

public class DailySumMain {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜입력: ");
		int date = sc.nextInt();
		System.out.println("startIndex: ");
		int startIndex = sc.nextInt();
		System.out.println("endIndex: ");
		int endIndex = sc.nextInt();
		sc.close();

		xmlParse(buildUrl("xml", startIndex, endIndex, date));

		System.out.println();

		jsonParse(buildUrl("json", startIndex, endIndex, date));

	} // end main

	public static String buildUrl(String req, int stin, int endin, int date) {
		String url = String.format(
				"http://openapi.seoul.go.kr:8088/53576c67506a736135346359696467/%s/SPOP_DAILYSUM_JACHI/%d/%d/%d", req,
				stin, endin, date);

		return url;
	}

	public static void xmlParse(String xmlUrl) throws IOException {

		Document doc;
		Elements elements;
		doc = Jsoup.connect(xmlUrl).execute().parse();

		elements = doc.select("SPOP_DAILYSUM_JACHI > row");

//		System.out.println(elements.size());

		System.out.println("날짜구\t  ID\t총생활인구수\t일최대이동인구수");
		System.out.println("--------------------------------------------------");
		for (Element e : elements) {
			String STDR_DE_ID = e.selectFirst("STDR_DE_ID").text().trim();
			String SIGNGU_CODE_SE = e.selectFirst("SIGNGU_CODE_SE").text().trim();
			String TOT_LVPOP_CO = e.selectFirst("TOT_LVPOP_CO").text().trim();
			String DAIL_MXMM_MVMN_LVPOP_CO = e.selectFirst("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();
			System.out
					.println(STDR_DE_ID + "  " + SIGNGU_CODE_SE + "\t" + TOT_LVPOP_CO + "\t" + DAIL_MXMM_MVMN_LVPOP_CO);

		}

	}

	public static void jsonParse(String jsonUrl) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL(jsonUrl);

		Obj obj = mapper.readValue(url, Obj.class);

		System.out.println("날짜구\t  ID\t총생활인구수\t일최대이동인구수");
		System.out.println("--------------------------------------------------");
		for (ReqValue e : obj.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.println(
					e.STDR_DE_ID + "  " + e.SIGNGU_CODE_SE + "\t" + e.TOT_LVPOP_CO + "\t" + e.DAIL_MXMM_MVMN_LVPOP_CO);
		}

	}

} // end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Obj {
	public DailySum SPOP_DAILYSUM_JACHI;

	public DailySum getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(DailySum SPOP_DAILYSUM_JACHI) {
		this.SPOP_DAILYSUM_JACHI = SPOP_DAILYSUM_JACHI;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class DailySum {
	private List<ReqValue> row;

	public List<ReqValue> getRow() {
		return row;
	}

	public void setRow(List<ReqValue> row) {
		this.row = row;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class ReqValue {
	public String STDR_DE_ID;
	public String SIGNGU_CODE_SE;
	public String TOT_LVPOP_CO;
	public String DAIL_MXMM_MVMN_LVPOP_CO;

	public String getSTDR_DE_ID() {
		return this.STDR_DE_ID;
	}

	public void setSTDR_DE_ID(String STDR_DE_ID) {
		this.STDR_DE_ID = STDR_DE_ID;
	}

	public String getSIGNGU_CODE_SE() {
		return this.SIGNGU_CODE_SE;
	}

	public void setSIGNGU_CODE_SE(String SIGNGU_CODE_SE) {
		this.SIGNGU_CODE_SE = SIGNGU_CODE_SE;
	}

	public String getTOT_LVPOP_CO() {
		return this.TOT_LVPOP_CO;
	}

	public void setTOT_LVPOP_CO(String TOT_LVPOP_CO) {
		this.TOT_LVPOP_CO = TOT_LVPOP_CO;
	}

	public String getDAIL_MXMM_MVMN_LVPOP_CO() {
		return this.DAIL_MXMM_MVMN_LVPOP_CO;
	}

	public void setDAIL_MXMM_MVMN_LVPOP_CO(String DAIL_MXMM_MVMN_LVPOP_CO) {
		this.DAIL_MXMM_MVMN_LVPOP_CO = DAIL_MXMM_MVMN_LVPOP_CO;
	}
}
