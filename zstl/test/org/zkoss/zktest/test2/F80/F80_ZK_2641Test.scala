package org.zkoss.zktest.test2.F80

import java.text.SimpleDateFormat
import java.util.Date

import org.junit.Test
import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "F80-ZK-2641.zul")
class F80_ZK_2641Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """

<?xml version="1.0" encoding="UTF-8"?>

<!--
F80-ZK-2641.zul

  Purpose:
    
  Description:
    
  History:
    Wed, Apr 15, 2015 12:32:05 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<window>
  <label multiline="true">
  0. new feature to support multiple customized error messages 
  1. focus on each input widget
  2. input something or nothing and blur
  3. please see zul file and make some test
  </label>
  <vlayout>
  <label>textbox</label>
  <textbox constraint="no empty: no empty, /.+@.+\.[a-z]+/: email only"></textbox>
  <label>intbox</label>
  <intbox constraint="no negative: no neg, no positive: no pos"></intbox>
  <intbox constraint="no zero: no zero, no positive: no pos, no empty: no empty"></intbox>
  <label>datebox</label>
  <datebox constraint="no empty: no empty, no future: no future" format="yyyyMMdd"/>
  <datebox constraint="after 20150416: no before, before 20150420: no after" format="yyyyMMdd"/>
  <datebox constraint="between 20150416 and 20150420: between , no empty: no empty" format="yyyyMMdd"/>
  <label>combobox</label>
  <combobox constraint="strict: strict, no empty: no empty">
      <comboitem label="1"/>
      <comboitem label="2"/>
      <comboitem label="3"/>
  </combobox>
  <label>assign a function to intbox</label>
  <intbox id="intbox" />
  <button label="add constraint"
  onClick="intbox.constraint = new SimpleConstraint(SimpleConstraint.NO_NEGATIVE)" />
  </vlayout>
</window>

"""
    runZTL(zscript,
      () => {
        var tb = jq(".z-textbox");
        focus(tb);
        blur(tb);
        waitResponse();
        verifyEquals("no empty", jq(".z-errorbox-content").text());
        sendKeys(tb, "a");
        blur(tb);
        waitResponse();
        verifyEquals("email only", jq(".z-errorbox-content").text());

        var ib = jq(".z-intbox");
        waitResponse();
        sendKeys(ib, "-1");
        blur(ib);
        waitResponse();
        verifyEquals("no neg", jq(".z-errorbox-content").eq(1).text());
        click(ib);
        sendKeys(ib, Keys.BACK_SPACE, Keys.BACK_SPACE);
        sendKeys(ib, "1");
        blur(ib);
        waitResponse()
        verifyEquals("no pos", jq(".z-errorbox-content").eq(1).text());

        var ib2 = jq(".z-intbox").eq(1);
        focus(ib2);
        blur(ib2);
        waitResponse();
        verifyEquals("no empty", jq(".z-errorbox-content").eq(2).text());
        sendKeys(ib2, "0");
        blur(ib2);
        waitResponse();
        verifyEquals("no zero", jq(".z-errorbox-content").eq(2).text());

        var db = jq(".z-datebox-input");
        var format = new SimpleDateFormat("yyyyMMdd");
        //get tomorrow's date
        var d = new Date((new Date).getTime() + (1000 * 60 * 60 * 24));
        focus(db);
        blur(db);
        waitResponse();
        verifyEquals("no empty", jq(".z-errorbox-content").eq(3).text());
        sendKeys(db, format.format(d));
        blur(db);
        waitResponse();
        verifyEquals("no future", jq(".z-errorbox-content").eq(3).text());

        var db2 = jq(".z-datebox-input").eq(1);
        sendKeys(db2, "20150415");
        blur(db2);
        waitResponse();
        verifyEquals("no before", jq(".z-errorbox-content").eq(4).text());
        click(db2)
        sendKeys(db2, Keys.BACK_SPACE, Keys.BACK_SPACE, "21");
        blur(db2);
        waitResponse();
        verifyEquals("no after", jq(".z-errorbox-content").eq(4).text());

        var db3 = jq(".z-datebox-input").eq(2);
        focus(db3);
        blur(db3);
        waitResponse();
        verifyEquals("no empty", jq(".z-errorbox-content").eq(5).text());
        sendKeys(db3, "20150421");
        blur(db3);
        waitResponse();
        verifyEquals("between", jq(".z-errorbox-content").eq(5).text());

        var cb = jq(".z-combobox-input");
        focus(cb);
        blur(cb);
        waitResponse();
        verifyEquals("no empty", jq(".z-errorbox-content").eq(6).text());
        sendKeys(cb, "a");
        blur(cb);
        waitResponse();
        verifyEquals("strict", jq(".z-errorbox-content").eq(6).text());

        var ib3 = jq(".z-intbox").eq(2);
        click(jq(".z-button"));
        waitResponse();
        sendKeys(ib3, "-1");
        blur(ib3);
        waitResponse();
        verifyEquals("Only positive number or zero is allowed", jq(".z-errorbox-content").eq(7).text());
      })

  }
}