package com.lec.java.crawl11;


/* XML, JSON 파싱 연습
 * 
 * ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/json/stationInfo/1/5/서울

 */

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//■서울시 지하철 역사 정보
//http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1
//
//샘플url
//
//XML 버젼
//http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/xml/stationInfo/1/5/서울
//
//JSON 버젼
//http://swopenAPI.seoul.go.kr/api/subway/53576c67506a736135346359696467/json/stationInfo/1/5/서울

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Crawl11Main {
	public static final String REQ_SERVICE = "stationInfo";
	public static final String API_KEY = "53576c67506a736135346359696467";

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("서울시 지하철역사(station) 정보");

		String url_address = "";
		StringBuffer sb; // response 받은 텍스트

		// API url 에 필요한 parameter 들

		String station = "시청";

		System.out.println("---- XML 파싱 ----");
		url_address = buildUrlAddress("xml", station);
//		System.out.println(url_address);

		sb = readFromUrl(url_address);
		parseXML(sb.toString());

		System.out.println("---- JSON 파싱 ----");
		url_address = buildUrlAddress("json", station);
//		System.out.println(url_address);

		sb = readFromUrl(url_address);
		parseJSON(sb.toString());

		System.out.println("\n 프로그램 종료");
	}

	public static String buildUrlAddress(String reqType, String station) throws UnsupportedEncodingException {
		String url_address = String.format("http://swopenapi.seoul.go.kr/api/subway/%s/%s/stationInfo/1/4/%s", API_KEY,
				reqType, URLEncoder.encode(station, "UTF-8"));

		return url_address;

	}

	/**
	 * 
	 * 
	 * 
	 * @param urlAddress : 주어진 url주소
	 * @return 서버로부터 받은 텍스트데이터(HTML) 리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {

		StringBuffer sb = new StringBuffer(); // response 받은 데이터 담을 객체
		

		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnection

		InputStream in = null;
		InputStreamReader reader = null; // byte 스트림 --> 문자기반 Reader
		BufferedReader br = null;

		char[] buf = new char[512]; // 문자용 버퍼

		// BufferedReader <- InputStreamReader <- HttpURLConnection

		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection) url.openConnection(); // Connection 객체 생성

			if (conn != null) {
				conn.setConnectTimeout(2000); // 2초 이내에 '연결'이 수립안되면
												// java.net.SocketTimeoutException 발생

				conn.setRequestMethod("GET"); // GET 방식 request
				// "GET", "POST" ...

				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false); // 캐시 사용안함

				System.out.println("request 시작" + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을때까지 delay

				System.out.println("response 완료");

				// response 받은 후 가장 먼저 response code 값 확인 // code 값이 200일때 정상
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				// 참조 : https://developer.mozilla.org/ko/docs/Web/HTTP/Status

				if (responseCode == HttpURLConnection.HTTP_OK) {
					in = conn.getInputStream();// InputStreamReader <- HttpURLConnection
					reader = new InputStreamReader(in, "utf-8"); // InputStreamReader <- InputStream
					br = new BufferedReader(reader); // BufferedReader < = InputStreamReader

					int cnt; // 읽은 글자 개수
					while ((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt); // response 받은 텍스트를 StringBuffer에 추가
					}

				} else {
					System.out.println("response 실패");
					return null;
				}
			} else {
				System.out.println("conn null");
				return null;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (conn != null)
				conn.disconnect(); // 작업 끝나고 Connection 해제
		}

		return sb;

	}

	public static void parseXML(String xmlText) {
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;

		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();

			InputStream in = new ByteArrayInputStream(xmlText.getBytes("UTF-8"));

			Document dom = dBuilder.parse(in);

			Element docElement = dom.getDocumentElement();

			docElement.normalize();

			NodeList nList = docElement.getElementsByTagName("row");

			System.out.println();

			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

				if (node.getNodeType() != node.ELEMENT_NODE)
					continue;

				Element element = (Element) node;

				String statnNm = element.getElementsByTagName("statnNm").item(0).getChildNodes().item(0).getNodeValue()
						.trim();
				String subwayId = element.getElementsByTagName("subwayId").item(0).getChildNodes().item(0)
						.getNodeValue().trim();
				String subwayNm = element.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0)
						.getNodeValue().trim();
				;

				System.out.printf(i + 1 + ": %s역 %s %s\n", statnNm, subwayId, subwayNm);

			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void parseJSON(String jsonText) {
		JSONObject jObj = new JSONObject(jsonText); // JSON파싱 : JSONObject <- String

		JSONArray rows = jObj.getJSONArray("stationList");

		for (int i = 0; i < rows.length(); i++) {
			String statnNm = rows.getJSONObject(i).getString("statnNm");

			String subwayId = rows.getJSONObject(i).getString("subwayId");
			;
			String subwayNm = rows.getJSONObject(i).getString("subwayNm");
			;

			System.out.printf(i + 1 + ": %s역 %s %s\n", statnNm, subwayId, subwayNm);
		}
	}
}
