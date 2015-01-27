package pageObjects.ht;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.jdbc.Statement;

import pageObjects.BasePageObject;
import pageObjects.hotels.HotelsListingPageObject;

/**
 * 
 * This class contains all the elements of Holidays Homepage and methods to
 * interact with those elements.
 * 
 * @author sidharth.taneja@makemytrip.com
 * 
 */
public class HTPageObject extends BasePageObject {
	private WebDriver driver;

	
	@FindBy(css = "ul.hotellist li:nth-child(1) div.infoprice3  span")
	public WebElement firstHotelPrice;
	
	@FindBy(css = ".Rate-Roomtype")
	public WebElement roomTypeOndetailPage;

	@FindBy(css = "input#cFreeSearch")
	public WebElement destinationInput;

	@FindBy(css = "#mainBottomNavigation")
	public WebElement footerObject;

	@FindBy(css = ".boxNode_key")
	List<WebElement> toCityList;

	@FindBy(css = "#zpCal0Title")
	WebElement curryear;

	@FindBy(css = "#zpCal1Title")
	WebElement curryear2;

	@FindBy(css = "#zpCal0NextMonthButtonStatus")
	WebElement nextbtn;

	@FindBy(css = "#zpCal1NextMonthButtonStatus")
	WebElement nextbtn2;

	@FindBy(css = "#zpCal0PrevMonthButtonStatus")
	WebElement prevbtn;

	@FindBy(css = "#zpCal1PrevMonthButtonStatus")
	WebElement prevbtn2;

	@FindBy(css = "#zpCal5CloseButtonStatus")
	public WebElement closeCal;

	@FindBy(css = "a#imgCalendararr")
	public WebElement depCalClick;

	@FindBy(css = "a#imgCalendardept")
	public WebElement desCalClick;

	@FindBy(css = ".cover_infohotel h2>a")
	public List<WebElement> hotelistOnListingPage;

	@FindBy(css = ".daysrow td.day")
	List<WebElement> datediv;

	@FindBy(css = "#divDestName")
	public WebElement cityTextOnListingPage;

	@FindBy(css = "#hotel-detail>h1")
	public WebElement hotelTextOnListingPage;

	@FindBy(css = "a.btn_lg")
	public WebElement searchButton;

	@FindBy(css = "div#socialonline div:nth-child(1) a")
	public WebElement signInLink;

	@FindBy(css = "a[onclick='opengooglelogin();'] img")
	public WebElement gmailLoginButton;

	@FindBy(css = "a[onclick='openfacebooklogin();'] img#SocialLoginPanel_imgFBSignIn")
	public WebElement fbLoginButton;

	@FindBy(css = "#Email")
	public WebElement enterGmailID;

	@FindBy(css = "#email")
	public WebElement enterFbID;

	@FindBy(css = "#Passwd")
	public WebElement enterGmailPasswrd;

	@FindBy(css = "#pass")
	public WebElement enterFbPasswrd;

	@FindBy(css = "#signIn")
	public WebElement clickGmailSignInButton;

	@FindBy(css = "#u_0_1")
	public WebElement clickFbSignInButton;

	@FindBy(css = "a.hc_f_btn_v5")
	public List<WebElement> bookNowOnCT;

	@FindBy(css = "div.hc_m_content div.hc_i h3 a")
	public List<WebElement> hotelListCT;
	
	@FindBy(css = "table#hc_htl_pm_rates_content tbody > tr")
	public List<WebElement> websiteListCT;

	@FindBy(css = "td.hc_tbl_col4 img")
	public List<WebElement> websiteOptionsOnCT;

	@FindBy(css = ".hc_ab_v3 tr td:nth-child(2) a.hc_f_btn_v11")
	public List<WebElement> goButtonOnCT;

	@FindBy(css = ".hc_ab_v3 tr td:nth-child(3) a ")
	public List<WebElement> hotelListDialogBoxOnCT;

	@FindBy(css = ".hc_ab_v3 tr td:nth-child(4)")
	public List<WebElement> HotelPriceOnCT;

	@FindBy(css = "#HotelDetail1_hypHotelName")
	public WebElement hotelNameOnDetail;

	@FindBy(css = "div#lblTotalOriginal span")
	public WebElement priceListOnDetailPage;

	@FindBy(css = "td.Rate-Contiditons a")
	public WebElement termAndConditionLinkOnDetailPage;

