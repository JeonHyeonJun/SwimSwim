import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class HttpTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HttpURLConnection urlConnection = null;	//웹서버와 통신을 도와줌
		URL url;
		BufferedReader br = null;
		try {
			DocumentBuilderFactory dbFactory 
			= DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			System.out.print("검색어입력: ");
			String search = scan.next();
			url = new URL("http://openapi.11st.co.kr/openapi"
					+ "/OpenApiService.tmall?key=470c22aada080760827dae30daa86ac4"
					+ "&apiCode=ProductSearch&keyword="
					+URLEncoder.encode(search,"EUC-KR")+"&sortCd=H");
			
			urlConnection = (HttpURLConnection) url.openConnection();
			Document doc = dBuilder.parse(urlConnection.getInputStream());
			NodeList nList = doc.getElementsByTagName("Product");
			for(int temp = 0; temp < nList.getLength(); temp++){
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element) nNode;
					System.out.println("Product Name : "
					+ eElement.getElementsByTagName("ProductName")
					.item(0)
					.getTextContent());
					System.out.println("Product Price : "
					+ eElement.getElementsByTagName("ProductPrice")
					.item(0)
					.getTextContent());
				}
			}
			
			
//			br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"EUC-KR"));	//얘를 read하면 응답을 읽을수 있대요!
//			String msg = null;
//			while((msg = br.readLine()) != null){
//				System.out.println(msg);
//			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
