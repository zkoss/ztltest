package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test
import java.awt.event.KeyEvent
import org.openqa.selenium.Keys
import org.zkoss.ztl.ZKSeleneseTestBase

@Tags(tags = "B70-ZK-2152.zul")
class B70_ZK_2152Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?xml version="1.0" encoding="UTF-8"?>

<!--
B70-ZK-2152.zul

	Purpose:
		
	Description:
		
	History:
		Mon, June 20, 2014  14:16:12 PM, Created by jerrychen

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk>
	<zscript>
		String string = "10/10/2014 05:00:00";
		Date date = null;
		try{
			date = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(string);
		} catch(Exception ex){}
	</zscript>
	<div>
		1. click datebox and input specified time into timebox.
		<separator/>
		2. if there's not the result as expected, it's a bug.
		<separator/>
	</div>
	<div>
		21:00:00 => 10/10/2014 21:00:00
		<separator/>
		<datebox cols="30" format="MM/dd/yyyy HH:mm:ss"
			onCreate="self.value = date" width="230px" />
	</div>
	<div>
		11:00:00 => 10/10/2014 11:00:00 AM
		<separator/>
		<datebox cols="30" format="MM/dd/yyyy hh:mm:ss a"
			onCreate="self.value = date" width="230px" />
	</div>
	<div>
		11:00:00 => 10/10/2014 11:00:00 AM
		<separator/>
		<datebox cols="30" format="MM/dd/yyyy KK:mm:ss a"
			onCreate="self.value = date" width="230px" />
	</div>
	<div>
		21:00:00 => 10/10/2014 21:00:00
		<separator/>
		<datebox cols="30" format="MM/dd/yyyy kk:mm:ss"
			onCreate="self.value = date" width="230px" />
	</div>
</zk>

"""  
  runZTL(zscript,
    () => {
      clickAt(jq(".z-datebox-button").eq(0), "1,1");
      waitResponse();
      var inp = jq(".z-timebox-input").eq(0); 
      zk(inp).eval("setSelectionRange(0);'test'");
      waitResponse();
      keyPress(inp, "210000"); 
      waitResponse();
      sendKeys(inp, Keys.ENTER);
      waitResponse();
      verifyTrue(jq("@datebox").eq(0).toWidget().get("text").equals("10/10/2014 21:00:00"));
      
      clickAt(jq(".z-datebox-button").eq(1), "1,1");
      waitResponse();
      inp = jq(".z-timebox-input").eq(1); 
      zk(inp).eval("setSelectionRange(0);'test'");
      waitResponse();
      keyPress(inp, "110000"); 
      waitResponse();
      sendKeys(inp, Keys.ARROW_RIGHT);
      waitResponse();
      sendKeys(inp, Keys.ARROW_UP);
      waitResponse();
      sendKeys(inp, Keys.ENTER);
      waitResponse();
      verifyTrue(jq("@datebox").eq(1).toWidget().get("text").equals("10/10/2014 11:00:00 AM"));
      
      clickAt(jq(".z-datebox-button").eq(2), "1,1");
      waitResponse();
      inp = jq(".z-timebox-input").eq(2); 
      zk(inp).eval("setSelectionRange(0);'test'");
      waitResponse();
      keyPress(inp, "110000"); 
      waitResponse();
      sendKeys(inp, Keys.ARROW_RIGHT);
      waitResponse();
      sendKeys(inp, Keys.ARROW_UP);
      waitResponse();
      sendKeys(inp, Keys.ENTER);
      waitResponse();
      verifyTrue(jq("@datebox").eq(2).toWidget().get("text").equals("10/10/2014 11:00:00 AM"));
      
      clickAt(jq(".z-datebox-button").eq(3), "1,1");
      waitResponse();
      inp = jq(".z-timebox-input").eq(3); 
      zk(inp).eval("setSelectionRange(0);'test'");
      waitResponse();
      keyPress(inp, "210000"); 
      waitResponse();
      sendKeys(inp, Keys.ENTER);
      waitResponse();
      verifyTrue(jq("@datebox").eq(3).toWidget().get("text").equals("10/10/2014 21:00:00"));
    })
    
  }
}