	@FindBy(css = "div[style='visibility: visible; position: absolute; left: 551px; top: 472px;'] div.popup_box > div:nth-of-type(3) div.inner_info span")
	public WebElement freeCancelationTexctOnDetailPage;

	@FindBy(css = "#txtFirstName_New")
	public WebElement firstName;

	@FindBy(css = "#txtLastName_New")
	public WebElement lastName;

	@FindBy(css = "#txtEmail_New")
	public WebElement email;

	@FindBy(css = "#txtConfirmEmail_New")
	public WebElement confirmemail;

	@FindBy(css = "#txtPhoneNumber")
	public WebElement phonenmber;

	@FindBy(css = "#cboNationality_New")
	public WebElement selectNationality;

	@FindBy(css = "#couponCodeText")
	public WebElement discountCoupon;

	@FindBy(css = "#dealBtnDivID a")
	public WebElement applydiscountButton;

	@FindBy(css = "a#topselectedcurrency")
	public WebElement currencyDropdown;

	@FindBy(css = "li a[onclick='javascript:topbordermorecurrencyclicked();return false;'] u")
	public WebElement moreCurrencyLink;

	@FindBy(css = "ul.list_currency span.cur")
	public List<WebElement> currencyList;

	@FindBy(css = "#linkBtnContinue")
	public WebElement continueButtonOnDetailPage;

	@FindBy(css = "li[id*=hotelFullInfo]")
	private List<WebElement> listingmaindiv;
	// @FindBy (css="select#jumpMenuUpper")
	// private Select sortdropdown;
	// Payment Screen Page Objects
	@FindBy(css = "div.style_guest_detail")
	private WebElement htldiv;
	// @FindBy (css="select#PaymentAddCard_cboSelectPayment")
	// private Select pymntmethod;
	@FindBy(css = "#PaymentAddCard_txtCardNumber")
	private WebElement cardno;
	@FindBy(css = "#PaymentAddCard_txtCardHolderName")
	private WebElement cardholdername;
	// @FindBy (css="select#PaymentAddCard_cboExpireMonth")
	// private Select expiremnth;
	// @FindBy (css="select#PaymentAddCard_cboExpireYear")
	// private Select expireyear;
	@FindBy(css = "#PaymentAddCard_txtSecureNo")
	private WebElement secureno;
	@FindBy(css = "#btnContinueAction a")
	private WebElement completebtn;

