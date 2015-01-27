//code to parse the xml file and send the mail
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import test.BaseTestClass;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sun.jna.platform.FileUtils;

public class urlToDatabase extends BaseTestClass {

	public int tcs = 0;
	public String name = "";
	public String status = "";
	public String ccr = "";
	public String srbcNmbr = "";
	public String mstrBug = "";
	public Connection conn;
	protected Properties configProp = new Properties();
	protected FileInputStream configFis;
	protected File file = new File("");
	String val;
	String opt;
	String reporterURL;
	Timestamp tim;
	int i = 0;

	public void nmbrOfTCs() {

		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"hudsonBuild.properties"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
			String host1 = InetAddress.getLocalHost().toString();
			String hostIp = host1.substring(host1.indexOf("/") + 1).trim();
			String builtDetail = everything.substring(
					everything.indexOf("build.summary="),
					everything.indexOf("build.admin"));
			String jobNameAndBultNmbr = builtDetail.substring(
					builtDetail.indexOf("executing") + 10).trim();
			String builtNmbr = jobNameAndBultNmbr.substring(jobNameAndBultNmbr
					.indexOf("#") + 1);
			String builtName = jobNameAndBultNmbr.substring(0,
					jobNameAndBultNmbr.indexOf("\\") - 1).trim();
			String reporterURL = "http://" + hostIp + ":8080/job/"
					+ builtName.replace(" ", "%20") + "/" + builtNmbr
					+ "/testngreports/";
			try {
				String xmlFilePath = "C:\\Program Files (x86)\\Jenkins\\jobs\\"+builtName+"\\builds\\lastUnstableBuild\\build.xml";

				File xmlFile = new File(xmlFilePath);

				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
						.newInstance();

				DocumentBuilder documentBuilder = documentBuilderFactory
						.newDocumentBuilder();

				Document doc = documentBuilder.parse(xmlFile);

				doc.getDocumentElement().normalize();
				NodeList nodeList = doc.getElementsByTagName("build");

				String lUnstable = null;
				// do this the old way, because nodeList is not iterable
				Node node = nodeList.item(0);
				Element eElement = (Element) node;
				lUnstable = eElement.getElementsByTagName("number").item(0)
						.getTextContent();
				String lastbuildStatus=eElement.getElementsByTagName("result").item(0)
						.getTextContent();

				System.out.println(" Hello "+lUnstable+" "+builtNmbr);
				int lastUnstableBuild = Integer.parseInt(lUnstable);
				int curr = Integer.parseInt(builtNmbr);

				System.out.println(" " + curr + " " + lastUnstableBuild);
				if ((curr - lastUnstableBuild == 1)&&(lastbuildStatus.trim().equals("UNSTABLE"))) {

					String to = "Sidharth.Taneja@makemytrip.com";// change
																	// accordingly
					String from = "172.16.43.74@makemytrip.com";// change
																// accordingly
					String host = "localhost";// or IP address

					// Get the session object
					Properties properties = System.getProperties();
					properties.setProperty("mail.smtp.host", host);
					Session session = Session.getDefaultInstance(properties);

					// compose the message

					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));
					message.addRecipient(Message.RecipientType.TO,
							new InternetAddress(to));
					message.setSubject("Cheetah Alert - " + builtName);
					message.setText("Cheetah Alert - " + builtName + "  "
							+ reporterURL);

					// Send message
					Transport.send(message);
					System.out.println("message sent successfully....");
				}
			}
			// mail.send();}
			catch (Exception e) {
				System.out.println("XML Parser or Mail sending error");
			}

		} catch (Exception e) {
			System.out.println("Database Error2");
		}
	}

}
