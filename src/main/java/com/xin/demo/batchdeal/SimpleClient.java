package com.xin.demo.batchdeal;

import java.io.IOException;
import java.net.URLEncoder; 

public class SimpleClient {
	@SuppressWarnings("deprecation")
	
	
	
	public static void main(String[] args) throws IOException {
//		String url = "http://eship.cndhl.com/shipOrder.do?method=insert&ToCountryName:UnitedStatesOfAmerica(美国)&Division:UTAH(UT)&hiddenChargeValue:&DCC_Code:USD&GoodsStr:0|1|0.5|0|0|0&Total_Pics:1&Total_Weight:0.5&countryCode:&ShippingPaymentType:S&BillingAccountNumber:602396718&ShipperID:602396718&Ship_PersonName:Mr.Qu&ReferenceID:HY031501&CompanyName:GuangZhouBaiLunTradingco.,LTD&AddressLine0:GuangZhouBaiLunTradingco.,LTD&AddressLine1:GuangZhouBaiLunTradingco.,LTD&PostalCode:510425&AddressLine2:GuangZhouBaiLunTradingco.,LTD&Ship_City:GUANGZHOU&PhoneNumber:13570463355&ToCompany:xhxhxh&ToCountryCode:US&ToAddress0:228SOUTH300EAST&ToAddress1:APT21SaltLake&DivisionCode:UT&ToAddress2:&ToCity:SALTLAKECITY&ToPersonName:xh&ToPostalCode:84101&ToPostalCodeUK1:&ToPostalCodeUK2:&ToPhoneNumber:16786129265&GlobalProductCode:P&LocalProductCode:ExpressWorldwide&packageType:2&Piece0:1&Weight0:0.5&Piece1:&Weight1:&Piece2:&Weight2:&Contents:HAIRSAMPLE3PCS&FederalTaxId:&ToFederalTaxId:&DeclaredValue:30.00&DeclaredCurrencyCode:USD&CommodityCode:&ChargeValue:&DutyPaymentType:R&MakeInvice:1&inviceDetailString:HAIRSAMPLE|3||10.00|CN|China(中国)&incoterm:DAP-DeliveredatPlace&englishexportType:Permanent(永久)&inviceType:2&date:2016-03-15&inviceCode:&exportType:1&payment:&ttermsFp:6&note:&goodsdescribe:HAIRSAMPLE&num:3&goodsCode:&price:10.00&CountryFp:CN&goodsdescribe:&num:&goodsCode:&price:&CountryFp:CN&goodsdescribe:&num:&goodsCode:&price:&CountryFp:CN&TotalPieces:3&TotalDeclaredValue:30.00&eInviceDetailString:&eIncoterm:PleaseSelect&eEnglishexportType:Permanent(永久)&eDate:&eInviceCode:&eExportType:1&ePayment:&eTtermsFp:0&eNote:&ePlatform:&platformOrderNumber:&eGoodsdescribe:&eNum:&eUnit:&price:&eCountryFp:&platformOrderNumber:&eGoodsdescribe2:&num:&eUnit2:&price:&eCountryFp:&platformOrderNumber:&eGoodsdescribe3:&num:&eUnit3:&price:&eCountryFp:&eTotalPieces:&eTotalDeclaredValue:&tdx:0&Today:&dayinType:dayinPDF";
		String encode = URLEncoder.encode("(美国)");
		System.out.println(encode);
	}
}