	public Map<String, String> listingdetails(String hoteltobook)
			throws Exception {
		waitUntilElementLoads(listingmaindiv.get(0));
		Map<String, String> listingPageDict = new HashMap<String, String>();
		// Select sortdropdown=(Select)
		// driver.findElement(By.cssSelector("select#jumpMenuUpper"));
		Select sortdropdown = new Select(driver.findElement(By
				.cssSelector("select#jumpMenuUpper")));
		sortdropdown.selectByVisibleText("Price");

		for (int i = 0; i < listingmaindiv.size() - 1; i++) {
			WebElement listdiv = listingmaindiv.get(i);
			String htlname = listdiv.findElement(
					By.cssSelector("div.search_site a")).getText();
			// listingPageDict.put("hotelname", htlname);

			WebElement listdivdetails = listdiv.findElement(By
					.cssSelector("div.cover_infohotel"));
			if (listdivdetails.getText().contains(hoteltobook)) {
				WebElement listdivratediv = listdiv.findElement(By
						.cssSelector("div.info_rate"));
				// String
				// listdivanvgnightfare=listdiv.findElement(By.cssSelector("td.rate_roomrate_avg")).getText();
				System.out.println(listdivdetails.getText());
				WebElement listdivshowhide = listdiv.findElement(By
						.cssSelector("div.show_hide a"));
				listdivshowhide.click();
				WebElement listdivshowhideagain = listdiv.findElement(By
						.cssSelector("div.show_hide a"));
				if (listdivshowhideagain.getText().contains("Show Remaining")) {
					listdivshowhideagain.click();
				}
				try {
					waitUntilElementLoads(listdiv.findElements(
							By.cssSelector("[id*=RoomByRoomId]")).get(0));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					listingPageDict.put("showmoreflag", "flase");
					e.printStackTrace();
					return listingPageDict;
				}
				List<WebElement> listdivshidedivs = listdiv.findElements(By
						.cssSelector("[id*=RoomByRoomId]"));

				System.out.println(listdivshidedivs.size());
				// if(listdivshidedivs.size()>0){
				// for(int j=0;j<listdivshidedivs.size()-1;j++){
				WebElement showhidediv = listdivshidedivs.get(0);
				// showhidediv.findElement(By.cssSelector("td.rate_conditionmore2 a")).click();
				// String
				// cancelpolicy=driver.findElement(By.cssSelector("div#divHiddenForPopUp .popup_box .inside_inner:nth-of-type(2) div.inner_left_popup div.inner_info")).getText();
				// if(listdivdetails.getText().contains(hoteltobook)){
				/*
				 * String[] policysplit=cancelpolicy.split("23:59");
				 * System.out.println(policysplit[1]); String
				 * policystr=policysplit[1]; String[]
				 * policydate=policystr.split("(destination time)"); String
				 * canceldate=policydate[0].split("\\(")[0].trim(); String
				 * currentDateStr = null; Date currentDate = null;
				 * SimpleDateFormat format = new
				 * SimpleDateFormat("dd MMM. yyyy"); String dateStartStr =
				 * getDateStrFromOdrinalDate(canceldate); long diff = 0; try {
				 * Date dateStr = format.parse(dateStartStr); currentDateStr =
				 * format.format(new Date()); currentDate =
				 * format.parse(currentDateStr); diff = dateStr.getTime() -
				 * currentDate.getTime(); System.out.println(diff / (24 * 60 *
				 * 60 * 1000)); diff=diff / (24 * 60 * 60 * 1000); } catch
				 * (Exception e) { // TODO Auto-generated catch block
				 * e.printStackTrace(); } if(diff>=10){
				 */

				String roomrate = showhidediv.findElement(
						By.cssSelector(".rate_roomrate_avg span")).getText();
				String roomtype = showhidediv.findElement(
						By.cssSelector(".rate_roomtype")).getText();
				listingPageDict.put("hotelname", htlname);
				listingPageDict.put("roomrate", roomrate);
				listingPageDict.put("roomtype", roomtype);
				listingPageDict.put("showmoreflag", "true");
				System.out.println(roomrate);
				showhidediv.findElement(By.cssSelector(".rate_booknow a"))
						.click();
				return listingPageDict;
				/*
				 * } else { driver.findElement(By.cssSelector(
				 * "div#divHiddenForPopUp .close_popup img")).click(); }
				 */
			}
			// else
			// driver.findElement(By.cssSelector("div#divHiddenForPopUp .close_popup img")).click();

			/*
			 * else { listingPageDict.put("showmoreflag","flase"); }
			 */
		}

		/*
		 * if (doesElementExist(listdivratediv)){ String
		 * roomrate=listdivratediv.
		 * findElement(By.cssSelector("td.rate_roomrate_avg>span")).getText();
		 * String roomtype=listdivratediv.findElement(By.cssSelector(
		 * "tr:nth-child(2) td:nth-child(1)")).getText();
		 * listingPageDict.put("roomrate", roomrate);
		 * listingPageDict.put("roomtype", roomtype);
		 * listingPageDict.put("showmoreflag","true");
		 * listdivratediv.findElement(By.cssSelector("a")).click(); } else
		 * listingPageDict.put("showmoreflag","flase");
		 */
		listingPageDict.put("showmoreflag", "flase");
		return listingPageDict;
	}

	private static String getDateStrFromOdrinalDate(String ordinalDateStartStr) {

		String newDate = null;
		if (ordinalDateStartStr.contains("st"))
			newDate = ordinalDateStartStr.replace("st", "");
		else if (ordinalDateStartStr.contains("nd"))
			newDate = ordinalDateStartStr.replace("nd", "");
		else if (ordinalDateStartStr.contains("rd"))
			newDate = ordinalDateStartStr.replace("rd", "");
		else
			newDate = ordinalDateStartStr.replace("th", "");
		return newDate;
	}

