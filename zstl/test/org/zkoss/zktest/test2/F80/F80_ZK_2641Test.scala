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
    runZTL(() => {
      var tb1 = jq(".z-textbox").eq(0);
      var eBtn = jq("$emptyBtn")
      click(tb1);
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no empty", jq(".z-errorbox-content").text());
      click(tb1);
      waitResponse();
      sendKeys(tb1, "a");
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("email only", jq(".z-errorbox-content").text());

      var ib = jq(".z-intbox");
      waitResponse();
      sendKeys(ib, "-1");
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no neg", jq(".z-errorbox-content").eq(1).text());
      click(ib);
      sendKeys(ib, Keys.BACK_SPACE, Keys.BACK_SPACE);
      sendKeys(ib, "1");
      sleep(300)
      waitResponse()
      click(eBtn);
      waitResponse();
      verifyEquals("no pos", jq(".z-errorbox-content").eq(1).text());

      var ib2 = jq(".z-intbox").eq(1);
      click(ib2);
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no empty", jq(".z-errorbox-content").eq(2).text());
      sendKeys(ib2, "0");
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no zero", jq(".z-errorbox-content").eq(2).text());

      var db = jq(".z-datebox-input");
      //get tomorrow's date
      click(db);
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no empty", jq(".z-errorbox-content").eq(3).text());
      var tomorrowStr = getEval("new zk.fmt.Calendar().formatDate(new Date(new Date().getTime() + 24 * 60 * 60 * 1000), 'yyyyMMdd')")
      sendKeys(db, tomorrowStr);
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no future", jq(".z-errorbox-content").eq(3).text());

      var db2 = jq(".z-datebox-input").eq(1);
      sendKeys(db2, "20150415");
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no before", jq(".z-errorbox-content").eq(4).text());
      click(db2)
      sendKeys(db2, Keys.END, Keys.BACK_SPACE, Keys.BACK_SPACE, "21")
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no after", jq(".z-errorbox-content").eq(4).text());

      var db3 = jq(".z-datebox-input").eq(2);
      click(db3);
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no empty", jq(".z-errorbox-content").eq(5).text());
      sendKeys(db3, "20150421");
      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("between", jq(".z-errorbox-content").eq(5).text());

      var cb = jq(".z-combobox-input");
      focus(cb);

      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("no empty", jq(".z-errorbox-content").eq(6).text());
      sendKeys(cb, "a");

      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("strict", jq(".z-errorbox-content").eq(6).text());

      var ib3 = jq(".z-intbox").eq(2);
      click(jq(".z-button"));
      waitResponse();
      sendKeys(ib3, "-1");

      waitResponse();
      click(eBtn);
      waitResponse();
      verifyEquals("Only positive number or zero is allowed", jq(".z-errorbox-content").eq(7).text());
    })

  }
}