	public String paymentpage(String fare, String htlnm,
			Map<String, String> paymentdetails) {
		Map<String, String> paymentmap = new HashMap<String, String>();
		try {
			waitUntilElementLoads(htldiv);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "paymentpageflase";
		}
		String htldetails = htldiv.getText();
		Boolean fareflg = false, htlnmflg = false;
		if (htldetails.contains(fare)) {
			fareflg = true;
		}
		if (htldetails.contains(htlnm)) {
			htlnmflg = true;
		}
		if (fareflg && htlnmflg) {
			paymentmap.put("pymntflg", "true");
		} else
			paymentmap.put("pymntflg", "false");

		Select pymntmethod = new Select(driver.findElement(By
				.cssSelector("select#PaymentAddCard_cboSelectPayment")));
		pymntmethod.selectByVisibleText(paymentdetails.get("paymentmethod"));
		cardno.sendKeys(paymentdetails.get("cardno"));
		cardholdername.sendKeys(paymentdetails.get("cardholdername"));
		Select expiremnth = new Select(driver.findElement(By
				.cssSelector("select#PaymentAddCard_cboExpireMonth")));
		expiremnth.selectByVisibleText(paymentdetails.get("cardexpiremonth"));
		Select expireyear = new Select(driver.findElement(By
				.cssSelector("select#PaymentAddCard_cboExpireYear")));
		expireyear.selectByVisibleText(paymentdetails.get("cardexpireyear"));
		secureno.sendKeys(paymentdetails.get("cardsecureno"));
		if (doesElementExist(driver.findElement(By
				.cssSelector("input#PaymentAddCard_txtCCMoreInfoAddress")))) {
			WebElement addr = driver.findElement(By
					.cssSelector("input#PaymentAddCard_txtCCMoreInfoAddress"));
			addr.sendKeys(paymentdetails.get("address"));
		}
		if (doesElementExist(driver.findElement(By
				.cssSelector("input#PaymentAddCard_txtCCMoreInfoCity")))) {
			WebElement city = driver.findElement(By
					.cssSelector("input#PaymentAddCard_txtCCMoreInfoCity"));
			city.sendKeys(paymentdetails.get("citypayment"));
		}

		if (doesElementExist(driver.findElement(By
				.cssSelector("select#PaymentAddCard_cboCCMoreInfoCountry")))) {
			Select country = new Select(driver.findElement(By
					.cssSelector("select#PaymentAddCard_cboCCMoreInfoCountry")));
			country.selectByVisibleText(paymentdetails.get("country"));
		}

		completebtn.click();
		try {
			waitUntilElementLoads(driver.findElement(By
					.cssSelector("div.inferline:nth-of-type(1)>p")));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "thankyoupageflase";
		}

		String bookid = driver.findElement(
				By.cssSelector("div.inferline:nth-of-type(1)>p")).getText();
		return bookid;
	}

	@SuppressWarnings("finally")
	public boolean doesElementExist(WebElement myObject) {
		String flag = "";
		try {
			if (myObject.isDisplayed()) {
				flag = "0";
			}
		} catch (Exception e) {
			flag = "1";
		}

		finally {
			if (flag == "0") {
				return true;
			} else {
				return false;
			}
		}
	}

	@SuppressWarnings("finally")
	public boolean doesElementExist(WebElement myObject, String csspth) {
		String flag = "";
		try {
			if (myObject.findElement(By.cssSelector(csspth)).isDisplayed()) {
				flag = "0";
			}
		} catch (Exception e) {
			flag = "1";
		}

		finally {
			if (flag == "0") {
				return true;
			} else {
				return false;
			}
		}
	}

	public void waitUntilElementLoads(WebElement myobject)
			throws InterruptedException {

		int i = 0;

		while (!myobject.isDisplayed()) {

			// while (pleaseWait.isDisplayed()){

			if (i > 30) {

				break;

			} else {

				Thread.sleep(1000);

				i = i + 1;

			}

		}
	}

	@SuppressWarnings("finally")
	public boolean doesElementExist(List<WebElement> myObject) {
		String flag = "";
		try {
			if (myObject.get(0).isDisplayed()) {
				flag = "0";
			}
		} catch (Exception e) {
			flag = "1";
		} finally {
			if (flag == "0") {
				return true;
			} else {
				return false;
			}
		}
	}

	public HTPageObject(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(
				new AjaxElementLocatorFactory(this.driver, 10), this);
	}

	public void enterFromCity(String toCity) throws Exception {
		String[] cityarr2 = toCity.split(",");
		String cityname2 = cityarr2[0];
		String[] inp = cityname2.split("");
		int i = 0;
		destinationInput.clear();
		destinationInput.click();
		destinationInput.sendKeys(toCity);
		Thread.sleep(5000);
		int count = 0;
		for (WebElement curr_to : toCityList) {
			if (curr_to.getText().contains(toCity)) {
				curr_to.click();
				break;
			}
		}
	}

	public int dateSelector(String seldate, int oprn) {

		int selyr = Integer.parseInt(StringUtils.mid(seldate, 6, 4));
		String a = curryear.getText();
		int pos = a.indexOf(",");
		a = a.substring(pos + 1).trim();
		int curyr = Integer.parseInt(a);

		int selmnth = mnthtonum(StringUtils.mid(seldate, 2, 3));
		int currentmnth = mnthtonum(StringUtils.left(curryear.getText()
				.substring(0, curryear.getText().indexOf(",")), 3));

		int seldt = Integer.parseInt(StringUtils.left(seldate, 2));

		int datefound = 0;

		if (curyr < selyr) {
			// code for fwd
			int clickcount = (12 - currentmnth) + selmnth + 12
					* (selyr - curyr - 1);
			int i;
			for (i = 1; i <= clickcount; i++) {

				nextbtn.click();
				// nextbtn.sendKeys(Keys.ENTER);
			}
		}

		if (curyr > selyr) {
			// code for backward
			int clickcount = (12 - selmnth) + currentmnth + 12
					* (curyr - selyr - 1);
			int i;
			for (i = 1; i <= clickcount; i++) {

				prevbtn.click();
				// prevbtn.sendKeys(Keys.ENTER);
			}
		}

		if (curyr == selyr) {
			// code if equal (decide fwd or backwd)
			int clickcount = selmnth - currentmnth;
			clickcount = Math.abs(clickcount);
			int i;
			for (i = 1; i <= clickcount; i++) {
				if (selmnth < currentmnth) {
					if (StringUtils.contains(prevbtn.getAttribute("class"),
							"disabled")) {
					} else {
						prevbtn.click();
						// prevbtn.sendKeys(Keys.ENTER);

					}
				} else {
					if (StringUtils.contains(nextbtn.getAttribute("class"),
							"disabled")) {
					} else {
						nextbtn.click();
						// nextbtn.sendKeys(Keys.ENTER);
					}
					currentmnth = mnthtonum(StringUtils.left(curryear.getText()
							.substring(0, curryear.getText().indexOf(",")), 3));
					if (currentmnth == selmnth) {
						out: for (WebElement dateblock : datediv) {
							if (Integer.parseInt(dateblock.getText()) == seldt) {
								// System.out.println(dateblock);
								dateblock.click();
								datefound = 1;
								break out;
							}
						}
					}
				}
			}
		}

		/*
		 * if (curyr == selyr && currentmnth == selmnth) { for (WebElement
		 * dateblock : datediv) { // System.out.println(dateblock.getText()); if
		 * (StringUtils.length(dateblock.getText()) > 0) { if
		 * (StringUtils.contains(dateblock.getAttribute("class"), "disabled")) {
		 * } else { if (Integer.parseInt(dateblock.getText()) == seldt) { if
		 * (oprn == 1) { if (StringUtils.contains(
		 * dateblock.getAttribute("class"), "ui-state-active")) { datefound = 2;
		 * } } else { // new //
		 * Actions(driver).moveToElement(dateblock).click().perform(); //
		 * dateblock.sendKeys(Keys.ENTER); System.out.println(dateblock);
		 * dateblock.click();
		 * 
		 * datefound = 1; break; } } } } } }
		 */

		return datefound;

	}

	public int dateSelector2(String seldate, int oprn) {

		int selyr = Integer.parseInt(StringUtils.mid(seldate, 6, 4));
		String a = curryear2.getText();
		int pos = a.indexOf(",");
		a = a.substring(pos + 1).trim();
		int curyr = Integer.parseInt(a);

		int selmnth = mnthtonum(StringUtils.mid(seldate, 2, 3));
		int currentmnth = mnthtonum(StringUtils.left(curryear2.getText()
				.substring(0, curryear2.getText().indexOf(",")), 3));

		int seldt = Integer.parseInt(StringUtils.left(seldate, 2));

		int datefound = 0;

		if (curyr < selyr) {
			// code for fwd
			int clickcount = (12 - currentmnth) + selmnth + 12
					* (selyr - curyr - 1);
			int i;
			for (i = 1; i <= clickcount; i++) {

				nextbtn2.click();
				// nextbtn.sendKeys(Keys.ENTER);
			}
		}

		if (curyr > selyr) {
			// code for backward
			int clickcount = (12 - selmnth) + currentmnth + 12
					* (curyr - selyr - 1);
			int i;
			for (i = 1; i <= clickcount; i++) {

				prevbtn2.click();
				// prevbtn.sendKeys(Keys.ENTER);
			}
		}

		if (curyr == selyr) {
			// code if equal (decide fwd or backwd)
			int clickcount = selmnth - currentmnth;
			clickcount = Math.abs(clickcount);
			int i;
			for (i = 1; i <= clickcount; i++) {
				if (selmnth < currentmnth) {
					if (StringUtils.contains(prevbtn2.getAttribute("class"),
							"disabled")) {
					} else {
						prevbtn2.click();
						// prevbtn.sendKeys(Keys.ENTER);

					}
				} else {
					if (StringUtils.contains(nextbtn2.getAttribute("class"),
							"disabled")) {
					} else {
						nextbtn.click();
						// nextbtn.sendKeys(Keys.ENTER);
					}
				}
			}
		}

		if (curyr == selyr && currentmnth == selmnth) {
			for (WebElement dateblock : datediv) {
		//		System.out.println(dateblock.getText());
				if (StringUtils.length(dateblock.getText()) > 0) {
					if (StringUtils.contains(dateblock.getAttribute("class"),
							"disabled")) {
					} else {
						if (Integer.parseInt(dateblock.getText()) == seldt) {
							if (oprn == 1) {
								if (StringUtils.contains(
										dateblock.getAttribute("class"),
										"ui-state-active")) {
									datefound = 2;
								}
							} else {
								// new
								// Actions(driver).moveToElement(dateblock).click().perform();
								// dateblock.sendKeys(Keys.ENTER);
								System.out.println(dateblock);
								dateblock.click();

								datefound = 1;
								break;
							}
						}
					}
				}
			}
		}

		return datefound;

	}

	public boolean hotelPricingOnDetailPage(String price) {

		// System.out.println(priceListOnDetailPage.get(i).getText());
		String a = price.substring(3);
		float p1 = Float.parseFloat(a);
		String b = priceListOnDetailPage.getText().substring(3)
				.replace(",", "");
		float p2 = Float.parseFloat(b);
		if (p2 > p1) {
			return true;
		} else {
			return false;
		}
	}

	public int mnthtonum(String mnthname) {
		int selmnth = 0;
		switch (StringUtils.lowerCase(mnthname)) {
		case "jan":
			selmnth = 1;
			break;
		case "feb":
			selmnth = 2;
			break;
		case "mar":
			selmnth = 3;
			break;
		case "apr":
			selmnth = 4;
			break;
		case "may":
			selmnth = 5;
			break;
		case "jun":
			selmnth = 6;
			break;
		case "jul":
			selmnth = 7;
			break;
		case "aug":
			selmnth = 8;
			break;
		case "sep":
			selmnth = 9;
			break;
		case "oct":
			selmnth = 10;
			break;
		case "nov":
			selmnth = 11;
			break;
		case "dec":
			selmnth = 12;
			break;
		}
		return selmnth;
	}

	public void enterDetailPageDetails(String name, String lastname,
			String email, String contact, String nationality,
			String discountcoupon) {
		firstName.sendKeys(name);
		lastName.sendKeys(lastname);
		this.email.sendKeys(email);
		confirmemail.sendKeys(email);
		phonenmber.sendKeys(contact);
		new Select(selectNationality).selectByVisibleText(nationality);
		if (!discountcoupon.equalsIgnoreCase("n")) {
			discountCoupon.sendKeys(discountcoupon);
			applydiscountButton.click();
		}
		continueButtonOnDetailPage.click();

	}

	public boolean dbvalidation(String QAorStaging, String bookingID,
			String userName, String passwrd) throws Exception {
		// Step 1: Load the JDBC ODBC driver.
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		// Step 2: Establish the connection to the database.
		String url = "jdbc:odbc:" + QAorStaging;
		Connection conn = DriverManager.getConnection(url, userName, passwrd);
		boolean cn = conn.isClosed();
		String queryCheck;
		if (QAorStaging.trim().equals("QA")) {
			queryCheck = "SELECT * FROM Logging.dbo.xx_BookingLogger where BookingID='"
					+ bookingID + "'";
		} else {
			queryCheck = "SELECT * FROM loggingtest.dbo.xx_BookingLogger where BookingID='"
					+ bookingID + "'";
		}

		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(queryCheck);
		String data = null;
		while (rs.next()) {
			data = rs.getString("BookingStatusonCompletion");
		}
		System.out.println("Booking status is " + data);
		if (data.trim().equalsIgnoreCase("SENTGUEST’")) {
			return true;
		} else {
			return false;
		}

	}

        

	public void currencySelector(String currency) throws Exception {

		currencyDropdown.click();
		Thread.sleep(10000);
		moreCurrencyLink.click();
		outer: for (int i = 0; i < currencyList.size(); i++) {
			// System.out.println(currencyList.get(i).getText());
			if (currencyList.get(i).getText().trim().equalsIgnoreCase(currency)) {
				currencyList.get(i).click();
				break outer;
			}
			if (currencyList.get(i).getText().trim().equalsIgnoreCase("UGX")) {
                                 //code to perform scrolling in popup
				Actions dragger = new Actions(driver);
				WebElement draggablePartOfScrollbar = driver.findElement(By
						.cssSelector("#scroller"));
				int numberOfPixelsToDragTheScrollbarDown = 200;
				dragger.moveToElement(draggablePartOfScrollbar).clickAndHold()
						.moveByOffset(0, numberOfPixelsToDragTheScrollbarDown)
						.release().perform();
				i = 0;
				currencyList = driver.findElements(By
						.cssSelector("ul.list_currency span.cur"));
			}

		}

	}

	public float CurrencyChange(String QAorStaging, String userName,
			String password, String from, String to) throws Exception {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		// Step 2: Establish the connection to the database.
		String url = "jdbc:odbc:" + QAorStaging;
		Connection conn = DriverManager.getConnection(url, userName, password);
		boolean cn = conn.isClosed();
		String queryCheck = "Select top 1 ExchangeRate from  MasterCurrencyRatesENGINE where Currency_CodeFrom='"
				+ from + "' and Currency_CodeTo='" + to + "'";
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(queryCheck);
		String data = null;
		while (rs.next()) {
			data = rs.getString("ExchangeRate");
		}
		float f=Float.parseFloat(data);
		return f;
	}
	
	public Map<String, String> listingdetailsBeforClickingBookNowButton(String hoteltobook)
			throws Exception {
		waitUntilElementLoads(listingmaindiv.get(0));
		Map<String, String> listingPageDict = new HashMap<String, String>();
		Select sortdropdown = new Select(driver.findElement(By
				.cssSelector("select#jumpMenuUpper")));
		sortdropdown.selectByVisibleText("Price");

		for (int i = 0; i < listingmaindiv.size() - 1; i++) {
			WebElement listdiv = listingmaindiv.get(i);
			String htlname = listdiv.findElement(
					By.cssSelector("div.search_site a")).getText();
			WebElement listdivdetails = listdiv.findElement(By
					.cssSelector("div.cover_infohotel"));
			if (listdivdetails.getText().contains(hoteltobook)) {
				WebElement listdivratediv = listdiv.findElement(By
						.cssSelector("div.info_rate"));
				System.out.println(listdivdetails.getText());
				WebElement listdivshowhide = listdiv.findElement(By
						.cssSelector("div.show_hide a"));
				listdivshowhide.click();
				WebElement listdivshowhideagain = listdiv.findElement(By
						.cssSelector("div.show_hide a"));
				if (listdivshowhideagain.getText().contains("Show Remaining")) {
					listdivshowhideagain.click();
				}
				try {
					waitUntilElementLoads(listdiv.findElements(
							By.cssSelector("[id*=RoomByRoomId]")).get(0));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					listingPageDict.put("showmoreflag", "flase");
					e.printStackTrace();
					return listingPageDict;
				}
				List<WebElement> listdivshidedivs = listdiv.findElements(By
						.cssSelector("[id*=RoomByRoomId]"));

				System.out.println(listdivshidedivs.size());
				WebElement showhidediv = listdivshidedivs.get(0);
					String roomrate = showhidediv.findElement(
						By.cssSelector(".rate_roomrate_avg span")).getText();
				String roomtype = showhidediv.findElement(
						By.cssSelector(".rate_roomtype")).getText();
				listingPageDict.put("hotelname", htlname);
				listingPageDict.put("roomrate", roomrate);
				listingPageDict.put("roomtype", roomtype);
				listingPageDict.put("showmoreflag", "true");
				
				return listingPageDict;
			}
			}

		listingPageDict.put("showmoreflag", "flase");
		return listingPageDict;
	}
}
